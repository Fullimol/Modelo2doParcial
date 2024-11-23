package modelo2doparcial;

public class Book implements Comparable<Book> {

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
