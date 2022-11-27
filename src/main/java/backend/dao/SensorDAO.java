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
public class SensorDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public Sensor save(Sensor entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);		
		return entity;	
	}

	public Sensor update(Sensor entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);		
		return entity;
	}

	public void delete(Sensor entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);	
	}

	public Sensor findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Sensor.class, id);
	}

	public List<Sensor> findAll() {
		// TODO Auto-generated method stub
		String jpql = "Select s from Sensor s";
		TypedQuery<Sensor> ret = entityManager.createQuery(jpql, Sensor.class);
		return 	ret.getResultList();
	}

    public Sensor findByRef_sensor(String ref_sensor) {
		return (Sensor) entityManager.createQuery("FROM Sensor u WHERE u.ref_sensor = :ref")
				.setParameter("ref", ref_sensor)
				.getSingleResult();
    }
}
