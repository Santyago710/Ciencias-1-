import java.util.Random;
import java.util.Scanner;

public class algoritmos{
static int stepQuick;
static int cyclesQuick;
static int stepMerge;
static int cyclesMerge;
static int stepHeap;
static int cyclesHeap;
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Ingrese el tamaño del array(100, 1000, 10000)");
        int size=scanner.nextInt();
        int[] array = generateRandomArray(size);
        int[] arrayQuick = array;
        int[] arrayMerge = array;
        int[] arrayHeap = array;
        System.out.println("Arreglo desordenado:");
        printArray(array);
        System.out.println("Arreglo ordenado mediante quick sort");
        quicksort(arrayQuick, 0, size-1);
        printArray(arrayQuick);
        System.out.println("La cantidad de pasos es de: "+stepQuick);
        System.out.println("La cantidad de ciclos es: "+cyclesQuick);
        System.out.println("--/--/--/--/--/--/--/--/--/--/--/--/--/--/---/--/--/--/--/--/--/--/--/--/--/--/--/");
        System.out.println("Arreglo ordenado mediante heap sort");
        organizar(arrayHeap);
        printArray(arrayHeap);
        System.out.println("La cantidad de pasos es de: "+stepHeap);
        System.out.println("La cantidad de ciclos es: "+cyclesHeap);
        System.out.println("--/--/--/--/--/--/--/--/--/--/--/--/--/--/---/--/--/--/--/--/--/--/--/--/--/--/--/");
        System.out.println("Arreglo ordenado mediante merge sort");
        mergeSort(arrayMerge,0,arrayMerge.length-1);
        printArray(arrayMerge);
        System.out.println("La cantidad de pasos es de: "+stepMerge);
        System.out.println("La cantidad de ciclos es: "+cyclesMerge);
    }


    public static void quicksort(int []array, int left, int right){
        int pivot=array[left];
        int i=left;
        int j=right;
        int aux;
        while(i<j){
            stepQuick++;
            while(array[i]<=pivot && i<j){
                i++;
                stepQuick+=3;
                cyclesQuick++;
            }   
            while(array[j]>pivot){
                j--;
                stepQuick+=2;
                cyclesQuick++;
            }
            if(i<j){
                aux=array[i];
                array[i]=array[j];
                array[j]=aux;
                stepQuick+=4;
            }
        }
        stepQuick++;
        
        array[left]=array[j];
        array[j]=pivot;
        stepQuick+=2;
        
        if(left<(j-1)){
            quicksort(array,left,j-1);
        }
        stepQuick++;    
        
        if((j+1)<right){
            quicksort(array,j+1,right);
        }
        stepQuick++; 
            
    }


    public static void merge(int[] array, int left, int middle, int right) {
        
        
        int n1 = middle - left + 1;
        int n2 = right - middle;
        

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        stepMerge++; // Contando la creación de los subarreglos
        
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
            stepMerge += 3; // Contando cada paso del bucle
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
            stepMerge += 3; // Contando cada paso del bucle
        }

        int i = 0, j = 0;
        int k = left;
        stepMerge++; // Contando la inicialización de los índices
        
        while (i < n1 && j < n2) {
            stepMerge += 2; // Contando la evaluación de la condición del bucle
            cyclesMerge++; // Incrementa el contador de ciclos
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
                stepMerge += 3; // Contando la comparación 
            } else {
                array[k] = rightArray[j];
                j++;
                stepMerge += 3; // Contando la comparación y la asignación
            }
            k++;
            stepMerge++; // Contando la actualización del índice k
        }

        while (i < n1) {
            stepMerge++; // Contando la evaluación de la condición del bucle
            cyclesMerge++; // Incrementa el contador de ciclos
            array[k] = leftArray[i];
            i++;
            k++;
            stepMerge += 3; // Contando las operaciones dentro del bucle
        }

        while (j < n2) {
            stepMerge++; // Contando la evaluación de la condición del bucle
            cyclesMerge++; // Incrementa el contador de ciclos
            array[k] = rightArray[j];
            j++;
            k++;
            stepMerge += 3; // Contando las operaciones dentro del bucle
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        
        if (left < right) {
            int middle = (left + right) / 2;
            stepMerge++; // Contando el cálculo del medio
            
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
            stepMerge++; // Contando la llamada a merge
        }
        stepMerge++; // Contando la evaluación de la condición if
    }
    

    public static void organizar(int[] array ){
        
        int longitud = array.length;
        
        //crea el monticulo
        for (int i = longitud / 2 - 1; i >= 0; i-- ){
            stepHeap +=3;
           
            amontonar(array, longitud, i); 
        }
        
        // Extraer uno por uno los elementos del monticulo
        for(int i = longitud - 1; i>= 0; i--){
            //Mover la raiz actual al final
            int auxiliar = array[0];
            array[0] = array[i];
            array[i] = auxiliar;
            
            stepHeap += 6;
            
            
            //Llama amontonar para el monton reducido
            amontonar(array, i, 0);
        }
    }

    public static void amontonar(int[] array, int size, int i){
        int mayor = i; // hace que el numero mayor sea la raiz
        int left = 2 * i + 1;
        int right =  2 * i + 2;
        
        //Verifica si el hijo que esta a la izquierda es mayor a la raiz
        if(left < size && array[left] > array[mayor]){
         mayor = left;
         stepHeap+=2;
         cyclesHeap++;
 
        }
        
        //Verifica si el hijo de la derecha es mas grande que el numero mayor actual
        if(right < size  && array[right] > array[mayor]){
            mayor = right;
            stepHeap += 2;
            cyclesHeap ++;
        }
           
        //Si el mayor no es la raiz
        if(mayor != i){
            int change = array[i];
            array[i] = array[mayor];
            array[mayor] = change;
            stepHeap+= 4;
            
            
            //Recursion 
            amontonar(array, size, mayor);
            
            
        }
        
    }


    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);  // Genera números aleatorios entre 0 y 9999
        }
        return array;
    }


    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}