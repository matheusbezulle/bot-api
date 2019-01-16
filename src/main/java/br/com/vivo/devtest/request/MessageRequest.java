package br.com.vivo.devtest.request;

public class MessageRequest {
	
	private String conversationId;
	private String timestamp;
	private String from;
	private String to;
	private String text;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
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

	public String getConversationId() {
		return conversationId;
	}
	
	public void setConversationId(String conversationId) {
		this.conversationId = conversationId;
	}
	
}
