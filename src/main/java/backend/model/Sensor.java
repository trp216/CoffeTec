package backend.model;


import javax.persistence.*;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Data
@Getter
@Setter
@NoArgsConstructor
public class Sensor {

	public Sensor(String ref_sensor, String state, String country) {
		this.ref_sensor = ref_sensor;
		this.state = state;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Sensor{" +
				"ref_sensor='" + ref_sensor + '\'' +
				", state='" + state + '\'' +
				", country='" + country + '\'' +
				", serial_controler_number='" + serial_controler_number + '\'' +
				'}';
	}

	@Id
	@GeneratedValue
	private Integer id_sensor;

	@OneToMany(mappedBy = "sensor", fetch = FetchType.LAZY, orphanRemoval = false)
	private List<Registro> listAuthorities = new ArrayList<>();

	private String ref_sensor, state, postal_code, 
		country, serial_controler_number;
	
	private Double intervalo_registro;

}
