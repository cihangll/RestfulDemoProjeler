package com.cihangll.jerseyclient.client;

import com.cihangll.jerseyclient.model.Project;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

public class ProjectClientAPITest {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();

		String uri = "http://localhost:8080/api/project-client-api/addProject";
		WebTarget target = client.target(uri);

		Entity<Project> xmlEntity = Entity.xml(new Project(1, "Cihan", "Computer"));

		Response response = target.request().post(xmlEntity);
		String message = response.readEntity(String.class);

		System.out.println(response.getStatusInfo());
		System.out.println(response.getStatus());
		System.out.println(message);

		String uri2 = "http://localhost:8080/api/project-client-api/addProjectBatch";
		WebTarget target2 = client.target(uri2);

		/**
		 * Doğrudan (Entity ile)kullanımında hata veriyordu.
		 * Bu şekilde hata vermedi.
		 */
		Entity<GenericEntity<List<Project>>> listEntity = Entity.xml(
				new GenericEntity<List<Project>>(Arrays.asList(
						new Project(1, "Cihan", "Computer"),
						new Project(2, "Yakup", "Testing"))) {
				});

		Response response2 = target2.request().post(listEntity);
		String message2 = response2.readEntity(String.class);

		System.out.println(response2.getStatusInfo());
		System.out.println(response2.getStatus());
		System.out.println(message2);

		client.close();
	}

}
