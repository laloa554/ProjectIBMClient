package Citibanamex.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coordenadas {
	@NotNull
	private float latitud;
	@NotNull
	private float longitud;
}
