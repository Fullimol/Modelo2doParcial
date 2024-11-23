package modelo2doparcial;

//SIEMPRE hacerlo para permitir serializarlo a BYTES. Permite que los objetos de la clase Book sean convertidos a una secuencia de bytes.
import java.io.Serializable; // (NO HACE FALTE PARA SERIALIZAR EN JSON).

public class Book implements Comparable<Book>, Serializable {

    private static final long serialVersionUID = 1L; // Identificador de versión para la serialización

    //atributos
    private String titulo;
    private String autor;
    private int anio;

    //constructor
    public Book(String titulo, String autor, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public int compareTo(Book other) {
        return this.titulo.compareTo(other.titulo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LIBRO: {")
                .append("Titulo: '")
                .append(titulo)
                .append('\'')
                .append(", Autor: '")
                .append(autor).append('\'')
                .append(", Anio: ")
                .append(anio)
                .append('}');
        return sb.toString();
    }
}
