public class GestorEmprestimos {
    private NossoHash<String, Fila<Usuario>> tabelasFila;
    private ListaDupla acervo;

    public GestorEmprestimos(ListaDupla acervo) {
        this.acervo = acervo;
        this.tabelasFila = new NossoHash<>();
    }

    public void solicitarEmprestimo(String isbn, Usuario u) {
        Livro livro = acervo.buscarPorIsbn(isbn);
        
        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            System.out.println("Empréstimo registrado com sucesso para: " + u.getNome());
        } else {
            if (!tabelasFila.containsKey(isbn)) {
                tabelasFila.put(isbn, new Fila<>());
            }
            tabelasFila.get(isbn).enfileira(u);
            System.out.println("Livro indisponível. " + u.getNome() + " adicionado à fila de espera.");
        }
    }

    public void devolverLivro(String isbn) {
        Livro livro = acervo.buscarPorIsbn(isbn);

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        System.out.println("Livro '" + livro.getTitulo() + "' devolvido.");

        if (tabelasFila.containsKey(isbn) && !tabelasFila.get(isbn).filaVazia()) {
            Usuario proximo = tabelasFila.get(isbn).desenfileira();
            System.out.println("Livro emprestado automaticamente para o próximo da fila: " + proximo.getNome());
        } else {
            livro.setDisponivel(true);
            System.out.println("Nenhum usuário na fila. Livro está disponível novamente.");
        }
    }

    public void listarFilaDeEspera(String isbn) {
        Livro livro = acervo.buscarPorIsbn(isbn);
        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        System.out.println("Fila de espera para o livro: " + livro.getTitulo());
        if (tabelasFila.containsKey(isbn)) {
            System.out.println(tabelasFila.get(isbn));
        } else {
            System.out.println("\\");
        }
    }
}