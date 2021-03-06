/**
 * @author ${Prashanth Thipparthi}
 */
package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * This class is the Object Relational Mapper (ORM) for the Login table in the database
 */

@XmlRootElement
@Entity(name = "login")
@Table(name = "login")
public class Login {
	
	@Id
	private String username;
	private String password;
	private boolean flag;
	
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
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
