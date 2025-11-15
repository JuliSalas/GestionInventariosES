public class ListaProductos {

    private Producto cabeza;

    public void insertarFinal(Producto p) {
        Producto copia = new Producto(p.getNombre(), p.getPrecio(), p.getCategoria(), p.getFechaVencimiento(), p.getCantidad());

        if (cabeza == null) {
            cabeza = copia;
            return;
        }

        Producto aux = cabeza;
        while (aux.sig != null)
            aux = aux.sig;

        aux.sig = copia;
    }

    public void imprimirFactura() {
        if (cabeza == null) {
            System.out.println("El carrito está vacío.");
            return;
        }

        double total = 0;
        Producto aux = cabeza;

        System.out.println("\n- FACTURA DEL CLIENTE -");

        while (aux != null) {
            double subtotal = aux.getPrecio() * aux.getCantidad();
            System.out.println(aux.getNombre() + " x" + aux.getCantidad() + " = ₡" + subtotal);
            total += subtotal;
            aux = aux.sig;
        }

        System.out.println("TOTAL A PAGAR: ₡" + total);
        System.out.println("------------------");
    }
}



