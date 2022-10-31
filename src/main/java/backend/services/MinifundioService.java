package backend.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dao.MinifundioDAO;
import backend.model.Minifundio;

@Service
public class MinifundioService {
	
	@Autowired
	private MinifundioDAO mDAO;

	@Autowired
	public MinifundioService(MinifundioDAO mDAO) {
		super();
		this.mDAO = mDAO;
	}
	
	@Transactional
	public Minifundio saveMinifundio(Minifundio m) {
		return mDAO.save(m);
	}

	@Transactional
	public Minifundio editMinifundio(Minifundio m){
		Minifundio result = null;

		if(m.getId_Minifundio()!=null) {
			Minifundio old = mDAO.findById(m.getId_Minifundio());
			if(old!=null) {
				result = mDAO.update(m);
			}

		}

		return result;
	}

	public Minifundio findById(Integer id) {
		return mDAO.findById(id);
	}

	public Iterable<Minifundio> findAll() {
		return mDAO.findAll();
	}


}
