public class NossoHash<K, V> {
    private Entrada<K, V>[] tabela;
    private final int CAPACIDADE = 16;

    @SuppressWarnings("unchecked")
    public NossoHash() {
        this.tabela = new Entrada[CAPACIDADE];
    }

    private int funcaoHash(K key) {
        return Math.abs(key.hashCode()) % CAPACIDADE;
    }

    public void put(K key, V value) {
        int posicao = funcaoHash(key);
        Entrada<K, V> nova = new Entrada<>(key, value);
        
        if (tabela[posicao] != null) {
            nova.proximo = tabela[posicao];
        }
        tabela[posicao] = nova;
    }

    public V get(K key) {
        int posicao = funcaoHash(key);
        Entrada<K, V> atual = tabela[posicao];

        while (atual != null) {
            if (atual.key.equals(key)) {
                return atual.value;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public boolean containsKey(K key) {
        int posicao = funcaoHash(key);
        Entrada<K, V> atual = tabela[posicao];

        while (atual != null) {
            if (atual.key.equals(key)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < CAPACIDADE; i++) {
            Entrada<K, V> atual = tabela[i];
            while (atual != null) {
                if (atual.value.equals(value)) {
                    return true;
                }
                atual = atual.proximo;
            }
        }
        return false;
    }

    public void exibeMap() {
        for (int i = 0; i < CAPACIDADE; i++) {
            System.out.print("[" + i + "]: ");
            Entrada<K, V> atual = tabela[i];
            while (atual != null) {
                System.out.print("{" + atual.key + "=" + atual.value + "} -> ");
                atual = atual.proximo;
            }
            System.out.println("null");
        }
    }
}