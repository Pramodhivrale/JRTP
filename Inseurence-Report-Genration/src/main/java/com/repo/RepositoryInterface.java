package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.entity.*;

@Repository
public interface RepositoryInterface extends JpaRepository<CustomerDataEntity, Integer>
{
	@Query(value = "select distinct(plan_name) from citizen_plan_table",nativeQuery = true)
	public List<String> getByPlanName();
	
	@Query(value = "select distinct(plan_status) from citizen_plan_table",nativeQuery = true)
	public List<String> getByPlanStatus();

}
