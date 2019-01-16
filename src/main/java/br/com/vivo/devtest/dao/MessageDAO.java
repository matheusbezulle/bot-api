package br.com.vivo.devtest.dao;

import java.util.List;

import br.com.vivo.devtest.model.Message;

public interface MessageDAO {
	
	public Message save(Message bot);
	
	public Message get(String id);
	
	public List<Message> getByConversationId(String conversationId);
	
}
