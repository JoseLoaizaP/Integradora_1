package model;

public class CultivoInvierno extends Cultivo {
    public CultivoInvierno(String nombre, int diasCrecimiento) {
        super(nombre, diasCrecimiento);
    }

    @Override
    public String getEstacion() {
        return "Invierno";
    }
}
