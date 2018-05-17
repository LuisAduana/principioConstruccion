package interfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;
import logicaDeNegocios.ConsultasBaseDatos;

/**
*
* @author BiiR4
*/
public class VentanaExperiencias extends JPanel implements ActionListener, MouseListener {
  
  private int fila = 0;
  static int nrc = 0;
  private JButton botonActualizar;
  private JButton botonModificarExperiencia;
  private JButton botonPasarLista;
  private JButton botonRegistrarExperiencia;
  private JLabel labelImagenLogoUv;
  private JLabel labelTitulo;
  private JScrollPane paneTabla;
  private JTable tablaExperiencias;
  private String nrcSeleccionado = "";
      
  VentanaExperiencias() {
    setBounds(0, 0, 540, 650);
    setLayout(null);
    setBackground(Color.BLUE);
    cargarLabelLogo();
    cargarLabelTitulo();
    cargarTablaExperiencias();
    construirTabla();
    cargarBotones();
    setVisible(false);
  }
  
  private void cargarBotones() {
    
    botonActualizar = new JButton("ACT");
    botonActualizar.setBounds(460, 150, 40, 40);
    botonActualizar.setLayout(null);
    botonActualizar.addActionListener(this);
    botonActualizar.setToolTipText("Refrescar");
    this.add(botonActualizar);
    
    botonPasarLista = new JButton("LIS");
    botonPasarLista.setBounds(430, 15, 70, 70);
    botonPasarLista.setLayout(null);
    botonPasarLista.addActionListener(this);
    botonPasarLista.setToolTipText("Pasar lista");
    this.add(botonPasarLista);
    
    botonRegistrarExperiencia = new JButton("EXP");
    botonRegistrarExperiencia.setBounds(240, 15, 70, 70);
    botonRegistrarExperiencia.setLayout(null);
    botonRegistrarExperiencia.addActionListener(this);
    botonRegistrarExperiencia.setToolTipText("Registrar nueva E.E");
    this.add(botonRegistrarExperiencia);
    
    botonModificarExperiencia = new JButton("MOD");
    botonModificarExperiencia.setBounds(335, 15, 70, 70);
    botonModificarExperiencia.setLayout(null);
    botonModificarExperiencia.addActionListener(this);
    botonModificarExperiencia.setToolTipText("Modificar E.E");
    this.add(botonModificarExperiencia);
    
  }
  
  private void construirTabla() {
    ConsultasBaseDatos consulta = new ConsultasBaseDatos();
    String titulos[] = {"Experiencia Educativa", "NRC"};
    String informacion[][] = consulta.obtenerMatrizExperiencia();
    tablaExperiencias = new JTable(informacion, titulos){
      @Override
      public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;
      }
    };
    tablaExperiencias.setFocusable(false);
    JTableHeader cabecera = tablaExperiencias.getTableHeader();
    cabecera.setPreferredSize(new Dimension(10, 20));
    tablaExperiencias.addMouseListener(this);
    paneTabla.setViewportView(tablaExperiencias);
  }
  
  private void cargarTablaExperiencias() {
    paneTabla = new JScrollPane();
    paneTabla.setBounds(15, 220, 500, 386);
    this.add(paneTabla);
  }
  
  private void cargarLabelTitulo() {
    labelTitulo = new JLabel();
    labelTitulo.setBounds(54, 180, 400, 30);
    labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
    labelTitulo.setText("EXPERIENCIAS EDUCATIVAS");
    labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
    labelTitulo.setLayout(null);
    this.add(labelTitulo);
  }
  
  private void cargarLabelLogo() {
    labelImagenLogoUv = new JLabel();
    labelImagenLogoUv.setBounds(15, 15, 173, 140);
    cargarLogoUv();
    labelImagenLogoUv.setLayout(null);
    this.add(labelImagenLogoUv);
  }

  private void cargarLogoUv() {
    ImageIcon imagen = 
        new ImageIcon(getClass().getResource("/imagenes/universidadVeracruzana.png"));
    ImageIcon icono = 
        new ImageIcon(imagen.getImage().getScaledInstance(labelImagenLogoUv.getWidth(), 
        labelImagenLogoUv.getHeight(), Image.SCALE_DEFAULT));
    labelImagenLogoUv.setIcon(icono);
  }

  @Override
  public void actionPerformed(ActionEvent evento) {
    
    VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
    
    if(evento.getSource() == botonActualizar) {
      construirTabla();
      tablaExperiencias.repaint();
    }
    
    if(evento.getSource() == botonRegistrarExperiencia) {
      VentanaRegistrarExperiencia ventanaRegistro;
      ventanaRegistro = new VentanaRegistrarExperiencia(ventanaPrincipal, true);
    }
    
    if(evento.getSource() == botonModificarExperiencia) {
      VentanaConsultaExperiencia ventanaConsulta;
      ventanaConsulta = new VentanaConsultaExperiencia(ventanaPrincipal, true);
    }
    
    if(evento.getSource() == botonPasarLista) {
      if(!nrcSeleccionado.equals("")) {
        nrc = Integer.parseInt(nrcSeleccionado);
        VentanaAlumnos panelAlumnos = new VentanaAlumnos();
        setVisible(false);
        panelAlumnos.setVisible(true);
      } else {
        JOptionPane.showMessageDialog(null, "Seleccione una Experiencia Educativa antes de pasar "
            + "lista");
      }
    }
  }
  
  @Override
  public void mouseClicked(MouseEvent evento) {
    fila = tablaExperiencias.getSelectedRow();
    nrcSeleccionado = (tablaExperiencias.getModel().getValueAt(fila, 1).toString());
  }

  @Override
  public void mousePressed(MouseEvent me) {
    // No hacer nada
  }

  @Override
  public void mouseReleased(MouseEvent me) {
    // No hacer nada
  }

  @Override
  public void mouseEntered(MouseEvent evento) {
    // No hacer nada
  }

  @Override
  public void mouseExited(MouseEvent me) {
    // No hacer nada
  }
  
}
