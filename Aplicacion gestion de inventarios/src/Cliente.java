public class Cliente {

    private String nombre;
    private int prioridad; // 1 básico, 2 afiliado, 3 premium

    private ListaProductos carrito;

    public Cliente(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        carrito = new ListaProductos();
    }

    public String getNombre() { return nombre; }
    public int getPrioridad() { return prioridad; }
    public ListaProductos getCarrito() { return carrito; }
}

