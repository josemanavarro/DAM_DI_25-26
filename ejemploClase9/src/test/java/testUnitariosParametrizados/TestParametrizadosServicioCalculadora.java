/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testUnitariosParametrizados;

import di.dam.ejemploclase9.controlador.ServicioCalculadora;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author jose
 */
public class TestParametrizadosServicioCalculadora {
    static ServicioCalculadora sc;
    @BeforeAll
    static void setup(){
        sc = new ServicioCalculadora();
    }
    @ParameterizedTest
    @CsvSource ({"5,2,+,7.0","10,2,/,5.0","2,2,*,4.0","3,8,-,-5.0"})
    void testVariasOperaciones(double a, double b, String op, Double res){
        Double real = sc.calcula(a,b,op);
        assertEquals(res, real);
    }
}
