// EDD Tarea 4
import java.util.Scanner;
public class Criba
{
    // Generar números primos de 1 a max
    public static int[] generarPrimos (int max)
    {
        int i,j;
        if (max >= 2) {
// Declaraciones
            int dimArray = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dimArray];
// Inicializar el array
            for (i=2; i<dimArray; i++)
                esPrimo[i] = true;
// Eliminar el 0 y el 1, que no son primos
            esPrimo[0] = esPrimo[1] = false;
// Criba
            for (i=2; i<Math.sqrt(dimArray)+1 ; i++) {
                if (esPrimo[i]) {
// Eliminar los múltiplos de i
                    for (j=2*i; j<dimArray; j+=i)
                        esPrimo[j] = false;
                }
            }
// ¿Cuántos primos hay?
            int cuentaPrimos = 0;
            for (i=0; i<dimArray; i++) {
                if (esPrimo[i])
                    cuentaPrimos++;
            }
// Rellenar el vector de números primos
            int[] primos = new int[cuentaPrimos];
            for (i=0, j=0; i<dimArray; i++) {
                if (esPrimo[i])
                    primos[j++] = i;
            }
            return primos;
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
