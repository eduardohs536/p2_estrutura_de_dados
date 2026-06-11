public class TesteEtapa1 {
    public static void main(String[] args) {
        ListaDupla lista = new ListaDupla();

        Livro l1 = new Livro("978-85-325-1101-0", "Harry Potter e a Pedra Filosofal", "J.K. Rowling", 2000);
        Livro l2 = new Livro("978-85-782-7069-8", "O Hobbit", "J.R.R. Tolkien", 2009);
        Livro l3 = new Livro("978-85-457-0287-0", "Frankenstein", "Mary Shelley", 2017);

        System.out.println("Inserindo livros:");
        lista.insereInicio(l2);
        lista.insereInicio(l1);
        lista.insereFim(l3);
        System.out.println("Tamanho: " + lista.tamanho());

        System.out.println("\nListando do inicio:");
        lista.listarDoInicio();

        System.out.println("\nListando do fim:");
        lista.listarDoFim();

        System.out.println("\nBuscando ISBN:");
        Livro buscado = lista.buscarPorIsbn("978-85-782-7069-8");
        System.out.println("Resultado: " + buscado);

        System.out.println("\nRemovendo:");
        System.out.println("Primeiro: " + lista.removePrimeiro());
        System.out.println("Ultimo: " + lista.removeUltimo());

        System.out.println("\nLista final:");
        lista.listarDoInicio();
        System.out.println("Tamanho final: " + lista.tamanho());
    }
}