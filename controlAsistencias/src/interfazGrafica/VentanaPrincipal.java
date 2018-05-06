package interfazGrafica;

import java.awt.Color;
import javax.swing.JFrame;

/**
*
* @author BiiR4
*/
public class VentanaPrincipal extends JFrame {
  
  VentanaExperiencias panelExperiencia = new VentanaExperiencias();
  
  public VentanaPrincipal() {
    setSize(540, 650);
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);
    setLocationRelativeTo(null);
    setResizable(false);
    setTitle("Experiencias Educativas");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(panelExperiencia);
  }
  

}
