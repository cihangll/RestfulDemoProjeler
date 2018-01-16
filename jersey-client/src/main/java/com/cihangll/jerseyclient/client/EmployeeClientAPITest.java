package com.cihangll.jerseyclient.client;

import com.cihangll.jerseyclient.model.Employee;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

public class EmployeeClientAPITest {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();

		String uri1 = "http://localhost:8080/api/employee-client-api/addEmployee";
		WebTarget target1 = client.target(uri1);

		Entity<Employee> jsonEntity = Entity.json(new Employee(1, "Cihan", "Güllü"));

		Response response = target1.request().post(jsonEntity);
		String sonuc = response.readEntity(String.class);

		System.out.println(response.getStatus());
		System.out.println(response.getStatusInfo());
		System.out.println(sonuc);
		System.out.println("----------------------------END");
		//----------------------------------------------

		String uri2 = "http://localhost:8080/api/employee-client-api/addEmployeeBatch";
		WebTarget target2 = client.target(uri2);

		Entity<List<Employee>> jsonEntityList = Entity.json(Arrays.asList(
				new Employee(1, "Cihan", "Güllü"),
				new Employee(2, "Eshat", "Ergun"),
				new Employee(2, "İsmail", "Dal")));
		Response response2 = target2.request().post(jsonEntityList);
		String sonuc2 = response2.readEntity(String.class);

		System.out.println(response2.getStatus());
		System.out.println(response2.getStatusInfo());
		System.out.println(sonuc2);
		System.out.println("----------------------------END");

		client.close();
	}

}
