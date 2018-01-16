package com.cihangll.jerseyclient.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/message-client-api")
public class MessageResource {

	@GET
	@Path("/message")
	// http://localhost:8080/api/message-client-api/message
	public String getMessage() {
		String message = "Hello JAX-RS Client API!";
		return message;
	}

	@GET
	@Path("/messages")
	@Produces(MediaType.APPLICATION_JSON)
	// http://localhost:8080/api/message-client-api/messages
	public List<String> getMessages() {
		return Arrays.asList("Message-1", "Message-2", "Message-3");
	}

}
