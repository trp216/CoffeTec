package backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.Getter;
import lombok.Setter;

@Entity
//@Data
@Getter
@Setter
public class Viaje {
	
	@Id
	private Integer id_viaje;
	
	private double distancia;
	
	private Date fecha_inicio, fecha_fin;
	

}
