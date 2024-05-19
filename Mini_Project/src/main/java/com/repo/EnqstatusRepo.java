package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.EnqStatusEntity;

@Repository
public interface EnqstatusRepo extends JpaRepository<EnqStatusEntity, Integer>{

}
