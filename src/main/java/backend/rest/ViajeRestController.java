package backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Viaje;
import backend.services.ViajeService;

@RestController
public class ViajeRestController {
	
	@Autowired
	private ViajeService viajeService;
	
	@RequestMapping(value = "/api/viaje/", method = RequestMethod.GET)
	public Iterable<Viaje> findAll() {
		return viajeService.findAll();
	}

	@RequestMapping(value = "/api/viaje/", method = RequestMethod.POST)
	public void saveViaje(@RequestBody Viaje viaje) {
		try {
			viajeService.saveViaje(viaje);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/api/viaje/", method = RequestMethod.PUT)
	public Viaje editViaje(@RequestBody Viaje viaje) {

		return viajeService.editViaje(viaje);

	}

	@RequestMapping(value = "/api/viaje/{id}", method = RequestMethod.GET)
	public Viaje findById(@PathVariable("id") Integer id) {
		return viajeService.findById(id);
	}


}
