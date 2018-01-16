package com.cihangll.jersey.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/clientTest")
public class ClientTestResource {

	@GET
	@Path("/message")
	// http://localhost:8080/beanparam/clientTest/message
	public String getHello() {
		String message = "Hello JAX-RS Client API!";
		return message;
	}

	@GET
	@Path("/messages")
	@Produces(MediaType.APPLICATION_JSON)
	// http://localhost:8080/beanparam/clientTest/messages
	public List<String> getMessages() {
		return Arrays.asList("Message-1", "Message-2", "Message-3");
	}
}
