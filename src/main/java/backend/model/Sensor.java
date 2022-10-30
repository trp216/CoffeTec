package backend.model;

import java.util.Date;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
//@Data
@Getter
@Setter
public class Sensor {
	
	@Id
	private Integer id_sensor;
	
	private String ref_sensor, state, postal_code, country;

}
