package backend.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
//@Data
@Getter
@Setter
public class Minifundio {

	@Id
	private Integer id_Minifundio;

	private String nombre_planta, nombre_region;

	private Date fecha_siembra_plantas,
	fecha_ultima_recoleccion,
	fecha_ultima_poda;

	// bi-directional many-to-one association to Sensor
	@OneToMany(mappedBy = "id_sensor")
	@JsonIgnore
	private List<Sensor> sensores;

	// unidirectional many-to-one association to Persona
	@OneToOne(mappedBy = "id_persona")
	@JsonIgnore
	private Persona persona;

	// bi-directional many-to-one association to Cafetos
	@OneToMany(mappedBy = "id_cafetos")
	@JsonIgnore
	private List<Cafetos> cafetos;

}
