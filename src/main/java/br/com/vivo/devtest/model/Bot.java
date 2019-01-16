package br.com.vivo.devtest.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.vivo.devtest.request.BotRequest;

@Entity
public class Bot {
	
	@Id
	private String idBot;

	private String nmBot;

	public Bot() {
	}
	
	public Bot(BotRequest botRequest) {
		this.idBot = botRequest.getId();
		this.nmBot = botRequest.getName();
	}
	
	public String getIdBot() {
		return this.idBot;
	}

	public void setIdBot(String idBot) {
		this.idBot = idBot;
	}

	public String getNmBot() {
		return this.nmBot;
	}

	public void setNmBot(String nmBot) {
		this.nmBot = nmBot;
	}

}