package backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import backend.model.BultoRegistro;
import backend.services.BultoRegistroService;

@RestController
public class BultoRegistroRestController {
	
	@Autowired
	private BultoRegistroService bultoRegistroService;
	
	@RequestMapping(value = "/api/bultoregistro/", method = RequestMethod.GET)
	public Iterable<BultoRegistro> findAll() {
		return bultoRegistroService.findAll();
	}

	@RequestMapping(value = "/api/bultoregistro/", method = RequestMethod.POST)
	public void saveBultoRegistro(@RequestBody BultoRegistro registro) {
		try {
			bultoRegistroService.saveBultoRegistro(registro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/api/bultoregistro/", method = RequestMethod.PUT)
	public BultoRegistro editRegistro(@RequestBody BultoRegistro registro) {

		return bultoRegistroService.editBultoRegistro(registro);

	}

	@RequestMapping(value = "/api/bultoregistro/{id}", method = RequestMethod.GET)
	public BultoRegistro findById(@PathVariable("id") Integer id) {
		return bultoRegistroService.findById(id);
	}

}
