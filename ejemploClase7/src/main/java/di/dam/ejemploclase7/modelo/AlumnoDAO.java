/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.dam.ejemploclase7.modelo;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jose
 */
public interface AlumnoDAO {
    List<Alumno> obtener() throws SQLException;
    Optional<Alumno> buscarId(int id) throws SQLException;
    List<Alumno> buscarApellido(String patron) throws SQLException;
    Alumno insertar(Alumno a) throws SQLException;   // Devuelve con ID asignado
    boolean update(Alumno a) throws SQLException;   // true si actualiza 1 fila
    boolean borrarId(int id) throws SQLException;
    long contar() throws SQLException;    
}
