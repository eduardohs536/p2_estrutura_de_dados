public class Fila<T> {
    private No<T> primeiro;
    private No<T> ultimo;
    private int totalElementos;

    public Fila() {
        this.primeiro = null;
        this.ultimo = null;
        this.totalElementos = 0;
    }

    public void enfileira(T info) {
        No<T> novo = new No<>(info);
        if (filaVazia()) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.setProximo(novo);
            ultimo = novo;
        }
        totalElementos++;
    }

    public T desenfileira() {
        if (filaVazia()) {
            throw new FilaVaziaException("A fila está vazia.");
        }
        T valor = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        totalElementos--;
        
        if (primeiro == null) {
            ultimo = null;
        }
        return valor;
    }

    public T primeiro() {
        if (filaVazia()) {
            return null;
        }
        return primeiro.getInfo();
    }

    public boolean filaVazia() {
        return totalElementos == 0;
    }

    public int tamanho() {
        return totalElementos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        No<T> atual = primeiro;
        while (atual != null) {
            sb.append("[").append(atual.getInfo()).append("]->");
            atual = atual.getProximo();
        }
        sb.append("\\");
        return sb.toString();
    }
}