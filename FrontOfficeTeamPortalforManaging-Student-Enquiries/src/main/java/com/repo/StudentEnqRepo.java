package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bindings.UpdateForm;
import com.entity.StudentEnqEntity;

@Repository
public interface StudentEnqRepo extends JpaRepository<StudentEnqEntity, Integer>{


}
