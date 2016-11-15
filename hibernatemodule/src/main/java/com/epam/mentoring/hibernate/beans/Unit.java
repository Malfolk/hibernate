package com.epam.mentoring.hibernate.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * @author Siarhei_Karytka
 */
@Entity
public class Unit
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
	@SequenceGenerator(name = "id_seq", sequenceName = "id_sequence")
	private long unitID;

	@Column
	private String unitName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "unit")
	List<Employee> employees;

	public long getUnitID()
	{
		return unitID;
	}

	public void setUnitID(long unitID)
	{
		this.unitID = unitID;
	}

	public List<Employee> getEmployees()
	{
		return employees;
	}

	public void setEmployees(List<Employee> employees)
	{
		this.employees = employees;
	}

	public String getUnitName()
	{
		return unitName;
	}

	public void setUnitName(String unitName)
	{
		this.unitName = unitName;
	}
}
