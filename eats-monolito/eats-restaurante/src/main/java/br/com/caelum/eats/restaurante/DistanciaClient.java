package br.com.caelum.eats.restaurante;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.AllArgsConstructor;
import lombok.Getter;

@FeignClient("distancia")
public interface DistanciaClient {

	@PostMapping("/restaurantes")
	Map<String, Object> incluirRestaurante(@RequestBody PedidoAtualizacaoRestauranteRequest restaurante);
	
	@PutMapping("/restaurantes/{numeroRestaurante}")
	Map<String, Object> atualizarRestaurante(@PathVariable Long numeroRestaurante,
			@RequestBody PedidoAtualizacaoRestauranteRequest restaurante);

}

@Getter
@AllArgsConstructor
class PedidoAtualizacaoRestauranteRequest {
	private Long id;
	private String cep;
	private Long tipoDeCozinhaId;
}