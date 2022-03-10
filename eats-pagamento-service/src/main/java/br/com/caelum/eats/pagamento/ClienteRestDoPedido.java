package br.com.caelum.eats.pagamento;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
public class ClienteRestDoPedido {
	
	private PedidoClient pedidoCliente;
	
    public ClienteRestDoPedido(PedidoClient pedidoCliente) {
        this.pedidoCliente = pedidoCliente;
    }

    void notificaPagamentoDoPedido(Long pedidoId) {

    	ResponseEntity<?> response = pedidoCliente.atualizaStatus(pedidoId, new PedidoMudancaDeStatusRequest("pago".toUpperCase()));

        if (!HttpStatus.valueOf(response.getStatusCodeValue()).is2xxSuccessful()) {
            throw new RuntimeException("problema ao tentar mudar o status do pedido: " + pedidoId);
        }
    }
}

@Getter
@AllArgsConstructor
class PedidoMudancaDeStatusRequest {
    private String status;
}
