package br.com.vivo.devtest.response;

import br.com.vivo.devtest.model.Bot;

public class BotResponse {
	
	private String id;
	private String name;
	
	public BotResponse() {}
	
	public BotResponse(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public BotResponse(Bot vivoBot) {
		this.id = vivoBot.getIdBot();
		this.name = vivoBot.getNmBot();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
