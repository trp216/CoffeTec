package backend.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dao.BultoDAO;
import backend.model.Bulto;

@Service
public class BultoService {
	
	@Autowired
	private BultoDAO bDAO;
	
	@Autowired	
	public BultoService(BultoDAO bDAO) {
		super();
		this.bDAO = bDAO;
	}

	@Transactional
	public Bulto saveBulto(Bulto b) {
		return bDAO.save(b);
	}

	@Transactional
	public Bulto editBulto(Bulto b){
		Bulto result = null;

		if(b.getId_Bulto()!=null) {
			Bulto old = bDAO.findById(b.getId_Bulto());
			if(old!=null) {
				result = bDAO.update(b);
			}
		}
		return result;
	}

	public Bulto findById(Integer id) {
		return bDAO.findById(id);
	}

	public Iterable<Bulto> findAll() {
		return bDAO.findAll();
	}

}
