import java.util.Scanner;

/*Representa um nó da árvore.*/
class Nodo {
    char dado; // Armazena a letra ou número
    Nodo esquerda; // Representa o caminho do ponto
    Nodo direita;  // Representa o caminho do traço

    public Nodo() {
        this.dado = '\0'; 
        this.esquerda = null;
        this.direita = null;
    }
}

/* Gerencia a árvore binária de Código Morse.
*/
class ArvoreBinariaMorse {
    private Nodo raiz;

    public ArvoreBinariaMorse() {
        this.raiz = new Nodo();
    }

    public void inserir(String codigo, char letra) {
        Nodo atual = this.raiz;
        for (int i = 0; i < codigo.length(); i++) {
            char direcao = codigo.charAt(i);
            if (direcao == '.') {
                if (atual.esquerda == null) {
                    atual.esquerda = new Nodo();
                }
                atual = atual.esquerda;
            } else if (direcao == '-') {
                if (atual.direita == null) {
                    atual.direita = new Nodo();
                }
                atual = atual.direita;
            }
        }
        atual.dado = letra;
    }

    public String buscar(String mensagemMorse) {
        String resultado = "";
        String codigoAtual = "";
        for (int i = 0; i < mensagemMorse.length(); i++) {
            char c = mensagemMorse.charAt(i);
            if (c == ' ') {
                if (codigoAtual.length() > 0) {
                    resultado = resultado + buscarCaractere(codigoAtual);
                    codigoAtual = "";
                }
            } else {
                codigoAtual = codigoAtual + c;
            }
        }
        if (codigoAtual.length() > 0) {
            resultado = resultado + buscarCaractere(codigoAtual);
        }
        return resultado;
    }

    private char buscarCaractere(String codigo) {
        Nodo atual = this.raiz;
        for (int i = 0; i < codigo.length(); i++) {
            char direcao = codigo.charAt(i);
            if (direcao == '.') {
                atual = atual.esquerda;
            } else if (direcao == '-') {
                atual = atual.direita;
            }
            if (atual == null) {
                return '?';
            }
        }
        if (atual.dado == '\0') {
             return '?';
        }
        return atual.dado;
    }

    public void remover(String codigo) {
        Nodo atual = this.raiz;
        for (int i = 0; i < codigo.length(); i++) {
            char direcao = codigo.charAt(i);
            if (direcao == '.') {
                atual = atual.esquerda;
            } else if (direcao == '-') {
                atual = atual.direita;
            }
            if (atual == null) {
                return;
            }
        }
        if (atual != null) {
            atual.dado = '\0';
        }
    }

    public void exibir() {
        System.out.println("--- Exibindo Árvore Morse ---");
        exibirRecursivo(this.raiz, "");
        System.out.println("-----------------------------");
    }

    private void exibirRecursivo(Nodo no, String codigo) {
        if (no == null) {
            return;
        }
        if (no.dado != '\0') {
            if (codigo.length() == 0) {
                 System.out.println("RAIZ (Nó inicial)");
            } else {
                 System.out.println("Código: " + codigo + " -> Caractere: " + no.dado);
            }
        }
        exibirRecursivo(no.esquerda, codigo + ".");
        exibirRecursivo(no.direita, codigo + "-");
    }

    public void popularArvore() {
        // Letras
        inserir(".-", 'A'); inserir("-...", 'B'); inserir("-.-.", 'C');
        inserir("-..", 'D'); inserir(".", 'E'); inserir("..-.", 'F');
        inserir("--.", 'G'); inserir("....", 'H'); inserir("..", 'I');
        inserir(".---", 'J'); inserir("-.-", 'K'); inserir(".-..", 'L');
        inserir("--", 'M'); inserir("-.", 'N'); inserir("---", 'O');
        inserir(".--.", 'P'); inserir("--.-", 'Q'); inserir(".-.", 'R');
        inserir("...", 'S'); inserir("-", 'T'); inserir("..-", 'U');
        inserir("...-", 'V'); inserir(".--", 'W'); inserir("-..-", 'X');
        inserir("-.--", 'Y'); inserir("--..", 'Z');
        // Números
        inserir("-----", '0'); inserir(".----", '1'); inserir("..---", '2');
        inserir("...--", '3'); inserir("....-", '4'); inserir(".....", '5');
        inserir("-....", '6'); inserir("--...", '7'); inserir("---..", '8');
        inserir("----.", '9');
    }
}

/* Classe principal que contém o método main para executar o programa. */
public class Main {
    public static void main(String[] args) {
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
        arvore.popularArvore();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        System.out.println("Bem-vindo ao Decodificador de Código Morse!");

        while (opcao != 5) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Decodificar mensagem Morse para Texto");
            System.out.println("2. Inserir um novo caractere na árvore");
            System.out.println("3. Remover um caractere da árvore");
            System.out.println("4. Exibir a Árvore Morse");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            String entrada = scanner.nextLine();
            if (entrada.length() == 1 && entrada.charAt(0) >= '1' && entrada.charAt(0) <= '5') {
                opcao = Integer.parseInt(entrada);
            } else {
                System.out.println("Opção inválida! Por favor, insira um número de 1 a 5.");
                opcao = 0;
                continue;
            }

            if (opcao == 1) {
                System.out.print("Digite a mensagem em código Morse (use '.' para ponto, '-' para traço e espaço entre letras): ");
                String morse = scanner.nextLine();
                String texto = arvore.buscar(morse);
                System.out.println("Texto decodificado: " + texto);
            } else if (opcao == 2) {
                System.out.print("Digite o caractere a ser inserido: ");
                String charEntrada = scanner.nextLine();
                if (charEntrada.length() != 1) {
                    System.out.println("Erro: por favor, insira apenas um caractere.");
                } else {
                    char letra = charEntrada.charAt(0);
                    System.out.print("Digite o código Morse para '" + letra + "': ");
                    String codigo = scanner.nextLine();
                    arvore.inserir(codigo, letra);
                    System.out.println("Caractere '" + letra + "' inserido com sucesso!");
                }
            } else if (opcao == 3) {
                System.out.print("Digite o código Morse do caractere a ser removido: ");
                String codigo = scanner.nextLine();
                arvore.remover(codigo);
                System.out.println("Remoção concluída. Se o código existia, seu valor foi apagado.");
            } else if (opcao == 4) {
                arvore.exibir();
            } else if (opcao == 5) {
                System.out.println("Saindo do programa.");
            }
        }
        scanner.close();
    }
}
