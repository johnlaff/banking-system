package br.com.treebank.adapters.inbound.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Agencia")
public class AgenciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AgenciaID")
    private Long id;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Endereco")
    private String endereco;

    @Column(name = "Telefone")
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "GerenteID", referencedColumnName = "FuncionarioID", foreignKey = @ForeignKey(name = "FK_Agencia_Gerente"))
    private FuncionarioEntity gerente;
}