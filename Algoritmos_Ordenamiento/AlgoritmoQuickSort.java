/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmoquicksort;

import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class AlgoritmoQuickSort {
static int ciclos=0; 
static int pasos=0;
    public static void main(String[] args) {
        int rango,arreglo[],elementos;
        
        elementos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de elementos el arreglo"));
        arreglo=new int[elementos];
        rango=Integer.parseInt(JOptionPane.showInputDialog("El arreglo se llenará de forma aleatoria. ingrese el número máximo hasta el cual desea obtener los números aleatorios.\nEl número debe ser mayor a 1"));
        for (int i = 0; i < elementos; i++) {
            arreglo[i]=(int)(Math.random()*rango);
        }
        System.out.println("El arreglo en forma aleatoria es:");
        for(int i=0;i<elementos;i++){
            System.out.print(arreglo[i]+" ");
        }
        quicksort(arreglo,0,(arreglo.length-1));
        
        System.out.println("\nEl arreglo ordenado es:");
        
        imprimir(arreglo);
        
        System.out.println("\nLa cantidad de pasos es: "+pasos);
        System.out.println("La cantidad de ciclos es: "+ciclos);
        
    }
    
    public static void quicksort(int []arreglo, int izq, int der){
        int pivote=arreglo[izq];
        int i=izq;
        int j=der;
        int aux;
        while(i<j){
            pasos++;
            while(arreglo[i]<=pivote && i<j){
                i++;
                pasos+=3;
                ciclos++;
            }   
            while(arreglo[j]>pivote){
                j--;
                pasos+=2;
                ciclos++;
            }
            if(i<j){
                aux=arreglo[i];
                arreglo[i]=arreglo[j];
                arreglo[j]=aux;
                pasos+=4;
            }
        }
        pasos++;
        
        arreglo[izq]=arreglo[j];
        arreglo[j]=pivote;
        pasos+=2;
        
        if(izq<(j-1)){
            quicksort(arreglo,izq,j-1);
        }
        pasos++;    
        
        if((j+1)<der){
            quicksort(arreglo,j+1,der);
        }
        pasos++; 
            
    }
    
    public static void imprimir(int []arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]+" ");
        }
    }

}
