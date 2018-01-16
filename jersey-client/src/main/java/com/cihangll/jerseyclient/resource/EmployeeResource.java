package com.cihangll.jerseyclient.resource;

import com.cihangll.jerseyclient.model.Employee;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/employee-client-api")
public class EmployeeResource {

	@POST
	@Path("/addEmployee")
	@Consumes(MediaType.APPLICATION_JSON)
	// http://localhost:8080/api/employee-client-api/addEmployee
	public String addEmployee(Employee employee) {
		System.out.println("EmployeeResource#addEmployee");
		System.out.println(employee);
		return "addEmployee#succeed";
	}

	@POST
	@Path("/addEmployeeBatch")
	@Consumes(MediaType.APPLICATION_JSON)
	// http://localhost:8080/api/employee-client-api/addEmployeeBatch
	public String addEmployeeBatch(List<Employee> employees) {
		System.out.println("EmployeeResource#addEmployeeBatch");
		System.out.println(employees);
		return "addEmployeeBatch#succeed";
	}
}
