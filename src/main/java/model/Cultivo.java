package model;

public abstract class Cultivo {
    protected String nombre;
    protected int diasCrecimiento;

    public Cultivo(String nombre, int diasCrecimiento) {
        this.nombre = nombre;
        this.diasCrecimiento = diasCrecimiento;
    }

    public abstract String getEstacion();

    public String getNombre() {
        return nombre;
    }

    public int getDiasCrecimiento() {
        return diasCrecimiento;
    }
}
