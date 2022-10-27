package backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backend.model.Sensor;

@Repository
@Transactional
@Scope("singleton")
public class SensorDAO implements ISensorDAO{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Sensor save(Sensor entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);		
		return entity;	
	}

	@Override
	public Sensor update(Sensor entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);		
		return entity;
	}

	@Override
	public void delete(Sensor entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);	
	}

	@Override
	public Sensor findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Sensor.class, id);
	}

	@Override
	public List<Sensor> findAll() {
		// TODO Auto-generated method stub
		String jpql = "Select s from Sensor s";
		TypedQuery<Sensor> ret = entityManager.createQuery(jpql, Sensor.class);
		return 	ret.getResultList();
	}
}
