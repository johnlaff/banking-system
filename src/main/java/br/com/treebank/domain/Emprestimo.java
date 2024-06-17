package br.com.treebank.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table (name = "Emprestimo")
@Data
public class Emprestimo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long emprestimoId;

    @ManyToOne
    @JoinColumn (name = "clienteId", nullable = false)
    private Cliente cliente;

    @Column (nullable = false)
    private Double valorEmprestimo;

    @Column (nullable = false)
    private Date dataInicio;

    @Column (nullable = false)
    private Date dataTermino;

    @Column (nullable = false)
    private Double taxaJuros;
}
