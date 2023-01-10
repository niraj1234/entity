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
@AllArgsConstructor
@NoArgsConstructor
public class Course {

	@Id
	@SequenceGenerator(name="course_sequence" , sequenceName = "course_sequence_1" , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "course_sequence_table")
	private Long courseId;
	private String title;
	private Integer fees;
	
}
