package backend.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dao.PersonaDAO;
import backend.model.Persona;

@Service
public class PersonaService {

	//reference to upload an image https://bushansirgur.in/spring-boot-file-upload-and-download-with-database/

	@Autowired
	private PersonaDAO pDAO;

	@Autowired
	public PersonaService(PersonaDAO pDAO) {
		super();
		this.pDAO = pDAO;
	}
	
	@Transactional
	public Persona savePersona(Persona registro) {
		return pDAO.save(registro);
	}

	@Transactional
	public Persona editPersona(Persona persona){
		Persona result = null;

		if(persona.getId_persona()!=null) {
			Persona old = pDAO.findById(persona.getId_persona());
			if(old!=null) {
				result = pDAO.update(persona);
			}

		}

		return result;
	}

	public Persona findById(Integer id) {
		return pDAO.findById(id);
	}

	public Iterable<Persona> findAll() {
		return pDAO.findAll();
	}

}
