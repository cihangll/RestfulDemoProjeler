package com.cihangll.jersey.resource;

import javax.ws.rs.*;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Path("/encoded")
@Produces("text/html; charset=UTF-8")
public class EncodedResource {

	@GET
	@Path("/getEmployeeEncoded")
	// http://localhost:8080/encoded/getEmployeeEncoded?name=['cihan']
	// http://localhost:8080/encoded/getEmployeeEncoded?name=%27cihan%27
	// http://localhost:8080/encoded/getEmployeeEncoded?name=['öÖğıİçÇöÖğĞ']
	/*
	* URI template , matrix, query ve diger form parametrelerin hepsi HTTP spect’ine gore
	* encode edilmelidir. Varsayilan olarak JAX-RS , bu parametre degerlerini , ilgili Java
	* tipine donusturmeden once decode edecektir.Iste bazen raw encoded degeri kullanmak isteyebiliriz
	* bu durumda @javax.ws.rs.Encoded annotationdan yararlanabiliriz.
	*
	* Levent Ergüder.
	* */
	public String getEmployeeByNameEncoded(@Encoded @QueryParam("name") String name) throws UnsupportedEncodingException {
		String message = "getEmployeeByNameEncoded is called. <br/>";
		String decodedName = URLDecoder.decode(name, "UTF-8");
		return message + " decodedName :" + decodedName + "<br/>encoded : " + name;
	}

}
