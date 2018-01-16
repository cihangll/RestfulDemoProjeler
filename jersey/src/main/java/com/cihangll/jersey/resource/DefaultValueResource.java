package com.cihangll.jersey.resource;

import javax.ws.rs.*;
import java.util.List;

@Path("/defaultvalue")
public class DefaultValueResource {

	@GET
	@Path("/carById")
	//http://localhost:8080/defaultvalue/carById
	public String getCarById(@DefaultValue("100") @QueryParam("id") int id) {
		String message = "getBookById is called. <br/>" + " Id : " + id;
		return message;
	}

	@GET
	@Path("/carByMatrixParam")
	//http://localhost:8080/defaultvalue/carByMatrixParam
	public String getCarByMatrixParam(@DefaultValue("default value") @MatrixParam("brand") String brand,
									  @DefaultValue("default color") @MatrixParam("color") List<String> colors) {
		String message = "getCarWithMatrixParam is called.<br/>" + "Brand : " + brand + " Colors : " + colors;
		return message;
	}
}
