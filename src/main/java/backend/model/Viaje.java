package backend.model;

import java.util.Date;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

@Entity
public class Viaje {
	
	@Id
	private Integer id_viaje;
	
	private double distancia, peso_carga;
	
	private Date fecha_inicio, fecha_fin;
	

}
