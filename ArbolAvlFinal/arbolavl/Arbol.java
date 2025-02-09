package arbolavl;

public interface Arbol <T extends Comparable<T>> {
    
    Arbol<T> insertar(T data);
    
    void borrar(T data);
    
    
    //Pendiente de implementar
    void recorrer();
    
    T getMax();
    
    T getMin();
    
    boolean isEmpty();
    
}