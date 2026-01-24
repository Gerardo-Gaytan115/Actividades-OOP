public class Pares {

    public static void main(String[] args) {

        int[] pares = new int[50];
        int indice = 0;

        for (int i = 2; i <= 100; i += 2) {
            pares[indice] = i;
            indice++;
        }

        System.out.println("Números pares del 2 al 100:");

        for (int i = 0; i < pares.length; i++) {
            System.out.print(pares[i] + " ");
        }
    }
}
