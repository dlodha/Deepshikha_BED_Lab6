package com.glearning.studentManagement.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="users")
@Getter
@Setter
@ToString(exclude="roles")
@EqualsAndHashCode(exclude="role")
@NoArgsConstructor
public class User {

   @Id
   @Column(name = "user_id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name="username")
   private String username;
   @Column(name="password")
   private String password;
    
	@ManyToMany(mappedBy="users", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Role> roles;
	
	public void addRole(Role role) {
		if(this.roles == null) {
			this.roles = new ArrayList<>();
		}
		this.roles.add(role);
		role.getUsers().add(this);
	}

}