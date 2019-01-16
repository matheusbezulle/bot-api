package br.com.vivo.devtest.dao;

import br.com.vivo.devtest.model.Bot;

public interface BotDAO {
	
	public Bot saveOrUpdate(Bot bot);
	
	public Bot get(String id);
	
	public boolean delete(String id);
	
}
