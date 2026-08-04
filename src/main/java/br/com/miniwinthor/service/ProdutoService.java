package br.com.miniwinthor.service;

import br.com.miniwinthor.dao.ProdutoDAO;
import br.com.miniwinthor.exceptions.ValidacaoException;
import br.com.miniwinthor.model.Produto;
import java.util.List;

/**
 * Service com as regras de negócio para salvar, atualizar ou listar produtos.
 */
public class ProdutoService {

    private final ProdutoDAO produtoDAO;

    public ProdutoService() {
        this.produtoDAO = new ProdutoDAO();
    }

    public void cadastrarProduto(Produto produto) {
        validarRegrasDeNegocio(produto);

        produtoDAO.salvar(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoDAO.listar();
    }

    public Produto buscarProduto(int codigo) {
        if (codigo <= 0) {
            throw new ValidacaoException("O código inserido para busca é inválido.");
        }
        return produtoDAO.buscarPorCodigo(codigo);
    }

    public void atualizarProduto(Produto produto) {
        validarRegrasDeNegocio(produto);

        Produto existe = produtoDAO.buscarPorCodigo(produto.getCodigo());
        if(existe == null) {
            throw new ValidacaoException("Produto de código " + produto.getCodigo() + " não foi encontrado para atualização.");
        }

        produtoDAO.atualizar(produto);
    }

    public void removerProduto(int codigo) {
        if (codigo <= 0) {
            throw new ValidacaoException("Código de produto inválido.");
        }
        produtoDAO.remover(codigo);
    }

    private void validarRegrasDeNegocio(Produto produto) {
        if (produto == null) {
            throw new ValidacaoException("O produto não pode ser nulo.");
        }
        if (produto.getCodigo() <= 0) {
            throw new ValidacaoException("O código do produto deve ser positivo e maior que zero.");
        }
        if (produto.getDescricao() == null || produto.getDescricao().trim().isEmpty()) {
            throw new ValidacaoException("A descrição do produto não pode ser vazia.");
        }
        if (produto.getPrecoDeCompra() < 0) {
            throw new ValidacaoException("O preço de compra não pode ser negativo.");
        }
        if (produto.getPrecoDeVenda() < 0) {
            throw new ValidacaoException("O preço de venda não pode ser negativo.");
        }
    }
}
