public class Profesor {
    private String nombre;
    private String numeroNomina;
    private double sueldoPorHora;
    private Materia materia; // 0 o 1

    // Constructor por defecto
    public Profesor() {
        this.nombre = "";
        this.numeroNomina = "";
        this.sueldoPorHora = 0.0;
        this.materia = null; // Puede darse de alta sin materia
    }

    // Constructor con parámetros
    public Profesor(String nombre, String numeroNomina, double sueldoPorHora, Materia materia) {
        this.nombre = nombre != null ? nombre : "";
        this.numeroNomina = numeroNomina != null ? numeroNomina : "";
        setSueldoPorHora(sueldoPorHora);
        // Asociación (no composición): mantenemos referencia o null
        this.materia = materia;
    }

    // Constructor de copia (copia superficial de la asociación Materia)
    public Profesor(Profesor other) {
        if (other == null) throw new IllegalArgumentException("Profesor a copiar no puede ser null");
        this.nombre = other.nombre;
        this.numeroNomina = other.numeroNomina;
        this.sueldoPorHora = other.sueldoPorHora;
        this.materia = other.materia; // asociación: no se copia profundamente
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre != null ? nombre : ""; }

    public String getNumeroNomina() { return numeroNomina; }
    public void setNumeroNomina(String numeroNomina) { this.numeroNomina = numeroNomina != null ? numeroNomina : ""; }

    public double getSueldoPorHora() { return sueldoPorHora; }
    public void setSueldoPorHora(double sueldoPorHora) {
        if (sueldoPorHora < 0) throw new IllegalArgumentException("Sueldo por hora no puede ser negativo");
        this.sueldoPorHora = sueldoPorHora;
    }

    public Materia getMateria() { return materia; }

    /** Asigna una materia. Reemplaza la anterior si existiese. */
    public void asignarMateria(Materia materia) {
        this.materia = materia; // puede ser null para desasignar
    }

    /** Calcula sueldo semanal = horasSemanales(materia) * sueldoPorHora. Si no hay materia, 0. */
    public double calcularSueldoSemanal() {
        if (materia == null) return 0.0;
        return materia.getHorasSemanales() * sueldoPorHora;
    }

    @Override
    public String toString() {
        String mat = (materia == null) ? "Sin materia" : materia.getNombre() + " (" + materia.getClave() + ")";
        return "Profesor{" +
               "nombre='" + nombre + '\'' +
               ", numeroNomina='" + numeroNomina + '\'' +
               ", sueldoPorHora=" + sueldoPorHora +
               ", materia=" + mat +
               ", sueldoSemanal=" + calcularSueldoSemanal() +
               '}';
    }
}