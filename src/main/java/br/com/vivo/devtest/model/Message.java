package br.com.vivo.devtest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.vivo.devtest.request.MessageRequest;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idMsg;

	private String dsMsg;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtMsg;

	private String idFrom;
	
	private String idTo;

	private String idCvs;

	public Message() {
	}
	
	public Message(MessageRequest messageRequest) {
		this.dsMsg = messageRequest.getText();
		this.dtMsg = new Date();
		this.idFrom = messageRequest.getFrom();
		this.idTo = messageRequest.getTo();
		this.idCvs = messageRequest.getConversationId();
	}
	
	public String getIdMsg() {
		return idMsg;
	}

	public void setIdMsg(String idMsg) {
		this.idMsg = idMsg;
	}

	public String getDsMsg() {
		return dsMsg;
	}

	public void setDsMsg(String dsMsg) {
		this.dsMsg = dsMsg;
	}

	public Date getDtMsg() {
		return dtMsg;
	}

	public void setDtMsg(Date dtMsg) {
		this.dtMsg = dtMsg;
	}

	public String getIdFrom() {
		return idFrom;
	}

	public void setIdFrom(String idFrom) {
		this.idFrom = idFrom;
	}

	public String getIdTo() {
		return idTo;
	}

	public void setIdTo(String idTo) {
		this.idTo = idTo;
	}

	public String getIdCvs() {
		return idCvs;
	}

	public void setIdCvs(String idCvs) {
		this.idCvs = idCvs;
	}
	
}
