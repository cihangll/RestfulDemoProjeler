package com.cihangll.jersey.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import java.util.List;

public class MessageClientTest {

	public static void main(String args[]) {

		// test1
		String uri = "http://localhost:8080/clientTest/message";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);

		Invocation.Builder builder = target.request();
		String message = builder.get(String.class);
		System.out.println(message);

		// test2
		String uri2 = "http://localhost:8080/clientTest/messages";
		WebTarget target2 = client.target(uri2);
		Invocation.Builder builder2 = target2.request();
		List<String> message2 = builder2.get(new GenericType<List<String>>() {
		});
		System.out.println(message2);

		client.close();

	}
}
