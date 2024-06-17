package br.com.treebank.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table (name = "PagamentoEmprestimo")
@Data
public class PagamentoEmprestimo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long pagamentoId;

    @ManyToOne
    @JoinColumn (name = "emprestimoId", nullable = false)
    private Emprestimo emprestimo;

    @Column (nullable = false)
    private Double valorPagamento;

    @Column (nullable = false)
    private Date dataPagamento;
}
