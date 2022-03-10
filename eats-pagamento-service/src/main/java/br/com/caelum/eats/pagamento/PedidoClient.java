package br.com.caelum.eats.pagamento;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("monolito")
interface PedidoClient {

    @PutMapping("/pedidos/{pedidoId}/status")
    ResponseEntity<?> atualizaStatus(@PathVariable Long pedidoId, @RequestBody PedidoMudancaDeStatusRequest pedidoParaAtualizar);
}
