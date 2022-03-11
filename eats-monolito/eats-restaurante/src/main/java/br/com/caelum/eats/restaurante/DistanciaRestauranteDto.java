package br.com.caelum.eats.restaurante;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistanciaRestauranteDto {
	
	private Long id;

	private String cep;
	
	private Long tipoDeCozinhaId;
	
}
