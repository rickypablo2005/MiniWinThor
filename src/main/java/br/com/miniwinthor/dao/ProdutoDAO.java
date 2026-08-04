package br.com.miniwinthor.dao;

import br.com.miniwinthor.database.Conexao;
import br.com.miniwinthor.exceptions.BancoDeDadosException;
import br.com.miniwinthor.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) responsável pela persistência do Produto.
 */
public class ProdutoDAO {

    public void salvar(Produto produto) {
        String sql = "INSERT INTO produtos (codigo, descricao, preco_compra, preco_venda, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexao.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, produto.getCodigo());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPrecoDeCompra());
            stmt.setDouble(4, produto.getPrecoDeVenda());
            stmt.setString(5, produto.getStatus());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao persistir o produto no banco.", e);
        }
    }

    public List<Produto> listar() {
        String sql = "SELECT * FROM produtos";
        List<Produto> produtos = new ArrayList<>();

        try (Connection con = Conexao.getConnection(); 
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto p = new Produto();
                p.setCodigo(rs.getInt("codigo"));
                p.setDescricao(rs.getString("descricao"));
                p.setPrecoDeCompra(rs.getDouble("preco_compra"));
                p.setPrecoDeVenda(rs.getDouble("preco_venda"));
                p.setStatus(rs.getString("status"));
                produtos.add(p);
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao buscar a lista de produtos.", e);
        }

        return produtos;
    }

    public Produto buscarPorCodigo(int codigo) {
        String sql = "SELECT * FROM produtos WHERE codigo = ?";
        
        try (Connection con = Conexao.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Produto p = new Produto();
                    p.setCodigo(rs.getInt("codigo"));
                    p.setDescricao(rs.getString("descricao"));
                    p.setPrecoDeCompra(rs.getDouble("preco_compra"));
                    p.setPrecoDeVenda(rs.getDouble("preco_venda"));
                    p.setStatus(rs.getString("status"));
                    return p;
                }
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao buscar o produto de código " + codigo, e);
        }
        
        return null;
    }

    public void atualizar(Produto produto) {
        String sql = "UPDATE produtos SET descricao = ?, preco_compra = ?, preco_venda = ?, status = ? WHERE codigo = ?";

        try (Connection con = Conexao.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getPrecoDeCompra());
            stmt.setDouble(3, produto.getPrecoDeVenda());
            stmt.setString(4, produto.getStatus());
            stmt.setInt(5, produto.getCodigo());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao atualizar o produto.", e);
        }
    }

    public void remover(int codigo) {
        String sql = "DELETE FROM produtos WHERE codigo = ?";

        try (Connection con = Conexao.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao remover o produto.", e);
        }
    }
}
