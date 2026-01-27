/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.dam.ejemploclase7.controlador;

import di.dam.ejemploclase7.modelo.Alumno;
import di.dam.ejemploclase7.modelo.AlumnoDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Logica de negocio para los alumnos
 * @author jose
 */
public class AlumnoControlador {
    private final AlumnoDAO dao;
    
    /**
     * Constructor con dos ejemplos
     * @param dao
     */
    public AlumnoControlador(AlumnoDAO dao){
        this.dao = Objects.requireNonNull(dao, "dao no puede ser null");
    }

    /**
     * @return the listaAlumnos
     * @throws java.sql.SQLException
     */
    public List<Alumno> getListaAlumnos() throws SQLException {
        return dao.obtener();
    }

    /**
     * Añade un alumno
     * @param alumno
     * @return Si se ha insertado
     * @throws java.sql.SQLException
     */
    public boolean altaAlumno(Alumno alumno) throws SQLException, IllegalArgumentException{
        if (validar(alumno)) {
            dao.insertar(alumno);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Valida un alumno antes de pasarlo al DAO
     * @param alumno
     * @return 
     */
    private boolean validar(Alumno alumno){
        boolean valido = true;
        if (alumno.getNombre() == null || alumno.getNombre().isBlank()) {
            valido = false;
            throw new IllegalArgumentException("El nombre es obligatorio");            
        }
        if (alumno.getApellidos() == null || alumno.getApellidos().isBlank()) {
            valido = false;
            throw new IllegalArgumentException("Los apellidos son obligatorios");
        }
        if (alumno.getCurso() == null || alumno.getCurso().isBlank()) {
            valido = false;
            throw new IllegalArgumentException("El curso es obligatorio");
        }
        if (alumno.getAlta() == null)
            alumno.setAlta(new Date());
        return valido;
    }
    
    /**
     * Actualiza un usuario existente (por ID).
     * @param alumno
     * @return Si ha actualizado
     * @throws java.sql.SQLException
     */
    public boolean actualizarAlumno(Alumno alumno) throws SQLException {
        if (alumno.getId() == null) {
            throw new IllegalArgumentException("Para actualizar, el usuario debe tener ID");
        }
        validar(alumno);
        return dao.update(alumno);
    }

    /**
     * Borra por ID.
     * @param id
     * @return Si ha borrado
     * @throws java.sql.SQLException
     */
    public boolean borrarUsuario(int id) throws SQLException {
        return dao.borrarId(id);
    }
    
}
