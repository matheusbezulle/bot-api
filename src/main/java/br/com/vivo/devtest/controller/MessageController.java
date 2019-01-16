package br.com.vivo.devtest.controller;

import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;

import br.com.vivo.devtest.dao.MessageDAO;
import br.com.vivo.devtest.endpoint.Endpoint;
import br.com.vivo.devtest.model.Message;
import br.com.vivo.devtest.request.MessageRequest;
import br.com.vivo.devtest.response.MessageResponse;

@Controller
public class MessageController {
	
	@Autowired
	private MessageDAO messageDAO;
	
	@RequestMapping(value = Endpoint.MESSAGES, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessageResponse> save(@RequestBody MessageRequest message) {
		
		if (Objects.isNull(message.getConversationId()) || (message.getConversationId()).isEmpty() || 
			Objects.isNull(message.getFrom()) || (message.getFrom()).isEmpty() ||
			Objects.isNull(message.getTo()) || (message.getTo()).isEmpty() || 
			Objects.isNull(message.getText()) || (message.getText()).isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		MessageResponse response = new MessageResponse(messageDAO.save(new Message(message)));
		return new ResponseEntity<MessageResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = Endpoint.MESSAGES + "/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessageResponse> get(@PathVariable("id") String id) {
		
		if (id.isEmpty() || Objects.isNull(id)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		MessageResponse response = new MessageResponse(messageDAO.get(id));
		return new ResponseEntity<MessageResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = Endpoint.MESSAGES, method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MessageResponse>> getByConversationId(@RequestParam("conversationId") String conversationId) {
		
		if (conversationId.isEmpty() || Objects.isNull(conversationId)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		List<MessageResponse> response = new ArrayList<>();
		List<Message> messages = messageDAO.getByConversationId(conversationId);
		
		messages.forEach(m -> response.add(new MessageResponse(m)));
		
		return new ResponseEntity<List<MessageResponse>>(response, HttpStatus.OK);
	}
	
}
