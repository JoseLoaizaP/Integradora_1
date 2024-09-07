package model;

public class CultivoOtoño extends Cultivo{
    public CultivoOtoño(String nombre, int diasCrecimiento) {
        super(nombre, diasCrecimiento);
    }
    @Override
    public String getEstacion() {
        return "Otoño";
    }
}
