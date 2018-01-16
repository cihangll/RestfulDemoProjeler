package com.cihangll.jerseyclient.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import java.util.List;

public class MessageClientAPITest {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();

		String uri1 = "http://localhost:8080/api/message-client-api/message";
		String uri2 = "http://localhost:8080/api/message-client-api/messages";

		WebTarget target1 = client.target(uri1);
		WebTarget target2 = client.target(uri2);

		Invocation.Builder builder1 = target1.request();
		Invocation.Builder builder2 = target2.request();

		String message = builder1.get(String.class);
		List<String> messages = builder2.get(new GenericType<List<String>>() {
		});

		System.out.println(message);
		System.out.println(messages);

		client.close();
	}
}
