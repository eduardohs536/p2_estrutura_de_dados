public class NoDuplo {
    private Livro livro;
    private NoDuplo proximo;
    private NoDuplo anterior;

    public NoDuplo(Livro livro) {
        this.livro = livro;
        this.proximo = null;
        this.anterior = null;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public NoDuplo getProximo() {
        return proximo;
    }

    public void setProximo(NoDuplo proximo) {
        this.proximo = proximo;
    }

    public NoDuplo getAnterior() {
        return anterior;
    }

    public void setAnterior(NoDuplo anterior) {
        this.anterior = anterior;
    }
}