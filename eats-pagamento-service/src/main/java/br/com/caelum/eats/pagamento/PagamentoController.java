package br.com.caelum.eats.pagamento;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/pagamentos")
@AllArgsConstructor
class PagamentoController {

	private PagamentoRepository pagamentoRepo;
	private ClienteRestDoPedido pedidoCliente;

	@GetMapping
	ResponseEntity<List<PagamentoDto>> lista() {
		return ResponseEntity.ok(pagamentoRepo.findAll()
				.stream()
				.map(PagamentoDto::new)
				.collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	PagamentoDto detalha(@PathVariable("id") Long id) {
		return pagamentoRepo.findById(id)
				.map(PagamentoDto::new)
				.orElseThrow(ResourceNotFoundException::new);
	}

	@PostMapping
	ResponseEntity<PagamentoDto> cria(@RequestBody Pagamento pagamento, UriComponentsBuilder uriBuilder) {
		pagamento.setStatus(Pagamento.Status.CRIADO);
		Pagamento salvo = pagamentoRepo.save(pagamento);
		URI path = uriBuilder.path("/pagamentos/{id}").buildAndExpand(salvo.getId()).toUri();
		return ResponseEntity.created(path).body(new PagamentoDto(salvo));
	}

	@PutMapping("/{id}")
	PagamentoDto confirma(@PathVariable("id") Long id) {
    	log.info("Confirma pagamento do pedido ID "+id);
		Pagamento pagamento = pagamentoRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
		pagamento.setStatus(Pagamento.Status.CONFIRMADO);
		pedidoCliente.notificaPagamentoDoPedido(pagamento.getPedidoId());
		pagamentoRepo.save(pagamento);
		return new PagamentoDto(pagamento);
	}

	@DeleteMapping("/{id}")
	PagamentoDto cancela(@PathVariable("id") Long id) {
		Pagamento pagamento = pagamentoRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
		pagamento.setStatus(Pagamento.Status.CANCELADO);
		pagamentoRepo.save(pagamento);
		return new PagamentoDto(pagamento);
	}

}