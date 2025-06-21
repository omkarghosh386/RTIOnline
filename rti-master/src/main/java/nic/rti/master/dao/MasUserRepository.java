package nic.rti.master.dao;

import nic.rti.master.entity.MasUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasUserRepository extends JpaRepository<MasUser, Integer> {

    @Query("SELECT mu FROM MasUser mu")
    List<MasUser> getUsers();
}
