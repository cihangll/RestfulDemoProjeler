package com.cihangll.jersey.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/provider")
public class ProviderResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/streamingOutput")
	// http://localhost:8080/provider/streamingOutput
	public StreamingOutput streamingOutput() {

	/*	StreamingOutput output = new StreamingOutput() {
			@Override
			public void write(OutputStream o) throws IOException, WebApplicationException {
				String message = "streamingOutput is called.";
				o.write(message.getBytes());
			}
		};
		return output;
	*/

		String message = "streamingOutput is called.";
		//StreamingOutput output = (OutputStream o) -> o.write(message.getBytes());
		StreamingOutput output = (o) -> o.write(message.getBytes());
		return output;
	}

	@GET
	@Path("/file")
	@Produces(MediaType.TEXT_PLAIN)
	// http://localhost:8080/provider/file
	public File getFile() throws URISyntaxException {
		URI uri = getClass().getClassLoader().getResource("file.txt").toURI();
		File file = new File(uri);
		return file;
	}

	@GET
	@Path("/inputStream")
	@Produces(MediaType.TEXT_PLAIN)
	// http://localhost:8080/provider/inputStream
	public InputStream getFileInputStream() throws FileNotFoundException, URISyntaxException {
		URI uri = getClass().getClassLoader().getResource("file.txt").toURI();
		File file = new File(uri);
		FileInputStream is = new FileInputStream(file);
		return is;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/byteArray")
	// http://localhost:8080/provider/byteArray
	public byte[] byteArray() {
		String message = "byteArray is called.";
		return message.getBytes();
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/stringXMLResponse")
	// http://localhost:8080/provider/stringXMLResponse
	public String stringXMLResponse() {
		String message = "<customer><name>testName testSurname</name></customer>";
		return message;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/intResponse")
	// http://localhost:8080/provider/intResponse
	public int intResponse() {
		return 100;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/booleanResponse")
	// http://localhost:8080/provider/booleanResponse
	public boolean booleanResponse() {
		return true;
	}
}
