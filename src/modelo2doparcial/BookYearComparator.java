package modelo2doparcial;

import java.util.Comparator;

public class BookYearComparator implements Comparator<Book> {
//Es una clase separada que implementa la interfaz Comparator<Book> y define cómo comparar dos instancias de Book según el anio.
    @Override
    public int compare(Book libro1, Book libro2) {
        return Integer.compare(libro1.getAnio(), libro2.getAnio());
    }
}
