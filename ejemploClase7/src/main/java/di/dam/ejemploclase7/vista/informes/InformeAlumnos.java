/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.dam.ejemploclase7.vista.informes;

import di.dam.ejemploclase7.modelo.Alumno;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


/**
 *
 * @author jose
 */
public class InformeAlumnos {
    public void generarInforme(List<Alumno> listaAlumnos){
        try {
            System.out.println("Iniciando generación del reporte...");

            InputStream reportStream = InformeAlumnos.class
                    .getResourceAsStream("/Ejemplo_1_Clase_A4.jrxml");

            if (reportStream == null) {
                System.err.println("❌ ERROR: No se encontró el archivo .jrxml en resources.");
                return;
            }

            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaAlumnos);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

            String salida = "Mi_Primer_Reporte.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, salida);

            System.out.println("✅ ¡Éxito! El reporte se generó en: " + System.getProperty("user.dir") + "\\" + salida);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
