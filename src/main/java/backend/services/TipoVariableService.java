package backend.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dao.TipoVariableDAO;
import backend.model.TipoVariable;

@Service
public class TipoVariableService {
	
	@Autowired
	private TipoVariableDAO tvDAO;

	@Autowired
	public TipoVariableService(TipoVariableDAO tvDAO) {
		super();
		this.tvDAO = tvDAO;
	}
	
	@Transactional
	public TipoVariable saveTipoVariable(TipoVariable tp) {
		return tvDAO.save(tp);
	}

	@Transactional
	public TipoVariable editTipoVariable(TipoVariable tp){
		TipoVariable result = null;

		if(tp.getIdTipoVariable()!=null) {
			TipoVariable old = tvDAO.findById(tp.getIdTipoVariable());
			if(old!=null) {
				result = tvDAO.update(tp);
			}

		}

		return result;
	}

	public TipoVariable findById(Integer id) {
		return tvDAO.findById(id);
	}

	public Iterable<TipoVariable> findAll() {
		return tvDAO.findAll();
	}


}
