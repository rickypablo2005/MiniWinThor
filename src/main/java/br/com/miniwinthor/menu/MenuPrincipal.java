package br.com.miniwinthor.menu;

import br.com.miniwinthor.exceptions.BancoDeDadosException;
import br.com.miniwinthor.exceptions.ValidacaoException;
import br.com.miniwinthor.model.Produto;
import br.com.miniwinthor.service.ProdutoService;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private final Scanner scanner;
    private final ProdutoService produtoService;

    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);
        this.produtoService = new ProdutoService();
    }

    public void iniciar() {
        int opcao = 0;

        System.out.println("=========================================");
        System.out.println("=     BEM VINDO AO MINI WINTHOR APP     =");
        System.out.println("=========================================");

        do {
            System.out.println("\nESCOLHA UMA OPÇÃO:");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar produto");
            System.out.println("4 - Alterar produto");
            System.out.println("5 - Remover produto");
            System.out.println("6 - Sair");
            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                processarOpcao(opcao);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite um número inteiro válido.");
            } catch (BancoDeDadosException e) {
                System.out.println("=====================================================");
                System.out.println(">>> ALERTA DE SISTEMA (MOCK): ");
                System.out.println(e.getMessage());
                System.out.println("=====================================================\n");
            } catch (ValidacaoException e) {
                System.out.println("\n[ERRO DE VALIDAÇÃO] " + e.getMessage());
            } catch (Exception e) {
                System.out.println("\n[ERRO DESCONHECIDO] " + e.getMessage());
            }
        } while (opcao != 6);

        System.out.println("Saindo do MiniWinThor. Até logo!");
        scanner.close();
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarProduto();
                break;
            case 2:
                listarProdutos();
                break;
            case 3:
                buscarProduto();
                break;
            case 4:
                alterarProduto();
                break;
            case 5:
                removerProduto();
                break;
            case 6:
                // Sai
                break;
            default:
                System.out.println("Opção inválida! Escolha de 1 a 6.");
        }
    }

    private void cadastrarProduto() {
        System.out.println("\n--- CADASTRAR PRODUTO ---");
        Produto produto = lerProdutoDoConsole();
        produtoService.cadastrarProduto(produto);
        System.out.println("Operação de cadastro finalizada com sucesso!");
    }

    private void listarProdutos() {
        System.out.println("\n--- LISTAR PRODUTOS ---");
        List<Produto> lista = produtoService.listarProdutos();
        if (lista.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            lista.forEach(System.out::println);
        }
    }

    private void buscarProduto() {
        System.out.println("\n--- BUSCAR PRODUTO ---");
        System.out.print("Informe o código desejado: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        Produto p = produtoService.buscarProduto(codigo);
        if (p == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.println("Produto localizado: ");
            System.out.println(p);
        }
    }

    private void alterarProduto() {
        System.out.println("\n--- ALTERAR PRODUTO ---");
        System.out.println("ATENÇÃO: O código deve ser o mesmo do produto que se quer alterar.");
        Produto produto = lerProdutoDoConsole();
        produtoService.atualizarProduto(produto);
        System.out.println("Operação de alteração finalizada!");
    }

    private void removerProduto() {
        System.out.println("\n--- REMOVER PRODUTO ---");
        System.out.print("Informe o código do produto a ser removido: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        produtoService.removerProduto(codigo);
        System.out.println("Operação de remoção finalizada!");
    }

    /**
     * Auxiliar para coletar dados repetitivos da entidade via teclado
     */
    private Produto lerProdutoDoConsole() {
        Produto p = new Produto();

        System.out.print("Código: ");
        p.setCodigo(Integer.parseInt(scanner.nextLine()));

        System.out.print("Descrição: ");
        p.setDescricao(scanner.nextLine());

        System.out.print("Preço de Compra: ");
        p.setPrecoDeCompra(Double.parseDouble(scanner.nextLine()));

        System.out.print("Preço de Venda: ");
        p.setPrecoDeVenda(Double.parseDouble(scanner.nextLine()));

        System.out.print("Status: ");
        p.setStatus(scanner.nextLine());

        return p;
    }
}
