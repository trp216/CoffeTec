package backend.model;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

@Entity
public class Tipo_Variable {
	
	@Id
	private Integer id_tipo_variable;
	
	private String nombre, nombre_unidad, escala;

}
