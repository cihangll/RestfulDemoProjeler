package com.cihangll.jersey.resource;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.*;

@Path("cookieparam")
public class CookieParamResource {

	@GET
	@Path("/addCookie")
	public Response addCookie() {

		String result = "addCookie is called.";
		Response.ResponseBuilder builder = Response.ok(result);
		builder.cookie(new NewCookie("myCookie", "myCookieValue"));
		return builder.build();

		//return  Response.status(Response.Status.OK).entity(result).cookie(new NewCookie("myCookie", "myCookieValue")).build();
	}

	@GET
	@Path("/getCookie")
	public Response getCookie(@CookieParam("myCookie") String cookie) {
		String result = "getCookie is called. <br/>";

		Response.ResponseBuilder builder = Response.ok(result + " myCookie : " + cookie);
		return builder.build();

		// return Response.status(200).entity(result + " myCookie : " + cookie).build();
	}
}