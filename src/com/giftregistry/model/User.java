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
@Table(name="users")
public class User {
	@Id
	@Column(name="username")
	@Size(min=2, max=30)
	@NotEmpty
	private String username;
	
	@Column(name="password")
	@Size(min=2, max=30)
	@NotEmpty
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString(){
		return "username="+username+", password="+password;
	}

}


