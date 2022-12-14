package backend.model;

import java.awt.Image;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;


@Entity
//@Data
@Getter
@Setter
public class Cafetos {

	@Id
	private Integer id_cafetos;

	private String idQR, estado, enfermedad;

	@Lob
	@Column(name = "imagedata")
	private byte[] imageData;

	// bi-directional many-to-one association to Minifundio
	@ManyToOne
	@JoinColumn(name = "id_Minifundio")
	//@JsonIgnore
	private Minifundio minifundio;
}
