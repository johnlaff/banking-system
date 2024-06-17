package br.com.treebank.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "Funcionario")
@Data
public class Funcionario {
    @Id
    private Long funcionarioId;

    @Column (nullable = false)
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "agenciaId", nullable = false)
    private Agencia agencia;

    @OneToOne
    @MapsId
    @JoinColumn(name = "funcionarioId")
    private Pessoa pessoa;
}
