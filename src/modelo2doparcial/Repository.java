
package modelo2doparcial;


import java.util.ArrayList;

public interface Repository<T> {
    
    void add(T item);
    
    void remove(T item);
    
    ArrayList<T> getAll();
}

