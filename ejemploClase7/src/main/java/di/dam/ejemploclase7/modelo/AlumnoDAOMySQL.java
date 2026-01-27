/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.dam.ejemploclase7.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jose
 */
public class AlumnoDAOMySQL implements AlumnoDAO{
    
    /**
     * Define un mapa de alumnos
     * @param rs
     * @return
     * @throws SQLException 
     */
    private static Alumno map(ResultSet rs) throws SQLException {
        Alumno a = new Alumno();
        a.setId(rs.getInt("id"));
        a.setNombre(rs.getString("nombre"));
        a.setApellidos(rs.getString("apellidos"));
        a.setCiclo(rs.getString("ciclo"));
        a.setCurso(rs.getString("curso"));
        Date f = rs.getDate("fecha_alta");
        a.setAlta((f != null) ? f : null);
        return a;
    }
    
    /**
     * Obtiene todos los alumnos
     * @return List
     * @throws SQLException 
     */
    @Override
    public List<Alumno> obtener() throws SQLException {
        String sql = "SELECT id, nombre, apellidos, ciclo, curso, fecha_alta FROM alumnos ORDER BY apellidos, nombre";
        try (Connection cn = ConexionDatos.getConnection(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            List<Alumno> out = new ArrayList<>();
            while (rs.next()) {
                out.add(map(rs));
            }
            return out;
        }
    }

    /**
     * Busca un alumno y si lo encuentra lo devuelve
     * @param id
     * @return Alumno
     * @throws SQLException 
     */
    @Override
    public Optional<Alumno> buscarId(int id) throws SQLException {
        String sql = "SELECT id, nombre, apellidos, ciclo, curso, fecha_alta FROM alumnos ORDER BY apellidos, nombre WHERE id = ?";
        try (Connection cn = ConexionDatos.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(map(rs)) : Optional.empty();
            }
        }
    }

    /**
     * Busca por apellido, puede no encontrar
     * @param patron
     * @return
     * @throws SQLException 
     */
    @Override
    public List<Alumno> buscarApellido(String patron) throws SQLException {
        String sql = "SELECT id, nombre, apellidos, ciclo, curso, fecha_alta FROM alumnos WHERE apellidos LIKE ? ORDER BY apellidos, nombre";
        try (Connection cn = ConexionDatos.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, patron.replace('*', '%'));
            try (ResultSet rs = ps.executeQuery()) {
                List<Alumno> out = new ArrayList<>();
                while (rs.next()) {
                    out.add(map(rs));
                }
                return out;
            }
        }
    }

    /**
     * Añade un alumno a la tabla
     * @param a
     * @return
     * @throws SQLException 
     */
    @Override
    public Alumno insertar(Alumno a) throws SQLException {
        String sql = "INSERT INTO alumnos (nombre, apellidos, ciclo, curso, fecha_alta) VALUES (?,?,?,?,?)";
        try (Connection cn = ConexionDatos.getConnection(); PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellidos());
            ps.setString(3, a.getCurso());
            ps.setString(4, a.getCurso());
            // Si fechaAlta es null, dejamos que la BD ponga DEFAULT CURRENT_DATE
            if (a.getAlta() == null) {
                ps.setNull(5, Types.DATE);
            } else {
                ps.setDate(5, new java.sql.Date(a.getAlta().getTime()));
            }
            int n = ps.executeUpdate();
            if (n != 1) {
                throw new SQLException("Insert inesperado, filas afectadas=" + n);
            }
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    a.setId(keys.getInt(1));
                }
            }
            return a;
        }    
    }

    /**
     * Actualiza un alumno
     * @param a
     * @return boolean
     * @throws SQLException 
     */
    @Override
    public boolean update(Alumno a) throws SQLException {
        if (a.getId() == null) {
            throw new IllegalArgumentException("update requiere ID");
        }
        String sql;
        sql = "UPDATE alumnos SET nombre=?, apellidos=?, ciclo=?, curso=?, fecha_alta=? WHERE id=?";
        try (Connection cn = ConexionDatos.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellidos());
            ps.setString(3, a.getCiclo());
            ps.setString(4, a.getCurso());
            ps.setDate(5, (a.getAlta() != null) ? new java.sql.Date(a.getAlta().getTime()) : null);
            ps.setInt(6, a.getId());
            return ps.executeUpdate() == 1;
        }
    }

    /**
     * Borra un alumno dado su id
     * @param id
     * @return boolean
     * @throws SQLException 
     */
    @Override
    public boolean borrarId(int id) throws SQLException {
        String sql = "DELETE FROM alumnos WHERE id = ?";
        try (Connection cn = ConexionDatos.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        }
    }

    /**
     * Devuelve el número de alumnos
     * @return int
     * @throws SQLException 
     */
    @Override
    public long contar() throws SQLException {
        String sql = "SELECT COUNT(*) FROM alumnos";
        try (Connection cn = ConexionDatos.getConnection(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            rs.next();
            return rs.getLong(1);
        }
    }
    
}
