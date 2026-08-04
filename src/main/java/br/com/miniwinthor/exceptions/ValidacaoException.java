package br.com.miniwinthor.exceptions;

/**
 * Exceção lançada quando regras de negócio não são satisfeitas
 * (ex: preço negativo, campos vazios, etc).
 */
public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}
