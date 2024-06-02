package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.CourseEntity;

@Repository
public interface CourseListRepo extends JpaRepository<CourseEntity, Integer>
{
	@Query(value = "SELECT DISTINCT courses FROM Courses_data",nativeQuery = true)
	public List<String> GetcourseList();

}
