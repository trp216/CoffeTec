package backend.model;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

@Entity
public class Sensor {
	
	@Id
	private Integer id_sensor;
	
	private String ref_sensor, state, postal_code, country;

}
