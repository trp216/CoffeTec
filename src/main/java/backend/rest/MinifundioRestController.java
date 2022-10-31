package backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Minifundio;
import backend.services.MinifundioService;

@RestController
public class MinifundioRestController {
	
	@Autowired
	private MinifundioService minifundioService;
	
	@RequestMapping(value = "/api/minifundio/", method = RequestMethod.GET)
	public Iterable<Minifundio> findAll() {
		return minifundioService.findAll();
	}

	@RequestMapping(value = "/api/minifundio/", method = RequestMethod.POST)
	public void saveMinifundio(@RequestBody Minifundio minifundio) {
		try {
			minifundioService.saveMinifundio(minifundio);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/api/minifundio/", method = RequestMethod.PUT)
	public Minifundio editMinifundio(@RequestBody Minifundio minifundio) {

		return minifundioService.editMinifundio(minifundio);

	}

	@RequestMapping(value = "/api/minifundio/{id}", method = RequestMethod.GET)
	public Minifundio findById(@PathVariable("id") Integer id) {
		return minifundioService.findById(id);
	}

}
