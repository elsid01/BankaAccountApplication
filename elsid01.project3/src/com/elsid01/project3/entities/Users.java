package com.elsid01.project3.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Users {
	@Id
	//@GeneratedValue
	private int id;
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public int getId() {
//		return id;
//	}

	@Basic
	@Column
	private String userName;
	@Basic
	@Column
	private String password;
	
	public Users() {
		super();
	}
	
	public Users(int id, String userName, String password) {
		this.id=id;
		this.userName=userName;
		this.password=password;
	}
}
