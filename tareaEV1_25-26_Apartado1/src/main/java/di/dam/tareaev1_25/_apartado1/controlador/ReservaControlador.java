/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.dam.tareaev1_25._apartado1.controlador;

import di.dam.tareaev1_25._apartado1.modelo.Reserva;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose
 */
public class ReservaControlador {
    
    private final List<Reserva> reservas = new ArrayList<>();

    public ReservaControlador() {
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        // Datos de ejemplo para que la tabla no salga vacía
        reservas.add(new Reserva("Juan Pérez", "600123123", "Pádel",
                LocalDate.now(), LocalTime.of(9, 0), "Pendiente"));
        reservas.add(new Reserva("Ana López", "678456789", "Frontón",
                LocalDate.now(), LocalTime.of(10, 0), "Pagada"));
        reservas.add(new Reserva("Carlos Ruiz", "650111222", "Fútbol sala",
                LocalDate.now(), LocalTime.of(11, 30), "Cancelada"));
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void addReserva(Reserva r) {
        reservas.add(r);
    }

    public void removeReserva(Reserva r) {
        reservas.remove(r);
    }

    public void updateReserva(int index, Reserva r) {
        reservas.set(index, r);
    }

    public Reserva getReserva(int index) {
        return reservas.get(index);
    }

    public int size() {
        return reservas.size();
    }
}
