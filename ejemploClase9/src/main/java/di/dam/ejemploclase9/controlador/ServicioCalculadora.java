/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.dam.ejemploclase9.controlador;

/**
 *
 * @author jose
 */
public class ServicioCalculadora {

    public double calcula(double operando1, double operando2, String operador) {
        return switch (operador){
            case "+" -> operando1 + operando2;
            case "-" -> operando1 - operando2;
            case "*" -> operando1 * operando2;
            case "/" -> {
                if (operando2 == 0)
                    throw new ArithmeticException("División por cero");
                yield operando1 / operando2;
            }
            default -> throw new IllegalArgumentException("Operación no válida");
        };
    }
}
