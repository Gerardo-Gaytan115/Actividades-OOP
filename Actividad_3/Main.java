import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Producto p1 = new Producto();
            System.out.println("=== Captura Producto 1 ===");
            System.out.print("Descripción: ");
            p1.setDescripcion(sc.nextLine());
            System.out.print("Código: ");
            p1.setCodigo(sc.nextLine());
            System.out.print("Tipo (basico/premium): ");
            p1.setTipo(sc.nextLine());
            System.out.print("Costo: ");
            p1.setCosto(sc.nextDouble());
            sc.nextLine(); // limpiar buffer

            Producto p2 = new Producto();
            System.out.println("\n=== Captura Producto 2 ===");
            System.out.print("Descripción: ");
            p2.setDescripcion(sc.nextLine());
            System.out.print("Código: ");
            p2.setCodigo(sc.nextLine());
            System.out.print("Tipo (basico/premium): ");
            p2.setTipo(sc.nextLine());
            System.out.print("Costo: ");
            p2.setCosto(sc.nextDouble());

            double precioFinal1 = p1.calcularPrecio();
            double precioFinal2 = p2.calcularPrecio();

            p1.mostrarProducto();
            System.out.println("Precio final: $" + precioFinal1);

            p2.mostrarProducto();
            System.out.println("Precio final: $" + precioFinal2);

            System.out.println("\n" + p1.comprarProductos(p2));

        } catch (Exception e) {
            System.out.println("❌ Error: capturaste un valor inválido (ej. letras donde va número).");
        }

        sc.close();
    }
}