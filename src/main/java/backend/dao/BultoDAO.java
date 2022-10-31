package backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backend.model.Bulto;


@Repository
@Transactional
@Scope("singleton")
public class BultoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	
	public Bulto save(Bulto entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
		return entity;
	}

	
	public Bulto update(Bulto entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);		
		return entity;
	}

	
	public void delete(Bulto entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);	
	}

	
	public Bulto findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Bulto.class, id);	
	}

	
	public List<Bulto> findAll() {
		String jpql = "Select b from Bulto b";
		TypedQuery<Bulto> ret = entityManager.createQuery(jpql, Bulto.class);
		return 	ret.getResultList();
	}
	

}
