public class NodoProducto {
    Producto dato;
    NodoProducto siguiente;

    public NodoProducto(Producto p) {
        this.dato = p;
        this.siguiente = null;
    }
}
