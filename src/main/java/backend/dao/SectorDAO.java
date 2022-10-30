package backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import backend.model.Sector;

@Repository
@Transactional
@Scope("singleton")
public class SectorDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public Sector save(Sector entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);		
		return entity;
	}

	public Sector update(Sector entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);		
		return entity;
	}

	public void delete(Sector entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);		
	}

	public Sector findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Sector.class, id);
	}

	public List<Sector> findAll() {
		// TODO Auto-generated method stub
		String jpql = "Select s from Sector s";
		TypedQuery<Sector> ret = entityManager.createQuery(jpql, Sector.class);
		return 	ret.getResultList();
	}

}
