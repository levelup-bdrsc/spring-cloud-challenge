package br.com.caelum.eats.pagamento.controller.domain;

import java.math.BigDecimal;

import br.com.caelum.eats.pagamento.repository.entity.Pagamento;
import br.com.caelum.eats.pagamento.repository.entity.Pagamento.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDto {

	private Long id;
	private BigDecimal valor;
	private String nome;
	private String numero;
	private String expiracao;
	private String codigo;
	private Status status;
	private Long formaDePagamentoId;
	private Long pedidoId;

	public PagamentoDto(Pagamento p) {
		this(p.getId(), p.getValor(), p.getNome(), p.getNumero(), p.getExpiracao(), p.getCodigo(), p.getStatus(),
				p.getFormaDePagamentoId(), p.getPedidoId());
	}

}
