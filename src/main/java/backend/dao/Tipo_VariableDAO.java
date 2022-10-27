package backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backend.model.Tipo_Variable;

@Repository
@Transactional
@Scope("singleton")
public class Tipo_VariableDAO implements ITipo_VariableDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Tipo_Variable save(Tipo_Variable entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);		
		return entity;
	}

	@Override
	public Tipo_Variable update(Tipo_Variable entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);		
		return entity;
	}

	@Override
	public void delete(Tipo_Variable entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);
	}

	@Override
	public Tipo_Variable findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Tipo_Variable.class, id);
	}

	@Override
	public List<Tipo_Variable> findAll() {
		// TODO Auto-generated method stub
		String jpql = "Select tv from TipoVariable tp";
		TypedQuery<Tipo_Variable> ret = entityManager.createQuery(jpql, Tipo_Variable.class);
		return 	ret.getResultList();
	}

}
