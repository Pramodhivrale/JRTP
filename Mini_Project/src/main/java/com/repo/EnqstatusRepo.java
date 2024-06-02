package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.EnqStatusEntity;

@Repository
public interface EnqstatusRepo extends JpaRepository<EnqStatusEntity, Integer>
{
	@Query(value = "SELECT DISTINCT enq_status FROM enquery_status",nativeQuery = true)
	public List<String> getEnqStatus();

}
