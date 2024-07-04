package com.adminRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adminEntity.PlansEntity;

@Repository
public interface PlansRepo extends JpaRepository<PlansEntity, Integer> {

}
