package br.com.treebank.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "Cliente")
@Data
public class Cliente {
    @Id
    private Long clientId;
    @Column (nullable = false)
    private String tipoCliente;
    @OneToOne
    @MapsId
    @JoinColumn(name = "clienteId")
    private Pessoa pessoa;
}
