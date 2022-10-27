package backend.dao;

import java.util.List;

import backend.model.Sensor;


public interface ISensorDAO {
	
	public Sensor save(Sensor entity);
	public Sensor update(Sensor entity);
	public void delete(Sensor entity);
	public Sensor findById(Integer id);
	public List<Sensor> findAll();

}
