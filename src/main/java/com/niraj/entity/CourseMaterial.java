package com.niraj.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseMaterial {

	@Id
	@SequenceGenerator( name = "course_material_sequence" , sequenceName = "course_material_sequence" , allocationSize = 1)
	@GeneratedValue( strategy = GenerationType.SEQUENCE , generator = "course_material_sequence")
	private Long courseMaterialId;
	
	private String url;
	
}
