/**
 * @author Amith Gopal
 */
package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * This class is the Object Relational Mapper (ORM) for the candidates table in the database
 */

@XmlRootElement
@Entity(name = "candidates")
@Table(name = "candidates")
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private int candidateId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="candidatename")
	@JsonProperty("name")
	private String candidateName;
	
	@Column(name="skills")
	private String skills;
	
	
	@OneToOne
	@JoinColumn(name="username")
	private Login user;
	
	@OneToMany
	@JoinColumn(name="job_id_list")
	private List<Job> jobList;
	
	public Candidate() {
		
	}
	
	public int getCandidateId() {
		return this.candidateId;
	}
	
	public void setCandidateId(int candId) {
		this.candidateId = candId;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Login getUser() {
		return user;
	}

	public void setUser(Login user) {
		this.user = user;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

}
