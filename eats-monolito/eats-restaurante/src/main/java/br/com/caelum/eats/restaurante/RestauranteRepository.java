package br.com.caelum.eats.restaurante;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.caelum.eats.administrativo.TipoDeCozinha;

interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

	List<Restaurante> findAllByAprovado(boolean aprovado);

	Page<Restaurante> findAllByAprovadoAndTipoDeCozinha(boolean aprovado, TipoDeCozinha tipo, Pageable limit);

	Page<Restaurante> findAllByAprovado(boolean aprovado, Pageable limit);

	@Modifying(clearAutomatically = true)
	@Query("update Restaurante r set r.aprovado = true where r.id = :id")
	void aprovaPorId(@Param("id") Long id);

}
