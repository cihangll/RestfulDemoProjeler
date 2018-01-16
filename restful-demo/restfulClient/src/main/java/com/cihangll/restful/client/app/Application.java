package com.cihangll.restful.client.app;

import com.cihangll.restful.client.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Collection;

public class Application {

	private final Logger logger = LoggerFactory.getLogger(Application.class);
	private static String RESOURCE_URL = "http://localhost:8080/api/messages";

	private Client client;

	public Application() {
		client = ClientBuilder.newClient();
	}

	public Message createMessage(String text) {
		logger.info("Create Message '{}'", text);
		Message message = new Message();
		message.setText(text);

		Response response = client.target(RESOURCE_URL).request().post(Entity.json(message));
		logResponse(response);

		if (response.getStatus() == Response.Status.CREATED.getStatusCode()) {
			message = response.readEntity(Message.class);
			logger.info("Id: {}, Text: '{}'", message.getId(), message.getText());
			return message;
		}
		return null;
	}

	public void updateMessage(long id, String text) {
		logger.info("Update Message id: {} to text '{}'", id, text);

		Message message = new Message();
		message.setId(id);
		message.setText(text);
		Response response = client.target(RESOURCE_URL + "/" + message.getId()).request().put(Entity.json(message));
		logResponse(response);

		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			logger.info("Message updated!");
		}
	}

	public void deleteMessage(long id) {
		logger.info("Delete message id: {}", id);

		Response response = client.target(RESOURCE_URL + "/" + id).request().delete();
		logResponse(response);

		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			logger.info("Message deleted!");
		}
	}

	public void getMessage(long id, MediaType mediaType) {
		logger.info("Get message id: {}", id);

		Response response = client.target(RESOURCE_URL + "/" + id).request(mediaType).get();
		logResponse(response);

		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			Message message = response.readEntity(Message.class);
			logger.info("Id : {}, Text : '{}'", message.getId(), message.getText());
		}
	}

	public void getMessages(MediaType mediaType) {
		logger.info("Get all messages");

		Response response = client.target(RESOURCE_URL).request(mediaType).get();
		logResponse(response);

		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			Collection<Message> messages = Arrays.asList(response.readEntity(Message[].class));
			messages.stream().forEach(message -> logger.info("Id: {}, Text:'{}'", message.getId(), message.getText()));
		}
	}

	private void logResponse(Response response) {
		logger.info("Response Status: {}", response.getStatus());
		logger.info("Response Info: {}", response.getStatusInfo());
		logger.info("Response Headers: {}", response.getHeaders());
	}

	public static void main(String[] args) {

		Application application = new Application();
		application.createMessage("Hello World 1");
		application.createMessage("Hello World 2");
		application.createMessage("Hello World 3");
		application.createMessage("Hello World 4");

		application.getMessage(2, MediaType.APPLICATION_JSON_TYPE);
		application.deleteMessage(2);
		application.updateMessage(1, "New Text of fmessage id 1");
		application.getMessage(1, MediaType.APPLICATION_XML_TYPE);


		application.getMessages(MediaType.APPLICATION_XML_TYPE);
		application.getMessages(MediaType.APPLICATION_JSON_TYPE);

	}
}
