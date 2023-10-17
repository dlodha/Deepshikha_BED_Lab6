package com.glearning.studentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.studentManagement.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
