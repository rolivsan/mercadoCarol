package br.com.mercado.domain.repository;

import br.com.mercado.domain.model.Mercado;
import br.com.mercado.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercadoRepository extends JpaRepository<Mercado, Long> {
}
