package backend.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dao.CafetosDAO;
import backend.model.Cafetos;

@Service
public class CafetosService {

	@Autowired
	private CafetosDAO cDAO;

	@Autowired
	public CafetosService(CafetosDAO cDAO) {
		super();
		this.cDAO = cDAO;
	}
	
	@Transactional
	public Cafetos saveCafetos(Cafetos cafetos) {
		return cDAO.save(cafetos);
	}

	@Transactional
	public Cafetos editCafetos(Cafetos cafetos){
		Cafetos result = null;

		if(cafetos.getId_cafetos()!=null) {
			Cafetos old = cDAO.findById(cafetos.getId_cafetos());
			if(old!=null) {
				result = cDAO.update(cafetos);
			}

		}

		return result;
	}

	public Cafetos findById(Integer id) {
		return cDAO.findById(id);
	}

	public Iterable<Cafetos> findAll() {
		return cDAO.findAll();
	}
}
