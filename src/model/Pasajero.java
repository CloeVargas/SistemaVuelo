
package model;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Pasajero {
    private String nombre;
    private String dni;
    private int asiento;
    private double precioBoleto;
    private String tipoBoleto;
    private LocalDateTime fechaReserva;

    public Pasajero(String nombre, String dni, int asiento, double precioBoleto, String tipoBoleto) {
        this.nombre = nombre;
        this.dni = dni;
        this.asiento = asiento;
        this.precioBoleto = precioBoleto;
        this.tipoBoleto = tipoBoleto;
        this.fechaReserva = LocalDateTime.now();
    }

    // Método para calcular la multa de cancelación
    public double calcularMultaCancelacion(LocalDateTime fechaCancelacion) {
        long horasDiferencia = ChronoUnit.HOURS.between(fechaReserva, fechaCancelacion);
        if (horasDiferencia < 24) {
            return 0.0; // No hay multa si la cancelación es dentro de las 24 horas
        } else {
            return this.precioBoleto * 0.2; // Multa del 20% si es fuera de las 24 horas
        }
    }

    // Método para cancelar la reserva y liberar el asiento
    public void cancelarReserva(Vuelo vuelo, LocalDateTime fechaCancelacion) {
        double multa = calcularMultaCancelacion(fechaCancelacion);
        System.out.println("Multa de cancelación para " + nombre + ": " + multa);
        vuelo.liberarAsiento(); // Liberar el asiento cuando se cancela
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getAsiento() {
        return asiento;
    }

    public double getPrecioBoleto() {
        return precioBoleto;
    }

    public String getTipoBoleto() {
        return tipoBoleto;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }
}

