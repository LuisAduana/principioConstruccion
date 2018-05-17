package interfazGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import logicaDeNegocios.ConsultasBaseDatos;
import logicaDeNegocios.EliminacionBaseDatos;
import logicaDeNegocios.ExcepcionPersonal;
import logicaDeNegocios.ExperienciaEducativa;
import logicaDeNegocios.RegistrarBaseDatos;
import logicaDeNegocios.Validadores;

/**
*
* @author BiiR4
*/
public class VentanaConsultaExperiencia extends JDialog implements ActionListener{

  private JButton buscar;
  private JButton eliminar;
  private JButton cancelar;
  private JButton modificar;
  private JButton nuevo;
  private JPanel panelConsulta;
  private JLabel labelTitulo;
  private JLabel labelBuscarNrc;
  private JLabel labelNombreExp;
  private JLabel labelNrc;
  private JLabel labelNoClases;
  private JTextField idNrc;
  private JTextField nombreTexto;
  private JTextField nrcBuscar;
  private JTextField nrcTexto;
  private JTextField noClasesTexto;
  
  VentanaConsultaExperiencia(VentanaPrincipal ventanaPrincipal, boolean modal) {
    super(ventanaPrincipal, modal);
    setSize(500, 400);
    setTitle("Consultar");
    setLocationRelativeTo(null);
    setResizable(false);
    cargarPanel();
    setVisible(true);
  }
  
  private void cargarPanel() {
    panelConsulta = new JPanel();
    panelConsulta.setBounds(0, 0, 500, 400);
    panelConsulta.setLayout(null);
    this.add(panelConsulta);
    cargarLabelTitulo();
    cargarLabels();
    cargarTextFields();
    cargarBotones();
  }
  
  private void cargarBotones() {
    
    nuevo = new JButton();
    nuevo.setBounds(355, 98, 100,28);
    nuevo.setText("NUEVO");
    nuevo.addActionListener(this);
    nuevo.setLayout(null);
    nuevo.setVisible(false);
    panelConsulta.add(nuevo);
    
    buscar = new JButton();
    buscar.setBounds(355, 98, 100,28);
    buscar.setText("BUSCAR");
    buscar.addActionListener(this);
    buscar.setLayout(null);
    buscar.setVisible(true);
    panelConsulta.add(buscar);
    
    eliminar = new JButton();
    eliminar.setBounds(80, 320, 100, 28);
    eliminar.setText("ELIMINAR");
    eliminar.addActionListener(this);
    eliminar.setLayout(null);
    panelConsulta.add(eliminar);
    
    modificar = new JButton();
    modificar.setBounds(205, 320, 100, 28);
    modificar.setText("MODIFICAR");
    modificar.addActionListener(this);
    modificar.setLayout(null);
    panelConsulta.add(modificar);
    
    cancelar = new JButton();
    cancelar.setBounds(330, 320, 100, 28);
    cancelar.setText("CANCELAR");
    cancelar.addActionListener(this);
    cancelar.setLayout(null);
    panelConsulta.add(cancelar);
  }
  
  private void cargarTextFields() {
    
    nrcBuscar = new JTextField();
    nrcBuscar.setBounds(135, 98, 200, 28);
    nrcBuscar.setLayout(null);
    panelConsulta.add(nrcBuscar);
    
    nombreTexto = new JTextField();
    nombreTexto.setBounds(140, 168, 300, 28);
    nombreTexto.setLayout(null);
    nombreTexto.setEditable(false);
    panelConsulta.add(nombreTexto);
    
    nrcTexto = new JTextField();
    nrcTexto.setBounds(140, 208, 300, 28);
    nrcTexto.setLayout(null);
    nrcTexto.setEditable(false);
    panelConsulta.add(nrcTexto);
    
    noClasesTexto = new JTextField();
    noClasesTexto.setBounds(140, 248, 300, 28);
    noClasesTexto.setLayout(null);
    noClasesTexto.setEditable(false);
    panelConsulta.add(noClasesTexto);
    
    idNrc = new JTextField();
    idNrc.setBounds(0, 0, 70, 28);
    idNrc.setLayout(null);
    idNrc.setVisible(false);
    panelConsulta.add(idNrc);
  }
  
  private void cargarLabels() {
    
    labelBuscarNrc = new JLabel();
    labelBuscarNrc.setBounds(0, 100, 130, 20);
    labelBuscarNrc.setHorizontalAlignment(SwingConstants.RIGHT);
    labelBuscarNrc.setText("NRC a buscar: ");
    labelBuscarNrc.setLayout(null);
    panelConsulta.add(labelBuscarNrc);
    
    labelNombreExp = new JLabel();
    labelNombreExp.setBounds(25, 171, 100, 20);
    labelNombreExp.setHorizontalAlignment(SwingConstants.RIGHT);
    labelNombreExp.setText("Nombre: ");
    labelNombreExp.setLayout(null);
    panelConsulta.add(labelNombreExp);
    
    labelNrc = new JLabel();
    labelNrc.setBounds(25, 211, 100, 20);
    labelNrc.setHorizontalAlignment(SwingConstants.RIGHT);
    labelNrc.setText("NRC: ");
    labelNrc.setLayout(null);
    panelConsulta.add(labelNrc);
    
    labelNoClases = new JLabel();
    labelNoClases.setBounds(25, 250, 100, 20);
    labelNoClases.setHorizontalAlignment(SwingConstants.RIGHT);
    labelNoClases.setText("No. de Clases: ");
    labelNoClases.setLayout(null);
    panelConsulta.add(labelNoClases);
    
  }
  
  private void cargarLabelTitulo() {
    labelTitulo = new JLabel();
    labelTitulo.setBounds(50, 25, 400, 30);
    labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
    labelTitulo.setText("CONSULTAR EXPERIENCIA EDUCATIVA");
    labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
    labelTitulo.setLayout(null);
    panelConsulta.add(labelTitulo);
  }
  
  @Override
  public void actionPerformed(ActionEvent evento) {
    if(evento.getSource() == buscar) {
      consultarExperiencia();
    }
    
    if(evento.getSource() == modificar) {
      modificarExperiencia();
    }
    
    if(evento.getSource() == cancelar) {
      limpiarVentana();
      dispose();
    }
    
    if(evento.getSource() == eliminar) {
      eliminarExperiencia();
    }
    
    if(evento.getSource() == nuevo) {
      limpiarVentana();
      nuevo.setVisible(false);
      buscar.setVisible(true);
      nrcBuscar.setEditable(true);
      nombreTexto.setEditable(false);
      nrcTexto.setEditable(false);
      noClasesTexto.setEditable(false);
      repaint();
    }
  }
  
  private void eliminarExperiencia() {
    String idExp = idNrc.getText();
      if("".equals(idExp)) {
        JOptionPane.showMessageDialog(null, "Debe buscar un usuario para eliminarlo");
      } else {
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas eliminar la"
            + " E.E?");
        if(JOptionPane.OK_OPTION == respuesta){
          EliminacionBaseDatos eliminar = new EliminacionBaseDatos();
          if(eliminar.eliminarExperiencia(idExp)) {
            JOptionPane.showMessageDialog(null, "Experiencia eliminada con éxito");
            nuevo.setVisible(false);
            buscar.setVisible(true);
            nrcBuscar.setEditable(true);
            nombreTexto.setEditable(false);
            nrcTexto.setEditable(false);
            noClasesTexto.setEditable(false);
            limpiarVentana();
          } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar Experiencia");
          }
        } else {
          // Si el dialogo no se confirma entonces simplemente no se hace nada
        }
      }
  }
  
  private void modificarExperiencia() {
    String idExp = idNrc.getText();
    if("".equals(idExp)) {
      JOptionPane.showMessageDialog(null, "Debe buscar un usuario para modificarlo");
    } else {
      int nrcExperiencia = Integer.parseInt(idNrc.getText());
      RegistrarBaseDatos registrar = new RegistrarBaseDatos();
      Integer nrc = registrar.enviarNrc(nrcTexto.getText().trim());
      Integer noClases = registrar.enviarNoClases(noClasesTexto.getText().trim());
      if(nrc != null) {
        if(noClases != null) {
          int nrcEntero = Integer.parseInt(nrcTexto.getText().trim());
          int noDeClases = Integer.parseInt(noClasesTexto.getText().trim());
          String nombreExperiencia = nombreTexto.getText().trim();
          Validadores validar = new Validadores();
          try {

            validar.validarModificarIntNrc(nrcEntero);
            validar.validarNoDeClases(noDeClases);
            validar.validarModificarNombreExperiencia(nombreExperiencia);

            ExperienciaEducativa experiencia = new ExperienciaEducativa();
            experiencia.setNombreExperiencia(nombreExperiencia);
            experiencia.setNrc(nrcEntero);
            experiencia.setNoClases(noDeClases);

            registrar.modificarExperiencia(experiencia, nrcExperiencia);
          } catch (ExcepcionPersonal excepcion) {
            JOptionPane.showMessageDialog(null, "" + excepcion.getMessage() + "");
          }

        } else {
          JOptionPane.showMessageDialog(null, "Ingrese un No. de Clases válido", "ERROR", 
              JOptionPane.WARNING_MESSAGE);
        }
      } else {
        JOptionPane.showMessageDialog(null, "Ingrese un NRC válido", "ERROR", 
            JOptionPane.WARNING_MESSAGE);
      }
    }
  }
  
  private void limpiarVentana() {
    nombreTexto.setText("");
    nrcBuscar.setText("");
    nrcTexto.setText("");
    noClasesTexto.setText("");
    idNrc.setText("");
  }
  
  private void consultarExperiencia() {
    RegistrarBaseDatos registrar = new RegistrarBaseDatos();
    Integer nrc = registrar.enviarNrc(nrcBuscar.getText().trim());
    if(nrc != null) {
      int nrcEntero = Integer.parseInt(nrcBuscar.getText().trim());
      Validadores validar = new Validadores();
      try {
        
        validar.validarNrcBuscar(nrcEntero);
        ConsultasBaseDatos consulta = new ConsultasBaseDatos();
        ExperienciaEducativa experiencia = consulta.consultarExperiencia(nrcBuscar.getText().trim());

        if(experiencia != null) {
          nombreTexto.setText(experiencia.getNombreExperiencia());
          nrcTexto.setText(experiencia.getNrc()+"");
          idNrc.setText(experiencia.getNrc()+"");
          noClasesTexto.setText(experiencia.getNoClases()+"");

          nombreTexto.setEditable(true);
          nrcTexto.setEditable(true);
          noClasesTexto.setEditable(true);
          buscar.setVisible(false);
          nrcBuscar.setEditable(false);
          nuevo.setVisible(true);
        } else {
          JOptionPane.showMessageDialog(null, "NRC NO ENCONTRADO", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
      } catch (ExcepcionPersonal excepcion) {
        JOptionPane.showMessageDialog(null, "" + excepcion.getMessage() + "");
      }
    } else {
      JOptionPane.showMessageDialog(null, "Ingrese un NRC válido", "Advertencia", 
          JOptionPane.ERROR_MESSAGE);
    }
  }
  
}
