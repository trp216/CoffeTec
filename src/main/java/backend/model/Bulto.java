package backend.model;


import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.Getter;
import lombok.Setter;

@Entity
//@Data
@Getter
@Setter
public class Bulto {
	
	@Id
	private Integer id_Bulto;
	
	private Double peso;
	
	private String idQR;

}
