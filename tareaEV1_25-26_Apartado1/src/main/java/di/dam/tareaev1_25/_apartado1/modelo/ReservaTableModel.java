/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.dam.tareaev1_25._apartado1.modelo;


import javax.swing.table.AbstractTableModel;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author jose
 */
public class ReservaTableModel extends AbstractTableModel {

    private final String[] columnNames = {
            "Hora", "Pista", "Cliente", "Teléfono", "Fecha", "Estado"
    };

    private final List<Reserva> reservas;

    private final DateTimeFormatter dateFormatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DateTimeFormatter timeFormatter =
            DateTimeFormatter.ofPattern("HH:mm");

    public ReservaTableModel(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public int getRowCount() {
        return reservas.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reserva r = reservas.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> r.getHora() != null ? r.getHora().format(timeFormatter) : "";
            case 1 -> r.getPista();
            case 2 -> r.getNombreCliente();
            case 3 -> r.getTelefono();
            case 4 -> r.getFecha() != null ? r.getFecha().format(dateFormatter) : "";
            case 5 -> r.getEstado();
            default -> "";
        };
    }

    public Reserva getReservaAt(int rowIndex) {
        if (rowIndex < 0 || rowIndex >= reservas.size()) {
            return null;
        }
        return reservas.get(rowIndex);
    }

    public void fireDataChanged() {
        fireTableDataChanged();
    }
}
