package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.CustomerEntity;


@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {

}
