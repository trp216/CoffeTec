package backend.delegate;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import backend.model.Registro;

@Component
public class RegistroDelegate implements IRegistroDelegate{
	
	public final static String PATH = "http://localhost:8080/api/registro/";

	private RestTemplate rest;
	
	public RegistroDelegate() {
		rest = new RestTemplate();
	}

	@Override
	public Registro editarRegistro(Registro registro) {
		// TODO Auto-generated method stub
		rest.put(PATH, registro);
		return registro;
	}

	@Override
	public Iterable<Registro> findAll() {
		// TODO Auto-generated method stub
		Registro[] ads = rest.getForObject(PATH, Registro[].class);
		return Arrays.asList(ads);
	}

	@Override
	public void save(Registro registro) {
		// TODO Auto-generated method stub
		rest.postForEntity(PATH, registro, Registro.class);
	}

	@Override
	public Registro findById(Integer id) {
		// TODO Auto-generated method stub
		return rest.getForObject(PATH+id, Registro.class);	
		}

}
