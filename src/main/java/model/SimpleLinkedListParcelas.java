package model;

class SimpleLinkedListParcela {
    private Parcela cabeza;

    public SimpleLinkedListParcela() {
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

    // Cosechar todos los cultivos de una parcela específica
    public void cosecharCultivosDeParcela(int indiceParcela, SimpleLinkedListCofre cofre) {
        Parcela actual = cabeza;
        int contador = 0;

        // Buscar la parcela en el índice especificado
        while (actual != null && contador < indiceParcela) {
            actual = actual.siguiente;
            contador++;
        }

        if (actual != null) {
            // Cosechar cultivos y agregarlos al cofre
            NodoCultivo cultivoActual = actual.cultivos.getCabeza();  // Obtener el primer cultivo de la parcela
            while (cultivoActual != null) {
                cofre.agregarCultivo(cultivoActual.cultivo, 1);  // Suponemos que estamos agregando 1 unidad de cada cultivo
                cultivoActual = cultivoActual.siguiente;  // Pasar al siguiente cultivo
            }
            System.out.println("Cosechados todos los cultivos de la parcela " + (indiceParcela + 1));
        } else {
            System.out.println("Parcela no encontrada.");
        }
    }

    // Método para imprimir todas las parcelas y sus cultivos
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