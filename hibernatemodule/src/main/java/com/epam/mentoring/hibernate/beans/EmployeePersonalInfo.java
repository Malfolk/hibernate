package com.epam.mentoring.hibernate.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author Siarhei_Karytka
 */
@Entity
public class EmployeePersonalInfo
{
	@Id
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="employee"))
	private long employeeID;

	@Column
	private String employeeName;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Employee employee;

	public long getEmployeeID()
	{
		return employeeID;
	}

	public void setEmployeeID(long employeeID)
	{
		this.employeeID = employeeID;
	}

	public Employee getEmployee()
	{
		return employee;
	}

	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}

	public String getEmployeeName()
	{
		return employeeName;
	}

	public void setEmployeeName(String employeeName)
	{
		this.employeeName = employeeName;
	}
}
