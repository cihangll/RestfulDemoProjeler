package com.cihangll.jersey.resource;

import com.cihangll.jersey.model.Customer;
import com.cihangll.jersey.service.CustomerService;

import javax.ws.rs.*;

@Path("/exceptions")
public class ExceptionResource {

	/*
	 * JAX-RS 2.0 da HTTP error durumlarına karşılık exception sınıfları yer almakta.
	 * Hata fırlatmak için bunları kullanabiliriz.
	 *
	 * BadRequestException - 400
	 * NotAuthorizedException - 401
	 * ForbiddedException - 403
	 * NotFoundException - 404
	 * NotAllowedException - 405
	 * NotAcceptableException - 406
	 * NotSupportedException - 415
	 * InternalServerErrorException - 500
	 * ServiceUnavailableException - 503
	 *
	 * */

	@GET
	@Path("/customer/{id}")
	// http://localhost:8080/exceptions/customer/5
	public Customer getCustomer(@PathParam("id") int id) {

		System.out.println("getCustomer is called.");

		CustomerService service = new CustomerService();
		Customer customer = service.findCustomer(id);
		if (customer == null) {
			throw new NotFoundException();
		}
		return customer;
	}

	@GET
	@Path("/name/{id}")
	// http://localhost:8080/exceptions/name/5
	public String getCustomerName(@PathParam("id") int id) {
		System.out.println("getCustomerName is called...");
		//
		//
		throw new NotSupportedException();
	}

	@GET
	@Path("/address/{id}")
	// http://localhost:8080/exceptions/address/5
	public String getCustomerAddress(@PathParam("id") int id) {
		System.out.println("getCustomerAddress is called...");
		///
		///
		throw new ServiceUnavailableException();
	}
}
