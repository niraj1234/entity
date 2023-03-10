package com.niraj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niraj.entity.Student;
import com.niraj.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;


	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addNewStudent(student);		
	}

	@GetMapping("/all")
	public List<Student> getAllStudent(){
	return 	studentService.getAllStudent();
	}
	
	@GetMapping("/byName/{firstName}")
	public List<Student> getStudentByFirstName(@PathVariable("firstName") String firstName){
		return studentService.studentByFirstName(firstName);
	}

	@GetMapping("/byEmail/{email}")
	public Student getStudentByEmail(@PathVariable("email") String email){
		return studentService.getStudentByEmailId(email);
	}

	@GetMapping("/byEmailNative/{email}")
	public Student getStudentByEmailNative(@PathVariable("email") String email){
		return studentService.getStudentByEmailNative(email);
	}

	@GetMapping("/updateFirstName/{firstName}/{emailId}")
	public String updateFirstNameByEmailId(@PathVariable("firstName") String firstName , @PathVariable("emailId") String emailId ) {
        String responseMessage = "failed updation";
		int result = studentService.updateFirstNameByEmail(firstName,emailId);
		if(result>0) {
			responseMessage = "Updation of First Name successfully !!!" ;
		}
		return responseMessage;
	}
	
}
