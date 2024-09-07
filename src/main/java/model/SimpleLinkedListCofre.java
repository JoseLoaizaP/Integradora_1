package model;

public class SimpleLinkedListCofre {
    private Casilla cabeza;
    private static final int MAX_CASILLAS = 50; // Máximo de 50 casillas en el cofre
    private static final int MAX_ITEMS_POR_CASILLA = 25; // Máximo de 25 items por casilla
    private int casillasUsadas = 0; // Contador de las casillas usadas

    public SimpleLinkedListCofre() {
        this.cabeza = null;
    }

    // Método para agregar un cultivo al cofre
    public boolean agregarCultivo(Cultivo cultivo, int cantidad) {
        if (casillasUsadas >= MAX_CASILLAS) {
            System.out.println("Error: El cofre está lleno.");
            return false;
        }

        // Buscar si ya hay una casilla con el mismo cultivo
        Casilla actual = cabeza;
        while (actual != null) {
            if (actual.cultivo.getNombre().equals(cultivo.getNombre())) {
                int espacioDisponible = MAX_ITEMS_POR_CASILLA - actual.cantidad;

                // Si hay espacio en la casilla para más cultivos
                if (cantidad <= espacioDisponible) {
                    actual.cantidad += cantidad;
                    System.out.println("Se han agregado " + cantidad + " unidades de " + cultivo.getNombre() + " a una casilla existente.");
                    return true;
                } else {
                    // Si se llena la casilla actual y aún hay más cantidad por almacenar
                    actual.cantidad = MAX_ITEMS_POR_CASILLA;
                    cantidad -= espacioDisponible;
                    System.out.println("Se han llenado " + espacioDisponible + " unidades en una casilla existente.");
                    break;
                }
            }
            actual = actual.siguiente;
        }

        // Si no hay una casilla para este cultivo o hay sobrante, crear una nueva casilla
        if (cantidad > 0 && casillasUsadas < MAX_CASILLAS) {
            Casilla nuevaCasilla = new Casilla(cultivo, Math.min(cantidad, MAX_ITEMS_POR_CASILLA));
            casillasUsadas++;

            if (cabeza == null) {
                cabeza = nuevaCasilla;
            } else {
                actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevaCasilla;
            }

            System.out.println("Se han agregado " + nuevaCasilla.cantidad + " unidades de " + cultivo.getNombre() + " en una nueva casilla.");
            return true;
        }

        // Si el cofre está lleno
        System.out.println("Error: No se pueden agregar más casillas.");
        return false;
    }

    // Método para imprimir el contenido del cofre
    public void imprimirContenido() {
        if (cabeza == null) {
            System.out.println("El cofre está vacío.");
        } else {
            Casilla actual = cabeza;
            System.out.println("Contenido del cofre:");
            while (actual != null) {
                System.out.println(actual.cultivo.getNombre() + ": " + actual.cantidad + " unidades");
                actual = actual.siguiente;
            }
        }
    }
}