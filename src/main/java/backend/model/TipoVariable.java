package backend.model;


import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

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

}
