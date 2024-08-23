/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package heapsort;

import javax.swing.JOptionPane;

/**
 *
 * @author nicol
 */
public class HeapSort {
int pasos = 0;
int ciclos = 0;
    
    public void organizar(int[] arreglo ){
        
        int longitud = arreglo.length;
        
        //crea el monticulo
        for (int i = longitud / 2 - 1; i >= 0; i-- ){
            pasos +=3;
            amontonar(arreglo, longitud, i); 
        }
        
        // Extraer uno por uno los elementos del monticulo
        for(int i = longitud - 1; i>= 0; i--){
            //Mover la raiz actual al final
            int auxiliar = arreglo[0];
            arreglo[0] = arreglo[i];
            arreglo[i] = auxiliar;
            
            pasos += 6;
            
            
            //Llama amontonar para el monton reducido
            amontonar(arreglo, i, 0);
        }
    }
    
    //Amontona un arbol de raiz i el cual es un indice de arreglo
    //longitud es la longitud del arreglo
    void amontonar(int[] arreglo, int longitud, int i){
        int mayor = i; // hace que el numero mayor sea la raiz
        int izquierda = 2 * i + 1;
        int derecha =  2 * i + 2;
        
        //Verifica si el hijo que esta a la izquierda es mayor a la raiz
        if(izquierda < longitud && arreglo[izquierda] > arreglo[mayor]){
         mayor = izquierda;
         pasos+=2;
         ciclos += 1;
 
        }
        
        //Verifica si el hijo de la derecha es mas grande que el numero mayor actual
        if(derecha < longitud  && arreglo[derecha] > arreglo[mayor]){
            mayor = derecha;
            pasos += 2;
            ciclos += 1;
        }
           
        //Si el mayor no es la raiz
        if(mayor != i){
            int cambiar = arreglo[i];
            arreglo[i] = arreglo[mayor];
            arreglo[mayor] = cambiar;
            pasos += 4;
            ciclos +=1;
            System.out.println("El numero de pasos es de "+ pasos );
            //Recursion 
            amontonar(arreglo, longitud, mayor);
            
            
        }
        
    }
    
    static void mostrarArreglo(int arreglo[]){
        int longitud = arreglo.length;
        for (int i = 0; i < longitud; i++){
            System.out.print("\n" + arreglo[i]+ " ");
            
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        int rango, arreglo[], longitud;
        
        longitud = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la longitud del arreglo"));
        
        arreglo = new int[longitud];
        rango = Integer.parseInt(JOptionPane.showInputDialog("El arreglo se llenará de forma aleatoria. ingrese el número máximo hasta el cual desea obtener los números aleatorios.\nEl número debe ser mayor a 1"));
        for (int i = 0; i < longitud; i++) {
            arreglo[i]=(int)(Math.random()*rango);
        }
        
        HeapSort hs = new HeapSort();
        hs.organizar(arreglo);
        
        System.out.println("El arreglo ordenado es");
        mostrarArreglo(arreglo);
    }
    
}
