package com.glearning.studentManagement.service;

import java.util.List;

import com.glearning.studentManagement.entity.Student;

public interface StudentService {
	  public List<Student> findAllStudent();
	  public Student saveStudent(Student student);
	  public Student updateStudent(Long id,Student student);
	  public Student findStudentById(Long id);
	  public void deleteStudent(Long id);
}
