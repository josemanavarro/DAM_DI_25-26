/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestGUI;

import di.dam.ejemploclase9.vista.VistaCalculadora;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.image.ScreenshotTaker;
import org.junit.jupiter.api.*;

/**
 *
 * @author jose
 */
public class TestUnitarioVisualCalculadora {
    
    private FrameFixture window;
    
    @BeforeAll
    public static void setupOnce(){
        // Obliga a que todo se repinte si falla un test
        FailOnThreadViolationRepaintManager.install();
    }
    
    @BeforeEach
    void setUp(){
        VistaCalculadora ventanaPrincipal = GuiActionRunner.execute(() -> new VistaCalculadora());
        window = new FrameFixture(ventanaPrincipal);
       
        // Medio segundo entre operaciones, para que lo veamos
        window.robot().settings().delayBetweenEvents(10);
        window.show();
    }
    
    @AfterEach
    void tearDown(TestInfo testInfo){
        
        try{
            // Hacemos una captura por test:
            ScreenshotTaker capturadora = new ScreenshotTaker();
            String marcaTemporal = String.valueOf(System.currentTimeMillis());
            String nombreFichero = marcaTemporal + "_" + testInfo.getDisplayName().replace("()", "")+".png";            
            capturadora.saveDesktopAsPng(nombreFichero);
        } catch (Exception e){
            // Por si falla en algún momento
            System.err.println("Ha fallado la captura del test: " + e.getMessage());
        } finally {
            // Limpia pase lo que pase
            window.cleanUp();
        }
    }
    
    @Test
    void debeSumarCorrectamente(){
        window.textBox("JTextFieldNumero1").enterText("10");
        window.textBox("JTextFieldNumero2").enterText("10");
        window.button("JButtonSumar").click();
        
        window.label("JLabelResultado").requireText("20.0");
    }
    
    @Test
    void debeDividirCorrectamente(){
        window.textBox("JTextFieldNumero1").enterText("10");
        window.textBox("JTextFieldNumero2").enterText("2");
        window.button("JButtonDividir").click();
        
        window.label("JLabelResultado").requireText("5.0");
    }
    
    @Test
    void debeFallarDividiendo(){
        window.textBox("JTextFieldNumero1").enterText("10");
        window.textBox("JTextFieldNumero2").enterText("0");
        window.button("JButtonDividir").click();
        
        window.label("JLabelResultado").requireText("ERROR");
    }
}
