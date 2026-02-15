public class Alumno {
    private String matricula;
    private String nombre;
    private int edad;
    private Curso curso; // agregado

    // Constructor por defecto
    public Alumno() {
        this.matricula = "";
        this.nombre = "";
        this.edad = 0;
        this.curso = null; // puede establecerse después
    }

    // Constructor con parámetros
    public Alumno(String matricula, String nombre, int edad, Curso curso) {
        this.matricula = matricula != null ? matricula : "";
        this.nombre = nombre != null ? nombre : "";
        setEdad(edad);
        this.curso = curso; // agregación: referencia compartida
    }

    // Constructor de copia (copia superficial del curso por agregación)
    public Alumno(Alumno other) {
        if (other == null) throw new IllegalArgumentException("Alumno a copiar no puede ser null");
        this.matricula = other.matricula;
        this.nombre = other.nombre;
        this.edad = other.edad;
        this.curso = other.curso; // agregación: mantener referencia
    }

    // Getters y setters
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula != null ? matricula : ""; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre != null ? nombre : ""; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) {
        if (edad < 0) throw new IllegalArgumentException("Edad no puede ser negativa");
        this.edad = edad;
    }

    public Curso getCurso() { return curso; }

    /** Inscribe al alumno en un curso (puede reemplazarse). */
    public void inscribirEnCurso(Curso curso) {
        this.curso = curso;
    }

    public int obtenerCreditosCurso() {
        return (curso == null) ? 0 : curso.getCreditosTotales();
    }

    public int obtenerHorasSemanalesCurso() {
        return (curso == null) ? 0 : curso.getHorasSemanalesTotales();
    }

    @Override
    public String toString() {
        String c = (curso == null) ? "Sin curso" : curso.getNombre() + " (Créditos: " + curso.getCreditosTotales() + ")";
        return "Alumno{" +
               "matricula='" + matricula + '\'' +
               ", nombre='" + nombre + '\'' +
               ", edad=" + edad +
               ", curso=" + c +
               '}';
    }
}