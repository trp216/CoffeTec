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
public class BultoRegistro {
	
	@Id
	private Integer id_bulto_registro;
	
	private String lugar, detalle;
	
	private Date fecha;

}
