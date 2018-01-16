package com.cihangll.jerseyclient.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

public class MessageClientAPITest2 {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();

		String uri = "http://localhost:8080/api/message-client-api/messages";
		WebTarget target = client.target(uri);
		Invocation.Builder builder = target.request();

		//Veri çekimi 1. yol
		Response response = builder.get();
		List<String> messages1 = response.readEntity(List.class);

		//Veri çekimi 2. yol
		List<String> messages2 = builder.get(new GenericType<List<String>>() {
		});

		System.out.println("### way1 ###");
		System.out.println(messages1);

		System.out.println("### way2 ###");
		System.out.println(messages2);

		client.close();
	}
}
