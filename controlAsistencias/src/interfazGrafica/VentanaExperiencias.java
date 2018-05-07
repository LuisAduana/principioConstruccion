package interfazGrafica;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import logicaDeNegocios.ConsultasBaseDatos;

/**
*
* @author BiiR4
*/
public class VentanaExperiencias extends JPanel implements ActionListener {
  
  private JLabel labelImagenLogoUv;
  private JLabel labelTitulo;
  private JTable tablaExperiencias;
  private JScrollPane paneTabla;
  private JButton botonRegistrarExperiencia;
  private JButton botonModificarExperiencia;
  
  public VentanaExperiencias() {
    setBounds(0, 0, 540, 650);
    setLayout(null);
    cargarLabelLogo();
    cargarLabelTitulo();
    cargarTablaExperiencias();
    construirTabla();
    cargarBotones();
    setVisible(true);
  }
  
  private void cargarBotones() {
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
    String informacion[][] = consulta.obtenerMatriz();
    tablaExperiencias = new JTable(informacion, titulos);    
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
    
    if(evento.getSource() == botonRegistrarExperiencia) {
      VentanaRegistrarExperiencia ventanaRegistro;
      ventanaRegistro = new VentanaRegistrarExperiencia(ventanaPrincipal, true);
    }
    
    if(evento.getSource() == botonModificarExperiencia) {
      VentanaConsultaExperiencia ventanaConsulta;
      ventanaConsulta = new VentanaConsultaExperiencia(ventanaPrincipal, true);
    }
  }


}
