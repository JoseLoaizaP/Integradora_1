package model;

import java.io.Serializable;


public class NodoCultivo implements Serializable {
    public Cultivo cultivo;
    public NodoCultivo siguiente;

    public NodoCultivo(Cultivo cultivo) {
        this.cultivo = cultivo;
        this.siguiente = null;
    }
    public Cultivo getCultivo() {
        return cultivo;
    }

    public void setSiguiente(NodoCultivo siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCultivo getSiguiente() {
        return siguiente;
    }
}
