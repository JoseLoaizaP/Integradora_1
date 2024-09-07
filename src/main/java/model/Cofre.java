package model;
import java.io.Serializable;
import exceptions.CofreException;

public class Cofre implements Serializable {
    private NodoCultivo cabeza;
    private int tamaño;

    public Cofre() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    public void agregarCultivo(Cultivo cultivo) throws CofreException {
        if (tamaño >= 50) {
            throw new CofreException("Cofre lleno.");
        }
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
        tamaño++;
    }

    public void ordenarCultivos(String criterio, boolean ascendente) {
        if (cabeza == null || cabeza.siguiente == null) return;

        boolean swapped;
        do {
            swapped = false;
            NodoCultivo actual = cabeza;
            NodoCultivo previo = null;

            while (actual != null && actual.siguiente != null) {
                NodoCultivo siguiente = actual.siguiente;
                if (comparar(actual.cultivo, siguiente.cultivo, criterio, ascendente) > 0) {
                    if (previo == null) {
                        NodoCultivo temp = cabeza;
                        cabeza = siguiente;
                        temp.siguiente = siguiente.siguiente;
                        cabeza.siguiente = temp;
                    } else {
                        NodoCultivo temp = actual.siguiente;
                        previo.siguiente = temp;
                        actual.siguiente = temp.siguiente;
                        temp.siguiente = actual;
                    }
                    swapped = true;
                }
                previo = actual;
                actual = actual.siguiente;
            }
        } while (swapped);
    }

    private int comparar(Cultivo c1, Cultivo c2, String criterio, boolean ascendente) {
        int resultado = 0;
        switch (criterio.toLowerCase()) {
            case "nombre":
                resultado = c1.getNombre().compareToIgnoreCase(c2.getNombre());
                break;
            case "tipo":
                resultado = c1.getEstacion().compareToIgnoreCase(c2.getEstacion());
                break;
            case "dias":
                resultado = Integer.compare(c1.getDiasCrecimiento(), c2.getDiasCrecimiento());
                break;
        }
        return ascendente ? resultado : -resultado;
    }

    public Cultivo buscarCultivo(String nombre) {
        NodoCultivo actual = cabeza;
        while (actual != null) {
            if (actual.cultivo.getNombre().equalsIgnoreCase(nombre)) {
                return actual.cultivo;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public NodoCultivo getCabeza() {
        return cabeza;
    }

    public int getTamaño() {
        return tamaño;
    }
}