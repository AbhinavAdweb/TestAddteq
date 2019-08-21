package com.abhinav.addteq.model;

import javax.persistence.*;

@Entity
@Table(name = "addteqTestUsers")
public class UserData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String userName;
	
	public UserData() {

	}

	public UserData(String userName) {
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
