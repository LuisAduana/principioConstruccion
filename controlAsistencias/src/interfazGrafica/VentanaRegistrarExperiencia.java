package interfazGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import logicaDeNegocios.ConsultasBaseDatos;
import logicaDeNegocios.ExcepcionPersonal;
import logicaDeNegocios.ExperienciaEducativa;
import logicaDeNegocios.RegistrarBaseDatos;
import logicaDeNegocios.Validadores;

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
  private JLabel labelNoClases;
  private JPanel panelExperiencia;
  private JTextField nombreTexto;
  private JTextField nrcTexto;
  private JTextField noClasesTexto;
  
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
    registrar.setBounds(150, 240, 100, 28);
    registrar.setText("REGISTRAR");
    registrar.addActionListener(this);
    registrar.setLayout(null);
    panelExperiencia.add(registrar);
    
    cancelar = new JButton();
    cancelar.setBounds(280, 240, 100, 28);
    cancelar.setText("CANCELAR");
    cancelar.addActionListener(this);
    cancelar.setLayout(null);
    panelExperiencia.add(cancelar);
  }
  
  private void cargarTextFields() {
    nombreTexto = new JTextField();
    nombreTexto.setBounds(180, 102, 200, 28);
    nombreTexto.setLayout(null);
    panelExperiencia.add(nombreTexto);
    
    nrcTexto = new JTextField();
    nrcTexto.setBounds(180, 143, 200, 28);
    nrcTexto.setLayout(null);
    panelExperiencia.add(nrcTexto);
    
    noClasesTexto = new JTextField();
    noClasesTexto.setBounds(180, 183, 200, 28);
    noClasesTexto.setLayout(null);
    panelExperiencia.add(noClasesTexto);
    
  }
  
  private void cargarLabels() {
    labelNombreExp = new JLabel();
    labelNombreExp.setBounds(25, 105, 150, 20);
    labelNombreExp.setHorizontalAlignment(SwingConstants.RIGHT);
    labelNombreExp.setText("Nombre: ");
    labelNombreExp.setLayout(null);
    panelExperiencia.add(labelNombreExp);
    
    labelNrc = new JLabel();
    labelNrc.setBounds(25, 145, 150, 20);
    labelNrc.setHorizontalAlignment(SwingConstants.RIGHT);
    labelNrc.setText("NRC: ");
    labelNrc.setLayout(null);
    panelExperiencia.add(labelNrc);

    labelNoClases = new JLabel();
    labelNoClases.setBounds(25, 185, 150, 20);
    labelNoClases.setHorizontalAlignment(SwingConstants.RIGHT);
    labelNoClases.setText("No. de Clases: ");
    labelNoClases.setLayout(null);
    panelExperiencia.add(labelNoClases);
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
    Integer noClases = registrar.enviarNoClases(noClasesTexto.getText().trim());
    if(nrc != null) {
      if(noClases != null) {
        int nrcEntero = Integer.parseInt(nrcTexto.getText().trim());
        int noClasesEntero = Integer.parseInt(noClasesTexto.getText().trim());
        String nombreExperiencia = nombreTexto.getText().trim();
        Validadores validar = new Validadores();
        try {
          validar.validarIntNrc(nrcEntero);
          validar.validarNoDeClases(noClasesEntero);
          validar.validarNombreExperiencia(nombreExperiencia);
          
          ExperienciaEducativa experiencia = new ExperienciaEducativa();
          experiencia.setNombreExperiencia(nombreTexto.getText().trim());
          experiencia.setNrc(nrc);
          experiencia.setNoClases(noClasesEntero);
          registrar.registrarExperiencia(experiencia);
          
          nrcTexto.setText("");
          noClasesTexto.setText("");
          nombreTexto.setText("");
          
        } catch (ExcepcionPersonal excepcion) {
          JOptionPane.showMessageDialog(null, "" + excepcion.getMessage() + "");
        }
      } else {
        JOptionPane.showMessageDialog(null, "Ingrese un No. de Clases válido", "Advertencia", 
          JOptionPane.ERROR_MESSAGE);
      }
    } else {
      JOptionPane.showMessageDialog(null, "Ingrese un NRC válido", "Advertencia", 
          JOptionPane.ERROR_MESSAGE);
    }
  }
}
