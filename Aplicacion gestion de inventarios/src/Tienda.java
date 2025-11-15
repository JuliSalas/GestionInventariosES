public class Tienda {

    private ArbolProductos inventario = new ArbolProductos();
    private ColaClientes cola = new ColaClientes();

    public ArbolProductos getInventario() { return inventario; }

    public void agregarCliente(Cliente c) {
        cola.encolar(c);
    }

    public void atenderCliente() {
        if (cola.estaVacia()) {
            System.out.println("No hay clientes en espera.");
            return;
        }

        Cliente c = cola.atender();
        System.out.println("\nAtendiendo cliente: " + c.getNombre());
        c.getCarrito().imprimirFactura();
    }
}



