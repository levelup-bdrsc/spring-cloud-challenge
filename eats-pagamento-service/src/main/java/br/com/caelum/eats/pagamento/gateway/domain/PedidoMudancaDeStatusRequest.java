package br.com.caelum.eats.pagamento.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PedidoMudancaDeStatusRequest {
    private String status;
}