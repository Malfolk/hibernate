package com.epam.mentoring.hibernate.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

/**
 * @author Siarhei_Karytka
 */
@Entity
public class Project
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
	@SequenceGenerator(name = "id_seq", sequenceName = "id_sequence")
	private long projectID;

	@Column
	private String projectName;

	@ManyToMany(mappedBy = "projects")
	private List<Employee> employees;

	public long getProjectID()
	{
		return projectID;
	}

	public void setProjectID(long projectID)
	{
		this.projectID = projectID;
	}

	public List<Employee> getEmployees()
	{
		return employees;
	}

	public void setEmployees(List<Employee> employees)
	{
		this.employees = employees;
	}

	public String getProjectName()
	{
		return projectName;
	}

	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}
}
