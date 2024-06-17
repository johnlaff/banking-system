package br.com.treebank.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Pessoa")
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pessoaId;

    @Column (nullable = false)
    private String nome;

    @Column (nullable = false)
    private String endereco;

    @Column (nullable = false)
    private String telefone;

    @Column (nullable = false, unique = true)
    private String email;

    @Column (nullable = false)
    private Date dataNascimento;
}
