package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.AddressClass;

public interface AddRepo extends JpaRepository<AddressClass, Integer> {

}
