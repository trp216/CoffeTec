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
public class Registro {
	
	@Id
	private Integer id_registro;
	
	private Date fecha;
	
	private String dato;

}
