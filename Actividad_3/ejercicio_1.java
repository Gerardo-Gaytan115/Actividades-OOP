import java.util.Scanner;
public class ejercicio_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa la cantidad en metros: ");
        double metros = sc.nextDouble();

        double centimetros = convertirMetrosACentimetros(metros);

        System.out.println(metros + " metros son " + centimetros + " centímetros.");

        sc.close();
    }

    public static double convertirMetrosACentimetros(double metros) {
        return metros * 100;
    }
}