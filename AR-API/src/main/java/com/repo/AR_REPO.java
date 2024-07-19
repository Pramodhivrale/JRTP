package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.ArEntity;

@Repository
public interface AR_REPO extends JpaRepository<ArEntity, Long>{

	@Query("SELECT a FROM ArEntity a WHERE a.iesUser.userId = :userId")
	public java.util.List<ArEntity> findByUserId(int userId);

}
