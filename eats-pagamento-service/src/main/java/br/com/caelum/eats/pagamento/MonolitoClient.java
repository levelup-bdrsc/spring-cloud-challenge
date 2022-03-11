package br.com.caelum.eats.pagamento;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.AllArgsConstructor;
import lombok.Getter;

@FeignClient("monolito")
public interface MonolitoClient {

	@PutMapping("/pedidos/{numeroDoPedido}/status")
	Map<String, Object> atualizaStatus(@PathVariable Long numeroDoPedido, @RequestBody PedidoMudancaDeStatusRequest pedidoParaAtualizar);
	
}

@Getter
@AllArgsConstructor
class PedidoMudancaDeStatusRequest {
    private String status;
}