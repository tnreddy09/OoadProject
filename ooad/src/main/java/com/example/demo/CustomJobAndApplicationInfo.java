/**
 * @author Amith Gopal
 */
package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/*
 * This class is designed to accomodate information about job and application information.
 * This class information will be later serialized by the CustomJobAndApplicationInfoSerializer class
 */

@JsonSerialize(using=CustomJobAndApplicationInfoSerializer.class)
public class CustomJobAndApplicationInfo {
	List<Application> apps;
	Long jobId;
	String description;
	String skills;
	String location;
	String role;
	
	public CustomJobAndApplicationInfo(List<Application> apps, Long jobId, String description,
			String skills, String location, String role) {
		this.apps = apps;
		this.jobId = jobId;
		this.description = description;
		this.location = location;
		this.skills = skills;
		this.role = role;
	}
	
}
