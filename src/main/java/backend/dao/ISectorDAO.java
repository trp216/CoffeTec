package backend.dao;

import java.util.List;

import backend.model.Sector;


public interface ISectorDAO {
	
	public Sector save(Sector entity);
	public Sector update(Sector entity);
	public void delete(Sector entity);
	public Sector findById(Integer id);
	public List<Sector> findAll();

}
