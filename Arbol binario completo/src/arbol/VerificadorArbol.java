/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol;



import java.util.LinkedList;
import java.util.Queue;

public class VerificadorArbol {
	private ArbolBinario arbol;

    public VerificadorArbol(ArbolBinario arbol) {
        this.arbol = arbol;
    }

    // Método para verificar si el árbol es lleno
    public boolean esLleno(NodoArbol nodo) {
        if (nodo == null) {
            return true;
        }
        if ((nodo.nodoIzq == null && nodo.nodoDer != null) || (nodo.nodoIzq != null && nodo.nodoDer == null)) {
            return false;
        }
        return esLleno(nodo.nodoIzq) && esLleno(nodo.nodoDer);
    }

    // Método para verificar si el árbol es completo
    public boolean esCompleto() {
        NodoArbol raiz = arbol.getRaiz();
        if (raiz == null) return true;
        
        Queue<NodoArbol> cola = new LinkedList<>();
        cola.add(raiz);
        boolean encontradoNodoIncompleto = false;

        while (!cola.isEmpty()) {
            NodoArbol actual = cola.poll();

            if (actual.nodoIzq != null) {
                if (encontradoNodoIncompleto) return false;
                cola.add(actual.nodoIzq);
            } else {
                encontradoNodoIncompleto = true;
            }

            if (actual.nodoDer != null) {
                if (encontradoNodoIncompleto) return false;
                cola.add(actual.nodoDer);
            } else {
                encontradoNodoIncompleto = true;
            }
        }
        return true;
    }

    // Método para verificar si el árbol es perfecto
    public boolean esPerfecto() {
        int profundidad = calcularProfundidad(arbol.getRaiz());
        return esPerfectoRecursivo(arbol.getRaiz(), profundidad, 0);
    }

    private int calcularProfundidad(NodoArbol nodo) {
        int profundidad = 0;
        while (nodo != null) {
            profundidad++;
            nodo = nodo.nodoIzq;
        }
        return profundidad;
    }

    private boolean esPerfectoRecursivo(NodoArbol nodo, int profundidad, int nivel) {
        if (nodo == null) {
            return true;
        }
        if (nodo.nodoIzq == null && nodo.nodoDer == null) {
            return profundidad == nivel + 1;
        }
        if (nodo.nodoIzq == null || nodo.nodoDer == null) {
            return false;
        }
        return esPerfectoRecursivo(nodo.nodoIzq, profundidad, nivel + 1) && esPerfectoRecursivo(nodo.nodoDer, profundidad, nivel + 1);
    }

    // Método para determinar el tipo de árbol
    public String tipoDeArbol() {
        if (esPerfecto()) {
            return "Árbol perfecto";
        } else if (esCompleto()) {
            return "Árbol completo";
        } else if (esLleno(arbol.getRaiz())) {
            return "Árbol lleno";
        } else {
            return "Ninguno de los anteriores";
        }
    }
}

