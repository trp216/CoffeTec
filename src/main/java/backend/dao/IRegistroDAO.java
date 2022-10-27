package backend.dao;

import java.util.List;

import backend.model.Registro;

public interface IRegistroDAO {
	
	public Registro save(Registro entity);
	public Registro update(Registro entity);
	public void delete(Registro entity);
	public Registro findById(Integer id);
	public List<Registro> findAll();

}
