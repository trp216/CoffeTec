package backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Cafetos;
import backend.services.CafetosService;

@RestController
public class CafetosRestController {
	
	@Autowired
	private CafetosService cafetosService;
	
	@RequestMapping(value = "/api/cafetos/", method = RequestMethod.GET)
	public Iterable<Cafetos> findAll() {
		return cafetosService.findAll();
	}

	@RequestMapping(value = "/api/cafetos/", method = RequestMethod.POST)
	public void saveCafetos(@RequestBody Cafetos cafetos) {
		try {
			cafetosService.saveCafetos(cafetos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/api/cafetos/", method = RequestMethod.PUT)
	public Cafetos editCafetos(@RequestBody Cafetos cafetos) {

		return cafetosService.editCafetos(cafetos);

	}

	@RequestMapping(value = "/api/cafetos/{id}", method = RequestMethod.GET)
	public Cafetos findById(@PathVariable("id") Integer id) {
		return cafetosService.findById(id);
	}


}
