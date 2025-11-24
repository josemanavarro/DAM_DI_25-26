/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package di.dam.tareaev1_25._apartado1.controlador;
import di.dam.tareaev1_25._apartado1.vista.ReservaJFrame;

/**
 *
 * @author jose
 */
public class Lanzador {

    public static void main(String[] args) {
        ReservaControlador rc = new ReservaControlador();
        ReservaJFrame rjf = new ReservaJFrame(rc);
        rjf.setVisible(true);
    }
}
