package com.epam.mentoring.hibernate.service;

import com.epam.mentoring.hibernate.beans.Employee;
import com.epam.mentoring.hibernate.beans.Project;
import com.epam.mentoring.hibernate.beans.Unit;
import com.epam.mentoring.hibernate.dao.EmployeeDAO;

/**
 * @author Siarhei_Karytka
 */
public class EmployeeService
{
	private static EmployeeDAO employeeDAO;
	private static UnitService unitService;
	private static ProjectService projectService;

	public EmployeeService()
	{
		employeeDAO = new EmployeeDAO();
		unitService = new UnitService();
		projectService = new ProjectService();
	}

	public void persist(Employee entity)
	{
		employeeDAO.openCurrentSessionwithTransaction();
		employeeDAO.persist(entity);
		employeeDAO.closeCurrentSessionwithTransaction();
	}

	public void update(Employee entity)
	{
		employeeDAO.openCurrentSessionwithTransaction();
		employeeDAO.update(entity);
		employeeDAO.closeCurrentSessionwithTransaction();
	}

	public Employee findById(long id)
	{
		employeeDAO.openCurrentSession();
		Employee employee = employeeDAO.findById(id);
		employeeDAO.closeCurrentSession();
		return employee;
	}

	public void delete(long id)
	{
		employeeDAO.openCurrentSessionwithTransaction();
		Employee Employee = employeeDAO.findById(id);
		employeeDAO.delete(Employee);
		employeeDAO.closeCurrentSessionwithTransaction();
	}

	public EmployeeDAO employeeDAO()
	{
		return employeeDAO;
	}

	public void addEmployeeToProject(long employeeID, long projectID)
	{
		Employee employee = findById(employeeID);
		Project project = projectService.findById(projectID);
		employee.getProjects().add(project);
		persist(employee);
	}

	public void addEmployeeToUnit(long employeeID, long unitID)
	{
		Employee employee = findById(employeeID);
		Unit unit = unitService.findById(unitID);
		employee.setUnit(unit);
		persist(employee);
	}
}
