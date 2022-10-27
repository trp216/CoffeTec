package backend.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dao.RegistroDAO;
import backend.model.Registro;

@Service
public class RegistroService {

	@Autowired
	private RegistroDAO rDAO;

	@Autowired
	public RegistroService(RegistroDAO rDAO) {
		this.rDAO = rDAO;
	}

	@Override
	@Transactional
	public Registro saveRegistro(Registro registro) {
		return rDAO.save(registro);
	}

	@Override
	@Transactional
	public Registro editRegistro(Registro registro){
		Registro result = null;

		if(registro.getid_registro()!=null) {
			Registro old = rDAO.findById(registro.getid_registro());
			if(old!=null) {
				result = rDAO.update(registro);
			}

		}

		return result;
	}

	@Override
	public Registro findById(Integer id) {
		return rDAO.findById(id);
	}

	@Override
	public Iterable<Registro> findAll() {
		return rDAO.findAll();
	}

}
