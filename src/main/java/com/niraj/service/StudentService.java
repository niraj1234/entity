package com.niraj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niraj.entity.Student;
import com.niraj.repositoty.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student addNewStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	public List<Student> studentByFirstName(String firstName) {
		return studentRepository.findByFirstName(firstName);
	}
	
	
	public Student getStudentByEmailId(String emailId) {
		return studentRepository.getStudentByEmailId(emailId);
	}
	
	public Student getStudentByEmailNative(String emailId) {
		return studentRepository.getStudentByEmailNative(emailId);
	}

	public int updateFirstNameByEmail(String firstName, String emailId) {
		return studentRepository.updateStudentFirstNameByEmailId(firstName, emailId);
	}
	
	
}
