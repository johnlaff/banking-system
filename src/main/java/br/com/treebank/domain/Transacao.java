package br.com.treebank.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table (name = "Transacao")
@Data
public class Transacao {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long transacaoId;

    @ManyToOne
    @JoinColumn (name = "contaId", nullable = false)
    private Conta conta;

    @Column (nullable = false)
    private String tipoConta;

    @Column (nullable = false)
    private Double valor;

    @Column (nullable = false)
    private Date dataTransacao;
}
