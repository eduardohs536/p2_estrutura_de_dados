public class ListaDupla {
    private NoDuplo primeiro;
    private NoDuplo ultimo;
    private int totalElementos;

    public ListaDupla() {
        this.primeiro = null;
        this.ultimo = null;
        this.totalElementos = 0;
    }

    public void insereInicio(Livro livro) {
        NoDuplo novo = new NoDuplo(livro);
        if (totalElementos == 0) {
            primeiro = novo;
            ultimo = novo;
        } else {
            novo.setProximo(primeiro);
            primeiro.setAnterior(novo);
            primeiro = novo;
        }
        totalElementos++;
    }

    public void insereFim(Livro livro) {
        NoDuplo novo = new NoDuplo(livro);
        if (totalElementos == 0) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.setProximo(novo);
            novo.setAnterior(ultimo);
            ultimo = novo;
        }
        totalElementos++;
    }

    public Livro removePrimeiro() {
        if (totalElementos == 0) return null;
        Livro removido = primeiro.getLivro();
        primeiro = primeiro.getProximo();
        if (primeiro != null) {
            primeiro.setAnterior(null);
        } else {
            ultimo = null;
        }
        totalElementos--;
        return removido;
    }

    public Livro removeUltimo() {
        if (totalElementos == 0) return null;
        Livro removido = ultimo.getLivro();
        ultimo = ultimo.getAnterior();
        if (ultimo != null) {
            ultimo.setProximo(null);
        } else {
            primeiro = null;
        }
        totalElementos--;
        return removido;
    }

    public Livro buscarPorIsbn(String isbn) {
        NoDuplo atual = primeiro;
        while (atual != null) {
            if (atual.getLivro().getIsbn().equals(isbn)) {
                return atual.getLivro();
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void listarDoInicio() {
        NoDuplo atual = primeiro;
        while (atual != null) {
            System.out.println(atual.getLivro());
            atual = atual.getProximo();
        }
    }

    public void listarDoFim() {
        NoDuplo atual = ultimo;
        while (atual != null) {
            System.out.println(atual.getLivro());
            atual = atual.getAnterior();
        }
    }

    public int tamanho() {
        return totalElementos;
    }
}