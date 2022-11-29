package backend.rest;

import backend.dto.Registro_MinifundioDTO_in;
import backend.dto.Registro_MinifundioDTO_out;
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

	@RequestMapping(value = "/api/save_raw_registro/", method = RequestMethod.POST)
	public void saveRawRegistro(@RequestBody Iterable<Registro_MinifundioDTO_in> payload) {

		for (Registro_MinifundioDTO_in registro:payload) {
			System.out.println(registro.toString());
			registroService.saveRaw_registro(registro);
		}
		System.out.println();
	}

	@RequestMapping(value = "/api/registro/", method = RequestMethod.PUT)
	public Registro editRegistro(@RequestBody Registro registro) {
		return registroService.editRegistro(registro);
	}

	@RequestMapping(value = "/api/registro/{id}", method = RequestMethod.GET)
	public Registro findById(@PathVariable("id") Integer id) {
		return registroService.findById(id);
	}

	@RequestMapping(value = "/api/ultimo_registro/{device_ref}", method = RequestMethod.GET)
	public Registro_MinifundioDTO_out findById(@PathVariable("device_ref") String device_ref) {
		return registroService.findAllBySensorRef(device_ref);
	}

}
