/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbol;

public class ArbolBinario {
	NodoArbol raiz;
    int altura; // Atributo para almacenar la altura del árbol
    int grado;  // Atributo para almacenar el grado máximo del árbol

    public ArbolBinario() {
        raiz = null;
        altura = 0;
        grado = 0;
    }
    public NodoArbol getRaiz() {
        return raiz;
    }
    // Método para insertar nodo en el árbol y actualizar altura, grado y nivel
    public void agregar(int val, String nom) {
        if (raiz == null) {
            // Si la raíz es null, creamos el primer nodo en nivel 0
            raiz = new NodoArbol(val, nom, 0);
        } else {
            NodoArbol auxiliar = raiz;
            NodoArbol padre;
            int nivel = 0; // Nivel de la raíz es 0
            while (true) {
                padre = auxiliar;
                nivel++; // Aumentar el nivel a medida que bajamos en el árbol
                if (val < auxiliar.valor) {
                    auxiliar = auxiliar.nodoIzq;
                    if (auxiliar == null) {
                        // Crear un nuevo nodo con el nivel correspondiente
                        padre.nodoIzq = new NodoArbol(val, nom, nivel);
                        break;
                    }
                } else {
                    auxiliar = auxiliar.nodoDer;
                    if (auxiliar == null) {
                        // Crear un nuevo nodo con el nivel correspondiente
                        padre.nodoDer = new NodoArbol(val, nom, nivel);
                        break;
                    }
                }
            }
        }
        // Actualizar la altura y el grado después de insertar el nodo
        actualizarAtributos();
    }
    //Método para imprimir el árbol en notación inOrden
    public void inOrden(NodoArbol root) {
    	if(root!=null) {
    		inOrden(root.nodoIzq);
    		System.out.print(root.valor+" ");
    		inOrden(root.nodoDer);
    	}
    }
    
    // Método para saber si el árbol está vacío
    public boolean estaVacio() {
        return raiz == null;
    }

    // Método para buscar un nodo en el árbol
    public NodoArbol buscarNodo(int valorBuscar) {
        NodoArbol aux = raiz;
        while (aux != null && aux.valor != valorBuscar) {
            if (valorBuscar < aux.valor) {
                aux = aux.nodoIzq;
            } else {
                aux = aux.nodoDer;
            }
        }
        return aux; // Retorna el nodo si se encontró o null si no
    }

    // Método para calcular la altura de un nodo
    private int calcularAltura(NodoArbol nodo) {
        if (nodo == null) {
            return -1; // Retorna -1 porque una hoja tiene altura 0
        }
        int alturaIzquierda = calcularAltura(nodo.nodoIzq);
        int alturaDerecha = calcularAltura(nodo.nodoDer);
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    // Método para calcular el grado de un nodo
    private int calcularGrado(NodoArbol nodo) {
        if (nodo == null) {
            return 0; // Nodo no encontrado
        }
        int grado = 0;
        if (nodo.nodoIzq != null) grado++;
        if (nodo.nodoDer != null) grado++;
        return grado;
    }

    // Método para calcular el grado máximo del árbol
    private int calcularGradoMaximo(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }
        int gradoNodo = calcularGrado(nodo);
        int gradoIzquierda = calcularGradoMaximo(nodo.nodoIzq);
        int gradoDerecha = calcularGradoMaximo(nodo.nodoDer);
        return Math.max(gradoNodo, Math.max(gradoIzquierda, gradoDerecha));
    }

    // Método para actualizar la altura y el grado del árbol
    private void actualizarAtributos() {
        this.altura = calcularAltura(raiz);
        this.grado = calcularGradoMaximo(raiz);
    }

    // Método para obtener la altura del árbol
    public int getAltura() {
        return altura;
    }

    // Método para obtener el grado máximo del árbol
    public int getGrado() {
        return grado;
    }
	//Método para eliminar un nodo de un árbol
	public boolean eliminar(int d) {
		NodoArbol auxiliar=raiz;
		NodoArbol padre=raiz;
		boolean esHijoIzq=true;
		while(auxiliar.valor!=d) {
			padre=auxiliar;
			if(d<auxiliar.valor) {
				esHijoIzq=true;
				auxiliar=auxiliar.nodoIzq;
			}else {
				esHijoIzq=false;
				auxiliar=auxiliar.nodoDer;
			}
			if(auxiliar==null) {
				return false;
			}
		}
		if(auxiliar.nodoIzq==null & auxiliar.nodoDer==null) {
			if(auxiliar==raiz) {
				raiz=null;
			}else if(esHijoIzq){
				padre.nodoIzq=null;
			}else {
				padre.nodoDer=null;
			}
		}else if(auxiliar.nodoDer==null){
			if(auxiliar==raiz) {
				raiz=auxiliar.nodoIzq;
			}else if(esHijoIzq){
				padre.nodoIzq=auxiliar.nodoIzq;
			}else {
				padre.nodoDer=auxiliar.nodoIzq;
			}
		}else if(auxiliar.nodoIzq==null) {
			if(auxiliar==raiz) {
				raiz=auxiliar.nodoDer;
			}else if(esHijoIzq){
				padre.nodoIzq=auxiliar.nodoDer;
			}else {
				padre.nodoDer=auxiliar.nodoIzq;
			}
		}else {
			NodoArbol reemplazo=obtenerNodoReemplazo(auxiliar);
			if(auxiliar==raiz) {
				raiz=reemplazo;
			}else if(esHijoIzq) {
				padre.nodoIzq=reemplazo;
			}else {
				padre.nodoDer=reemplazo;
			}
			reemplazo.nodoIzq=auxiliar.nodoIzq;
		}
		return true;
	}
	//método encargado de devolver el nodo reemplazo
	public NodoArbol obtenerNodoReemplazo(NodoArbol nodoReemp) {
		NodoArbol reemplazarPadre=nodoReemp;
		NodoArbol reemplazo=nodoReemp;
		NodoArbol auxiliar=nodoReemp.nodoDer;
		while(auxiliar!=null) {
			reemplazarPadre=reemplazo;
			reemplazo=auxiliar;
			auxiliar=auxiliar.nodoIzq;
		}
		if(reemplazo!=nodoReemp.nodoDer) {
			reemplazarPadre.nodoIzq=reemplazo.nodoDer;
			reemplazo.nodoDer=nodoReemp.nodoDer;
		}
		return reemplazo;
	}
	
}