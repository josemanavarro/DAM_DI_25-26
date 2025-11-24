/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.dam.tareaev1_25._apartado1.modelo;

import java.time.LocalDate;
import java.time.LocalTime;


/**
 *
 * @author jose
 */
public class Reserva {
    
    private String nombreCliente;   // Nombre y apellidos.
    private String telefono;
    private String pista;           // "Pádel", "Frontón", "Fútbol sala", "Baloncesto"
    private LocalDate fecha;
    private LocalTime hora;
    private String estado;          // "Pendiente", "Pagada", "Cancelada"

    public Reserva() {
    }

    public Reserva(String nombreCliente, String telefono, String pista,
                   LocalDate fecha, LocalTime hora, String estado) {
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.pista = pista;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPista() {
        return pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", pista='" + pista + '\'' +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", estado='" + estado + '\'' +
                '}';
    }
}
