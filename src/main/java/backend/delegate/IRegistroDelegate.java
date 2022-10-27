package backend.delegate;

import backend.model.Registro;

public interface IRegistroDelegate {

	public Registro editarRegistro(Registro registro);

	public Iterable<Registro> findAll();

	public void save(Registro registro);

	public Registro findById(Integer id);

}
