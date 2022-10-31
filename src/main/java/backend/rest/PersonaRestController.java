package backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Persona;

@RestController
public class PersonaRestController {
	
	@Autowired
	private PersonaRestController personaService;
	
	@RequestMapping(value = "/api/persona/", method = RequestMethod.GET)
	public Iterable<Persona> findAll() {
		return personaService.findAll();
	}

	@RequestMapping(value = "/api/persona/", method = RequestMethod.POST)
	public void savePersona(@RequestBody Persona p) {
		try {
			personaService.savePersona(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/api/persona/", method = RequestMethod.PUT)
	public Persona editPersona(@RequestBody Persona p) {

		return personaService.editPersona(p);

	}

	@RequestMapping(value = "/api/persona/{id}", method = RequestMethod.GET)
	public Persona findById(@PathVariable("id") Integer id) {
		return personaService.findById(id);
	}

}
