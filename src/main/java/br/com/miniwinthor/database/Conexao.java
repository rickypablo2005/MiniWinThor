package br.com.miniwinthor.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.miniwinthor.exceptions.BancoDeDadosException;

/**
 * Classe utilitária para conexão com o banco de dados.
 */
public class Conexao {

    // Credenciais (Basta alterar esses valores quando o MySQL for instalado)
    private static final String HOST = "localhost";
    private static final String PORTA = "3306";
    private static final String NOME_BANCO = "miniwinthor";
    private static final String USUARIO = "usuario";
    private static final String SENHA = "senha";

    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORTA + "/" + NOME_BANCO;

    private Conexao() {
        // Classe utilitária, não deve ser instanciada
    }

    /**
     * Tenta estabelecer conexão com o banco MySQL via DriverManager.
     * Caso o banco não exista neste momento, lançará exceção amigável.
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao conectar no banco de dados. Verifique se o MySQL está rodando ou se as credenciais em Conexao.java estão corretas (Futura configuração!).", e);
        }
    }
}
