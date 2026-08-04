# MiniWinThor

![Java Version](https://img.shields.io/badge/Java-21-orange.svg)
![Build](https://img.shields.io/badge/build-Maven-C71A36.svg)

## Objetivo do projeto
O MiniWinThor é um projeto de console em Java com arquitetura Maven voltada para o cadastro e gerenciamento de produtos.

## Tecnologias
- Java 21
- Maven
- MySQL Connector/J
- JUnit 5

## Estrutura do projeto
```text
MiniWinThor/
├── pom.xml
├── README.md
├── .gitignore
└── src/
    └── main/
        └── java/
            └── br/
                └── com/
                    └── miniwinthor/
                        ├── Main.java
                        ├── model/
                        │   └── Produto.java
                        ├── dao/
                        │   └── ProdutoDAO.java
                        ├── service/
                        │   └── ProdutoService.java
                        ├── database/
                        │   └── Conexao.java
                        ├── menu/
                        │   └── MenuPrincipal.java
                        └── exceptions/
                            ├── BancoDeDadosException.java
                            └── ValidacaoException.java
```

## Como executar
1. Certifique-se de ter Java 21 e Maven instalados.
2. Na pasta do projeto, execute:
```bash
mvn clean compile
```
3. Para iniciar o menu interativo, execute a classe br.com.miniwinthor.Main.

## Configuração do MySQL
O projeto usa JDBC e espera uma conexão com o banco de dados miniwinthor. Ajuste as credenciais em src/main/java/br/com/miniwinthor/database/Conexao.java conforme o ambiente local.

## Banco de Dados

O MiniWinThor foi estruturado para utilizar **MySQL** com **JDBC**.

Os scripts SQL estão disponíveis na pasta `database/`.

### Arquivos

- `schema.sql` — cria o banco de dados e a tabela `produtos`.
- `sample-data.sql` — adiciona produtos de exemplo para testes.

> **Observação:** atualmente o projeto foi estruturado para fins de estudo e documentação. A conexão com um servidor MySQL não é obrigatória para compilar o projeto.
