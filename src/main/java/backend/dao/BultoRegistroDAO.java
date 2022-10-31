package backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backend.model.BultoRegistro;


@Repository
@Transactional
@Scope("singleton")
public class BultoRegistroDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public BultoRegistro save(BultoRegistro entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
		return entity;
	}

	
	public BultoRegistro update(BultoRegistro entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);		
		return entity;
	}

	
	public void delete(BultoRegistro entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);	
	}

	
	public BultoRegistro findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(BultoRegistro.class, id);	
	}
	
	public List<BultoRegistro> findAll() {
		String jpql = "Select b from BultoRegistro b";
		TypedQuery<BultoRegistro> ret = entityManager.createQuery(jpql, BultoRegistro.class);
		return 	ret.getResultList();
	}

}
