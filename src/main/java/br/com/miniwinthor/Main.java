package br.com.miniwinthor;

import br.com.miniwinthor.menu.MenuPrincipal;

/**
 * Ponto de entrada (Entry Point) da aplicação MiniWinThor refatorada com Maven.
 */
public class Main {
    public static void main(String[] args) {
        new MenuPrincipal().iniciar();
    }
}
