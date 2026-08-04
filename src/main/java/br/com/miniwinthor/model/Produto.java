package br.com.miniwinthor.model;

import java.util.Objects;

/**
 * Representa um produto cadastrado no sistema MiniWinThor.
 *
 * Esta classe contém os dados de um produto utilizado pelo sistema
 * de cadastro e gerenciamento de produtos.
 *
 * @author Rickelmy Pablo Silva dos Santos
 * @since 1.0
 */
    public class Produto {

    /**
 * Código identificador do produto.
 */
  private int codigo;

/**
 * Descrição do produto.
 */
  private String descricao;

/**
 * Preço de compra.
 */
  private double precoDeCompra;

/**
 * Preço de venda.
 */
  private double precoDeVenda;

/**
 * Situação do produto.
 */
  private String status;

    public Produto() {
    }

    public Produto(int codigo, String descricao, double precoDeCompra, double precoDeVenda, String status) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoDeCompra = precoDeCompra;
        this.precoDeVenda = precoDeVenda;
        this.status = status;
    }

   /**
 * Retorna o código do produto.
 *
 * @return código do produto
 */
    public int getCodigo() {
    return codigo;
}

    /**
 * Define o código do produto.
 *
 * @param codigo código identificador
 */
    public void setCodigo(int codigo) {
    this.codigo = codigo;
}

   /**
 * Retorna a descrição do produto.
 *
 * @return descrição do produto
 */
public String getDescricao() {
    return descricao;
}

   /**
 * Define a descrição do produto.
 *
 * @param descricao descrição do produto
 */
public void setDescricao(String descricao) {
    this.descricao = descricao;
}

    public double getPrecoDeCompra() {
        return precoDeCompra;
    }

    public void setPrecoDeCompra(double precoDeCompra) {
        this.precoDeCompra = precoDeCompra;
    }

    public double getPrecoDeVenda() {
        return precoDeVenda;
    }

    public void setPrecoDeVenda(double precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", precoDeCompra=" + precoDeCompra +
                ", precoDeVenda=" + precoDeVenda +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Produto produto = (Produto) o;
        return codigo == produto.codigo
                && Double.compare(produto.precoDeCompra, precoDeCompra) == 0
                && Double.compare(produto.precoDeVenda, precoDeVenda) == 0
                && Objects.equals(descricao, produto.descricao)
                && Objects.equals(status, produto.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descricao, precoDeCompra, precoDeVenda, status);
    }
}
