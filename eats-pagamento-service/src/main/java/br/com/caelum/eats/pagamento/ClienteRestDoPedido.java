package br.com.caelum.eats.pagamento;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ClienteRestDoPedido {

    private final MonolitoClient monolitoClient;

    public ClienteRestDoPedido(MonolitoClient monolitoClient) {
        this.monolitoClient = monolitoClient;
    }

    void notificaPagamentoDoPedido(Long pedidoId) {
    	log.info("Notifica Pagamento do Pedido ao Monolito");
		
        try {
        	monolitoClient.atualizaStatus(pedidoId, new PedidoMudancaDeStatusRequest("pago".toUpperCase()));
        }
        catch(Exception e) {
            throw new RuntimeException("problema ao tentar mudar o status do pedido: " + pedidoId);
        }
    }
}

