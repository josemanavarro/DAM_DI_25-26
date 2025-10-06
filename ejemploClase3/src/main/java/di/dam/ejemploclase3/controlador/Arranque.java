/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package di.dam.ejemploclase3.controlador;

import di.dam.ejemploclase3.vista.JFramePrincipal;

/**
 *
 * @author jose
 */
public class Arranque {

    public static void main(String[] args) {
        // Arranco la logica de negocio
        AlumnoControlador ac = new AlumnoControlador();
        
        // Definimos y mostramos la ventana principal
        JFramePrincipal jfp = new JFramePrincipal(ac);
        jfp.setVisible(true);
    }
}
