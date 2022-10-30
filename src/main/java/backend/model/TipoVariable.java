package backend.model;

import java.util.Date;

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

}
