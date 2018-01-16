package com.cihangll.jerseyclient.resource;

import com.cihangll.jerseyclient.model.Project;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/project-client-api")
public class ProjectResource {

	@POST
	@Path("/addProject")
	@Consumes(MediaType.APPLICATION_XML)
	// http://localhost:8080/api/project-client-api/addProject
	public String addProject(Project project) {
		System.out.println("ProjectResource#addProject");
		System.out.println(project);
		return "addProject#succeed";
	}

	@POST
	@Path("/addProjectBatch")
	@Consumes(MediaType.APPLICATION_XML)
	// http://localhost:8080/api/project-client-api/addProjectBatch
	public String addProjectBatch(List<Project> projectList) {
		System.out.println("ProjectResource#addProjectBatch");
		System.out.println(projectList);
		return "addProjectBatch#succeed";
	}
}
