package com.cihangll.jersey.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/library")
public class QueryParamResource {

	@GET
	@Path("/book")
	public String getBookById(@QueryParam("id") int id) {
		String message = "getBookById is called.<br/>" + "Id : " + id;
		return message;
	}

	@GET
	@Path("/book-byName")
	public String getBookByName(@QueryParam("name") String name) {
		String message = "getBookByName is called. <br/>" + " Name : " + name;
		return message;

	}

	@GET
	@Path("/books")
	public String getBooks(
			@QueryParam("start") int start, @QueryParam("end") int end,
			@QueryParam("orderBy") List<String> orderBy) {
		String message = "getBooks is called. <br/>" + " Start : " + start + " End : " + end + " OrderBy : " + orderBy;
		return message;
	}

	@GET
	@Path("/books-uriInfo")
	// http://localhost:8080/library/books-uriInfo?start=20&end=30&orderBy=author&orderBy=year
	public String getBooksUriInfo(@Context UriInfo uriInfo) {
		String start = uriInfo.getQueryParameters().getFirst("start");
		String end = uriInfo.getQueryParameters().getFirst("end");
		List<String> orderBy = uriInfo.getQueryParameters().get("orderBy");

		String message = "getBooksUriInfo is called. <br/>" + " Start : " + start + " End : " + end + " OrderBy : "
				+ orderBy;
		return message;
	}
}
