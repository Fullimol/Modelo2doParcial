package modelo2doparcial;

import java.util.List;

public class ModeloSP {

    public static void main(String[] args) {
// CREAR BLIBLIOTECA (LIBRARY)
        Library library = new Library();
// AGREGAR LIBROS (BOOK)
        Book book1 = new Book("Clean Code", "Robert C. Martin", 2008);
        library.add(new Book("Piensa en Java", "Bruce Eckel", 2002));
        library.add(new Book("Unified Modeling Language", "OMG", 2017));
        library.add(book1);
        library.add(new Book("The art of computer programming", "Donald Knuth",
                1964));
// MOSTRAR LIBROS (con iterator)
        System.out.println("Libros en la biblioteca:");
        for (Book book : library) {
            System.out.println(book);
        }
// ORDENAR POR FORMA NATURAL
        library.sortBooks();
        System.out.println("Libros en la biblioteca ORDENADOS (natural):");
        for (Book book : library) {
            System.out.println(book);
        }// ORDENAR POR AUTOR
        library.sortBooks(new BookAuthorComparator());
        System.out.println("Libros en la biblioteca ORDENADOS (autor):");
        for (Book book : library) {
            System.out.println(book);
        }
// ORDENAR POR AÑO DE PUBLICACIÓN
        library.sortBooks(new BookYearComparator());
        System.out.println("Libros en la biblioteca ORDENADOS (año):");
        for (Book book : library) {
            System.out.println(book);
        }
// ELIMINAR LIBRO
        library.remove(book1);
        System.out.println("Libros en la biblioteca ELIMINADO:");
        for (Book book : library) {
            System.out.println(book);
        }
        System.out.println("");
        System.out.println("(serializaciones: )");
// SERIALIZAR BINARIO
        if (library.writeBinary("libros.dat", library.getAll())) {
            System.out.println("Se serializó en binario");
        } else {
            System.out.println("NO se serializó a binario");
        }
//DESERIALIZAR BINARIO
        List<Book> listaLibrosBinario = library.readBinary("libros.dat");
// MOSTRAR LIBROS UTILIZANDO MÉTODO EXTERNO
        ModeloSP.listBooks(listaLibrosBinario);
// SERIALIZAR JSON
        if (library.writeJSON("libros.json", library.getAll())) {
            System.out.println("Se serializó en JSON");
        } else {
            System.out.println("NO se serializó a JSON");
        }
// DESERIALIZAR JSON
        List<Book> listaLibrosJSON = library.readJSON("libros.json");
// MOSTRAR LIBROS UTILIZANDO MÉTODO EXTERNO
        ModeloSP.listBooks(listaLibrosJSON);
    }

    private static void listBooks(List<? extends Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
