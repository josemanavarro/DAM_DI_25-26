/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.dam.ejemploclase7.modelo;

import di.dam.ejemploclase7.controlador.AlumnoControlador;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jose
 */
public class AlumnoTableModel extends AbstractTableModel{
    
    private List<Alumno> listaAlumnos;
    private String[] columnas = {"Nombre","Apellidos","Fecha alta","Ciclo","Curso"};
    
    public AlumnoTableModel(List<Alumno> listaAlumnos){
        super();
        this.listaAlumnos = listaAlumnos;
    }

    @Override
    public int getRowCount() {
        return listaAlumnos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case -2 -> {
                return listaAlumnos.get(rowIndex).getAlta();
            }
            case -1 -> {
                return listaAlumnos.get(rowIndex).getId();
            }
            case 0 -> {
                return listaAlumnos.get(rowIndex).getNombre();
            }
            case 1 -> {
                return listaAlumnos.get(rowIndex).getApellidos();
            }
            case 2 -> {
                return listaAlumnos.get(rowIndex).getAltaString();
            }
            case 3 -> {
                return listaAlumnos.get(rowIndex).getCiclo();
            }
            case 4 -> {
                return listaAlumnos.get(rowIndex).getCurso();
            }
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column){
        return columnas[column];
    }
    
    
}
