package backend.rest;

import backend.dto.Registro_MinifundioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Registro;
import backend.services.RegistroService;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Map;

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

	@RequestMapping(value = "/api/raw_registro/", method = RequestMethod.POST)
	public void saveRawRegistro(@RequestBody Iterable<Registro_MinifundioDTO> payload) {

		for (Registro_MinifundioDTO registro:payload) {
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

	@RequestMapping(value = "/api/ultimo_registro/{sensor_id}", method = RequestMethod.GET)
	public Registro_MinifundioDTO findById(@PathVariable("sensor_id") String sensor_ref) {
		return registroService.findAllBySensorRef(sensor_ref);
	}

}
