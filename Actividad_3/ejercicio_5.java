import java.util.Scanner;
public class ejercicio_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double totalVendido = capturarVentasYObtenerTotal(sc);
        int numeroVentas = obtenerNumeroVentas();

        double promedio = calcularPromedio(totalVendido, numeroVentas);

        System.out.println("\n===== REPORTE DE VENTAS =====");
        System.out.println("Número de ventas: " + numeroVentas);
        System.out.println("Total vendido: " + totalVendido);
        System.out.println("Promedio: " + promedio);

        sc.close();
    }

    private static int contadorVentas = 0;

    public static double capturarVentasYObtenerTotal(Scanner sc) {
        double total = 0;
        double venta;

        System.out.println("Captura ventas (ingresa -1 para terminar)");

        while (true) {
            venta = pedirVenta(sc);

            if (venta == -1) {
                break;
            }

            total = sumar(total, venta);
            contadorVentas++;
        }

        return total;
    }

    public static double pedirVenta(Scanner sc) {
        System.out.print("Ingresa el monto de la venta: ");
        return sc.nextDouble();
    }

    public static double sumar(double acumulado, double venta) {
        return acumulado + venta;
    }

    public static double calcularPromedio(double total, int cantidad) {
        if (cantidad == 0) {
            return 0; 
        }
        return total / cantidad;
    }

    public static int obtenerNumeroVentas() {
        return contadorVentas;
    }
}