package br.com.miniwinthor.model;

import java.util.Objects;

public class Produto {

    private int codigo;
    private String descricao;
    private double precoDeCompra;
    private double precoDeVenda;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

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
