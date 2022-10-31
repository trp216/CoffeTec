package backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backend.model.Minifundio;


@Repository
@Transactional
@Scope("singleton")
public class MinifundioDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	
	public Minifundio save(Minifundio entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
		return entity;
	}

	
	public Minifundio update(Minifundio entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);		
		return entity;
	}

	
	public void delete(Minifundio entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);	
	}

	
	public Minifundio findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Minifundio.class, id);	
	}

	
	public List<Minifundio> findAll() {
		String jpql = "Select m from Minifundio r";
		TypedQuery<Minifundio> ret = entityManager.createQuery(jpql, Minifundio.class);
		return 	ret.getResultList();
	}
	

}
