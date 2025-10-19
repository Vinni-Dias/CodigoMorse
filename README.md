# Projeto: Árvore Binária com Código Morse

Este projeto, desenvolvido para fins acadêmicos, consiste na implementação de uma estrutura de dados de árvore binária para representar, decodificar e manipular o Código Morse. O objetivo é criar um programa funcional que permita ao usuário interagir com a árvore, realizando operações como decodificação de mensagens, inserção, remoção e visualização dos caracteres.

##  Descrição do Projeto

A proposta do projeto é implementar uma árvore binária onde cada caminho da raiz até um nó representa a sequência de pontos e traços de um caractere específico. A estrutura da árvore segue a lógica do Código Morse, onde uma navegação para a subárvore **esquerda** corresponde a um 'ponto' (`.`) e para a subárvore **direita** corresponde a um 'traço' (`-`)[cite: 7].

O programa é capaz de decodificar mensagens, permitindo que o usuário insira uma sequência em Morse e receba o texto correspondente.

##  Funcionalidades

O programa oferece as seguintes funcionalidades através de um menu interativo:

**Decodificar Mensagens**: Permite que o usuário insira uma mensagem em Código Morse (com caracteres separados por espaço) e o programa a traduz para texto.
**Inserir Novos Caracteres**: O usuário pode adicionar novos caracteres (como sinais de pontuação) à árvore, fornecendo o caractere e seu respectivo código Morse.
**Remover Caracteres**: É possível remover um caractere da árvore através de seu código Morse. A remoção preserva a estrutura da árvore, apenas limpando o valor do nó, para não afetar outros caracteres que compartilham o mesmo caminho[cite: 13].
**Exibir a Árvore**: Mostra uma representação hierárquica de todos os caracteres presentes na árvore e seus respectivos códigos.

##  Tecnologias e Restrições

* **Linguagem:** Java

Este projeto foi desenvolvido seguindo restrições específicas que proíbem o uso de bibliotecas e estruturas de dados prontas, com o objetivo de focar na implementação pura da lógica da árvore.

* [cite_start]**Estruturas Proibidas**: `StringBuilder`, `Vector`, `Integer` (e outras classes wrapper), `List`, `Arrays`, tipos abstratos (`<>`), `try-catch`, `throws`, etc.[cite: 34, 35, 3].
* [cite_start]**Estruturas Permitidas**: Apenas `String`, `int` e `float`[cite: 36]. [cite_start]A função `length` só pode ser usada para manipulação de `String`[cite: 36, 2].

##  Estrutura do Código

O código-fonte está organizado nas seguintes classes:

* **`Nodo.java`**: Representa cada nó da árvore. Contém um campo para o caractere (`dado`) e dois ponteiros (`esquerda` e `direita`) para os nós filhos.
* **`ArvoreBinariaMorse.java`**: Contém a lógica principal da árvore, incluindo a `raiz` e os métodos para `inserir`, `buscar`, `remover` e `exibir` os dados.
* **`Main.java`**: Classe principal que contém a interface de menu para o usuário, processa as entradas e interage com o objeto `ArvoreBinariaMorse`.

##  Como Executar

1.  **Clone o repositório:**
    ```bash
    git clone [URL-DO-SEU-REPOSITORIO]
    ```
2.  **Navegue até o diretório do projeto:**
    ```bash
    cd [NOME-DO-DIRETORIO]
    ```
3.  **Compile o código:**
    Se estiver usando um compilador Java na linha de comando, compile o arquivo `Main.java`.
    ```bash
    javac Main.java
    ```
4.  **Execute o programa:**
    ```bash
    java Main
    ```
    O menu interativo será exibido no terminal.
