package com.glearning.studentManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Student")
@Data
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Student_Id")
	 private long id;
	@Column(name="FirstName")
	 private String firstName;
	@Column(name="LastName")
	 private String lastName;
	@Column(name="Course")
	 private String course;
	@Column(name="Country")
	 private String country;
}
