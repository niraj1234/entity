package com.niraj.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "courseMaterialId")
public class CourseMaterial {

	@Id
	@SequenceGenerator( name = "course_material_sequence" , sequenceName = "course_material_sequence" , allocationSize = 1)
	@GeneratedValue( strategy = GenerationType.SEQUENCE , generator = "course_material_sequence")
	private Long courseMaterialId;
	
	private String url;
	
	// 
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER , optional = false)
	@JoinColumn(name = "course_id_fk" , referencedColumnName =  "courseId")
	private Course course;
	
}
