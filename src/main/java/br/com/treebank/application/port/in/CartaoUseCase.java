package br.com.treebank.application.port.in;

import br.com.treebank.domain.Cartao;

import java.util.List;

public interface CartaoUseCase {
    List<Cartao> getAllCartoes();
    Cartao getCartaoById(Long id);
    Cartao createCartao(Cartao cartao);
    Cartao updateCartao(Long id, Cartao cartao);
    void deleteCartao(Long id);
}
