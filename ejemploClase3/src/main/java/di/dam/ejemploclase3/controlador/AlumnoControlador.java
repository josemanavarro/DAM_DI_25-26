/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.dam.ejemploclase3.controlador;

import di.dam.ejemploclase3.modelo.Alumno;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Logica de negocio para los alumnos
 * @author jose
 */
public class AlumnoControlador {
    private List<Alumno> listaAlumnos;
    
    /**
     * Constructor con dos ejemplos
     */
    public AlumnoControlador(){
        listaAlumnos = new ArrayList<>();
        listaAlumnos.add(new Alumno("José Manuel","Navarro",new Date(),"DAM","2º"));
        listaAlumnos.add(new Alumno("Anakin","SkyWalker",new Date(),"ASIR","1º"));
    }

    /**
     * @return the listaAlumnos
     */
    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    /**
     * @param listaAlumnos the listaAlumnos to set
     */
    public void setListaAlumnos(List<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
    
    /**
    * Añade un alumno
    */
    public void altaAlumno(Alumno alumno){
        listaAlumnos.add(alumno);
    }
    
    
}
