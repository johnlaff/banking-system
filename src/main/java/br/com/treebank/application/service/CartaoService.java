package br.com.treebank.application.service;

import br.com.treebank.application.port.in.CartaoUseCase;
import br.com.treebank.application.port.out.CartaoRepository;
import br.com.treebank.domain.Cartao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoService implements CartaoUseCase {
    private final CartaoRepository cartaoRepository;

    public CartaoService(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }

    @Override
    public List<Cartao> getAllCartoes() {
        return cartaoRepository.findAll();
    }

    @Override
    public Cartao getCartaoById(Long id) {
        return cartaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Cartao não encontrado"));
    }

    @Override
    public Cartao createCartao(Cartao cartao) {
        return cartaoRepository.save(cartao);
    }

    @Override
    public Cartao updateCartao(Long id, Cartao cartao) {
        Cartao existingCartao = cartaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Cartao não encontrado"));
        existingCartao.setTipoCartao(cartao.getTipoCartao());
        existingCartao.setLimiteCredito(cartao.getLimiteCredito());
        existingCartao.setDataValidade(cartao.getDataValidade());
        return cartaoRepository.save(existingCartao);
    }

    @Override
    public void deleteCartao(Long id) {
        cartaoRepository.deleteById(id);
    }
}
