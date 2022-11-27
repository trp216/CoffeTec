package backend.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dao.SensorDAO;
import backend.model.Sensor;

@Service
public class SensorService {

	@Autowired
	private SensorDAO sDAO;

	@Autowired
	public SensorService(SensorDAO sDAO) {
		super();
		this.sDAO = sDAO;
	}
	
	@Transactional
	public Sensor saveSensor(Sensor sensor) {
		return sDAO.save(sensor);
	}

	@Transactional
	public Sensor editSensor(Sensor sensor){
		Sensor result = null;

		if(sensor.getId_sensor()!=null) {
			Sensor old = sDAO.findById(sensor.getId_sensor());
			if(old!=null) {
				result = sDAO.update(sensor);
			}
		}

		return result;
	}

	public Sensor findById(Integer id) {
		return sDAO.findById(id);
	}

	public Iterable<Sensor> findAll() {
		return sDAO.findAll();
	}

	public Sensor findByRef_sensor(String ref_sensor) {
		return sDAO.findByRef_sensor(ref_sensor);
	}



}
