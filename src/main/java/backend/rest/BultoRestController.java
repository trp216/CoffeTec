package backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Bulto;
import backend.services.BultoService;

@RestController
public class BultoRestController {
	
	@Autowired
	private BultoService bultoService;
	
	@RequestMapping(value = "/api/bulto/", method = RequestMethod.GET)
	public Iterable<Bulto> findAll() {
		return bultoService.findAll();
	}

	@RequestMapping(value = "/api/bulto/", method = RequestMethod.POST)
	public void saveBulto(@RequestBody Bulto b) {
		try {
			bultoService.saveBulto(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/api/bulto/", method = RequestMethod.PUT)
	public Bulto editBulto(@RequestBody Bulto b) {

		return bultoService.editBulto(b);

	}

	@RequestMapping(value = "/api/bulto/{id}", method = RequestMethod.GET)
	public Bulto findById(@PathVariable("id") Integer id) {
		return bultoService.findById(id);
	}


}
