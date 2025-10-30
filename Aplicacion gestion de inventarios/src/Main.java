import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static ListaProductos lista = new ListaProductos();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcion;
        do {
            System.out.println("\n GESTIÓN DE VENTAS");
            System.out.println("(1) Agregar producto al inicio");
            System.out.println("(2) Agregar producto al final");
            System.out.println("(3) Modificar producto");
            System.out.println("(4) Agregar imagen a producto");
            System.out.println("(5) Mostrar reporte");
            System.out.println("(6) Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> agregarProducto(true);
                case 2 -> agregarProducto(false);
                case 3 -> modificarProducto();
                case 4 -> agregarImagen();
                case 5 -> lista.imprimirReporte();
                case 6 -> System.out.println(" Se encuentra saliendo del sistema");
                default -> System.out.println(" Opción no válida. Intente de nuevo");
            }
        } while (opcion != 6);
    }

    private static void agregarProducto(boolean alInicio) {
        System.out.println("\nAgregar Producto ");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Precio: ");
        double precio = leerDouble();
        System.out.print("Categoría: ");
        String categoria = sc.nextLine();
        System.out.print("Fecha de vencimiento (o 'n/a'): ");
        String fecha = sc.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = leerEntero();

        Producto p = new Producto(nombre, precio, categoria, fecha, cantidad);
        if (alInicio) lista.insertarInicio(p);
        else lista.insertarFinal(p);
    }

    private static void modificarProducto() {
        System.out.println("\nModificar Producto");
        System.out.print("Nombre del producto a modificar: ");
        String nombre = sc.nextLine();

        System.out.println("Ingrese los nuevos datos:");
        System.out.print("Nuevo nombre: ");
        String nuevoNombre = sc.nextLine();
        System.out.print("Nuevo precio: ");
        double precio = leerDouble();
        System.out.print("Nueva categoría: ");
        String categoria = sc.nextLine();
        System.out.print("Nueva fecha de vencimiento: ");
        String fecha = sc.nextLine();
        System.out.print("Nueva cantidad: ");
        int cantidad = leerEntero();

        Producto nuevo = new Producto(nuevoNombre, precio, categoria, fecha, cantidad);
        lista.modificarProducto(nombre, nuevo);
    }

    private static void agregarImagen() {
        System.out.println("\nAgregar Imagen");
        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.print("Ruta de la imagen (ejemplo: src/img/producto1.jpg): ");
        String ruta = sc.nextLine();
        lista.agregarImagen(nombre, ruta);
    }

    private static int leerEntero() {
        while (true) {
            try {
                int valor = Integer.parseInt(sc.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número entero válido: ");
            }
        }
    }

    private static double leerDouble() {
        while (true) {
            try {
                double valor = Double.parseDouble(sc.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.print(" Ingrese un número válido: ");
            }
        }
    }
}
