package com.glearning.studentManagement.serviceImpl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.studentManagement.entity.Student;
import com.glearning.studentManagement.repository.StudentRepository;
import com.glearning.studentManagement.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
    
	@Autowired
	private StudentRepository studentRepository;
	@Override
	
	public List<Student> findAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Transactional
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		
		return studentRepository.save(student);
	}

	@Override
	public Student findStudentById(Long id) {
		// TODO Auto-generated method stub
		return this.studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid student id passed"));
	}

	

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		// TODO Auto-generated method stub
		Student existingStudent= this.studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid student id passed"));
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setCountry(student.getCountry());
		existingStudent.setCourse(student.getCourse());
		return studentRepository.save(existingStudent);
	}

}
