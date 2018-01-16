package com.cihangll.jersey.resource;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

@Path("/headerparam")
public class HeaderParamResource {

	//http://localhost:8080/headerparam/getInfo
	@GET
	@Path("/getInfo")
	public String getInfo(@HeaderParam("user-agent") String userAgent) {
		String message = "getInfo is called. <br/>" + "User Agent" + userAgent;
		return message;
	}
}
