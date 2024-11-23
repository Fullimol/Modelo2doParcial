package modelo2doparcial;

import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Library implements Iterable<Book> {

    //atributos
    private List<Book> libros;

    //constructor
    public Library() {
        this.libros = new ArrayList<>();
    }

    //metodos
    public void add(Book book) {
        libros.add(book);
    }

    public void remove(Book book) {
        libros.remove(book);
    }

    public void sortBooks() { //ordeno según su orden natural
        Collections.sort(libros);
    }

    // Método para ordenar los libros usando un comparador 
    public void sortBooks(Comparator<Book> comparator) {
        Collections.sort(libros, comparator);
    }

    // Implementación del método iterator() de la interfaz Iterable DEBE IR SIEMPRE
    @Override
    public Iterator<Book> iterator() {
        return libros.iterator();
    }

}
