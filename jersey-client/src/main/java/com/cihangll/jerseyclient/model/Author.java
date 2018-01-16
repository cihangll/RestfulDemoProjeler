package com.cihangll.jerseyclient.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Author {

	@XmlElement
	private String id;
	@XmlElement
	private String name;
	@XmlElement
	private String surname;
	@XmlElement
	private String city;

	public Author() {
	}

	public Author(String id, String name, String surname, String city) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Author{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", city='" + city + '\'' +
				'}';
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
