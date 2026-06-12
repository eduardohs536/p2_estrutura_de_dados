import java.util.Scanner;

public class BibliotecaDigital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDupla acervo = new ListaDupla();
        Catalogo catalogo = new Catalogo();
        GestorEmprestimos gestor = new GestorEmprestimos(catalogo);

        int opcao = 0;

        while (opcao != 8) {
            System.out.println("\n=== MENU BIBLIOTECA DIGITAL ===");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Buscar livro por ISBN");
            System.out.println("3. Listar acervo do inicio ao fim");
            System.out.println("4. Listar acervo do fim ao inicio");
            System.out.println("5. Solicitar emprestimo");
            System.out.println("6. Devolver livro");
            System.out.println("7. Ver fila de espera de um livro");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opcao: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = 0;
            }

            if (opcao == 1) {
                System.out.print("ISBN: ");
                String isbn = scanner.nextLine();
                System.out.print("Titulo: ");
                String titulo = scanner.nextLine();
                System.out.print("Autor: ");
                String autor = scanner.nextLine();
                System.out.print("Ano de Publicacao: ");
                int ano = Integer.parseInt(scanner.nextLine());

                Livro novoLivro = new Livro(isbn, titulo, autor, ano);
                acervo.insereFim(novoLivro);
                catalogo.cadastrar(novoLivro);
                System.out.println("Livro cadastrado com sucesso.");

            } else if (opcao == 2) {
                System.out.print("Digite o ISBN: ");
                String isbnBusca = scanner.nextLine();
                Livro livroBuscado = catalogo.buscar(isbnBusca);
                if (livroBuscado != null) {
                    System.out.println("Resultado: " + livroBuscado);
                } else {
                    System.out.println("Livro nao encontrado.");
                }

            } else if (opcao == 3) {
                System.out.println("\nAcervo (Inicio ao Fim):");
                acervo.listarDoInicio();

            } else if (opcao == 4) {
                System.out.println("\nAcervo (Fim ao Inicio):");
                acervo.listarDoFim();

            } else if (opcao == 5) {
                System.out.print("Digite o ISBN do livro: ");
                String isbnEmp = scanner.nextLine();
                System.out.print("Matricula do usuario: ");
                int mat = Integer.parseInt(scanner.nextLine());
                System.out.print("Nome do usuario: ");
                String nome = scanner.nextLine();
                System.out.print("Email do usuario: ");
                String email = scanner.nextLine();

                Usuario usuario = new Usuario(mat, nome, email);
                gestor.solicitarEmprestimo(isbnEmp, usuario);

            } else if (opcao == 6) {
                System.out.print("Digite o ISBN do livro para devolucao: ");
                String isbnDev = scanner.nextLine();
                gestor.devolverLivro(isbnDev);

            } else if (opcao == 7) {
                System.out.print("Digite o ISBN do livro: ");
                String isbnFila = scanner.nextLine();
                gestor.listarFilaDeEspera(isbnFila);

            } else if (opcao == 8) {
                System.out.println("Encerrando o sistema.");

            } else {
                System.out.println("Opcao invalida.");
            }
        }
        scanner.close();
    }
}