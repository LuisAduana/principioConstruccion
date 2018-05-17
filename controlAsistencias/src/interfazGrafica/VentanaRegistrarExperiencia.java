package interfazGrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import logicaDeNegocios.ExperienciaEducativa;
import logicaDeNegocios.RegistrarBaseDatos;

/**
*
* @author BiiR4
*/
public class VentanaRegistrarExperiencia extends JDialog implements ActionListener {

  private JButton cancelar;
  private JButton registrar;
  private JLabel labelTitulo;
  private JLabel labelNombreExp;
  private JLabel labelNrc;
  private JPanel panelExperiencia;
  private JTextField nombreTexto;
  private JTextField nrcTexto;
  
  public VentanaRegistrarExperiencia(VentanaPrincipal ventanaPrincipal, boolean modal) {
    super(ventanaPrincipal, modal);
    setSize(500, 350);
    setTitle("Registro");
    setLocationRelativeTo(null);
    setResizable(false);
    cargarPanel();
    setVisible(true);
  }

  private void cargarPanel() {
    panelExperiencia = new JPanel();
    panelExperiencia.setBounds(0, 0, 500, 350);
    panelExperiencia.setLayout(null);
    this.add(panelExperiencia);
    cargarLabelTitulo();
    cargarLabels();
    cargarTextFields();
    cargarBotones();
  }
  
  private void cargarBotones() {
    registrar = new JButton();
    registrar.setBounds(150, 220, 100, 28);
    registrar.setText("REGISTRAR");
    registrar.addActionListener(this);
    registrar.setLayout(null);
    panelExperiencia.add(registrar);
    
    cancelar = new JButton();
    cancelar.setBounds(280, 220, 100, 28);
    cancelar.setText("CANCELAR");
    cancelar.addActionListener(this);
    cancelar.setLayout(null);
    panelExperiencia.add(cancelar);
  }
  
  private void cargarTextFields() {
    nombreTexto = new JTextField();
    nombreTexto.setBounds(180, 122, 200, 28);
    nombreTexto.setLayout(null);
    panelExperiencia.add(nombreTexto);
    
    nrcTexto = new JTextField();
    nrcTexto.setBounds(180, 163, 200, 28);
    nrcTexto.setLayout(null);
    panelExperiencia.add(nrcTexto);
  }
  
  private void cargarLabels() {
    labelNombreExp = new JLabel();
    labelNombreExp.setBounds(25, 125, 150, 20);
    labelNombreExp.setHorizontalAlignment(SwingConstants.RIGHT);
    labelNombreExp.setText("Nombre: ");
    labelNombreExp.setLayout(null);
    panelExperiencia.add(labelNombreExp);
    
    labelNrc = new JLabel();
    labelNrc.setBounds(25, 165, 150, 20);
    labelNrc.setHorizontalAlignment(SwingConstants.RIGHT);
    labelNrc.setText("NRC: ");
    labelNrc.setLayout(null);
    panelExperiencia.add(labelNrc);    
  }
  
  private void cargarLabelTitulo() {
    labelTitulo = new JLabel();
    labelTitulo.setBounds(50, 25, 400, 30);
    labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
    labelTitulo.setText("REGISTRAR EXPERIENCIA EDUCATIVA");
    labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
    labelTitulo.setLayout(null);
    panelExperiencia.add(labelTitulo);
  }
  
  @Override
  public void actionPerformed(ActionEvent evento) {
    if(evento.getSource() == registrar){
      registrar();
    }
    if(evento.getSource() == cancelar) {
      dispose();
    }
  }
  
  private void registrar() {
    RegistrarBaseDatos registrar = new RegistrarBaseDatos();
    Integer nrc = registrar.enviarNrc(nrcTexto.getText().trim());
    if(nrc != null) {
      int nrcEntero = Integer.parseInt(nrcTexto.getText().trim());
      if(nrcEntero > 9999.9 && nrcEntero < 100000) {
        ExperienciaEducativa experiencia = new ExperienciaEducativa();
        experiencia.setNombreExperiencia(nombreTexto.getText().trim());
        experiencia.setNrc(nrc);
        registrar.registrarExperiencia(experiencia);
      } else {
        JOptionPane.showMessageDialog(null, "Debe ingresar un NRC válido", "Advertencia",
            JOptionPane.ERROR_MESSAGE);
      }
    } else {
      JOptionPane.showMessageDialog(null, "Debe ingresar un NRC válido", "Advertencia", 
          JOptionPane.ERROR_MESSAGE);
    }
  }
}
