package backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backend.model.Viaje;

@Repository
@Transactional
@Scope("singleton")
public class ViajeDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public Viaje save(Viaje entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);		
		return entity;
	}

	public Viaje update(Viaje entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);		
		return entity;
	}

	public void delete(Viaje entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);
	}

	public Viaje findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Viaje.class, id);	
	}

	public List<Viaje> findAll() {
		// TODO Auto-generated method stub
		String jpql = "Select v from Viaje v";
		TypedQuery<Viaje> ret = entityManager.createQuery(jpql, Viaje.class);
		return 	ret.getResultList();	
	}

}
