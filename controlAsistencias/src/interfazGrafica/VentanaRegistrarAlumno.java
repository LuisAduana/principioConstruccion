package interfazGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import logicaDeNegocios.ExcepcionPersonal;
import logicaDeNegocios.Validadores;

/**
*
* @author BiiR4
*/
public class VentanaRegistrarAlumno extends JDialog implements ActionListener {

  private JButton cancelar;
  private JButton registrar;
  private JCheckBox repite;
  private JLabel labelMatricula;
  private JLabel labelNombreAlumno;
  private JLabel labelApeMaterno;
  private JLabel labelApePaterno;
  private JLabel labelTitulo;
  private JTextField textoMatricula;
  private JTextField textoNombreAlumno;
  private JTextField textoApeMaterno;
  private JTextField textoApePaterno;
  private JPanel panelAlumno;
  
  public VentanaRegistrarAlumno(VentanaPrincipal ventanaPrincipal, boolean modal) {
    super(ventanaPrincipal, modal);
    setSize(500, 350);
    setTitle("Registro");
    setLocationRelativeTo(null);
    setResizable(false);
    cargarPanel();
    setVisible(true);
  }
  
  private void cargarBotones() {
    registrar = new JButton();
    registrar.setBounds(150, 275, 100, 28);
    registrar.setText("REGISTRAR");
    registrar.addActionListener(this);
    registrar.setLayout(null);
    panelAlumno.add(registrar);
    
    cancelar = new JButton();
    cancelar.setBounds(280, 275, 100, 28);
    cancelar.setText("CANCELAR");
    cancelar.addActionListener(this);
    cancelar.setLayout(null);
    panelAlumno.add(cancelar);
  }  
  
  private void cargarTextFields() {
    textoMatricula = new JTextField();
    textoMatricula.setBounds(180, 83, 200, 28);
    textoMatricula.setLayout(null);
    panelAlumno.add(textoMatricula);
    
    textoNombreAlumno = new JTextField();
    textoNombreAlumno.setBounds(180, 123, 200, 28);
    textoNombreAlumno.setLayout(null);
    panelAlumno.add(textoNombreAlumno);
    
    textoApeMaterno = new JTextField();
    textoApeMaterno.setBounds(180, 163, 200, 28);
    textoApeMaterno.setLayout(null);
    panelAlumno.add(textoApeMaterno);
    
    textoApePaterno = new JTextField();
    textoApePaterno.setBounds(180, 203, 200, 28);
    textoApePaterno.setLayout(null);
    panelAlumno.add(textoApePaterno);
  }
  
  private void cargarLabels() {
    
    labelMatricula = new JLabel();
    labelMatricula.setBounds(25, 85, 150, 20);
    labelMatricula.setHorizontalAlignment(SwingConstants.RIGHT);
    labelMatricula.setText("Matricula: ");
    labelMatricula.setLayout(null);
    panelAlumno.add(labelMatricula);
    
    labelNombreAlumno = new JLabel();
    labelNombreAlumno.setBounds(25, 125, 150, 20);
    labelNombreAlumno.setHorizontalAlignment(SwingConstants.RIGHT);
    labelNombreAlumno.setText("Nombre: ");
    labelNombreAlumno.setLayout(null);
    panelAlumno.add(labelNombreAlumno);
    
    labelApePaterno = new JLabel();
    labelApePaterno.setBounds(25, 165, 150, 20);
    labelApePaterno.setHorizontalAlignment(SwingConstants.RIGHT);
    labelApePaterno.setText("Ape. Paterno: ");
    labelApePaterno.setLayout(null);
    panelAlumno.add(labelApePaterno);

    labelApeMaterno = new JLabel();
    labelApeMaterno.setBounds(25, 205, 150, 20);
    labelApeMaterno.setHorizontalAlignment(SwingConstants.RIGHT);
    labelApeMaterno.setText("Ape. Materno: ");
    labelApeMaterno.setLayout(null);
    panelAlumno.add(labelApeMaterno);
    
    repite = new JCheckBox();
    repite.setBounds(235, 245,150, 20);
    repite.setHorizontalAlignment(SwingConstants.RIGHT);
    repite.setText("Repite");
    repite.setLayout(null);
    panelAlumno.add(repite);
    
  }
  
  private void cargarLabelTitulo() {
    labelTitulo = new JLabel();
    labelTitulo.setBounds(50, 25, 400, 30);
    labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
    labelTitulo.setText("REGISTRAR ALUMNO");
    labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
    labelTitulo.setLayout(null);
    panelAlumno.add(labelTitulo);
  }
  
  private void cargarPanel() {
    panelAlumno = new JPanel();
    panelAlumno.setBounds(0, 0, 500, 350);
    panelAlumno.setLayout(null);
    this.add(panelAlumno);
    cargarLabelTitulo();
    cargarLabels();
    cargarTextFields();
    cargarBotones();
  }
  
  @Override
  public void actionPerformed(ActionEvent evento) {
    if(evento.getSource() == registrar) {
      registrar();
    }
    if(evento.getSource() == cancelar) {
      dispose();
    }
  }
  
  private void registrar() {
    Validadores validar = new Validadores();
    String matricula = textoMatricula.getText().trim();
    String nombreAlumno = textoNombreAlumno.getText().trim();
    String apellidoMatAlumno = textoApeMaterno.getText().trim();
    String apellidoPatAlumno = textoApePaterno.getText().trim();
    try {
      validar.validarMatricula(matricula);
      validar.validarNombreAlumno(nombreAlumno);
      validar.validarApellidoMaterno(apellidoMatAlumno);
      validar.validarApellidoPaterno(apellidoPatAlumno);
    } catch (ExcepcionPersonal excepcion) {
      JOptionPane.showMessageDialog(null, "" + excepcion.getMessage() + "");
    }
  }
  
}
