package br.com.caelum.eats.pagamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caelum.eats.pagamento.repository.entity.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
