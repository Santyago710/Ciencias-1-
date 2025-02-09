package arbolavl;


/**
 *
 * @author nicol
 */


public class Nodo <T extends Comparable<T>>{
    
     private  T data;
     private int altura = 1;
     private Nodo<T> hijoIq;
     private Nodo<T> hijoDer;

    public Nodo(T data) {
        this.data = data;
    }

      
     
     
     //Bloque de getters
    public T getData() {
        return data;
    }

    public int getAltura() {
        return altura;
    }

    public Nodo<T> getHijoIq() {
        return hijoIq;
    }

    public Nodo<T> getHijoDer() {
        return hijoDer;
    }

    
    //Bloque de Setters
    public void setData(T data) {
        this.data = data;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setHijoIq(Nodo<T> hijoIq) {
        this.hijoIq = hijoIq;
    }

    public void setHijoDer(Nodo<T> hijoDer) {
        this.hijoDer = hijoDer;
    }
    
    
    
}
