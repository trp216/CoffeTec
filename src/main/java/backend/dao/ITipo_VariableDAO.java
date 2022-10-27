package backend.dao;

import java.util.List;

import backend.model.Tipo_Variable;

public interface ITipo_VariableDAO {
	
	public Tipo_Variable save(Tipo_Variable entity);
	public Tipo_Variable update(Tipo_Variable entity);
	public void delete(Tipo_Variable entity);
	public Tipo_Variable findById(Integer id);
	public List<Tipo_Variable> findAll();

}
