package br.com.caelum.eats.restaurante;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ClienteRestDoRestaurante {

    private final DistanciaClient client;

    public ClienteRestDoRestaurante(DistanciaClient client) {
        this.client = client;
    }

    void incluirRestaurante(Long id, String cep, Long tipoRestauranteId) {
    	log.info("Notifica Criacao de restaurante ao servico de Distancia");
		
        try {
        	client.incluirRestaurante(new PedidoAtualizacaoRestauranteRequest(id, cep, tipoRestauranteId));
        }
        catch(Exception e) {
            throw new RuntimeException("problema ao tentar incluir restaurante: " + id);
        }
    }

    void alterarRestaurante(Long id, String cep, Long tipoRestauranteId) {
    	log.info("Notifica Alteracao de restaurante ao servico de Distancia");
		
        try {
        	client.atualizarRestaurante(id, new PedidoAtualizacaoRestauranteRequest(id, cep, tipoRestauranteId));
        }
        catch(Exception e) {
            throw new RuntimeException("problema ao tentar alterar restaurante: " + id);
        }
    }
}
