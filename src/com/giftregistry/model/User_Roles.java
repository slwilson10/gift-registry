package com.giftregistry.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user_roles")
public class User_Roles {
	
	@Id
	@Column(name="user_role_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleId;
	
	
	@Column(name="username")
	private String username;
	
	@Column(name="ROLE")
	private String role;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString(){
		return "username="+username+", roleId="+roleId+", role="+role;
	}

}
