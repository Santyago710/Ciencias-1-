package arbol;

public class NodoArbol {
	int valor;
	String nombre;
	NodoArbol nodoIzq;
	NodoArbol nodoDer;
	//constructor
	public NodoArbol(int val, String nom) {
		this.valor=val;
		this.nombre=nom;
		this.nodoDer=null;
		this.nodoIzq=null;
	}
	//método para imprimir	
	public String toString() {
		return nombre + " y su valor es " + valor;
	}
}
