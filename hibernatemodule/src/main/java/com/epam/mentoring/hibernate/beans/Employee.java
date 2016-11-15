package com.epam.mentoring.hibernate.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author Siarhei_Karytka
 */
@Entity
public class Employee
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
	@SequenceGenerator(name = "id_seq", sequenceName = "id_sequence")
	private long employeeID;

	@OneToOne(mappedBy = "employee", cascade=CascadeType.ALL)
	private EmployeePersonalInfo employeePersonalInfo;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ProjectEmployees",
			joinColumns = { @JoinColumn(name = "employeeID") },
			inverseJoinColumns = { @JoinColumn(name = "projectID") })
	private List<Project> projects = new ArrayList<Project>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unitID")
	private Unit unit;

	@Embedded
	private Address address;

	public long getEmployeeID()
	{
		return employeeID;
	}

	public void setEmployeeID(long employeeID)
	{
		this.employeeID = employeeID;
	}

	public EmployeePersonalInfo getEmployeePersonalInfo()
	{
		return employeePersonalInfo;
	}

	public void setEmployeePersonalInfo(EmployeePersonalInfo employeePersonalInfo)
	{
		this.employeePersonalInfo = employeePersonalInfo;
	}

	public List<Project> getProjects()
	{
		return projects;
	}

	public void setProjects(List<Project> projects)
	{
		this.projects = projects;
	}

	public Unit getUnit()
	{
		return unit;
	}

	public void setUnit(Unit unit)
	{
		this.unit = unit;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}
}
