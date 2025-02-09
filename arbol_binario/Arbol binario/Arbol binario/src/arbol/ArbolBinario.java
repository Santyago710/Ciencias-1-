package arbol;

public class ArbolBinario {
	NodoArbol raiz;
	
	public ArbolBinario() {
		raiz = null;
	}
	//método para insertar nodo en el árbol
	public void agregar(int val, String nom) {
		//se crea un nuevo nodo
		NodoArbol nuevo = new NodoArbol(val, nom);
		//si no hay raíz, la raíz ahora será el nuevo nodo
		if(raiz == null) {
			raiz=nuevo;
		}else{
			//el nodo auxiliar apunta a la raíz
			NodoArbol auxiliar=raiz;
			//se crea el nodo padre
			NodoArbol padre;
			//se inicia un ciclo
			while(true) {
				//el padre apunta al auxiliar
				padre=auxiliar;
				//se verifica si el valor a ingresar es menor al valor de la raíz
				if(val<auxiliar.valor) {
					//al auxiliar le asigna el valor del nodo izquierdo 
					auxiliar=auxiliar.nodoIzq;
					//revisa si ese nodo está vacío
					if(auxiliar==null) {
						//Si sí lo está, al nodo padre se le agrega en el nodo izquierdo el nuevo nodo creado
						padre.nodoIzq=nuevo;
						return;
					}
				//como el valor es mayor o igual al valor del nodo auxiliar, revisa este caso
				}else {
					//al auxiliar le asigna el valor del nodo derecho
					auxiliar=auxiliar.nodoDer;
					//revisa si ese nodo está vacío
					if(auxiliar==null) {
						//Si sí lo está, al nodo padre se le agrega en el nodo derecho el nuevo nodo creado
						padre.nodoDer=nuevo;
						return;
					}
				}
			}
		}
	}
	//saber si el árbol está vacío
	public boolean estaVacio() {
		if(raiz==null) {
			return true;
		}else {
			return false;
		}
	}
	//Método para buscar nodo
	public NodoArbol buscarNodo(int valorBuscar) {
		//nodo auxiliar igual al valor de la raíz
		NodoArbol aux=raiz;
		//mientras que el valor del nodo sobre el que está no sea igual al nodo que está buscando
		while(aux.valor!=valorBuscar) {
			//Si el valor a buscar es menor al del nodo actual, ingresa al hijo izquierdo
			if(valorBuscar < aux.valor) {
				//EL auxiliar ahora es el nodo actual y se reinicia el ciclo
				aux=aux.nodoIzq;
			//Si el valor a buscar es mayor al del nodo actual, ingresa al hijo derecho
			}else {
				//El auxiliar ahora es el nodo actual y se reinicia el ciclo
				aux=aux.nodoDer;
			}
			//si el auxiliar es igual a un valor nulo, quiere decir que nunca encontró el  nodo
			if(aux==null) {
				return null;
			}
		}
		//si el valor del nodo auxiliar es igual al del nodo a buscar, retorna inmediatamente dicho nodo
		return aux;
	}
	
}
