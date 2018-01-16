package com.cihangll.jersey.resource;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

/**
 * Bu tiplere ait objeleri injecte etmek için kullanabiliriz.
 * <p>
 * javax.ws.rs.core.HttpHeaders
 * javax.ws.rs.core.UriInfo
 * javax.ws.rs.core.Request
 * javax.servlet.http.HttpServletRequest
 * javax.servlet.http.HttpServletResponse
 * javax.servlet.ServletConfig
 * javax.servlet.ServletContext
 * javax.ws.rs.core.SecurityContext
 */

@Path("/context")
public class ContextResource {

	//http://localhost:8080/headerparam/getInfoWithContext
	//RESULT:
	/*	getInfoWithContexth is called
		host : [localhost:8080]
		connection : [keep-alive]
		cache-control : [max-age=0]
		user-agent : [Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36]
		upgrade-insecure-requests : [1]
		accept : [text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,**;q=0.8]
		accept-encoding : [gzip, deflate, br]
		accept-language : [tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7]
		cookie : [Idea-e9d6ebbf=bd86bb7c-f40a-4d05-8c94-20af8814e4ff]
	*/
	@GET
	@Path("/getInfoWithContext")
	public String getInfoWithContexth(@Context HttpHeaders headers) {
		String message = " getInfoWithContext is called";

		for (String headerName : headers.getRequestHeaders().keySet()) {
			message = message + "<br/>" + headerName + " : " + headers.getRequestHeader(headerName);
		}
		return message;
	}

	@GET
	@Path("/getCookieWithContext")
	// http://localhost:8080/context/getCookieWithContext
	public Response getCookieWithContext(@Context HttpHeaders headers) {

		String result = "getCookieWithContext is called. <br/>";
		for (String name : headers.getCookies().keySet()) {
			Cookie cookie = headers.getCookies().get(name);
			result = result + "Cookie: " + name + "=" + cookie.getValue() + "<br/>";
		}

		Response.ResponseBuilder builder = Response.ok(result);
		return builder.build();

		//way two
		//return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/servletContext")
	// http://localhost:8080/context/servletContext
	public String injectServletContext(@Context ServletContext context) {
		String message = "injectServletContext is called.";
		String contextPath = context.getContextPath();
		return message + "<br/>" + contextPath;
	}

	@GET
	@Path("/servletconfig")
	// http://localhost:8080/context/servletconfig
	public String injectServletConfig(@Context ServletConfig config) {
		String message = "injectServletConfig is called.";
		return message + "<br/> " + config.getServletName();
	}

	@GET
	@Path("/request")
	// http://localhost:8080/context/request
	/**
	 * injectHttpServletRequest is called.
	 * /context/request
	 */
	public String injectHttpServletRequest(@Context HttpServletRequest request) {
		String message = "injectHttpServletRequest is called.";
		return message + "<br/> " + request.getPathInfo();
	}

	@GET
	@Path("/response")
	// http://localhost:8080/context/response
	public String injectHttpServletResponse(@Context HttpServletResponse response) {
		String message = "injectHttpServletResponse is called.";
		return message + "<br/> " + response.getCharacterEncoding();
	}

}
