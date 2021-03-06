package com.cihangll.jersey.resource;

import com.cihangll.jersey.model.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@Path("/jaxb")
public class JaxbResource {

	@GET
	@Path("/person")
	@Produces(MediaType.APPLICATION_XML)
	// http://localhost:8080/jaxb/person
	public Person getPerson() {

		Person person = new Person();
		person.setId(1);
		person.setName("Cihan");
		person.setSurname("Güllü");

		return person;
	}

	@GET
	@Path("/personWithJAXBContext")
	@Produces(MediaType.APPLICATION_XML)
	// http://localhost:8080/jaxb/personWithJAXBContext
	public String getPersonWithJAXBContext() throws JAXBException {

		Person person = new Person();
		person.setId(1);
		person.setName("Cihan");
		person.setSurname("Güllü");

		/**
		 * Marshalling – Java objelerini -> XML e donusturme islemi
		 * Unmarshalling – XML icerigini Java objelererine donusturme islemi
		 */
		JAXBContext context = JAXBContext.newInstance(Person.class);
		StringWriter writer = new StringWriter();
		context.createMarshaller().marshal(person, writer);
		return writer.toString();
	}

	@GET
	@Path("/persons")
	@Produces(MediaType.APPLICATION_XML)
	// http://localhost:8080/jaxb/persons
	public List<Person> getPersons() {
		Person person1 = new Person();
		person1.setId(1);
		person1.setName("Levent");
		person1.setSurname("Erguder");

		Person person2 = new Person();
		person2.setId(2);
		person2.setName("Joshua");
		person2.setSurname("Bloch");

		Person person3 = new Person();
		person3.setId(3);
		person3.setName("James");
		person3.setSurname("Gosling");

		List<Person> persons = new ArrayList<Person>();
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);

		return persons;
	}

	@GET
	@Path("/personsArray")
	@Produces(MediaType.APPLICATION_XML)
	// http://localhost:8080/jaxb/personsArray
	public Person[] getPersonsArray() {
		Person person1 = new Person();
		person1.setId(1);
		person1.setName("Levent");
		person1.setSurname("Erguder");

		Person person2 = new Person();
		person2.setId(2);
		person2.setName("Joshua");
		person2.setSurname("Bloch");

		Person person3 = new Person();
		person3.setId(3);
		person3.setName("James");
		person3.setSurname("Gosling");

		Person[] persons = new Person[]{person1, person2, person3};

		return persons;
	}
}
