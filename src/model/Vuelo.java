package model;
import java.time.LocalDateTime;

public class Vuelo {
    private String codigoVuelo;
    private String destino;
    private double precioBoleto;
    private int asientosDisponibles;
    private LocalDateTime fechaSalida;

    public Vuelo(String codigoVuelo, String destino, double precioBoleto, int asientosDisponibles, LocalDateTime fechaSalida) {
        this.codigoVuelo = codigoVuelo;
        this.destino = destino;
        this.precioBoleto = precioBoleto;
        this.asientosDisponibles = asientosDisponibles;
        this.fechaSalida = fechaSalida;
    }

    // Método para reservar un asiento
    public boolean reservarAsiento() {
        if (asientosDisponibles > 0) {
            asientosDisponibles--;
            return true; // Reserva exitosa
        }
        return false; // No hay asientos disponibles
    }

    // Método para liberar un asiento (cuando se cancela una reserva)
    public void liberarAsiento() {
        asientosDisponibles++;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }
}


