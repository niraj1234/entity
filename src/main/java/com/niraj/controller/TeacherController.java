package com.niraj.controller;

import java.nio.channels.AsynchronousByteChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niraj.entity.Course;
import com.niraj.entity.Teacher;
import com.niraj.repositoty.TeacherRepository;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private TeacherRepository  teacherRepository;
	
	
	@GetMapping("/saveTeacher")
	public String saveTeacher() {
		Course coursePHP = Course.builder().title("PHP").fees(345).build();
		Course courseLaravel = Course.builder().title("Laravel").fees(726).build();
		Course courseCodeIgniter = Course.builder().title("CodeIgniter").fees(772).build();
		
		ArrayList<Course> courseList = new ArrayList<>();
		courseList.add(coursePHP);
		courseList.add(courseLaravel);
		courseList.add(courseCodeIgniter);

//      Now this shifted to ManyToOne Mapping
//		Teacher teacher = Teacher.builder()
//		.firstName("Pat").lastName("Cummins")
//		.courses(courseList).build();	
//		teacherRepository.save(teacher);
		
		return "Use Case Completed ==> "+(new Date()).toString();
	}  
	
}
