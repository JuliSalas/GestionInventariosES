import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Tienda tienda = new Tienda();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int op;

        do {
            System.out.println("\n- MENU PRINCIPAL -");
            System.out.println("1. Agregar producto al inventario");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Registrar cliente y llenar carrito");
            System.out.println("4. Atender siguiente cliente");
            System.out.println("5. Salir");
            System.out.print("Seleccione opción: ");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1 -> agregarProductoInventario();
                case 2 -> tienda.getInventario().imprimirInventario();
                case 3 -> registrarCliente();
                case 4 -> tienda.atenderCliente();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }

        } while (op != 5);
    }

    private static void agregarProductoInventario() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.print("Categoría: ");
        String categoria = sc.nextLine();
        System.out.print("Fecha vencimiento: ");
        String fecha = sc.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = Integer.parseInt(sc.nextLine());

        tienda.getInventario().insertar(new Producto(nombre, precio, categoria, fecha, cantidad));
    }

    private static void registrarCliente() {
        System.out.print("Nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.print("Prioridad (1=básico, 2=afiliado, 3=premium): ");
        int prioridad = Integer.parseInt(sc.nextLine());

        Cliente c = new Cliente(nombre, prioridad);

        System.out.println("¿Cuántos productos desea agregar al carrito?");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Nombre del producto: ");
            String nom = sc.nextLine();

            Producto p = tienda.getInventario().buscar(nom);
            if (p != null) {
                System.out.print("Cantidad: ");
                int cant = Integer.parseInt(sc.nextLine());

                Producto copia = new Producto(p.getNombre(), p.getPrecio(), p.getCategoria(), p.getFechaVencimiento(), cant);
                c.getCarrito().insertarFinal(copia);
            } else {
                System.out.println("Producto no encontrado en inventario.");
            }
        }

        tienda.agregarCliente(c);
    }
}
