/**
 * @author Amith Gopal
 */
package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * This class is the Object Relational Mapper (ORM) for the applications table in the database
 */


@XmlRootElement
@Entity
@Table(name = "applications") 
public class Application implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="application_id")
	@JsonProperty("appId")
	private int application_id;	
	
	
	@ManyToOne
	@JoinColumn(name="job_id")
	private Job jObj;
	
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidateObj;
	
	@JsonProperty("creationDate")
	private Date creation_date;
	@JsonProperty("status")
	private String status;
	
	public Application() {}
	
	public int getApplicationId()
	{
		return application_id;
	}
	
	public void setApplicationId(int applicationId)
	{
		this.application_id = applicationId;
	}
	
	
	public Job getJob()
	{
		return this.jObj;
	}
	
	public void setJob(Job job)
	{
		this.jObj = job;
	}
	
	public Candidate getCandidate()
	{
		return this.candidateObj;
	}
	
	public void setCandidate(Candidate candidate)
	{
		this.candidateObj = candidate;
	}
	
	
	public Date getCreationDate()
	{
		return creation_date;
	}
	
	public void setCreationDate(Date date)
	{
		this.creation_date = date;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}

}

