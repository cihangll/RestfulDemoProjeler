package com.cihangll.jersey.resource;

import javax.ws.rs.*;

@Path("http-response")
public class HTTPResponseResource {

	@GET
	@Path("/responseOk")
	// Status Code - 200
	// http://localhost:8080/http-response/responseOk
	public String responseOk() {
		return "responseOk is called.";
	}

	@GET
	@Path("/responseNull")
	// Status Code - 204
	// http://localhost:8080/http-response/responseNull
	public String responseNull() {
		return null;
	}

	// HTTP Response Code : 204
	// Send HTTP DELETE
	@DELETE
	@Path("/person/{id}")
	public void delete(@PathParam("id") int id) {
	}


	// send with HTTP GET
	//
	// RESTEasy
	// javax.ws.rs.NotAllowedException: RESTEASY003650: No resource method found
	// for GET, return 405 with Allow header
	//
	// Jersey
	// HTTP Response Code : 405
	// HTTP Status 405 - Method Not Allowed
	@POST
	@Path("/response405")
	public String response405() {
		String message = "response405 is called.";
		return message;
	}

}
