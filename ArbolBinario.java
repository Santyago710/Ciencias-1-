package arbol;

public class ArbolBinario {
    NodoArbol raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // Método para insertar nodo en el árbol
    public void agregar(int val, String nom) {
        NodoArbol nuevo = new NodoArbol(val, nom);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            NodoArbol auxiliar = raiz;
            NodoArbol padre;
            while (true) {
                padre = auxiliar;
                if (val < auxiliar.valor) {
                    auxiliar = auxiliar.nodoIzq;
                    if (auxiliar == null) {
                        padre.nodoIzq = nuevo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.nodoDer;
                    if (auxiliar == null) {
                        padre.nodoDer = nuevo;
                        return;
                    }
                }
            }
        }
    }
        // Método para buscar un nodo
    public NodoArbol buscarNodo(int valor) {
        NodoArbol actual = raiz;
        while (actual != null && actual.valor != valor) {
            if (valor < actual.valor) {
                actual = actual.nodoIzq;
            } else {
                actual = actual.nodoDer;
            }
        }
        return actual;
    }

     // Método para rotar hacia la derecha
    public void rotarDerecha(int valorNodo) {
        NodoArbol nodo = buscarNodo(valorNodo);
        
        if (nodo == null || nodo.nodoIzq == null) {
            System.out.println("Rotation not possible.");
            return;
        }
        
        NodoArbol leftChild = nodo.nodoIzq;
        
        // Realizar la rotación
        nodo.nodoIzq = leftChild.nodoDer;
        leftChild.nodoDer = nodo;
        
        // Actualizar la raíz si es necesario
        if (nodo == raiz) {
            raiz = leftChild;
        }
    }

    // Método para rotar hacia la izquierda
    public void rotarIzquierda(int valorNodo) {
        NodoArbol nodo = buscarNodo(valorNodo);
        
        if (nodo == null || nodo.nodoDer == null) {
            System.out.println("Rotation not possible.");
            return;
        }
        
        NodoArbol rightChild = nodo.nodoDer;
        
        // Realizar la rotación
        nodo.nodoDer = rightChild.nodoIzq;
        rightChild.nodoIzq = nodo;
        
        // Actualizar la raíz si es necesario
        if (nodo == raiz) {
            raiz = rightChild;
        }
    }

    public boolean estaVacio() {
        return raiz == null;
    }
    public NodoArbol getRaiz() {
        return raiz;
    }
    public void imprimirArbol() {
        imprimirArbolConRamas(raiz, "", true);
    }
    
    // Método recursivo para imprimir el árbol con ramas
    private void imprimirArbolConRamas(NodoArbol nodo, String prefijo, boolean esUltimo) {
        if (nodo != null) {
            System.out.println(prefijo + (esUltimo ? "└── " : "├── ") + nodo);
    
            // Prefijo para los nodos hijos
            String nuevoPrefijo = prefijo + (esUltimo ? "    " : "│   ");
    
            imprimirArbolConRamas(nodo.nodoIzq, nuevoPrefijo, false);
            imprimirArbolConRamas(nodo.nodoDer, nuevoPrefijo, true);
        }
    }
    
    
}