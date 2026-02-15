import java.util.Arrays;

public class Curso {
    private String nombre;
    private Materia[] materias; // exactamente 3

    // Constructor por defecto
    public Curso() {
        this.nombre = "";
        this.materias = new Materia[3];
        // Inicializamos con materias "vacías" para respetar cardinalidad
        for (int i = 0; i < 3; i++) {
            this.materias[i] = new Materia();
        }
    }

    // Constructor con parámetros (3 materias)
    public Curso(String nombre, Materia m1, Materia m2, Materia m3) {
        this.nombre = nombre != null ? nombre : "";
        if (m1 == null || m2 == null || m3 == null) {
            throw new IllegalArgumentException("Un curso debe tener exactamente 3 materias no nulas");
        }
        this.materias = new Materia[] {
            new Materia(m1), new Materia(m2), new Materia(m3) // copia profunda por composición
        };
    }

    // Constructor de copia (copia profunda de materias)
    public Curso(Curso other) {
        if (other == null) throw new IllegalArgumentException("Curso a copiar no puede ser null");
        this.nombre = other.nombre;
        this.materias = new Materia[3];
        for (int i = 0; i < 3; i++) {
            this.materias[i] = new Materia(other.materias[i]);
        }
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre != null ? nombre : ""; }

    public Materia[] getMaterias() {
        // Devolvemos copia para proteger inmutabilidad externa
        return Arrays.stream(materias).map(Materia::new).toArray(Materia[]::new);
    }

    /** Reemplaza una materia (0,1,2) por copia, respetando composición. */
    public void setMateria(int indice, Materia materia) {
        if (indice < 0 || indice >= 3) throw new IndexOutOfBoundsException("Índice de materia debe ser 0, 1 o 2");
        if (materia == null) throw new IllegalArgumentException("Materia no puede ser null");
        this.materias[indice] = new Materia(materia);
    }

    /** Suma créditos de las 3 materias. */
    public int getCreditosTotales() {
        int total = 0;
        for (Materia m : materias) total += m.getCreditos();
        return total;
    }

    /** Suma horas semanales de las 3 materias. */
    public int getHorasSemanalesTotales() {
        int total = 0;
        for (Materia m : materias) total += m.getHorasSemanales();
        return total;
    }

    @Override
    public String toString() {
        return "Curso{" +
               "nombre='" + nombre + '\'' +
               ", creditosTotales=" + getCreditosTotales() +
               ", horasSemanalesTotales=" + getHorasSemanalesTotales() +
               ", materias=" + Arrays.toString(materias) +
               '}';
    }
}