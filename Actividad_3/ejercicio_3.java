import java.util.Scanner;
public class ejercicio_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== MINI CALCULADORA =====");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.print("Elige una opción (1 o 2): ");
        int opcion = sc.nextInt();

        System.out.print("Ingresa el primer número: ");
        double num1 = sc.nextDouble();

        System.out.print("Ingresa el segundo número: ");
        double num2 = sc.nextDouble();

        double resultado;

        switch (opcion) {
            case 1:
                resultado = sumar(num1, num2);
                System.out.println("Resultado de la suma: " + resultado);
                break;

            case 2:
                resultado = restar(num1, num2);
                System.out.println("Resultado de la resta: " + resultado);
                break;

            default:
                System.out.println("Opción inválida. Debes elegir 1 o 2.");
                break;
        }

        sc.close();
    }

    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }
}
