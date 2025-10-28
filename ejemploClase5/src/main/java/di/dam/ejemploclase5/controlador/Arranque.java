/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package di.dam.ejemploclase5.controlador;

import di.dam.ejemploclase5.modelo.AlumnoDAOMySQL;
import di.dam.ejemploclase5.vista.JFramePrincipal;

/**
 *
 * @author jose
 */
public class Arranque {

    public static void main(String[] args) {
        // Arranco la logica de negocio
        AlumnoDAOMySQL dao = new AlumnoDAOMySQL();
        AlumnoControlador ac = new AlumnoControlador(dao);
        
        // Definimos y mostramos la ventana principal
        JFramePrincipal jfp = new JFramePrincipal(ac);
        jfp.setVisible(true);
    }
}
