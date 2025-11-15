import java.util.ArrayList;

public class Producto implements Comparable<Producto> {

    private String nombre;
    private double precio;
    private String categoria;
    private String fechaVencimiento;
    private int cantidad;
    private ArrayList<String> listaImagenes;

    // Punteros del árbol binario
    Producto izq;
    Producto der;

    // Puntero exclusivo para la lista del carrito
    Producto sig;

    public Producto(String nombre, double precio, String categoria, String fechaVencimiento, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;

        this.listaImagenes = new ArrayList<>();

        this.izq = null;
        this.der = null;
        this.sig = null;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getCategoria() { return categoria; }
    public String getFechaVencimiento() { return fechaVencimiento; }
    public int getCantidad() { return cantidad; }
    public ArrayList<String> getListaImagenes() { return listaImagenes; }

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public void agregarImagen(String ruta) { listaImagenes.add(ruta); }

    public int compareTo(Producto o) {
        return this.nombre.compareToIgnoreCase(o.nombre);
    }

    public String toString() {
        return nombre + " | ₡" + precio + " | Cantidad: " + cantidad;
    }
}

