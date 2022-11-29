package backend.services;

import javax.transaction.Transactional;

import backend.dto.Registro_MinifundioDTO_in;
import backend.dto.Registro_MinifundioDTO_out;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dao.RegistroDAO;
import backend.model.Registro;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class RegistroService {

	@Autowired
	private RegistroDAO rDAO;
	@Autowired
	private SensorService sensorService;


	@Autowired
	public RegistroService(RegistroDAO rDAO) {
		this.rDAO = rDAO;
	}

	@Transactional
	public Registro saveRegistro(Registro registro) {
		return rDAO.save(registro);
	}

	@Transactional
	public Registro editRegistro(Registro registro){
		Registro result = null;

		if(registro.getId_registro()!=null) {
			Registro old = rDAO.findById(registro.getId_registro());
			if(old!=null) {
				result = rDAO.update(registro);
			}

		}

		return result;
	}

	public Registro findById(Integer id) {
		return rDAO.findById(id);
	}

	public Iterable<Registro> findAll() {
		return rDAO.findAll();
	}

	public void delete(Registro registro){rDAO.delete(registro);}


	public Registro_MinifundioDTO_out findAllBySensorRef(String device_ref) {
		//		10232022_A001_sensor_ph
		List<String> sensor_types = Arrays.asList("ph", "temperature", "humidity", "P", "K", "N");

		List<Double> sensor_values = new ArrayList<Double>();

		Registro_MinifundioDTO_out last_device_registros = new Registro_MinifundioDTO_out();

		last_device_registros.setDeviceID(device_ref);

		for (String sensor: sensor_types) {
			String ref_sensor_id = device_ref+"_sensor_"+sensor;

			Integer sensor_id = sensorService.findByRef_sensor(ref_sensor_id).getId_sensor();
			Registro r = findLastBySensorId(sensor_id);
			sensor_values.add(Double.parseDouble(r.getDato()));
			last_device_registros.setDatetime(r.getFecha().toString());
		}

		last_device_registros.setPh(sensor_values.get(0));
		last_device_registros.setTemperature(sensor_values.get(1));
		last_device_registros.setHumidity(sensor_values.get(2));
		last_device_registros.setP(sensor_values.get(3));
		last_device_registros.setK(sensor_values.get(4));
		last_device_registros.setN(sensor_values.get(5));

		System.out.println(last_device_registros);

		return last_device_registros;
	}

	public Registro findLastBySensorId (Integer sensor_id){
		return rDAO.findLastBySensorId(sensor_id);
	}

	public void saveRaw_registro(Registro_MinifundioDTO_in registro) {
		String sensor_base_ref = registro.getDeviceID();
		Date date = Date.from(LocalDateTime.now().toInstant(OffsetDateTime.now().getOffset()));

		saveRegistro(new Registro(sensorService.findByRef_sensor(sensor_base_ref+"_sensor_ph"),date,Double.toString(registro.getPh())));
		saveRegistro(new Registro(sensorService.findByRef_sensor(sensor_base_ref+"_sensor_temperature"),date,Double.toString(registro.getTemperature())));
		saveRegistro(new Registro(sensorService.findByRef_sensor(sensor_base_ref+"_sensor_humidity"),date,Double.toString(registro.getHumidity())));
		saveRegistro(new Registro(sensorService.findByRef_sensor(sensor_base_ref+"_sensor_P"),date,Double.toString(registro.getP())));
		saveRegistro(new Registro(sensorService.findByRef_sensor(sensor_base_ref+"_sensor_K"),date,Double.toString(registro.getK())));
		saveRegistro(new Registro(sensorService.findByRef_sensor(sensor_base_ref+"_sensor_N"),date,Double.toString(registro.getN())));
	}
}
