import java.util.Scanner;
public class ejercicio_2 {
    public static void main(String[] args) {
        System.out.print("Ingresa un número: ");
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();

        if (esPar(numero)) {
            System.out.println("El número es par.");
        } else {
            System.out.println("El número es impar.");
        }

        sc.close();
    }

    public static boolean esPar(int n) {
        return n % 2 == 0;
    }
}
