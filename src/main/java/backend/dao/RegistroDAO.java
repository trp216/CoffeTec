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
	

}
