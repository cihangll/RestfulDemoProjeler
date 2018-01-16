package com.cihangll.jerseyclient.resource;

import com.cihangll.jerseyclient.model.Author;
import com.cihangll.jerseyclient.model.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("/library-client-api")
public class LibraryResource {

	@GET
	@Path("/welcome")
	@Produces(MediaType.TEXT_PLAIN)
	// http://localhost:8080/api/library-client-api/welcome
	public Response welcome() {
		String message = "Welcome Library!";
		Response.ResponseBuilder builder = Response.ok(message);
		return builder.build();
	}

	@GET
	@Path("/book/{isbn}")
	@Produces(MediaType.APPLICATION_JSON)
	// http://localhost:8080/api/library-client-api/book/test
	public Response getBookById(@PathParam("isbn") String isbn) {
		// assume that searched in DB.
		Book book = new Book(isbn, "Livro do desassossego", 550, 23.72);
		Response.ResponseBuilder builder = Response.ok(book);
		return builder.build();
	}

	@GET
	@Path("/author")
	@Produces(MediaType.APPLICATION_XML)
	// http://localhost:8080/api/library-client-api/author
	public Response getAuthor() {
		Author author = new Author("1", "Fernando", "Pessoa", "Portugal");
		Response.ResponseBuilder builder = Response.ok(author);
		return builder.build();
	}

	@GET
	@Path("/authors")
	@Produces(MediaType.APPLICATION_XML)
	// http://localhost:8080/api/library-client-api/authors
	public List<Author> getAuthors() {
		Author author = new Author("1", "Turgut", "Uyar", "Turkey");
		Author author2 = new Author("2", "Albert", "Camus", "French");
		return Arrays.asList(author, author2);
	}
}
