package backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backend.model.Cafetos;


@Repository
@Transactional
@Scope("singleton")
public class CafetosDAO {
	

	@PersistenceContext
	private EntityManager entityManager;

	public Cafetos save(Cafetos entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
		return entity;
	}

	
	public Cafetos update(Cafetos entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);		
		return entity;
	}

	
	public void delete(Cafetos entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);	
	}

	
	public Cafetos findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Cafetos.class, id);	
	}

	
	public List<Cafetos> findAll() {
		String jpql = "Select c from Cafetos c";
		TypedQuery<Cafetos> ret = entityManager.createQuery(jpql, Cafetos.class);
		return 	ret.getResultList();
	}
	

}
