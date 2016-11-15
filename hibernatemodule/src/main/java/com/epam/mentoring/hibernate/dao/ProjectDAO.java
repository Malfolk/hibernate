package com.epam.mentoring.hibernate.dao;

import com.epam.mentoring.hibernate.beans.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Siarhei_Karytka
 */
public class ProjectDAO
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

	public void persist(Project entity)
	{
		getCurrentSession().save(entity);
	}

	public void update(Project entity)
	{
		getCurrentSession().update(entity);
	}

	public Project findById(long id)
	{
		Project book = (Project) getCurrentSession().get(Project.class, id);
		return book;
	}

	public void delete(Project entity)
	{
		getCurrentSession().delete(entity);
	}
}
