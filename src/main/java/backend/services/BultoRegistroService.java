package backend.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dao.BultoRegistroDAO;
import backend.model.BultoRegistro;

@Service
public class BultoRegistroService {

	@Autowired
	private BultoRegistroDAO brDAO;

	@Autowired
	public BultoRegistroService(BultoRegistroDAO brDAO) {
		super();
		this.brDAO = brDAO;
	}
	
	@Transactional
	public BultoRegistro saveBultoRegistro(BultoRegistro br) {
		return brDAO.save(br);
	}

	@Transactional
	public BultoRegistro editBultoRegistro(BultoRegistro br){
		BultoRegistro result = null;

		if(br.getId_bulto_registro()!=null) {
			BultoRegistro old = brDAO.findById(br.getId_bulto_registro());
			if(old!=null) {
				result = brDAO.update(br);
			}

		}

		return result;
	}

	public BultoRegistro findById(Integer id) {
		return brDAO.findById(id);
	}

	public Iterable<BultoRegistro> findAll() {
		return brDAO.findAll();
	}

}
