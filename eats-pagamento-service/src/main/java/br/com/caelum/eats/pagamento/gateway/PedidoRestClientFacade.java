package br.com.caelum.eats.pagamento.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelum.eats.pagamento.gateway.domain.PedidoMudancaDeStatusRequest;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PedidoRestClientFacade {

    private final PedidoFeignRestClient restClient;

    @Autowired
    public PedidoRestClientFacade(PedidoFeignRestClient restClient) {
        this.restClient = restClient;
    }

   public void notificaPagamentoDoPedido(Long pedidoId) {
	   
        try {
        	restClient.notificaPagamentoDoPedido(pedidoId, new PedidoMudancaDeStatusRequest("pago".toUpperCase()));
		} catch (FeignException e) {
			log.error("Erro ao chamar API para notificação do pagamento do pedido.", e);
			throw new RuntimeException("problema ao tentar mudar o status do pedido: " + pedidoId);
		}
        
    }
}


