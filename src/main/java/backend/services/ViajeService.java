package backend.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dao.ViajeDAO;
import backend.model.Viaje;

@Service
public class ViajeService {
	
	@Autowired
	private ViajeDAO vDAO;

	@Autowired
	public ViajeService(ViajeDAO vDAO) {
		super();
		this.vDAO = vDAO;
	}
	
	@Transactional
	public Viaje saveViaje(Viaje viaje) {
		return vDAO.save(viaje);
	}

	@Transactional
	public Viaje editViaje(Viaje viaje){
		Viaje result = null;

		if(viaje.getId_viaje()!=null) {
			Viaje old = vDAO.findById(viaje.getId_viaje());
			if(old!=null) {
				result = vDAO.update(viaje);
			}

		}

		return result;
	}

	public Viaje findById(Integer id) {
		return vDAO.findById(id);
	}

	public Iterable<Viaje> findAll() {
		return vDAO.findAll();
	}


}
