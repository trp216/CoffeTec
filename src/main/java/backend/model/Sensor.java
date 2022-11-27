package backend.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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


	// bi-directional many-to-one association to Registro
	@OneToMany(mappedBy = "id_registro")
	@JsonIgnore
	private List<Registro> registros;

	// bi-directional many-to-one association to TipoVariable
	@ManyToOne
	@JoinColumn(name = "idTipoVariable")
	//@JsonIgnore
	private TipoVariable tipoVariable;

	// bi-directional many-to-one association to Minifundio
	@ManyToOne
	@JoinColumn(name = "id_Minifundio")
	//@JsonIgnore
	private Minifundio minifundio;

	// bi-directional many-to-one association to Viaje
	@ManyToOne
	@JoinColumn(name = "id_viaje")
	//@JsonIgnore
	private Viaje viaje;
}
