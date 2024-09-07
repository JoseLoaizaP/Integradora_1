package model;

public class SimpleLinkedListParcelas {
    private Parcela cabeza;

    public SimpleLinkedListParcelas() {
        this.cabeza = null;
    }

    // Agregar una nueva parcela
    public void agregarParcela() {
        Parcela nuevaParcela = new Parcela();

        if (cabeza == null) {
            cabeza = nuevaParcela;
        } else {
            Parcela actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevaParcela;
        }
    }

    // Agregar un cultivo a una parcela específica (por índice)
    public void agregarCultivoAParcela(int indiceParcela, Cultivo cultivo) {
        Parcela actual = cabeza;
        int contador = 0;

        // Buscar la parcela en el índice especificado
        while (actual != null && contador < indiceParcela) {
            actual = actual.siguiente;
            contador++;
        }

        if (actual != null) {
            actual.cultivos.agregarCultivo(cultivo);  // Agregar el cultivo a la parcela
        } else {
            System.out.println("Parcela no encontrada.");
        }
    }

    // Imprimir todas las parcelas y sus cultivos
    public void imprimirParcelasYCultivos() {
        Parcela actual = cabeza;
        int contador = 1;

        while (actual != null) {
            System.out.println("Parcela " + contador + ":");
            actual.cultivos.imprimirCultivos();
            actual = actual.siguiente;
            contador++;
        }
    }
}