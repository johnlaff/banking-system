package br.com.treebank.adapters.inbound.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Cliente")
@PrimaryKeyJoinColumn(name = "ClienteID", foreignKey = @ForeignKey(name = "FK_Cliente_Pessoa"))
public class ClienteEntity extends PessoaEntity {
    @Column(name = "TipoCliente")
    private String tipoCliente;
}
