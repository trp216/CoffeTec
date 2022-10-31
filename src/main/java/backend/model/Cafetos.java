package backend.model;

import java.awt.Image;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
//@Data
@Getter
@Setter
public class Cafetos {
	
	@Id
	private Integer id_cafetos;
	
	private String idQR, estado, enfermedad;
	
	private Image foto;

}
