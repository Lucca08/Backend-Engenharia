package com.example.backend.Dominio.repositories;

import com.example.backend.Dominio.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepCliente extends JpaRepository<Cliente, Long> {
}
