package com.example.backend.Dominio.model;

import java.time.LocalDate;
import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Builder
@AllArgsConstructor
@Data
@Entity
public class Assinatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "cod_App")
    private Aplicativo codApp;

    @ManyToOne
    @JoinColumn(name = "cod_Cli")
    private Cliente cliente;

    private Date inicioVigencia;
    private Date fimVigencia;
}
