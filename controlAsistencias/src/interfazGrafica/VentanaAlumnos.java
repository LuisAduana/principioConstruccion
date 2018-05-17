package interfazGrafica;

import static interfazGrafica.VentanaExperiencias.nrc;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.JTableHeader;
import logicaDeNegocios.ConsultasBaseDatos;

/**
*
* @author BiiR4
*/
public class VentanaAlumnos extends JPanel implements ActionListener, MouseListener{
  
  private JButton botonActualizar;
  private JButton botonConsultarAlumno;
  private JButton botonRegistrarAlumno;
  private JButton regresar;
  private JLabel labelImagenLogoUv;
  private JLabel labelTitulo;
  private JScrollPane paneTabla;
  private JTable tablaAlumnos;
  
  VentanaAlumnos(){
    setBounds(0, 0, 540, 650);
    setLayout(null);
    setBackground(Color.YELLOW);
    cargarLabelLogo();
    cargarLabelTitulo();
    cargarBotones();
    setVisible(true);
  }
  
  private void construirTabla() {
    
    ConsultasBaseDatos consulta = new ConsultasBaseDatos();
    String titulos[] = {"Nombre", "Ape. Paterno", "Ape. Materno", "Asistencia"};
    String informacion[][] = consulta.obtenerMatrizAlumno(nrc);
    tablaAlumnos = new JTable(informacion, titulos){
      @Override
      public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;
      }
    };
    tablaAlumnos.setFocusable(false);
    JTableHeader cabecera = tablaAlumnos.getTableHeader();
    cabecera.setPreferredSize(new Dimension(10, 20));
    tablaAlumnos.addMouseListener(this);
    paneTabla.setViewportView(tablaAlumnos);
  }
  
  private void cargarTablaAlumnos() {
    paneTabla = new JScrollPane();
    paneTabla.setBounds(15, 220, 500, 386);
    this.add(paneTabla);
  }
  
  private void cargarBotones() {
    
    botonActualizar = new JButton("ACT");
    botonActualizar.setBounds(460, 150, 40, 40);
    botonActualizar.setLayout(null);
    botonActualizar.addActionListener(this);
    botonActualizar.setToolTipText("Refrescar");
    this.add(botonActualizar);
    
    regresar = new JButton("REG");
    regresar.setBounds(430, 15, 70, 70);
    regresar.setLayout(null);
    regresar.addActionListener(this);
    regresar.setToolTipText("Regresar");
    this.add(regresar);
    
    botonRegistrarAlumno = new JButton("ALU");
    botonRegistrarAlumno.setBounds(240, 15, 70, 70);
    botonRegistrarAlumno.setLayout(null);
    botonRegistrarAlumno.addActionListener(this);
    botonRegistrarAlumno.setToolTipText("Registrar nuevo Alumno");
    this.add(botonRegistrarAlumno);
    
    botonConsultarAlumno = new JButton("MOD");
    botonConsultarAlumno.setBounds(335, 15, 70, 70);
    botonConsultarAlumno.setLayout(null);
    botonConsultarAlumno.addActionListener(this);
    botonConsultarAlumno.setToolTipText("Modificar E.E");
    this.add(botonConsultarAlumno);
  }
  
  private void cargarLabelTitulo() {
    labelTitulo = new JLabel();
    labelTitulo.setBounds(54, 180, 400, 30);
    labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
    labelTitulo.setText("ALUMNOS");
    labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
    labelTitulo.setLayout(null);
    this.add(labelTitulo);
  }
  
  private void cargarLogoUv() {
    ImageIcon imagen = 
        new ImageIcon(getClass().getResource("/imagenes/universidadVeracruzana.png"));
    ImageIcon icono = 
        new ImageIcon(imagen.getImage().getScaledInstance(labelImagenLogoUv.getWidth(), 
        labelImagenLogoUv.getHeight(), Image.SCALE_DEFAULT));
    labelImagenLogoUv.setIcon(icono);
  }
  
  private void cargarLabelLogo() {
    labelImagenLogoUv = new JLabel();
    labelImagenLogoUv.setBounds(15, 15, 173, 140);
    cargarLogoUv();
    labelImagenLogoUv.setLayout(null);
    this.add(labelImagenLogoUv);
  }

  @Override
  public void actionPerformed(ActionEvent evento) {
    VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();

    if(evento.getSource() == regresar) {
      setVisible(false);
      JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
      frame.dispose();      
      ventanaPrincipal.setVisible(true);
    }
    
    if(evento.getSource() == botonRegistrarAlumno) {
      VentanaRegistrarAlumno ventanaRegistro;
      ventanaRegistro = new VentanaRegistrarAlumno(ventanaPrincipal, true);
    }
    
    if(evento.getSource() == botonConsultarAlumno) {
      VentanaConsultaAlumno ventanaConsultaAlumno;
      ventanaConsultaAlumno = new VentanaConsultaAlumno(ventanaPrincipal, true);
    }
    
    if(evento.getSource() == botonActualizar) {
      cargarTablaAlumnos();
      construirTabla();
    }
    
  }

  @Override
  public void mouseClicked(MouseEvent me) {
    
  }

  @Override
  public void mousePressed(MouseEvent me) {
    
  }

  @Override
  public void mouseReleased(MouseEvent me) {

  }

  @Override
  public void mouseEntered(MouseEvent me) {

  }

  @Override
  public void mouseExited(MouseEvent me) {

  }
  
}
