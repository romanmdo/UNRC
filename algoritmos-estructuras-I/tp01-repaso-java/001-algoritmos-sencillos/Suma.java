import java.util.Scanner;

public class Suma {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); 
    
        System.out.print("Ingresa el primer número: ");
        int a = sc.nextInt();
    
        System.out.print("Ingresa el segundo número: ");
        int b = sc.nextInt();

        int resultado = suma(a, b);
        System.out.println("La suma es: " + resultado);
    }

    public static int suma(int a, int b) {
        return a + b;
    }
}
