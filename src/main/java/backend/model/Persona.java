package backend.model;


import javax.persistence.*;


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

}
