package com.niraj.repositoty;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.niraj.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long>{
	public List<Student> findByFirstName(String firstName);
	public List<Student> findByFirstNameContaining(String name);
	public List<Student> findByLastNameNotNull();
	public List<Student> findByGuardianName(String name);
	public Student findByFirstNameAndLastName(String firstName , String lastName);
	
	
	// Custom Made Functions

	// JPQL
	@Query("select s from Student s where s.emailId = ?1")
	public Student getStudentByEmailId(String emailId);
	
	@Query("select s.firstName from Student s where s.emailId = ?1")
	public Student getStudentFirstNameByEmailId(String emailId);
	
	// Native Query
	@Query(value= "select * from tbl_student s where s.email_address = ?1" , nativeQuery = true)
	public Student getStudentByEmailNative(String emailId);
	
	// Native Named Query
	@Query(value= "select * from tbl_student s where s.email_address = :emailId" , nativeQuery = true)
	public Student getStudentByEmailNativeNamed(@Param("emailId") String emailId);

	@Modifying
	@Transactional
	@Query(value="update tbl_student set first_name = ?1 where email_address = ?2" , nativeQuery = true)
    public int updateStudentFirstNameByEmailId(String firstName , String emailId); 	
	
	
}










