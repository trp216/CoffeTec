package backend.model;

import java.awt.Image;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

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
	
	private Image foto;

}
