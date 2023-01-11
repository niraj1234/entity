package com.niraj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niraj.entity.CourseMaterial;
import com.niraj.service.CourseMaterialService;

@RestController
@RequestMapping("/courseMaterial")
public class CourseMaterialController {

	@Autowired
	private CourseMaterialService courseMaterialSevice;

	@PostMapping("/add")
	public CourseMaterial addCourseMaterial(@RequestBody CourseMaterial courseMaterial) {	

	    System.out.println("Data in Course Material ==> " + courseMaterial);	
		return courseMaterialSevice.addCourseMaterial(courseMaterial);			
	//	return null;			

	}
}
