package com.cihangll.restful.service;

import com.cihangll.restful.domain.Message;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class MessageManagerImpl implements MessageManager {

	private Map<Long, Message> messages = new HashMap<>();

	@Override
	public Message createMessage(Message msg) {
		Message message = new Message(messages.size() + 1, msg.getText());
		messages.put(message.getId(), message);
		return message;
	}

	@Override
	public boolean updateMessage(Message msg) {
		return messages.replace(msg.getId(), msg) != null;
	}

	@Override
	public boolean deleteMessage(long id) {
		return messages.remove(id) != null;
	}

	@Override
	public Message getMessage(long id) {
		return messages.get(id);
	}

	@Override
	public Collection<Message> getMessages() {
		return messages.values();
	}
}
