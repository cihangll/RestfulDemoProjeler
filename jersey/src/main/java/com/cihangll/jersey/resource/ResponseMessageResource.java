package com.cihangll.jersey.resource;

import com.cihangll.jersey.model.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("/responseMessage")
public class ResponseMessageResource {

	@GET
	@Path("/name")
	// http://localhost:8080/responseMessage/name
	public Response getPersonNameById() {

		String personName = "Cihan";

		//	Response.ResponseBuilder builder = Response.ok(personName);
		//	builder.header("myHeader","myHeaderValue");
		//	builder.cookie(new NewCookie("myCookie", "myCookieValue"));
		//	return builder.build();

		return Response.status(Response.Status.OK)
				.entity(personName)
				.header("myHeader", "myHeaderValue")
				.cookie(new NewCookie("myCookie", "myCookieValue"))
				.build();
	}

	@GET
	@Path("/persons")
	@Produces(MediaType.APPLICATION_JSON)
	// http://localhost:8080/responseMessage/persons
	public Response getAllPersons() {

		Person person1 = new Person(100, "Levent", "Erguder");
		Person person2 = new Person(101, "James", "Gosling");
		Person person3 = new Person(102, "Joshua", "Bloch");
		Person person4 = new Person(103, "Cihan", "Güllü");

		List<Person> persons = Arrays.asList(person1, person2, person3, person4);
		return Response.ok(persons).build();
	}
}
