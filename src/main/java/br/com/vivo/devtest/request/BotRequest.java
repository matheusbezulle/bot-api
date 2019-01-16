package br.com.vivo.devtest.request;

import java.io.Serializable;

public class BotRequest implements Serializable {

	private static final long serialVersionUID = 3848345687414600269L;
	
	private String id;
	private String name;
	
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
