public class ArbolProductos {

    private Producto raiz;

    public void insertar(Producto p) {
        raiz = insertarRec(raiz, p);
    }

    private Producto insertarRec(Producto actual, Producto p) {
        if (actual == null) return p;

        if (p.compareTo(actual) < 0)
            actual.izq = insertarRec(actual.izq, p);
        else
            actual.der = insertarRec(actual.der, p);

        return actual;
    }

    public Producto buscar(String nombre) {
        return buscarRec(raiz, nombre);
    }

    private Producto buscarRec(Producto actual, String nombre) {
        if (actual == null) return null;

        int cmp = nombre.compareToIgnoreCase(actual.getNombre());

        if (cmp == 0) return actual;
        else if (cmp < 0) return buscarRec(actual.izq, nombre);
        else return buscarRec(actual.der, nombre);
    }

    public void imprimirInventario() {
        System.out.println("\n- INVENTARIO -");
        inOrden(raiz);
        System.out.println("--------------");
    }

    private void inOrden(Producto p) {
        if (p != null) {
            inOrden(p.izq);
            System.out.println(p);
            inOrden(p.der);
        }
    }
}
