package nic.rti.master.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import nic.rti.master.entity.Appeal;

@Repository
public interface AppealRepository extends CrudRepository<Appeal, Long> {

    // 1. Appeal Pending <= 10 Days
    @Query(value = """
        SELECT COUNT(*) FROM "RTIMIS"."appeal"
        WHERE "ApplID" = :appealId
        AND closing_date IS NULL
        AND registration_no NOT IN (
            SELECT registration_no
            FROM "RTIMIS"."action_history"
            WHERE action_status = '7C'
            AND do_code = :appealCode
        )
        AND (CURRENT_DATE - DATE(recvd_date)) <= 10
        """, nativeQuery = true)
    int countAppealsPending10Days(@Param("appealId") int appealId, @Param("appealCode") String appealCode);


    // 2. New Appeals
    @Query(value = """
        SELECT COUNT(*) FROM "RTIMIS"."appeal"
        WHERE "ApplID" = :appealId
        AND closing_date IS NULL
        AND registration_no NOT IN (
            SELECT registration_no FROM "RTIMIS"."app_assessment_details"
        )
        """, nativeQuery = true)
    int countNewAppeals(@Param("appealId") int appealId);


    // 3. Appeals Under Process
    @Query(value = """
        SELECT COUNT(*) FROM "RTIMIS"."appeal" A
        JOIN "RTIMIS"."action_history" AH ON A.registration_no = AH.registration_no
        WHERE AH.action_status IN ('70', '7A', '7D', '7C')
        AND AH.action_srno = (
            SELECT MAX(action_srno)
            FROM "RTIMIS"."action_history"
            WHERE registration_no = A.registration_no
        )
        AND A.closing_date IS NULL
        AND A."ApplID" = :appealId
        """, nativeQuery = true)
    int countAppealsUnderProcess(@Param("appealId") int appealId);


    // 4. Comments Received from PIO
    @Query(value = """
        SELECT COUNT(*) FROM "RTIMIS"."commentscpio" C
        JOIN "RTIMIS"."appeal" A ON C.registration_no = A.registration_no
        WHERE C.flag = 'R'
        AND A.closing_date IS NULL
        AND A."ApplID" = :appealId
        """, nativeQuery = true)
    int countCommentsFromPIO(@Param("appealId") int appealId);
}
