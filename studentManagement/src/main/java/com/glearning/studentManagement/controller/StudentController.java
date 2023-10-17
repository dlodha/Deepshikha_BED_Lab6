package com.glearning.studentManagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.glearning.studentManagement.entity.Student;
import com.glearning.studentManagement.service.StudentService;


@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@RequestMapping("/students/list")
    public String getStudents(Model model) {
		List<Student> students =studentService.findAllStudent();
		model.addAttribute("students", students);
		return "students";
	}
	@GetMapping("/students/new")
    public String createStudent(Model model) {
		Student student =new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	@PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
	    return "redirect:/students/list";
	} 
	
	@PostMapping("/students/{id}")
    public String updateStudent(@ModelAttribute("student") Student student,@PathVariable Long id) {
		studentService.updateStudent(id,student);
	    return "redirect:/students/list";
	}
	
	@GetMapping("/students/edit/{id}")
	 public String updateStudentForm(@PathVariable Long id,  Model model) {
	  model.addAttribute("student",studentService.findStudentById(id));
	  return "edit_student";
	 }
	

	@GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
	    return "redirect:/students/list";
	}
	@GetMapping("/students/403")
    public String error403(Model model) {
		model.addAttribute("msg","Error 403 Access Denied");
		return "403";
	}
}
