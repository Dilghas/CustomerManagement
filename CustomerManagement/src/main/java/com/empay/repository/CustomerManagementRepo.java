package com.empay.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empay.entity.CustomerManagementEntity;

public interface CustomerManagementRepo extends JpaRepository<CustomerManagementEntity,Integer> {

//	CustomerManagementEntity findBySerialNumber(Integer serialNumber); 
	
	
	@Query("select c from CustomerManagementEntity c where c.serialNumber= :serialNumber")
	CustomerManagementEntity findSerialNumber(@Param("serialNumber")Integer serialNumber);
	
	
	
	
}
