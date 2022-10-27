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
public class ViajeDAO implements IViajeDAO{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Viaje save(Viaje entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);		
		return entity;
	}

	@Override
	public Viaje update(Viaje entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);		
		return entity;
	}

	@Override
	public void delete(Viaje entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);
	}

	@Override
	public Viaje findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Viaje.class, id);	
	}

	@Override
	public List<Viaje> findAll() {
		// TODO Auto-generated method stub
		String jpql = "Select v from Viaje v";
		TypedQuery<Viaje> ret = entityManager.createQuery(jpql, Viaje.class);
		return 	ret.getResultList();	
	}

}
