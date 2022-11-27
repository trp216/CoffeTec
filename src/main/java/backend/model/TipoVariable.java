package backend.model;


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
public class TipoVariable {

	@Id
	private Integer idTipoVariable;

	private String nombre, nombreUnidad, escala;

	private Integer limite_inf1, limite_inf2, limite_sup1, limite_sup2;

	// bi-directional many-to-one association to Sensor
	@OneToMany(mappedBy = "id_sensor")
	@JsonIgnore
	private List<Sensor> sensores;

}
