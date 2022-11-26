package backend.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;


import lombok.Getter;
import lombok.Setter;

@Entity
//@Data
@Getter
@Setter
public class Persona {
	
	@Id
	private Integer id_persona;
	
	private String nombre, telefono, correo, rol, lugar_trabajo;

	@Lob
	@Column(name = "imagedata")
	private byte[] foto;

}
