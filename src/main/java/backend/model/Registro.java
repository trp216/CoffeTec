package backend.model;

import java.util.Date;

import javax.persistence.*;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Data
@Getter
@Setter
@NoArgsConstructor
public class Registro {
	public Registro(Sensor sensor, Date fecha, String dato) {
		this.sensor = sensor;
		this.fecha = fecha;
		this.dato = dato;
	}

	@Override
	public String toString() {
		return "Registro{" +
				"id_registro=" + id_registro +
				", fecha=" + fecha +
				", dato='" + dato + '\'' +
				'}';
	}

	@Id
	@GeneratedValue
	private Integer id_registro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sensor.id_sensor")
	private Sensor sensor;

	private Date fecha;
	
	private String dato;

}
