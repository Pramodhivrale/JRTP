package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.StudentEnqEntity;
import com.request.UpdateForm;

@Repository
public interface StudentEnqRepo extends JpaRepository<StudentEnqEntity, Integer>{


}
