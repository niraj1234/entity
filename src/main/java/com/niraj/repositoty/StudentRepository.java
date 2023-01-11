package com.niraj.repositoty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niraj.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long>{
	public List<Student> findByFirstName(String firstName);
	public List<Student> findByFirstNameContaining(String name);
	public List<Student> findByLastNameNotNull();
	public List<Student> findByGuardianName(String name);
	public Student findByFirstNameAndLastName(String firstName , String lastName);
}
