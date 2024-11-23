package modelo2doparcial;

import java.util.Comparator;

public class BookAuthorComparator implements Comparator<Book> {
//Es una clase separada que implementa la interfaz Comparator<Book> y define cómo comparar dos instancias de Book según el autor.
    @Override
    public int compare(Book libro1, Book libro2) {
        return libro1.getAutor().compareTo(libro2.getAutor());
    }
}
