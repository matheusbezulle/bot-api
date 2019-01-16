package br.com.vivo.devtest.response;

import java.util.Date;

import br.com.vivo.devtest.model.Message;

public class MessageResponse {
	
	private String id;
	private String conversationId;
	private Date timestamp;
	private String from;
	private String to;
	private String text;
	
	public MessageResponse(Message message) {
		this.id = message.getIdMsg();
		this.conversationId = message.getIdCvs();
		this.timestamp = message.getDtMsg();
		this.from = message.getIdFrom();
		this.to = message.getIdTo();
		this.text = message.getDsMsg();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getConversationId() {
		return conversationId;
	}
	
	public void setConversationId(String conversationId) {
		this.conversationId = conversationId;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getFrom() {
		return from;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}
	
	public String getTo() {
		return to;
	}
	
	public void setTo(String to) {
		this.to = to;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
}
