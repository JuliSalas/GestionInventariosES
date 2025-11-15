import java.util.LinkedList;

public class ColaClientes {

    private LinkedList<Cliente> cola = new LinkedList<>();

    public void encolar(Cliente c) {
        if (cola.isEmpty()) {
            cola.add(c);
            return;
        }

        // Insertar respetando prioridad
        int i = 0;
        while (i < cola.size() && cola.get(i).getPrioridad() >= c.getPrioridad()) {
            i++;
        }

        cola.add(i, c);
        System.out.println("Cliente agregado a la cola con prioridad " + c.getPrioridad());
    }

    public Cliente atender() {
        if (cola.isEmpty()) return null;
        return cola.removeFirst();
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }
}

