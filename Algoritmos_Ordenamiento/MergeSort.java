import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    
    static int cycleCounter = 0;
    static int stepCounter = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el tamaño del array (100, 1000, 10000): ");
        int size = scanner.nextInt();
        
        
        int[] array = generateRandomArray(size);
       
        System.out.println("Arreglo desordenado:");
        printArray(array);
       
        // Resetea los contadores antes de ordenar
        cycleCounter = 0;
        
        mergeSort(array, 0, array.length - 1);
        
        System.out.println("\nArreglo ordenado:");
        printArray(array);
        
        
        System.out.println("\nNúmero de ciclos: " + cycleCounter);
        System.out.println("Número de pasos: " + stepCounter);
        
    }

    // Función para generar un array de números aleatorios
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        
        int[] array = new int[size];
        
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);  // Genera números aleatorios entre 0 y 9999
           
        }
        return array;
    }

    // Implementación del algoritmo Merge Sort
    public static void mergeSort(int[] array, int left, int right) {
        
        if (left < right) {
            int middle = (left + right) / 2;
            stepCounter++; // Contando el cálculo del medio
            
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
            stepCounter++; // Contando la llamada a merge
        }
        stepCounter++; // Contando la evaluación de la condición if
    }

    // Función para mezclar y ordenar dos subarreglos
    public static void merge(int[] array, int left, int middle, int right) {
        
        
        int n1 = middle - left + 1;
        int n2 = right - middle;
        

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        stepCounter++; // Contando la creación de los subarreglos
        
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
            stepCounter += 3; // Contando cada paso del bucle
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
            stepCounter += 3; // Contando cada paso del bucle
        }

        int i = 0, j = 0;
        int k = left;
        stepCounter++; // Contando la inicialización de los índices
        
        while (i < n1 && j < n2) {
            stepCounter += 2; // Contando la evaluación de la condición del bucle
            cycleCounter++; // Incrementa el contador de ciclos
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
                stepCounter += 3; // Contando la comparación 
            } else {
                array[k] = rightArray[j];
                j++;
                stepCounter += 3; // Contando la comparación y la asignación
            }
            k++;
            stepCounter++; // Contando la actualización del índice k
        }

        while (i < n1) {
            stepCounter++; // Contando la evaluación de la condición del bucle
            cycleCounter++; // Incrementa el contador de ciclos
            array[k] = leftArray[i];
            i++;
            k++;
            stepCounter += 3; // Contando las operaciones dentro del bucle
        }

        while (j < n2) {
            stepCounter++; // Contando la evaluación de la condición del bucle
            cycleCounter++; // Incrementa el contador de ciclos
            array[k] = rightArray[j];
            j++;
            k++;
            stepCounter += 3; // Contando las operaciones dentro del bucle
        }
    }

    // Función para imprimir el array
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
           
        }
        System.out.println();
       
    }
}
