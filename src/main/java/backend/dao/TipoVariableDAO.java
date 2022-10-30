package backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backend.model.TipoVariable;

@Repository
@Transactional
@Scope("singleton")
public class TipoVariableDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public TipoVariable save(TipoVariable entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);		
		return entity;
	}

	public TipoVariable update(TipoVariable entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);		
		return entity;
	}

	public void delete(TipoVariable entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);
	}

	public TipoVariable findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(TipoVariable.class, id);
	}

	public List<TipoVariable> findAll() {
		// TODO Auto-generated method stub
		String jpql = "Select tv from TipoVariable tp";
		TypedQuery<TipoVariable> ret = entityManager.createQuery(jpql, TipoVariable.class);
		return 	ret.getResultList();
	}

}
