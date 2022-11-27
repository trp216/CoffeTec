package backend.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
//@Data
@Getter
@Setter
public class Persona {

	@Id
	@GeneratedValue
	private Integer id_persona;

	private String nombre, telefono, correo, rol, lugar_trabajo;

	@Lob
	@Column(name = "imagedata")
	private byte[] foto;

	// bi-directional many-to-one association to Viaje
	@ManyToOne
	@JoinColumn(name = "id_viaje")
	//@JsonIgnore
	private Viaje viaje;

	// unidirectional many-to-one association to Minifundio
	@OneToOne(mappedBy = "id_Minifundio")
	@JsonIgnore
	private Minifundio minifundio;
}
