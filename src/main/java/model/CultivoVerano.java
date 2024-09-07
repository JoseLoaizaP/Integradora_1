package model;

public class CultivoVerano extends Cultivo{
    public CultivoVerano(String nombre, int diasCrecimiento) {
        super(nombre, diasCrecimiento);
    }

    @Override
    public String getEstacion() {
        return "Verano";
    }

}
