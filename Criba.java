import java.util.Scanner;
/**
 * Clase que implementa la Criba de Eratóstenes para encontrar números primos
 * hasta un número máximo dado.
 * <p>
 * La Criba de Eratóstenes es un algoritmo eficiente para encontrar todos los números primos
 * menores que un número dado (no incluido). Este enfoque marca los múltiplos de cada primo
 * encontrado como no primos, iterando hasta la raíz cuadrada del número máximo.
 * </p>
 * @author --
 */
public class Criba {
    /**
     * Método que inicializa un array a true excepto las posiciones 0 y 1
     * que se inicializan a false.
     * @param array
     */
    private static void inicializa(boolean array[]){
        for ( int i=2; i<array.length; i++)
            array[i] = true;
// Eliminar el 0 y el 1, que no son primos
        array[0] = array[1] = false;}

    /**
     * Método de criba de Erastóstenes.
     * Busca numeros primos de menor a mayor y elimina los múltiplos posibles.
     * @param array
     */
    private static void criba (boolean array[]){
        for (int i=2; i<Math.sqrt(array.length)+1 ; i++) {
            if (array[i]) {
// Eliminar los múltiplos de i
                for (int j=2*i; j<array.length; j+=i)
                    array[j] = false;
            }
        }
    }

    /**
     * Método para contar la cantidad de numeros primos que hay en un array.
     * @param array
     * @return cuentaPrimos cantidad nominal de numeros primos en parametro 'array'.
     */
    private static  int cuentaPrimos(boolean array[]){
        int cuentaPrimos = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i])
                cuentaPrimos++;
        }
        return cuentaPrimos;
    }

    /**
     * Método que crea un array con los primos que hay en el array pasado como parámetro.
     * @param array
     * @return primos array formado por números primos de parametro 'array'
     */
    private static int[] totalPrimos(boolean array[]){
        int[] primos = new int[cuentaPrimos(array)];
        for (int i=0, j=0; i< array.length; i++) {
            if (array[i])
                primos[j++] = i;
        }
        return primos;
    }
    /**
     * Genera un array de enteros para encontrar los números primos contenidos
     *
     * @param max El valor máximo para el cual se buscan los números primos.
     * @return totalPrimos(esPrimo) Un array de enteros que contiene todos los números primos menores o iguales al parametro 'max'.
     * Si el 'parametro 'max' es menor que 2, devuelve un arreglo vacío, ya que no existen números primos menores que 2.
     */
    public static int[] generarPrimos (int max)
    {
        int i,j;
        if (max >= 2) {
// Declaraciones
            int dimArray = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dimArray];
            inicializa(esPrimo);
            criba(esPrimo);
            return totalPrimos(esPrimo);
        } else { // max < 2
            return new int[0];
// Vector vacío
        }
    }
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int vector[]=new int[dato];
        System.out.println("\nVector inicial hasta :"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(i+1+"\t");
        }
        vector=generarPrimos(dato);
        System.out.println("\nVector de primos hasta:"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(vector[i]+"\t");
        }
    }
}
