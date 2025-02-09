/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package arbol;

public class Main {
    public static void main(String[] args) {
        // Crear un nuevo árbol binario
        ArbolBinario arbol = new ArbolBinario();

        // Agregar nodos al árbol
        arbol.agregar(50, "Nodo1");
        arbol.agregar(30, "Nodo2");
        arbol.agregar(70, "Nodo3");
        arbol.agregar(20, "Nodo4");
        arbol.agregar(40, "Nodo5");
        arbol.agregar(60, "Nodo6");
        arbol.agregar(80, "Nodo7");
        
        System.out.println("El árbol en notación inOrden es: ");
        arbol.inOrden(arbol.raiz);
        System.out.println();

        // Mostrar la altura y el grado del árbol
        System.out.println("Altura del árbol: " + arbol.getAltura());
        System.out.println("Grado máximo del árbol: " + arbol.getGrado());

        // Buscar un nodo en el árbol
        System.out.println("Se va a buscar el nodo de valor 40: ");
        NodoArbol nodoBuscado = arbol.buscarNodo(40);
        if (nodoBuscado != null) {
            System.out.println("\tNodo encontrado: " + nodoBuscado);
        } else {
            System.out.println("\tNodo no encontrado.");
        }
        System.out.println("Se va a eliminar el nodo de valor 70: ");
        // Eliminar un nodo del árbol
        boolean nodoEliminado = arbol.eliminar(70);
        if (nodoEliminado) {
            System.out.println("\tNodo con valor 70 eliminado.");
        } else {
            System.out.println("\tNo se encontró el nodo con valor 70 para eliminar.");
        }

        // Mostrar la altura y el grado del árbol después de la eliminación
        System.out.println("Altura del árbol después de eliminar un nodo: " + arbol.getAltura());
        System.out.println("Grado máximo del árbol después de eliminar un nodo: " + arbol.getGrado());

        // Crear un verificador de árbol para realizar verificaciones
        VerificadorArbol verificador = new VerificadorArbol(arbol);

        // Verificar si el árbol es lleno
        System.out.println("¿El árbol es lleno? " + verificador.esLleno(arbol.getRaiz()));

        // Verificar si el árbol es completo
        System.out.println("¿El árbol es completo? " + verificador.esCompleto());

        // Verificar si el árbol es perfecto
        System.out.println("¿El árbol es perfecto? " + verificador.esPerfecto());

        // Mostrar el tipo de árbol
        System.out.println("Tipo de árbol: " + verificador.tipoDeArbol());
    }
}


