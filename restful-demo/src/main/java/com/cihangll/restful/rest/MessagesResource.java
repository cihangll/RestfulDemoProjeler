package com.cihangll.restful.rest;

import com.cihangll.restful.domain.Message;
import com.cihangll.restful.service.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/messages")
/**
 * "http://localhost:8080/api/application.wadl" adresinden Web Application Description Language yani WADL dosyasını
 * görebilirsin.
 */
@Component
public class MessagesResource {

	private final MessageManager messageManager;

	@Autowired
	public MessagesResource(MessageManager messageManager) {
		this.messageManager = messageManager;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getMessages() {

		/**
		 * Collection'ı Array dizisine çevirme
		 * Örn; Collection<T> collection;
		 *
		 * collection.toArray(new T[collection.size])
		 */

		Collection<Message> messages = messageManager.getMessages();
		return Response.status(Response.Status.OK).entity(messages.toArray(new Message[messages.size()])).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createMessage(Message message) {
		Message createdMessage = messageManager.createMessage(message);
		return Response.status(Response.Status.CREATED).entity(createdMessage).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateMessage(@PathParam("id") long id, Message message) {
		if (message.getId() != id) {
			throw new IllegalArgumentException("Object id cannot be different than the parameter id");
		}
		if (messageManager.updateMessage(message)) {
			return Response.status(Response.Status.OK).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getMessage(@PathParam("id") long id) {
		Message message = messageManager.getMessage(id);
		if (message != null) {
			return Response.status(Response.Status.OK).entity(message).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteMessage(@PathParam("id") long id) {
		if (messageManager.deleteMessage(id)) {
			return Response.status(Response.Status.OK).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

}
