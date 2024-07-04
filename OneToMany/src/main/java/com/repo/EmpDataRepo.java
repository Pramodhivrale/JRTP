package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.EmpEntity;

public interface EmpDataRepo extends JpaRepository<EmpEntity, Integer>{

}
