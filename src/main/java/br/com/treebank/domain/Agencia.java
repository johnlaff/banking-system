package br.com.treebank.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Agencia")
@Data
public class Agencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agenciaId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String telefone;

    @OneToOne
    @JoinColumn(name = "gerenteId")
    private Funcionario gerente;
}
