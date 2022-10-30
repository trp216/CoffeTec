package backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Sector;
import backend.services.SectorService;

@RestController
public class SectorRestController {
	
	@Autowired
	private SectorService sectorService;
	
	@RequestMapping(value = "/api/sector/", method = RequestMethod.GET)
	public Iterable<Sector> findAll() {
		return sectorService.findAll();
	}

	@RequestMapping(value = "/api/sector/", method = RequestMethod.POST)
	public void saveSector(@RequestBody Sector sector) {
		try {
			sectorService.saveSector(sector);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/api/sector/", method = RequestMethod.PUT)
	public Sector editSector(@RequestBody Sector sector) {

		return sectorService.editSector(sector);

	}

	@RequestMapping(value = "/api/sector/{id}", method = RequestMethod.GET)
	public Sector findById(@PathVariable("id") Integer id) {
		return sectorService.findById(id);
	}

}
