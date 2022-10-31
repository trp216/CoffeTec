package backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backend.model.Persona;


@Repository
@Transactional
@Scope("singleton")
public class PersonaDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	
	public Persona save(Persona entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
		return entity;
	}

	
	public Persona update(Persona entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);		
		return entity;
	}

	
	public void delete(Persona entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);	
	}

	
	public Persona findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Persona.class, id);	
	}

	
	public List<Persona> findAll() {
		String jpql = "Select p from Persona p";
		TypedQuery<Persona> ret = entityManager.createQuery(jpql, Persona.class);
		return 	ret.getResultList();
	}

}
