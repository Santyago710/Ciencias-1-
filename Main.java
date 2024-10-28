package arbol;
public class Main {

	public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.agregar(10, "Raíz");
        arbol.agregar(5, "Izquierdo");
        arbol.agregar(15, "Derecho");
        //Verificar que tipo de arbol es (propio,impropio,Completo)
        VerificadorArbol verificador = new VerificadorArbol(arbol);
        System.out.println(verificador.tipoDeArbol());
        //Imprimir arbol
        System.out.println("Árbol antes de la rotación:");
        arbol.imprimirArbol();

        // Rotar a la derecha alrededor del nodo 10
        arbol.rotarDerecha(10);
        System.out.println("\nÁrbol después de rotar a la derecha en 10:");
        arbol.imprimirArbol();

        // Rotar a la izquierda alrededor del nuevo nodo raíz
        arbol.rotarIzquierda(arbol.getRaiz().valor);
        System.out.println("\nÁrbol después de rotar a la izquierda en el nuevo nodo raíz:");
        arbol.imprimirArbol();
    }

    
}

