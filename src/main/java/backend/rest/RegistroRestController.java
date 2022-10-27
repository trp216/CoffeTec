package backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Registro;
import backend.services.RegistroService;

@RestController
public class RegistroRestController {

	@Autowired
	private RegistroService registroService;

	@RequestMapping(value = "/api/registro/", method = RequestMethod.GET)
	public Iterable<Registro> findAll() {
		return registroService.findAll();
	}

	@RequestMapping(value = "/api/registro/", method = RequestMethod.POST)
	public void saveRegistro(@RequestBody Registro registro) {
		try {
			registroService.saveRegistro(registro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/api/registro/", method = RequestMethod.PUT)
	public Registro editRegistro(@RequestBody Registro registro) {

		return registroService.editRegistro(registro);

	}

	@RequestMapping(value = "/api/registro/{id}", method = RequestMethod.GET)
	public Registro findById(@PathVariable("id") Integer id) {
		return registroService.findById(id);
	}

}
