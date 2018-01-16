package com.cihangll.jersey.resource;

import com.cihangll.jersey.model.Customer;
import com.cihangll.jersey.service.CustomerNotFoundException;
import com.cihangll.jersey.service.CustomerService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("/exception")
public class WebApplicationExceptionResource {

	@GET
	@Path("/customer1/{id}")
	// http://localhost:8080/exception/customer1/1
	public Customer getCustemer1(@PathParam("id") int id) {

		System.out.println("getCustomer is called....");

		CustomerService service = new CustomerService();

		Customer customer = service.findCustomer(id);
		if (customer == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return customer;
	}

	@GET
	@Path("/customer2/{id}")
	// http://localhost:8080/exception/customer2/1
	public Customer getCustomer2(@PathParam("id") int id) {

		CustomerService service = new CustomerService();

		Customer customer = service.findCustomer(id);
		if (customer == null) {
			throw new CustomerNotFoundException("Could not find customer id : " + id);
		}
		return customer;
	}

	@GET
	@Path("/name/{id}")
	public String getCustomerName(@PathParam("id") int id) {
		System.out.println("getCustomerName is called...");
		throw new WebApplicationException(Response.Status.NOT_IMPLEMENTED);
	}


}
