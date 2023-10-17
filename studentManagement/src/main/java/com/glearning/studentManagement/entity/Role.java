package com.glearning.studentManagement.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Setter
@Getter
@ToString(exclude="users")
@EqualsAndHashCode(of ="id")
@NoArgsConstructor
@Table(name="roles")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;
	@ManyToMany
	@JoinTable(
			name="users_roles",
			joinColumns = @JoinColumn(name="role_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
	)
	private Set<User> users;
	
	public Set<User> getUsers(){
		if(this.users == null) {
			this.users = new HashSet<>();
		}
		return this.users;
	}
    
}