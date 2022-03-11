package br.com.caelum.eats.pagamento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
public class ClienteRestDoPedido {
	
	private PedidoClient pedidoCliente;
	
	private static final Logger LOG = LoggerFactory.getLogger(ClienteRestDoPedido.class);
	
    public ClienteRestDoPedido(PedidoClient pedidoCliente) {
        this.pedidoCliente = pedidoCliente;
    }

    void notificaPagamentoDoPedido(Long pedidoId) {
    	
    	LOG.info("Confirmando o pagamento do pedido {}.", pedidoId);

    	ResponseEntity<?> response = pedidoCliente.atualizaStatus(pedidoId, new PedidoMudancaDeStatusRequest("pago".toUpperCase()));

        if (!HttpStatus.valueOf(response.getStatusCodeValue()).is2xxSuccessful()) {
        	
        	LOG.error("Erro no processamento do pagamento do {}.", pedidoId);
        	
            throw new RuntimeException("problema ao tentar mudar o status do pedido: " + pedidoId);
        }
        
        LOG.info("Pedido {} pago com sucesso.", pedidoId);
    }
}

@Getter
@AllArgsConstructor
class PedidoMudancaDeStatusRequest {
    private String status;
}
