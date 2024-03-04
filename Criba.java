import java.util.Scanner;
public class Criba {
    public void inicializa(boolean array[]){
        for ( int i=2; i<array.length; i++)
            array[i] = true;
// Eliminar el 0 y el 1, que no son primos
        array[0] = array[1] = false;}
    public void criba (boolean array[]){
        for (int i=2; i<Math.sqrt(array.length)+1 ; i++) {
            if (array[i]) {
// Eliminar los múltiplos de i
                for (int j=2*i; j<array.length; j+=i)
                    array[j] = false;
            }
        }
    }
    public int cuentaPrimos(boolean array[]){
        int cuentaPrimos = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i])
                cuentaPrimos++;
        }
        return cuentaPrimos;
    }
    public int[] totalPrimos(boolean array[]){
        int[] primos = new int[cuentaPrimos(array)];
        for (int i=0, j=0; i< array.length; i++) {
            if (array[i])
                primos[j++] = i;
        }
        return primos;
    }
  
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
