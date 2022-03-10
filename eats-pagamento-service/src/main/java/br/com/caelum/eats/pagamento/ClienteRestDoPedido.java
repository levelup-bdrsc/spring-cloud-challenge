package br.com.caelum.eats.pagamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class ClienteRestDoPedido {

 
    private final PedidoClient pedidoClient;

    public ClienteRestDoPedido(PedidoClient pedidoClient) {
        this.pedidoClient = pedidoClient;
    }

    void notificaPagamentoDoPedido(Long pedidoId) {
    	
        ResponseEntity<?> response = pedidoClient.atualizaStatus(pedidoId, new PedidoMudancaDeStatusRequest("pago".toUpperCase()));

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


