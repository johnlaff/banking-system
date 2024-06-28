package br.com.treebank.adapters.inbound.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Getter
@Setter
@Table(name = "Funcionario")
@PrimaryKeyJoinColumn(name = "FuncionarioID", foreignKey = @ForeignKey(name = "FK_Funcionario_Pessoa"))
public class FuncionarioEntity extends PessoaEntity {
    @Column(name = "Cargo")
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "AgenciaID", foreignKey = @ForeignKey(name = "FK_Funcionario_Agencia"))
    @JsonIgnoreProperties("gerente")
    private AgenciaEntity agencia;
}