import java.time.LocalDateTime;

import model.Pasajero;
import model.Vuelo;

public class Main {
    public static void main(String[] args) {
        // Crear vuelo
        Vuelo vuelo = new Vuelo("A123", "New York", 500.0, 7, LocalDateTime.now().plusDays(3));  // Vuelo con fecha de salida en 3 días

        // Crear pasajeros
        Pasajero pasajero1 = new Pasajero("CLo", "12345678", 1, 15.0, "Económica");
        Pasajero pasajero2 = new Pasajero("Maria Lopez", "87654321", 2, 23.0, "Ejecutiva");

        // Reservar asientos
        System.out.println("Reserva exitosa para: " + pasajero1.getNombre());
        System.out.println("Ruta asignada: Ruta de conexión rápida");
        if (vuelo.reservarAsiento()) {
            System.out.println("Asientos disponibles después de reserva de pasajero 1: " + vuelo.getAsientosDisponibles());
        }

        // Simulamos una cancelación después de 24 horas
        System.out.println("Cancelación para: " + pasajero1.getNombre());
        LocalDateTime fechaCancelacion = LocalDateTime.now().plusHours(25);  // Se simula la cancelación 25 horas después
        pasajero1.cancelarReserva(vuelo, fechaCancelacion);  // Pasamos la fecha de cancelación
        System.out.println("Asientos disponibles después de cancelación de pasajero 1: " + vuelo.getAsientosDisponibles());

        // Reservar asiento para el segundo pasajero
        System.out.println("Reserva exitosa para: " + pasajero2.getNombre());
        System.out.println("Ruta asignada: Ruta premium con acceso a VIP");
        if (vuelo.reservarAsiento()) {
            System.out.println("Asientos disponibles después de reserva de pasajero 2: " + vuelo.getAsientosDisponibles());
        }
    }
}



