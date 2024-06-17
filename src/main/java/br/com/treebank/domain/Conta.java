package br.com.treebank.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Formula;

import java.util.Date;

@Entity
@Table (name = "Conta")
@Data
public class Conta {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long contaId;

    @ManyToOne
    @JoinColumn (name = "clienteId", nullable = false)
    private Cliente cliente;

    @Column (nullable = false)
    private String tipoConta;

    @Column (nullable = false)
    private Double saldo;

    @Column (nullable = false)
    private Date dataAbertura;

    @Formula("case when saldo >= 0 then 'Ativa' else 'Inativa' end")
    private String statusConta;

}
