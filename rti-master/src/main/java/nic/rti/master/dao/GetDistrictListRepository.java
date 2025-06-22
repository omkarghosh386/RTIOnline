package nic.rti.master.dao;

import nic.rti.master.entity.DistrictList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetDistrictListRepository extends JpaRepository<DistrictList, String> {
}
