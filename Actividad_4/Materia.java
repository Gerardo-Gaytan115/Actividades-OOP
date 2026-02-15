public class Materia {
    private String nombre;
    private String clave;
    private int creditos;
    private int horasSemanales;

    // Constructor por defecto
    public Materia() {
        this.nombre = "";
        this.clave = "";
        this.creditos = 0;
        this.horasSemanales = 0;
    }

    // Constructor con parámetros
    public Materia(String nombre, String clave, int creditos, int horasSemanales) {
        this.nombre = nombre;
        this.clave = clave;
        setCreditos(creditos);
        setHorasSemanales(horasSemanales);
    }

    // Constructor de copia (copia profunda de valores escalares)
    public Materia(Materia other) {
        if (other == null) {
            throw new IllegalArgumentException("Materia a copiar no puede ser null");
        }
        this.nombre = other.nombre;
        this.clave = other.clave;
        this.creditos = other.creditos;
        this.horasSemanales = other.horasSemanales;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre != null ? nombre : ""; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave != null ? clave : ""; }

    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) {
        if (creditos < 0) throw new IllegalArgumentException("Créditos no pueden ser negativos");
        this.creditos = creditos;
    }

    public int getHorasSemanales() { return horasSemanales; }
    public void setHorasSemanales(int horasSemanales) {
        if (horasSemanales < 0) throw new IllegalArgumentException("Horas semanales no pueden ser negativas");
        this.horasSemanales = horasSemanales;
    }

    @Override
    public String toString() {
        return "Materia{" +
               "nombre='" + nombre + '\'' +
               ", clave='" + clave + '\'' +
               ", creditos=" + creditos +
               ", horasSemanales=" + horasSemanales +
               '}';
    }
}