package com.glearning.studentManagement.bootStrapAppUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.glearning.studentManagement.entity.Role;
import com.glearning.studentManagement.entity.User;
import com.glearning.studentManagement.repository.RoleRepository;
import com.glearning.studentManagement.repository.UserRepository;

//@Component
//public class BootStrapAppUtil {
//	@Autowired
//	private UserRepository userRepository;
//	@Autowired
//	private RoleRepository roleRepository;
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	@EventListener(ApplicationReadyEvent.class)
//	public void insertUsers(ApplicationReadyEvent event) {
//		User deepshikha = new User();
//		deepshikha.setUsername("Deepshikha");
//		deepshikha.setPassword(this.passwordEncoder.encode("welcome"));
//
//		User admin = new User();
//		admin.setUsername("Admin");
//		admin.setPassword(this.passwordEncoder.encode("welcome"));
//		
//		this.userRepository.save(deepshikha);
//		this.userRepository.save(admin);
//		
//		Role userRole = new Role();
//		userRole.setName("USER");
//		
//		Role adminRole = new Role();
//		adminRole.setName("ADMIN");
//		
//		this.roleRepository.save(userRole);
//		this.roleRepository.save(adminRole);
//		
//		
//		deepshikha.addRole(userRole);
//		admin.addRole(userRole);
//		admin.addRole(adminRole);
//		
//		this.userRepository.save(deepshikha);
//		this.userRepository.save(admin);
//	}
//
//}
