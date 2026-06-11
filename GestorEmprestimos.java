public class GestorEmprestimos {
    private NossoHash<String, Fila<Usuario>> tabelasFila;
    private Catalogo catalogo; // Alterado de ListaDupla para Catalogo

    public GestorEmprestimos(Catalogo catalogo) {
        this.catalogo = catalogo;
        this.tabelasFila = new NossoHash<>();
    }

    public void solicitarEmprestimo(String isbn, Usuario u) {
        Livro livro = catalogo.buscar(isbn); // Busca instantânea O(1)
        
        if (livro == null) {
            System.out.println("Livro nao encontrado no catalogo.");
            return;
        }

        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            System.out.println("Emprestimo registrado para: " + u.getNome());
        } else {
            if (!tabelasFila.containsKey(isbn)) {
                tabelasFila.put(isbn, new Fila<>());
            }
            tabelasFila.get(isbn).enfileira(u);
            System.out.println("Livro indisponivel. " + u.getNome() + " adicionado a fila.");
        }
    }

    public void devolverLivro(String isbn) {
        Livro livro = catalogo.buscar(isbn); // Busca instantânea O(1)

        if (livro == null) {
            System.out.println("Livro nao encontrado no catalogo.");
            return;
        }

        System.out.println("Livro '" + livro.getTitulo() + "' devolvido.");

        if (tabelasFila.containsKey(isbn) && !tabelasFila.get(isbn).filaVazia()) {
            Usuario proximo = tabelasFila.get(isbn).desenfileira();
            System.out.println("Emprestado automaticamente para: " + proximo.getNome());
        } else {
            livro.setDisponivel(true);
            System.out.println("Nenhum usuario na fila. Livro disponivel.");
        }
    }

    public void listarFilaDeEspera(String isbn) {
        Livro livro = catalogo.buscar(isbn);
        if (livro == null) {
            System.out.println("Livro nao encontrado.");
            return;
        }

        System.out.println("Fila de espera para: " + livro.getTitulo());
        if (tabelasFila.containsKey(isbn)) {
            System.out.println(tabelasFila.get(isbn));
        } else {
            System.out.println("\\");
        }
    }
}