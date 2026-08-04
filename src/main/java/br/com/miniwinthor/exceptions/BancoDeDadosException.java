package br.com.miniwinthor.exceptions;

/**
 * Exceção lançada quando ocorre algum problema interno no acesso ao banco de dados,
 * seja falha de driver ou erro de SQL.
 */
public class BancoDeDadosException extends RuntimeException {
    public BancoDeDadosException(String mensagem) {
        super(mensagem);
    }

    public BancoDeDadosException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
