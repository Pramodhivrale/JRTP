package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.LoanEntity;

@Repository
public interface LoanRepo extends JpaRepository<LoanEntity, Integer>{

}
