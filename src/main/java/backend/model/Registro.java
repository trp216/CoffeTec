package backend.model;

import java.util.Date;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

@Entity
public class Registro {
	
	@Id
	private Integer id_registro;
	
	private Date fecha;
	
	private String dato;

}
