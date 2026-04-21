/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testUnitariosSimples;

import di.dam.ejemploclase9.controlador.ServicioCalculadora;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jose
 */
public class TestUnitarioServicioCalculadora {
    @Test
    void testDivisionSuccessfully() {        
        ServicioCalculadora sc = new ServicioCalculadora();
        assertEquals(5, sc.calcula(10, 2, "/"));
    }
    
    @Test
    void testServicioCalculadoraCeroThrowsException() {
        ServicioCalculadora sc = new ServicioCalculadora();
        Exception exception = assertThrows(ArithmeticException.class, () -> {
           sc.calcula(10, 0, "/");
        });
        assertEquals("División por cero", exception.getMessage());
    }
    
    @Test
    void testServicioCalculadoraOperacionThrowsException() {
        ServicioCalculadora sc = new ServicioCalculadora();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           sc.calcula(10, 0, "%");
        });
        assertEquals("Operación no válida", exception.getMessage());
    }

}
