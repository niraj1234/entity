package com.niraj.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "courseId")
public class Course {

	@Id
	@SequenceGenerator(name="course_sequence" , sequenceName = "course_sequence_1" , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "course_sequence_table")
	private Long courseId;
	private String title;
	private Integer fees;

	@OneToOne(mappedBy = "course")
	private CourseMaterial courseMaterial;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id_fk" , referencedColumnName = "teacherId")
	private Teacher teacher;
	
	@ManyToMany
	@JoinTable(name = "course_student_map", 
				joinColumns = @JoinColumn( 
									name = "course_id", 
									referencedColumnName = "courseId"), 
				inverseJoinColumns = @JoinColumn(
									name = "student_id", 
									referencedColumnName = "studentId")
	)
	private List<Student> students;
	
	public void addStudent(Student st) {
		if (students == null) {
			students = new ArrayList<Student>();
		}
		students.add(st);
	}



}




