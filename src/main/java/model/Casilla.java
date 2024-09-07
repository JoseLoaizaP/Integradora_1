package model;

public class Casilla {
    public Cultivo cultivo;
    public int cantidad;
    public Casilla siguiente;

    public Casilla(Cultivo cultivo, int cantidad) {
        this.cultivo = cultivo;
        this.cantidad = cantidad;
        this.siguiente = null;
    }
}
