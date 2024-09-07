package model;

import java.util.Timer;
import java.util.TimerTask;

public class SimulacionEstaciones {

    private int mesActual = 1;  // Empieza en enero (mes 1)
    private String[] estaciones = {"Invierno", "Primavera", "Verano", "Otoño"};

    public void iniciarSimulacion() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                actualizarMes();  // Solo actualiza el mes, sin mostrarlo
            }
        }, 0, 60000); // 60000 milisegundos = 1 minuto
    }

    // Método que solo actualiza el mes sin mostrarlo
    private void actualizarMes() {
        mesActual = (mesActual % 12) + 1; // Incrementa el mes y vuelve a 1 después de 12
    }

    // Método que muestra el mes y la estación
    public void mostrarMesYEstacion() {
        String estacion = obtenerEstacionPorMes(mesActual);
        System.out.println("Mes: " + mesActual + " - Estación: " + estacion);
    }

    private String obtenerEstacionPorMes(int mes) {
        if (mes >= 3 && mes <= 5) return "Primavera"; // Meses 3-5 son primavera
        if (mes >= 6 && mes <= 8) return "Verano";    // Meses 6-8 son verano
        if (mes >= 9 && mes <= 11) return "Otoño";    // Meses 9-11 son otoño
        return "Invierno"; // Meses 12, 1, 2 son invierno
    }

    public String obtenerEstacionActual() {
        return obtenerEstacionPorMes(mesActual);
    }


}