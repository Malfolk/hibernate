package com.epam.mentoring.hibernate.dao;

import com.epam.mentoring.hibernate.beans.Unit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Siarhei_Karytka
 */
public class UnitDAO
{
	private Session currentSession;

	private Transaction currentTransaction;

	private static SessionFactory getSessionFactory()
	{
		return HibernateUtil.getSessionFactory();
	}

	public Session openCurrentSession()
	{
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction()
	{
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession()
	{
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction()
	{
		currentTransaction.commit();
		currentSession.close();
	}

	public Session getCurrentSession()
	{
		return currentSession;
	}

	public void setCurrentSession(Session currentSession)
	{
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction()
	{
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction)
	{
		this.currentTransaction = currentTransaction;
	}

	public void persist(Unit entity)
	{
		getCurrentSession().save(entity);
	}

	public void update(Unit entity)
	{
		getCurrentSession().update(entity);
	}

	public Unit findById(long id)
	{
		Unit unit = (Unit) getCurrentSession().get(Unit.class, id);
		return unit;
	}

	public void delete(Unit entity)
	{
		getCurrentSession().delete(entity);
	}
}
