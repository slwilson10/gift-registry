package com.giftregistry.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="WhoFor")

public class WhoFor {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="WhoForName")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return name;
	}

}
