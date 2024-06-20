package com.example.backend.Dominio.services;

import com.example.backend.Dominio.model.*;
import com.example.backend.Dominio.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ServicoCadastramento {
    @Autowired
    private IRepCliente repCliente;

    @Autowired
    private IRepAssinatura repAssinatura;

    @Autowired
    private IRepPagamento repPagamento;

    @Autowired
    private IRepAplicativo repAplicativo;

    public ServicoCadastramento(IRepCliente repCliente, IRepAssinatura repAssinatura, IRepPagamento repPagamento, IRepAplicativo repAplicativo) {
        this.repCliente = repCliente;
        this.repAssinatura = repAssinatura;
        this.repPagamento = repPagamento;
        this.repAplicativo = repAplicativo;
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        return repCliente.save(cliente);
    }

    public Optional<Cliente> buscarClientePorId(Long id) {
        return repCliente.findById(id);
    }

    public Cliente atualizarCliente(Cliente cliente) {
        return repCliente.save(cliente);
    }

    public void deletarCliente(Long id) {
        repCliente.deleteById(id);
    }

    public Aplicativo cadastrarAplicativo(Aplicativo aplicativo) {
        return repAplicativo.save(aplicativo);
    }

    public Optional<Aplicativo> buscarAplicativoPorId(Long id) {
        return repAplicativo.findById(id);
    }

    public Aplicativo atualizarAplicativo(Aplicativo aplicativo) {
        return repAplicativo.save(aplicativo);
    }

    public void deletarAplicativo(Long id) {
        repAplicativo.deleteById(id);
    }

    public Assinatura cadastrarAssinatura(Assinatura assinatura) {
        LocalDate inicioVigencia = assinatura.getInicioVigencia().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        assinatura.setFimVigencia(Date.from(inicioVigencia.plusDays(7).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        return repAssinatura.save(assinatura);
    }

    public Optional<Assinatura> buscarAssinaturaPorId(Long id) {
        return repAssinatura.findById(id);
    }

    public Assinatura atualizarAssinatura(Assinatura assinatura) {
        return repAssinatura.save(assinatura);
    }

    public void deletarAssinatura(Long id) {
        repAssinatura.deleteById(id);
    }

    public Pagamento cadastrarPagamento(Pagamento pagamento) {
        Assinatura assinatura = pagamento.getAssinatura();
        LocalDate fimVigencia = assinatura.getFimVigencia().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        assinatura.setFimVigencia(Date.from(fimVigencia.plusMonths(1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        repAssinatura.save(assinatura);
        return repPagamento.save(pagamento);
    }

    public Optional<Pagamento> buscarPagamentoPorId(Long id) {
        return repPagamento.findById(id);
    }

    public Pagamento atualizarPagamento(Pagamento pagamento) {
        return repPagamento.save(pagamento);
    }

    public void deletarPagamento(Long id) {
        repPagamento.deleteById(id);
    }
}
