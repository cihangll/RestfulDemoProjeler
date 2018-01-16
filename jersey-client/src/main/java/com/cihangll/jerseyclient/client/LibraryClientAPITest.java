package com.cihangll.jerseyclient.client;

import com.cihangll.jerseyclient.model.Author;
import com.cihangll.jerseyclient.model.Book;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

public class LibraryClientAPITest {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();

		String uri1 = "http://localhost:8080/api/library-client-api/welcome";
		String uri2 = "http://localhost:8080/api/library-client-api/book/test";
		String uri3 = "http://localhost:8080/api/library-client-api/author";
		String uri4 = "http://localhost:8080/api/library-client-api/authors";

		String uri = "https://pb.diyalogo.com.tr/PostBoxService.svc";

		WebTarget target1 = client.target(uri1);
		WebTarget target2 = client.target(uri2);
		WebTarget target3 = client.target(uri3);
		WebTarget target4 = client.target(uri4);

		//Request 1
		String welcomeMessage = target1.request().get(String.class);

		//Request 2
		Response getBookJsonResponse = target2.request().get();
		Book getBook = getBookJsonResponse.readEntity(Book.class);

		//Request 3
		Response getAuthorXMLResponse = target3.request().get();
		Author author = getAuthorXMLResponse.readEntity(Author.class);
		/**
		 * NOT:readEntity metodundan sonra aynı response üzerinden readEntity yapılamıyor.
		 * Entity close işlemi yaptığı için hataya sebebiyet veriyor.
		 */
		String authorXMLType = target3.request().get(String.class);

		//Request 4
		Response getAuthorsXMLResponse = target4.request().get();
		List<Author> authors = getAuthorsXMLResponse.readEntity(new GenericType<List<Author>>() {
		});
		String authorsXMLType = target4.request().get(String.class);

		System.out.println(welcomeMessage);

		System.out.println("--------------------------------------END");

		System.out.println(getBookJsonResponse.getStatus());
		System.out.println(getBook);

		System.out.println("--------------------------------------END");

		System.out.println(getAuthorXMLResponse.getStatus());
		System.out.println(author);
		System.out.println(authorXMLType);

		System.out.println("--------------------------------------END");

		System.out.println(getAuthorsXMLResponse.getStatus());
		System.out.println(authors);
		System.out.println(authorsXMLType);

		System.out.println("--------------------------------------END");
		client.close();
	}
}
