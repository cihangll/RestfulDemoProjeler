package com.cihangll.jersey.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.PathSegment;
import java.util.List;

@Path("/pathsegment")
public class PathSegmentResource {

	//http://localhost:8080/pathsegment/car/criteria;color=red;color=blue;color=green;brand=testBrand
	@GET
	@Path("/car/{search : criteria}")
	public String getCar(@PathParam("search") PathSegment pathSegment) {
		//brand keyi ile gelmiş olan ilk değeri getir.
		String brand = pathSegment.getMatrixParameters().getFirst("brand");
		//kolor keyi ile gelen bütün değerleri liste halinde getir.
		List<String> colors = pathSegment.getMatrixParameters().get("color");
		String message = "getCar is called.<br/>";
		return message + "Brand: " + brand + " , Color :" + colors;
	}

	//http://localhost:8080/pathsegment/car/mercedes/blue/year/2015
	@GET
	@Path("car/{model : .+}/year/{year}")
	public String getCarByYear(@PathParam("model") List<PathSegment> car, @PathParam("year") String year) {
		String message = "getCarByYear is called.<br/>";
		return message + "Properties : " + car + " , Year : " + year;
	}


}
