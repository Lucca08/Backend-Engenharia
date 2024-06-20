package com.example.backend.Dominio.repositories;

import com.example.backend.Dominio.model.Cliente;

import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepCliente extends JpaRepository<Cliente, Long> {
    public Cliente findByNome(String nome);
    public Cliente listarPorNome(String nome);
    public Cliente listarPorId(Long id);
    public Cliente listarPorIdCliente(Long idCliente);
    public Cliente save(Client cliente);
}
