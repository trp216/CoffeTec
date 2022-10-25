package backend.model;

import java.util.Date;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

@Entity
public class Sector {
	
	@Id
	private Integer id_sector;
	
	private String nombre_plantas, nombre_region;
	
	private Date fecha_siembra_plantas, fecha_ultima_recoleccion,
					fecha_ultima_poda;

}
