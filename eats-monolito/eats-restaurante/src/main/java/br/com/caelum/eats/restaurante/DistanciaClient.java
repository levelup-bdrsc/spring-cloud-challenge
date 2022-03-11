package br.com.caelum.eats.restaurante;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;



@FeignClient("distancia-service")
public interface DistanciaClient {

	
    @PostMapping("/restaurantes")
    ResponseEntity<Restaurante> adiciona(@RequestBody DistanciaRestauranteDto restaurante);
    
    @PutMapping("/restaurantes/{id}")
    Restaurante atualiza(@PathVariable("id") Long id, @RequestBody DistanciaRestauranteDto restaurante);
}
