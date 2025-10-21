/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.dam.ejemploclase4.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Clase que representa a un alumno
 * @author jose
 */
public class Alumno {
    private Integer id;
    private String nombre;
    private String apellidos;
    private Date alta;
    private String ciclo;
    private String curso;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    /**
     * Constructor con todos los elementos
     * @param id
     * @param nombre Nombre del alumnos
     * @param apellidos Apellidos
     * @param alta Fecha de alta en el sistema
     * @param ciclo Ciclo que cursa
     * @param curso Año en el que está
     */
    public Alumno(Integer id, String nombre, String apellidos, Date alta, String ciclo, String curso){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.alta = alta;
        this.ciclo = ciclo;
        this.curso = curso;
    }
    
    /*
    * Constructor sin ID, la BD lo asigna por defecto
    */
    public Alumno(String nombre, String apellidos, Date alta, String ciclo, String curso){
        this(null, nombre, apellidos, alta, ciclo, curso);
    }
    /**
     * Constructor vacío para el map de AlumnoDAO
     */
    Alumno() {}
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the alta
     */
    public Date getAlta() {
        return alta;
    }
    
    /**
     * @return the alta
     */
    public String getAltaString() {
        return sdf.format(alta);
    }
    
    /**
     * @param alta the alta to set in String dormat
     */
    public void setAlta(String alta) {
        try {
            this.alta = sdf.parse(alta);
        } catch (ParseException ex) {
            System.getLogger(Alumno.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            this.alta = new Date();
        }
    }
    
    /** 
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * @param id
     */
    public void setId(Integer id){
        this.id = id;
    }
    
    /**
     * @param alta the alta to set
     */
    public void setAlta(Date alta) {
        this.alta = alta;
    }

    /**
     * @return the ciclo
     */
    public String getCiclo() {
        return ciclo;
    }

    /**
     * @param ciclo the ciclo to set
     */
    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * Pasa el alumno a un array de cadenas
     * @return String Array sa
     */
    public String[] toStringArray() {
        String[] sa = new String[5];
        sa[0] = nombre;
        sa[1] = apellidos;
        sa[2] = sdf.format(alta);
        sa[3] = ciclo;
        sa[4] = curso;
        return sa;
    }
    
    /*
    * Compara dos alumnos
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Alumno)) {
            return false;
        }
        Alumno a = (Alumno) o;
        return Objects.equals(id, a.id);
    }
    
    /*
    * Devuelve el hash de un objeto alumno, vinculado al id
    */
    @Override 
    public int hashCode() { 
        return Objects.hash(id); 
    }
}
