package br.com.vivo.devtest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vivo.devtest.dao.MessageDAO;
import br.com.vivo.devtest.model.Message;

@Repository
public class MessageDAOImpl implements MessageDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Message save(Message bot) {
		return em.merge(bot);
	}
	
	@SuppressWarnings("unchecked")
	public Message get(String id) {
		
		Query query = em.createQuery("SELECT M FROM Message M WHERE M.idMsg = :id", Message.class)
	                    .setParameter("id", id);
		return query.getResultList() != null ? ((List<Message>) query.getResultList()).get(0) : new Message();
	}
	
	@SuppressWarnings("unchecked")
	public List<Message> getByConversationId(String conversationId) {
		
		Query query = em.createQuery("SELECT M FROM Message M WHERE M.idCvs = :conversationId", Message.class)
                        .setParameter("conversationId", conversationId);
		return query.getResultList() != null ? (List<Message>) query.getResultList() : new ArrayList<Message>();
	}
	
}
