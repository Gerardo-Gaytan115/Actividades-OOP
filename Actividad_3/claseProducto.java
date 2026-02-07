public class Producto {

    private String descripcion;
    private String codigo;
    private String tipo;
    private double costo;
    private double impuesto;

    public Producto() {
        descripcion = "";
        codigo = "";
        tipo = "";
        costo = 0;
        impuesto = 0;
    }

    public String getDescripcion() { return descripcion; }
    public String getCodigo() { return codigo; }
    public String getTipo() { return tipo; }
    public double getCosto() { return costo; }
    public double getImpuesto() { return impuesto; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setCosto(double costo) { this.costo = costo; }

    public void mostrarProducto() {
        System.out.println("\n--- PRODUCTO ---");
        System.out.println("Descripción: " + descripcion);
        System.out.println("Código: " + codigo);
        System.out.println("Tipo: " + tipo);
        System.out.println("Costo: $" + costo);
        System.out.println("Impuesto: $" + impuesto);
    }

    public double calcularPrecio() {
        if (tipo.equalsIgnoreCase("basico")) {
            impuesto = costo * 0.10;
        } else if (tipo.equalsIgnoreCase("premium")) {
            impuesto = costo * 0.20;
        } else {
            impuesto = 0;
        }

        return costo + impuesto;
    }

    public String comprarProductos(Producto otro) {
        double precio1 = this.calcularPrecio();
        double precio2 = otro.calcularPrecio();

        if (precio1 > precio2) {
            return "El producto más caro es: " + this.descripcion;
        } else if (precio2 > precio1) {
            return "El producto más caro es: " + otro.descripcion;
        } else {
            return "Ambos productos tienen el mismo precio.";
        }
    }
}
