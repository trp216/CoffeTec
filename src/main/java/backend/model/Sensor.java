package backend.model;


import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.Getter;
import lombok.Setter;

@Entity
//@Data
@Getter
@Setter
public class Sensor {
	
	@Id
	private Integer id_sensor;
	
	private String ref_sensor, state, postal_code, 
		country, serial_controler_number;
	
	private Double intervalo_registro;

}
