package com.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.entity.CourseEntity;
import com.entity.EnqStatusEntity;
import com.repo.CourseListRepo;
import com.repo.EnqstatusRepo;

@Component
public class Runner implements ApplicationRunner{
	
	@Autowired
	private CourseListRepo courseListRepo;
	
	@Autowired
	private EnqstatusRepo enqstatusRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
	
		CourseEntity course=new CourseEntity();
		
		List<String> c=new ArrayList<>();
		c.add("Java-FullStack");
		c.add("Ui-Development");
		c.add(".Net-FullStack");
		c.add("Python-Fullstack");
		
		course.setCourses(c);
		courseListRepo.save(course);
		System.out.println("Courses updated");
		
		
		EnqStatusEntity e=new EnqStatusEntity();
		
		List<String> list=new ArrayList<>();
		list.add("NEW");
		list.add("ENROLLED");
		list.add("LOST");
		
		e.setEnqStatus(list);
		enqstatusRepo.save(e);
		System.out.println("Status updated");
		
		
		
		
		
		
		
		
	}

}
