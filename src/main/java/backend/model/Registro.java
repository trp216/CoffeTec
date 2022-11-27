package backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
//@Data
@Getter
@Setter
public class Registro {

	@Id
	private Integer id_registro;

	private Date fecha;

	private String dato;

	// bi-directional many-to-one association to Sensor
	@ManyToOne
	@JoinColumn(name = "id_sensor")
	//@JsonIgnore
	private Sensor sensor;

}
