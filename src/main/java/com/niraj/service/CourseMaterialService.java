package com.niraj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niraj.entity.CourseMaterial;
import com.niraj.repositoty.CourseMaterialRepository;

@Service
public class CourseMaterialService {

	@Autowired
	private CourseMaterialRepository courseMaterialRepository;

	public CourseMaterial addCourseMaterial(CourseMaterial courseMaterial) {

		return courseMaterialRepository.save(courseMaterial);
	}
	
	


}
