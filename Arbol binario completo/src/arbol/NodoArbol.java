package arbol;

public class NodoArbol {
	int valor;
	String nombre;
	NodoArbol nodoIzq;
	NodoArbol nodoDer;
	int nivel;
	//constructor
        
	public NodoArbol(int val, String nom, int niv) {
		this.valor=val;
		this.nombre=nom;
		this.nodoDer=null;
		this.nodoIzq=null;
		this.nivel=niv;
	}
	//método para imprimir	
	public String toString() {
		return nombre + " y su valor es " + valor + " en el nivel "+nivel;
	}
}

