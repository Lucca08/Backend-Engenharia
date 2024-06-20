package com.example.backend.Dominio.repositories;

import com.example.backend.Dominio.model.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepAssinatura extends JpaRepository<Assinatura, Long> {
}
