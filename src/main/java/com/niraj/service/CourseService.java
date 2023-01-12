package com.niraj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niraj.entity.Course;
import com.niraj.repositoty.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	public List<Course> getAllCourse() {
		return courseRepository.findAll();
	}

	public Course getCourseById(Long courseId) {
		return courseRepository.findById(courseId).get();
	}

	public void deleteCourseById(Long courseId) {
		courseRepository.deleteById(courseId);		
	}

	public Course updateCourse(Course course, Long courseId) {
		Course courseInDb = getCourseById(courseId);
		courseInDb.setFees(course.getFees() != null ? course.getFees() : courseInDb.getFees());
		courseInDb.setTitle(course.getTitle() != null ? course.getTitle() : courseInDb.getTitle());
		return courseRepository.save(courseInDb);
	}

	public Course saveCourseWithTeacher(Course coursePyThon) {
		System.out.println("In Course with Teache" + coursePyThon);
		return courseRepository.save(coursePyThon);
	}


}
