package com.niraj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niraj.entity.Course;
import com.niraj.entity.Teacher;
import com.niraj.repositoty.CourseRepository;
import com.niraj.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CourseRepository courseRepository;
	
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
	
	@DeleteMapping("/delete/{courseId}")
	public String deleteById(@PathVariable("courseId") Long courseId ) {
		courseService.deleteCourseById(courseId);
		return "Course Deleted Successfully !!!";
	}
	
	@PutMapping("/edit/{courseId}")
	public Course updateCourse(@RequestBody Course course , @PathVariable("courseId") Long courseId) {	
		return courseService.updateCourse(course , courseId);		
	}

	
	@GetMapping("/saveCourseWithTeacher")
	public Course saveCourseWithTeacher() {
		
		Teacher teacherPriya = Teacher.builder().firstName("Priya").lastName("Sinha").build();
//		CourseMaterial courseMaterialPy = CourseMaterial.builder().url("www.python.in").build();
		Course coursePyThon = Course.builder().title("Python").fees(1111).teacher(teacherPriya).build();
		coursePyThon.setTeacher(teacherPriya);
		
		return courseService.saveCourseWithTeacher(coursePyThon);
	}
	

	@GetMapping("/pagination/{p}")
	public List<Course> findAllPagination(@PathVariable("p") String p ) {
		Pageable firstPageWithTwoRecords = PageRequest.of(0, 2);
		Pageable secondPageWithThreeRecords  = PageRequest.of(1, 3);
		
		Page<Course> pageCourse = null ;
		
		if(p.equalsIgnoreCase("one")) {
			pageCourse = courseRepository.findAll(firstPageWithTwoRecords);
		}

		if(p.equalsIgnoreCase("two")) {
			pageCourse = courseRepository.findAll(secondPageWithThreeRecords);
		}

		List<Course> courses  = pageCourse.getContent();
		
		return courses;
	}
	
	
	@GetMapping("/sort/{s}")
	public List<Course> findAllBySorting(@PathVariable("s") String s ) {
		Pageable sortByData = PageRequest.of(0, 4, Sort.by(s).descending() );
		
		List<Course> courses = courseRepository.findAll(sortByData).getContent() ;
		
		return courses;
		
	}
	
	
}






