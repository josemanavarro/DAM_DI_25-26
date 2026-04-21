/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.dam.ejemploclase9.vista;

import di.dam.ejemploclase9.controlador.ServicioCalculadora;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jose
 */
public class VistaCalculadora extends JFrame{
    
    private JTextField JTextFieldNumero1, JTextFieldNumero2;
    private JLabel JLabelResultado;
    private JButton JButtonSumar, JButtonRestar, JButtonMultiplicar, JButtonDividir;
    private ServicioCalculadora sc;
    
    public VistaCalculadora(){
        // Ponemos título
        this.setTitle("Calculadora DAM Test");
        
        this.setSize(500, 80);
        
        // Ponemos un Layout:
        setLayout(new FlowLayout());
        
        // Creamos los componenes:
        JTextFieldNumero1 = new JTextField(5);        
        JTextFieldNumero2 = new JTextField(5);
        
        JTextFieldNumero1.setName("JTextFieldNumero1");
        JTextFieldNumero2.setName("JTextFieldNumero2");
        
        JButtonSumar = new JButton("+");
        JButtonRestar = new JButton("-");
        JButtonMultiplicar = new JButton("*");
        JButtonDividir = new JButton("/");
        
        JButtonSumar.setName("JButtonSumar");
        JButtonRestar.setName("JButtonRestar");
        JButtonMultiplicar.setName("JButtonMultiplicar");
        JButtonDividir.setName("JButtonDividir");
        
        JLabelResultado = new JLabel("0.0");
        JLabelResultado.setName("JLabelResultado");
               
        
        // Creamos los eventos
        JButtonSumar.addActionListener(e -> calcular("+"));
        JButtonRestar.addActionListener(e -> calcular("-"));
        JButtonMultiplicar.addActionListener(e -> calcular("*"));
        JButtonDividir.addActionListener(e -> calcular("/"));
        
        // Añadimos los componentes al panel
        this.add(JTextFieldNumero1);
        this.add(JTextFieldNumero2);
        this.add(JButtonSumar);
        this.add(JButtonRestar);
        this.add(JButtonMultiplicar);
        this.add(JButtonDividir);
        this.add(JLabelResultado);
        
        sc = new ServicioCalculadora();
        pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

    private void calcular(String operador) {
        try{
            double operando1 = Double.parseDouble(JTextFieldNumero1.getText());
            double operando2 = Double.parseDouble(JTextFieldNumero2.getText());
            double resultado = sc.calcula(operando1,operando2,operador);
            this.JLabelResultado.setText(String.valueOf(resultado));
        }
        catch (Exception ex){
            this.JLabelResultado.setText("ERROR");
            ex.printStackTrace();
        }
    }
}
