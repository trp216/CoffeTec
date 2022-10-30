package backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Sensor;
import backend.services.SensorService;

@RestController
public class SensorRestController {

	@Autowired
	private SensorService sensorService;
	
	@RequestMapping(value = "/api/sensor/", method = RequestMethod.GET)
	public Iterable<Sensor> findAll() {
		return sensorService.findAll();
	}

	@RequestMapping(value = "/api/sensor/", method = RequestMethod.POST)
	public void saveSensor(@RequestBody Sensor sensor) {
		try {
			sensorService.saveSensor(sensor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/api/sensor/", method = RequestMethod.PUT)
	public Sensor editSensor(@RequestBody Sensor sensor) {

		return sensorService.editSensor(sensor);

	}

	@RequestMapping(value = "/api/sensor/{id}", method = RequestMethod.GET)
	public Sensor findById(@PathVariable("id") Integer id) {
		return sensorService.findById(id);
	}
}
