public class ListaProductos {
    private NodoProducto cabeza;

    // Insertar al inicio
    public void insertarInicio(Producto p) {
        NodoProducto nuevo = new NodoProducto(p);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        System.out.println("Producto agregado al inicio correctamente.");
    }

    // Insertar al final
    public void insertarFinal(Producto p) {
        NodoProducto nuevo = new NodoProducto(p);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoProducto aux = cabeza;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
        System.out.println("Producto agregado al final correctamente.");
    }

    // Modificar producto por nombre
    public void modificarProducto(String nombre, Producto nuevoProducto) {
        NodoProducto aux = cabeza;
        while (aux != null) {
            if (aux.dato.getNombre().equalsIgnoreCase(nombre)) {
                aux.dato = nuevoProducto;
                System.out.println("Producto modificado correctamente.");
                return;
            }
            aux = aux.siguiente;
        }
        System.out.println("Producto no encontrado.");
    }

    // Agregar imagen a producto existente
    public void agregarImagen(String nombreProducto, String rutaImagen) {
        NodoProducto aux = cabeza;
        while (aux != null) {
            if (aux.dato.getNombre().equalsIgnoreCase(nombreProducto)) {
                aux.dato.agregarImagen(rutaImagen);
                System.out.println("Imagen agregada correctamente.");
                return;
            }
            aux = aux.siguiente;
        }
        System.out.println("Producto no encontrado.");
    }

    // Imprimir reporte total
    public void imprimirReporte() {
        if (cabeza == null) {
            System.out.println("No hay productos en la lista.");
            return;
        }

        NodoProducto aux = cabeza;
        double totalGeneral = 0;
        System.out.println("\n======= REPORTE DE PRODUCTOS =======");
        while (aux != null) {
            double totalProducto = aux.dato.getPrecio() * aux.dato.getCantidad();
            totalGeneral += totalProducto;
            System.out.println(aux.dato.toString());
            System.out.println("Costo total del producto: ₡" + totalProducto);
            aux = aux.siguiente;
        }
        System.out.println("----------------------------------");
        System.out.println("Costo total acumulado: ₡" + totalGeneral);
        System.out.println("==================================\n");
    }
}

