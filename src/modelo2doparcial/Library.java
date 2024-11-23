package modelo2doparcial;

import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.Writer;
import java.io.FileWriter;
import java.io.Reader;

import java.io.OutputStream;
import java.io.InputStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Library implements Iterable<Book>, Serializer<Book> {

    Gson gson = new Gson(); // Crear el objeto Gson, solo para llamar a .toJson y .fromJson
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

    public List<Book> getAll() {
        return libros;
    }

    // Implementación del método iterator() de la interfaz Iterable DEBE IR SIEMPRE
    @Override
    public Iterator<Book> iterator() {
        return libros.iterator();
    }

    //          **** SERIALIZACION ****
    @Override
    public void serializeToBinary(Book libro, OutputStream out) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(out)) {
            oos.writeObject(libro);
        }
    }

    @Override
    public Book deserializeFromBinary(InputStream in) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(in)) {
            return (Book) ois.readObject();
        }
    }

    @Override
    public String serializeToJson(Book libro) {
        return gson.toJson(libro);
    }

    @Override
    public Book deserializeFromJson(String json) {
        return gson.fromJson(json, Book.class);
    }

    // Método para guardar la biblioteca en un archivo binario 
    public boolean writeBinary(String fileName, List<Book> books) {
        try (OutputStream out = new FileOutputStream(fileName)) {
            for (Book book : books) {
                serializeToBinary(book, out);
            }
            System.out.println("Biblioteca guardada en formato binario.");
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return false;
        }
    }

    // Método para leer la biblioteca desde un archivo binario 
    public List<Book> readBinary(String fileName) {
        List<Book> libros = new ArrayList<>();
        try (InputStream in = new FileInputStream(fileName)) {
            while (true) {
                try {
                    Book libro = deserializeFromBinary(in);
                    libros.add(libro);
                } catch (IOException | ClassNotFoundException e) {
                    break;
                }
            }
            System.out.println("Biblioteca leída desde formato binario.");
            this.libros = libros;
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return libros;
    }

    // Método para guardar la biblioteca en un archivo JSON 
    public boolean writeJSON(String fileName, List<Book> libros) {
        try (Writer writer = new FileWriter(fileName)) {
            for (Book libro : libros) {
                String json = serializeToJson(libro);
                writer.write(json);
                writer.write("\n");
            }
            System.out.println("Biblioteca guardada en formato JSON.");
            return true;
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
            return false;
        }
    }

    // Método para leer la biblioteca desde un archivo JSON
    public List<Book> readJSON(String fileName) {
        List<Book> libros = new ArrayList<>();
        try (Reader archivo = new FileReader(fileName)) {
            BufferedReader bufferedReader = new BufferedReader(archivo);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Book libro = deserializeFromJson(line);
                libros.add(libro);
            }
            System.out.println("Biblioteca leída desde formato JSON.");
            this.libros = libros;
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return libros;
    }
}
