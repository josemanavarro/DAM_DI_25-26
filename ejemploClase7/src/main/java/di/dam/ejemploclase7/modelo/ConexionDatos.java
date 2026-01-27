/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.dam.ejemploclase7.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jose
 */
class ConexionDatos {
    
    // HOST: usa "localhost" si ejecutas desde tu PC.
    // Si la app Java está en el mismo docker-compose, usa "db".
    private static final String URL = "jdbc:mysql://localhost:3307/DI?useSSL=false&allowPublicKeyRetrieval=true&characterEncoding=utf8&serverTimezone=Europe/Madrid";
    private static final String USER = "di_user";
    private static final String PASS = "Alandalus2526";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
