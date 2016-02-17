package com.landa.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="currency")
public class Currency implements Comparable<Currency>{
	
	private int ID;
	private String name;
	private String country;
	private int yearAdopted;
	

	public Currency(int iD, String name, String country, int yearAdopted) {
		super();
		this.ID = iD;
		this.name = name;
		this.country = country;
		this.yearAdopted = yearAdopted;
	}
	
	public Currency() {
		// TODO Auto-generated constructor stub
	}

	public int compareTo(Currency other) {
        return name.compareTo(other.name);
    }
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getYearAdopted() {
		return yearAdopted;
	}
	public void setYearAdopted(int yearAdopted) {
		this.yearAdopted = yearAdopted;
	}
	
	
}

