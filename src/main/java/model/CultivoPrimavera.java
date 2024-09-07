package model;

public class CultivoPrimavera extends Cultivo {
    public CultivoPrimavera(String nombre, int diasCrecimiento) {
        super(nombre, diasCrecimiento);
    }

    @Override
    public String getEstacion() {
        return "Primavera";
    }
}
