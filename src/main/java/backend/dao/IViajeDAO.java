package backend.dao;

import java.util.List;

import backend.model.Viaje;

public interface IViajeDAO {
	
	public Viaje save(Viaje entity);
	public Viaje update(Viaje entity);
	public void delete(Viaje entity);
	public Viaje findById(Integer id);
	public List<Viaje> findAll();

}
