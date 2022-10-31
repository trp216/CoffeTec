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
public class Minifundio {
	
	@Id
	private Integer id_Minifundio;
	
	private String nombre_planta, nombre_region;
	
	private Date fecha_siembra_plantas,
				fecha_ultima_recoleccion,
				fecha_ultima_poda;

}
