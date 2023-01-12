package com.niraj.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niraj.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long>{

}
