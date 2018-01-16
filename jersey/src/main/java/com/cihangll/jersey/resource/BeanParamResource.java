package com.cihangll.jersey.resource;

import com.cihangll.jersey.model.Product;
import com.cihangll.jersey.model.User;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/beanparam")
public class BeanParamResource {

	@GET
	@Path("/getProductById/{category}")
	// http://localhost:8080/beanparam/getProductById/computer?id=5
	public String getProductById(@BeanParam Product product) {
		return "getProductById is called. <br/> " + product.toString();
	}

	@GET
	@Path("/getProductsByBrand/{category}")
	// http://localhost:8080/beanparam/getProductById/computer;brand=acerMarka;price=15413.151
	public String getProductsByBrand(@BeanParam Product product) {
		return "getProductsByBrand is called. <br/>" + product.toString();
	}

	@POST
	@Path("/addUser")
	public String addUser(@BeanParam User user) {
		return "addUser is called. " + user.toString();
	}
}