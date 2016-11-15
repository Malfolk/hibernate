package com.epam.mentoring.hibernate.service;

import com.epam.mentoring.hibernate.beans.Unit;
import com.epam.mentoring.hibernate.dao.UnitDAO;

/**
 * @author Siarhei_Karytka
 */
public class UnitService
{
	private static UnitDAO unitDAO;

	public UnitService()
	{
		unitDAO = new UnitDAO();
	}

	public void persist(Unit entity)
	{
		unitDAO.openCurrentSessionwithTransaction();
		unitDAO.persist(entity);
		unitDAO.closeCurrentSessionwithTransaction();
	}

	public void update(Unit entity)
	{
		unitDAO.openCurrentSessionwithTransaction();
		unitDAO.update(entity);
		unitDAO.closeCurrentSessionwithTransaction();
	}

	public Unit findById(long id)
	{
		unitDAO.openCurrentSession();
		Unit unit = unitDAO.findById(id);
		unitDAO.closeCurrentSession();
		return unit;
	}

	public void delete(long id)
	{
		unitDAO.openCurrentSessionwithTransaction();
		Unit Unit = unitDAO.findById(id);
		unitDAO.delete(Unit);
		unitDAO.closeCurrentSessionwithTransaction();
	}

	public UnitDAO unitDAO()
	{
		return unitDAO;
	}
}
