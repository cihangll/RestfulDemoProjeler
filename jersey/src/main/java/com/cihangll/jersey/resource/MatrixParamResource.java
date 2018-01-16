package com.cihangll.jersey.resource;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import java.util.List;

@Path("/matrixparam")
public class MatrixParamResource {

	//http://localhost:8080/matrixparam/car;brand=Mercedes;color=red;color=blue;
	@GET
	@Path("/car")
	public String getCarWithMatrixParam(
			@MatrixParam("brand") String brand,
			@MatrixParam("color") List<String> colors) {
		String message = "getCarWithMatrixParam is called.<br/>" + "Brand: " + brand + ", Color:" + colors;
		return message;
	}
}
