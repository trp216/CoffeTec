package backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backend.model.Registro;

@Repository
@Transactional
@Scope("singleton")
public class RegistroDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	
	public Registro save(Registro entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
		return entity;
	}

	
	public Registro update(Registro entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);		
		return entity;
	}

	
	public void delete(Registro entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);	
	}

	
	public Registro findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Registro.class, id);	
	}

	
	public List<Registro> findAll() {
		String jpql = "Select r from Registro r";
		TypedQuery<Registro> ret = entityManager.createQuery(jpql, Registro.class);
		return 	ret.getResultList();
	}

	public Registro findLastBySensorId(Integer sensor_id) {
		String jpql = "select t from Registro t where t.sensor.id_sensor = :ref_id order by t.id desc";
		Registro result = entityManager.createQuery(jpql, Registro.class).setParameter("ref_id", sensor_id).getResultList().get(0);
		return 	result;
	}



}
