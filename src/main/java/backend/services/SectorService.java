package backend.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dao.SectorDAO;
import backend.model.Sector;

@Service
public class SectorService {
	
	@Autowired
	private SectorDAO sDAO;

	@Autowired
	public SectorService(SectorDAO sDAO) {
		super();
		this.sDAO = sDAO;
	}
	
	@Transactional
	public Sector saveSector(Sector sector) {
		return sDAO.save(sector);
	}

	@Transactional
	public Sector editSector(Sector sector){
		Sector result = null;

		if(sector.getId_sector()!=null) {
			Sector old = sDAO.findById(sector.getId_sector());
			if(old!=null) {
				result = sDAO.update(sector);
			}

		}

		return result;
	}

	public Sector findById(Integer id) {
		return sDAO.findById(id);
	}

	public Iterable<Sector> findAll() {
		return sDAO.findAll();
	}

}
