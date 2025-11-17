/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.dam.ejemploclase6componente3;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author jose
 */
public class ImagenFondoJPanelPropertyEditorSupport extends PropertyEditorSupport{

    private ImagenFondoJPanel ifp = new ImagenFondoJPanel();
            
    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return ifp;
    }

    @Override
    public String getJavaInitializationString() {
        return "new di.dam.ejemploclase6componente3.ImagenFondo(new java.io.File(\""+ifp.getSelectedValue().getRutaImagen()+"\"),"+ifp.getSelectedValue().getOpacidad()+"f)"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public Object getValue() {
        return ifp.getSelectedValue();
    }
    
}
