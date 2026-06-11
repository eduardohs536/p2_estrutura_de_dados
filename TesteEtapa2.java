public class TesteEtapa2 {
    public static void main(String[] args) {
        ListaDupla acervo = new ListaDupla();
        GestorEmprestimos gestor = new GestorEmprestimos(acervo);

        Livro livro = new Livro("978-85-752-2403-8", "Harry Potter", "J.K", 2012);
        acervo.insereFim(livro);

        Usuario u1 = new Usuario(1001, "Eduardo Henrique", "eduardo@gmail.com");
        Usuario u2 = new Usuario(1002, "Ana Gabriella", "ana@gmail.com");
        Usuario u3 = new Usuario(1003, "Ana Landim", "analandim@gmail.com");

        System.out.println("--- Cenário 1: Empréstimo de livro disponível ---");
        gestor.solicitarEmprestimo("978-85-752-2403-8", u1);
        
        System.out.println("\n--- Cenário 2: Tentativas no mesmo livro (Fila de Espera) ---");
        gestor.solicitarEmprestimo("978-85-752-2403-8", u2);
        gestor.solicitarEmprestimo("978-85-752-2403-8", u3);
        
        System.out.println("\n--- Exibindo a Fila de Espera Atual ---");
        gestor.listarFilaDeEspera("978-85-752-2403-8");

        System.out.println("\n--- Cenário 3: Primeira Devolução (Atendimento Automático) ---");
        gestor.devolverLivro("978-85-752-2403-8");
        
        System.out.println("\n--- Exibindo a Fila de Espera Atualizada ---");
        gestor.listarFilaDeEspera("978-85-752-2403-8");

        System.out.println("\n--- Cenário 4: Segunda Devolução (Atendimento Automático do próximo) ---");
        gestor.devolverLivro("978-85-752-2403-8");

        System.out.println("\n--- Cenário 5: Terceira Devolução (Fila Vazia) ---");
        gestor.devolverLivro("978-85-752-2403-8");
    }
}