package com.cihangll.restful.service;

import com.cihangll.restful.domain.Message;

import java.util.Collection;

public interface MessageManager {

	Message createMessage(Message msg);

	boolean updateMessage(Message msg);

	boolean deleteMessage(long id);

	Message getMessage(long id);

	Collection<Message> getMessages();

}
