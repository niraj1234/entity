package com.niraj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niraj.entity.Course;
import com.niraj.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping("/add")
	public Course addCourse(@RequestBody Course course ) {
		return courseService.addCourse(course);
	}
	
	@GetMapping("/all")
	public List<Course> getAllCourse(){
		return courseService.getAllCourse();
	}

	@GetMapping("/{courseId}")
	public Course getCourseById(@PathVariable("courseId") Long courseId ) {
		return courseService.getCourseById(courseId);
	}
	
	@DeleteMapping("/{courseId}")
	public String deleteById(@PathVariable("courseId") Long courseId ) {
		courseService.deleteCourseById(courseId);
		return "Course Deleted Successfully !!!";
	}
	
	@PostMapping("edit/{courseId}")
	public Course updateCourse(@RequestBody Course course , @PathVariable("courseId") Long courseId) {

		// get the course first
		// Check if course available then update the value with new
		// If data is not there for any atribute, keep older value as it
		// after setting all the value call save method with courseId
		
		return course;		
	}
	
}







