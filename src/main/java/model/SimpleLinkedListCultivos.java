package model;

public class SimpleLinkedListCultivos {
    private NodoCultivo cabeza;

    public SimpleLinkedListCultivos() {
        this.cabeza = null;
    }

    // Método para agregar un cultivo al final de la lista
    public void agregarCultivo(Cultivo cultivo) {
        NodoCultivo nuevoNodo = new NodoCultivo(cultivo);

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoCultivo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }
    public NodoCultivo getCabeza() {
        return cabeza;
    }

    // Método para imprimir los cultivos en la parcela
    public void imprimirCultivos() {
        if (cabeza == null) {
            System.out.println("No hay cultivos en esta parcela.");
            return;
        }

        NodoCultivo actual = cabeza;
        while (actual != null) {
            System.out.println("Cultivo: " + actual.cultivo.getNombre() + " - Estación: " + actual.cultivo.getEstacion());
            actual = actual.siguiente;
        }
    }
}