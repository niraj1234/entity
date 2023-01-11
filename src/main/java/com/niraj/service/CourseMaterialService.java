package com.niraj.service;

import java.util.List;
import java.util.Optional;

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

	public List<CourseMaterial> getAllCourseMaterial() {
		return courseMaterialRepository.findAll();
	}

	public CourseMaterial getCourseMaterialById(Long courseMaterialId) {
		CourseMaterial courseMaterial;
		Optional<CourseMaterial> data = courseMaterialRepository.findById(courseMaterialId);
		if (data.isPresent()) {
			courseMaterial = data.get();
		} else {
			throw new RuntimeException("Data for current request CourseMaterial not available");
		}		
		return courseMaterial;
	}
	

}
