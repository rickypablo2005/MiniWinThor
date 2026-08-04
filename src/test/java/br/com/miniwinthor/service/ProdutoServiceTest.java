package br.com.miniwinthor.service;

import br.com.miniwinthor.model.Produto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoServiceTest {

    @Test
    void deveCriarProduto() {

        Produto produto = new Produto();

        produto.setDescricao("Notebook");

        assertEquals("Notebook", produto.getDescricao());

    }

    @Test
    void deveDefinirCodigo() {

        Produto produto = new Produto();

        produto.setCodigo(10);

        assertEquals(10, produto.getCodigo());

    }

    @Test
    void deveDefinirPrecoCompra() {

        Produto produto = new Produto();

        produto.setPrecoDeCompra(100.50);

        assertEquals(100.50, produto.getPrecoDeCompra());

    }

    @Test
    void deveDefinirPrecoVenda() {

        Produto produto = new Produto();

        produto.setPrecoDeVenda(150.75);

        assertEquals(150.75, produto.getPrecoDeVenda());

    }

    @Test
    void deveDefinirStatus() {

        Produto produto = new Produto();

        produto.setStatus("ATIVO");

        assertEquals("ATIVO", produto.getStatus());

    }
}
