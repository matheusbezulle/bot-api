package br.com.vivo.devtest.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vivo.devtest.dao.BotDAO;
import br.com.vivo.devtest.model.Bot;

@Repository
public class BotDAOImpl implements BotDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Bot saveOrUpdate(Bot bot) {
		return em.merge(bot);
	}
	
	@SuppressWarnings("unchecked")
	public Bot get(String id) {
		Query query = em.createQuery("SELECT B FROM Bot B WHERE B.idBot = :id", Bot.class)
	                    .setParameter("id", id);
		return query.getResultList() != null ? ((List<Bot>) query.getResultList()).get(0) : new Bot();
	}
	
	@Transactional
	public boolean delete(String id) {
		
		Bot bot = em.find(Bot.class, id);
		if(bot != null) {
			em.remove(bot);
			return true;
		}
		return false;
	}
	
}
