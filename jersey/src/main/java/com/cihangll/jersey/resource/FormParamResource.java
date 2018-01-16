package com.cihangll.jersey.resource;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("formparam")
public class FormParamResource {

	@POST
	@Path("/addPerson")
	public String addPerson(@FormParam("name") String name, @FormParam("surname") String surname) {
		String message = "addPerson is called. " + "Welcome , " + name + " " + surname;
		return message;
	}

}
