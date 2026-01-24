import java.util.Scanner;

public class EdadNombre {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = entrada.nextLine();

        int edad;

        while (true) {
            System.out.print("Ingrese su edad (número entero): ");

            if (entrada.hasNextInt()) {
                edad = entrada.nextInt();
                break; // sale del ciclo si es válido
            } else {
                System.out.println("Error: debe ingresar un número entero.");
                entrada.next(); // descarta la entrada incorrecta
            }
        }

        int mesesVividos = edad * 12;

        System.out.println("\n--- Resultado ---");

        System.out.println("Hola " + nombre + ", has vivido aproximadamente " + mesesVividos + " meses.");

        entrada.close();
    }
}
