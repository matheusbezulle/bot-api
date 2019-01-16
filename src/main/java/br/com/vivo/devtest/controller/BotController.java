package br.com.vivo.devtest.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.vivo.devtest.dao.BotDAO;
import br.com.vivo.devtest.endpoint.Endpoint;
import br.com.vivo.devtest.model.Bot;
import br.com.vivo.devtest.request.BotRequest;
import br.com.vivo.devtest.response.BotResponse;

@Controller
public class BotController {
	
	@Autowired
	private BotDAO botDAO;
	
	@RequestMapping(value = Endpoint.BOTS, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BotResponse> save(@RequestBody BotRequest bot) {
		
		if (Objects.isNull(bot.getId()) || (bot.getId()).isEmpty() || 
			Objects.isNull(bot.getName()) || (bot.getName()).isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		BotResponse response = new BotResponse(botDAO.saveOrUpdate(new Bot(bot)));
		return new ResponseEntity<BotResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = Endpoint.BOTS, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BotResponse> update(@RequestBody BotRequest bot) {
		
		if (Objects.isNull(bot.getId()) || (bot.getId()).isEmpty() || 
			Objects.isNull(bot.getName()) || (bot.getName()).isEmpty()) {
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		BotResponse response = new BotResponse(botDAO.saveOrUpdate(new Bot(bot)));
		return new ResponseEntity<BotResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = Endpoint.BOTS + "/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BotResponse> get(@PathVariable("id") String id) {
		
		if (id.isEmpty() || Objects.isNull(id)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		BotResponse response = new BotResponse(botDAO.get(id));
		return new ResponseEntity<BotResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = Endpoint.BOTS + "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BotResponse> delete(@PathVariable("id") String id) {
		
		if (id.isEmpty() || Objects.isNull(id)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		botDAO.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
