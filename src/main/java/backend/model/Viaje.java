package backend.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
//@Data
@Getter
@Setter
public class Viaje {

	@Id
	private Integer id_viaje;

	private double distancia;

	private Date fecha_inicio, fecha_fin;

	// bi-directional many-to-one association to Sensor
	@OneToMany(mappedBy = "id_sensor")
	@JsonIgnore
	private List<Sensor> sensores;

	// bi-directional many-to-one association to Persona
	@OneToMany(mappedBy = "id_persona")
	@JsonIgnore
	private List<Persona> personas;

}
