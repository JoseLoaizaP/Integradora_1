package model;


public class Parcela {
    public SimpleLinkedListCultivos cultivos;  // Lista de cultivos en la parcela
    public Parcela siguiente;  // Enlace a la siguiente parcela

    public Parcela() {
        this.cultivos = new SimpleLinkedListCultivos();  // Cada parcela tiene su propia lista de cultivos
        this.siguiente = null;
    }
}