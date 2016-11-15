package com.epam.mentoring.hibernate.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Siarhei_Karytka
 */
@Embeddable
public class Address
{
	@Column(name = "street")
	private String street;

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}
}
