package com.epam.mentoring.hibernate.service;

import com.epam.mentoring.hibernate.beans.Project;
import com.epam.mentoring.hibernate.dao.ProjectDAO;

/**
 * @author Siarhei_Karytka
 */
public class ProjectService
{
	private static ProjectDAO projectDAO;

	public ProjectService()
	{
		projectDAO = new ProjectDAO();
	}

	public void persist(Project entity)
	{
		projectDAO.openCurrentSessionwithTransaction();
		projectDAO.persist(entity);
		projectDAO.closeCurrentSessionwithTransaction();
	}

	public void update(Project entity)
	{
		projectDAO.openCurrentSessionwithTransaction();
		projectDAO.update(entity);
		projectDAO.closeCurrentSessionwithTransaction();
	}

	public Project findById(long id)
	{
		projectDAO.openCurrentSession();
		Project project = projectDAO.findById(id);
		projectDAO.closeCurrentSession();
		return project;
	}

	public void delete(long id)
	{
		projectDAO.openCurrentSessionwithTransaction();
		Project Project = projectDAO.findById(id);
		projectDAO.delete(Project);
		projectDAO.closeCurrentSessionwithTransaction();
	}

	public ProjectDAO projectDAO()
	{
		return projectDAO;
	}
}
