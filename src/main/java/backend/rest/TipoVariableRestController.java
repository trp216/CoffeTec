package backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import backend.model.TipoVariable;
import backend.services.TipoVariableService;

@RestController
public class TipoVariableRestController {
	
	@Autowired
	private TipoVariableService tipoVariableService;

	@RequestMapping(value = "/api/tipovariable/", method = RequestMethod.GET)
	public Iterable<TipoVariable> findAll() {
		return tipoVariableService.findAll();
	}

	@RequestMapping(value = "/api/tipovariable/", method = RequestMethod.POST)
	public void saveTipoVariable(@RequestBody TipoVariable tv) {
		try {
			tipoVariableService.saveTipoVariable(tv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/api/tipovariable/", method = RequestMethod.PUT)
	public TipoVariable editTipoVariable(@RequestBody TipoVariable tv) {

		return tipoVariableService.editTipoVariable(tv);

	}

	@RequestMapping(value = "/api/tipovariable/{id}", method = RequestMethod.GET)
	public TipoVariable findById(@PathVariable("id") Integer id) {
		return tipoVariableService.findById(id);
	}

}
