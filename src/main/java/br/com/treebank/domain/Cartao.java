package br.com.treebank.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table (name = "Cartao")
@Data
public class Cartao {
    @Id
    private Long cartaoId;

    @ManyToOne
    @JoinColumn (name = "clienteId", nullable = false)
    private Cliente cliente;

    @Column (nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'Débito'")
    private String tipoCartao;

    @Column (nullable = false)
    private Double limiteCredito;

    @Column (nullable = false)
    private Date dataValidade;
}
