package com.niraj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	}
	
	@GetMapping("/all")
	public List<CourseMaterial> getAllCourseMaterial(){	
		return courseMaterialSevice.getAllCourseMaterial();	
	}

	@GetMapping("/{courseMaterialId}")
	public CourseMaterial getCourseMaterialById(@PathVariable("courseMaterialId") Long courseMaterialId) {
		return courseMaterialSevice.getCourseMaterialById(courseMaterialId);
	}
	
}
