package com.example.backend.Dominio.repositories;

import com.example.backend.Dominio.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepPagamento extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByCodAssinatura(Long codAssinatura);
}
