package interfazGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author BiiR4
 */
public class VentanaConsultaAlumno extends JDialog implements ActionListener{
  
  private JPanel panelConsulta;

  VentanaConsultaAlumno(VentanaPrincipal ventanaPrincipal, boolean modal) {
    super(ventanaPrincipal, modal);
    setSize(500, 350);
    setTitle("Consultar");
    setLocationRelativeTo(null);
    setResizable(false);
    cargarPanel();
    setVisible(true);
  }
  
  private void cargarPanel() {
    panelConsulta = new JPanel();
    panelConsulta.setBounds(0, 0, 500, 350);
    panelConsulta.setLayout(null);
    this.add(panelConsulta);
    //cargarLabelTitulo();
    //cargarLabels();
    //cargarTextFields();
    //cargarBotones();
  }
  
  @Override
  public void actionPerformed(ActionEvent ae) {
    
  }
  
}
