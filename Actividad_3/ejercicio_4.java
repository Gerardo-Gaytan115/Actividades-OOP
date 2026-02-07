import java.util.Scanner;
public class ejercicio_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int calificacionValida = pedirCalificacionValida(sc);

        System.out.println("Calificación válida capturada: " + calificacionValida);

        sc.close();
    }

    public static int pedirCalificacionValida(Scanner sc) {
        int calificacion;

        do {
            System.out.print("Ingresa una calificación (0 a 100): ");
            calificacion = sc.nextInt();

            if (calificacion < 0 || calificacion > 100) {
                System.out.println("Calificación inválida. Debe estar entre 0 y 100.");
            }

        } while (calificacion < 0 || calificacion > 100);

        return calificacion;
    }
}