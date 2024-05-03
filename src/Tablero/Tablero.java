package Tablero;

import javax.swing.*;
import javax.sound.sampled.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicProgressBarUI;

import Partida.Ciudad;
import Partida.Vacunas;
import Partida.Virus;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Tablero extends JFrame {
	
	public Tablero(Ciudad[] ciudades, Virus[] viruses, Vacunas[] vacuna, int infectadasRonda, int enfActDerr, int brotDerr, int porcVac) {
	

    	Font customFont = loadFont("Starjedi.ttf");
    	Font buttonFont = customFont.deriveFont(Font.PLAIN, 14);
		
        // Configuración de la ventana principal
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        
        setSize(screenWidth, screenHeight);
        setTitle("CONQUISTA ESTELAR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 // Establecer el icono de la ventana
        Image iconImage = new ImageIcon("logo.jpg").getImage();
        setIconImage(Toolkit.getDefaultToolkit().getImage("logo.jpg"));
        getContentPane().setLayout(null);
        
        JButton Informacion = new JButton("informacion");
        Informacion.setForeground(new Color(255, 255, 255));
        Informacion.setBounds(675, 850, 150, 30);
        getContentPane().add(Informacion);
        Informacion.setFont(buttonFont);
        setButtonProperties(Informacion);
        
        JButton Investigar = new JButton("investigar");
        Investigar.setForeground(new Color(255, 255, 255));
        Investigar.setBounds(675, 915, 150, 30);
        getContentPane().add(Investigar);
        Investigar.setFont(buttonFont);
        setButtonProperties(Investigar);
        
        JLabel Brotes = new JLabel("Brotes");
        Brotes.setForeground(new Color(255, 255, 255));
        Brotes.setHorizontalAlignment(SwingConstants.CENTER);
        Brotes.setBounds(950, 850, 150, 30);
        getContentPane().add(Brotes);
        Brotes.setFont(buttonFont);
        
        JLabel Conquistas = new JLabel("conquistas");
        Conquistas.setForeground(new Color(255, 255, 255));
        Conquistas.setHorizontalAlignment(SwingConstants.CENTER);
        Conquistas.setBounds(950, 915, 150, 30);
        getContentPane().add(Conquistas);
        Conquistas.setFont(buttonFont);
        
        JLabel Acciones = new JLabel("acciones");
        Acciones.setHorizontalAlignment(SwingConstants.CENTER);
        Acciones.setForeground(new Color(255, 255, 255));
        Acciones.setBounds(1100, 850, 150, 30);
        getContentPane().add(Acciones);
        Acciones.setFont(buttonFont);
        
        JLabel Rondas = new JLabel("ronda");
        Rondas.setHorizontalAlignment(SwingConstants.CENTER);
        Rondas.setForeground(new Color(255, 255, 255));
        Rondas.setBounds(1100, 915, 150, 30);
        getContentPane().add(Rondas);
        Rondas.setFont(buttonFont);
        
        JLabel Darth_Maul = new JLabel("darth maul");
        Darth_Maul.setBackground(new Color(255, 255, 0));
        Darth_Maul.setForeground(new Color(255, 255, 0));
        Darth_Maul.setBounds(12, 885, 250, 30);
        getContentPane().add(Darth_Maul);
        Darth_Maul.setHorizontalAlignment(SwingConstants.CENTER);
        Darth_Maul.setFont(buttonFont);
        
        JLabel General_Grievous = new JLabel("general grievous");
        General_Grievous.setHorizontalAlignment(SwingConstants.CENTER);
        General_Grievous.setForeground(new Color(128, 255, 0));
        General_Grievous.setBounds(319, 885, 250, 30);
        getContentPane().add(General_Grievous);
        General_Grievous.setFont(buttonFont);
        
        JLabel Darth_Vader = new JLabel("darth vader");
        Darth_Vader.setHorizontalAlignment(SwingConstants.CENTER);
        Darth_Vader.setForeground(new Color(255, 0, 0));
        Darth_Vader.setBounds(319, 820, 250, 30);
        getContentPane().add(Darth_Vader);
        Darth_Vader.setFont(buttonFont);
        
        JLabel Darth_Sidious = new JLabel("darth sidious");
        Darth_Sidious.setHorizontalAlignment(SwingConstants.CENTER);
        Darth_Sidious.setForeground(new Color(0, 255, 255));
        Darth_Sidious.setBounds(12, 820, 250, 30);
        getContentPane().add(Darth_Sidious);
        Darth_Sidious.setFont(buttonFont);
        
        JProgressBar progressBar_Vader = new JProgressBar();
        progressBar_Vader.setToolTipText("");
        progressBar_Vader.setStringPainted(true);
        progressBar_Vader.setForeground(new Color(255, 0, 0));
        progressBar_Vader.setBounds(319, 850, 250, 30);
        getContentPane().add(progressBar_Vader);
        progressBar_Vader.setUI(new BasicProgressBarUI() {
            protected Color getSelectionForeground() {
                return Color.BLACK; // Cambiamos el color del texto del porcentaje
            }
        });
        progressBar_Vader.setValue(100);
        
        JProgressBar progressBar_Grievous = new JProgressBar();
        progressBar_Grievous.setStringPainted(true);
        progressBar_Grievous.setForeground(new Color(128, 255, 0));
        progressBar_Grievous.setBounds(319, 915, 250, 30);
        getContentPane().add(progressBar_Grievous);
        progressBar_Grievous.setUI(new BasicProgressBarUI() {
            protected Color getSelectionForeground() {
                return Color.BLACK; // Cambiamos el color del texto del porcentaje
            }
        });
        progressBar_Grievous.setValue(75);
        
        JProgressBar progressBar_Maul = new JProgressBar();
        progressBar_Maul.setForeground(new Color(255, 255, 0));
        progressBar_Maul.setStringPainted(true);
        progressBar_Maul.setBounds(12, 915, 250, 30);
        getContentPane().add(progressBar_Maul);
        progressBar_Maul.setUI(new BasicProgressBarUI() {
            protected Color getSelectionForeground() {
                return Color.BLACK; // Cambiamos el color del texto del porcentaje
            }
        });
        progressBar_Maul.setValue(50);
        
        JProgressBar progressBar_Sidious = new JProgressBar();
        progressBar_Sidious.setForeground(new Color(0, 255, 255));
        progressBar_Sidious.setStringPainted(true);
        progressBar_Sidious.setBounds(12, 850, 250, 30);
        getContentPane().add(progressBar_Sidious);
        progressBar_Sidious.setUI(new BasicProgressBarUI() {
            protected Color getSelectionForeground() {
                return Color.BLACK; // Cambiamos el color del texto del porcentaje
            }
        });
        progressBar_Sidious.setValue(25);
        
        JButton Jedah = new JButton("jedah");
        Jedah.setForeground(new Color(255, 0, 0));
        Jedah.setBounds(1147, 769, 125, 23);
        getContentPane().add(Jedah);
        Jedah.setFont(buttonFont);
        setButtonProperties(Jedah);
        Jedah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[47]); // Mostrar la ventana con la información
            }
        });
        
        JButton Iego = new JButton("iego");
        Iego.setForeground(new Color(255, 0, 0));
        Iego.setBounds(1113, 428, 125, 23);
        getContentPane().add(Iego);
        Iego.setFont(buttonFont);
        setButtonProperties(Iego);
        Iego.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[46]); // Mostrar la ventana con la información
            }
        });
        
        JButton Scarif = new JButton("scarif");
        Scarif.setForeground(new Color(255, 0, 0));
        Scarif.setBounds(1076, 656, 125, 23);
        getContentPane().add(Scarif);
        Scarif.setFont(buttonFont);
        setButtonProperties(Scarif);
        Scarif.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[45]); // Mostrar la ventana con la información
            }
        });
        
        JButton Exegol = new JButton("exegol");
        Exegol.setForeground(new Color(255, 0, 0));
        Exegol.setBounds(1040, 184, 125, 23);
        getContentPane().add(Exegol);
        Exegol.setFont(buttonFont);
        setButtonProperties(Exegol);
        Exegol.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[44]); // Mostrar la ventana con la información
            }
        });
        
        JButton Crait = new JButton("crait");
        Crait.setForeground(new Color(255, 0, 0));
        Crait.setBounds(1147, 239, 125, 23);
        getContentPane().add(Crait);
        Crait.setFont(buttonFont);
        setButtonProperties(Crait);
        Crait.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[43]); // Mostrar la ventana con la información
            }
        });
        
        JButton Ahch_To = new JButton("ahch to");
        Ahch_To.setForeground(new Color(255, 0, 0));
        Ahch_To.setBounds(1103, 123, 125, 23);
        getContentPane().add(Ahch_To);
        Ahch_To.setFont(buttonFont);
        setButtonProperties(Ahch_To);
        Ahch_To.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[42]); // Mostrar la ventana con la información
            }
        });
        
        JButton Korriban = new JButton("korriban");
        Korriban.setForeground(new Color(255, 0, 0));
        Korriban.setBounds(1103, 22, 125, 23);
        getContentPane().add(Korriban);
        Korriban.setFont(buttonFont);
        setButtonProperties(Korriban);
        Korriban.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[41]); // Mostrar la ventana con la información
            }
        });
        
        JButton Ithor = new JButton("ithor");
        Ithor.setForeground(new Color(255, 0, 0));
        Ithor.setBounds(949, 43, 125, 23);
        getContentPane().add(Ithor);
        Ithor.setFont(buttonFont);
        setButtonProperties(Ithor);
        Ithor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[40]); // Mostrar la ventana con la información
            }
        });
        
        JButton Duro = new JButton("duro");
        Duro.setForeground(new Color(255, 0, 0));
        Duro.setBounds(938, 133, 125, 23);
        getContentPane().add(Duro);
        Duro.setFont(buttonFont);
        setButtonProperties(Duro);
        Duro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[39]); // Mostrar la ventana con la información
            }
        });
        
        JButton Bothawui = new JButton("bothawui");
        Bothawui.setForeground(new Color(255, 0, 0));
        Bothawui.setBounds(1006, 338, 125, 23);
        getContentPane().add(Bothawui);
        Bothawui.setFont(buttonFont);
        setButtonProperties(Bothawui);
        Bothawui.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[38]); // Mostrar la ventana con la información
            }
        });
        
        JButton Eriadu = new JButton("eriadu");
        Eriadu.setForeground(new Color(255, 0, 0));
        Eriadu.setBounds(971, 552, 125, 23);
        getContentPane().add(Eriadu);
        Eriadu.setFont(buttonFont);
        setButtonProperties(Eriadu);
        Eriadu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[37]); // Mostrar la ventana con la información
            }
        });
        
        JButton Ilum = new JButton("ilum");
        Ilum.setForeground(new Color(255, 0, 0));
        Ilum.setBounds(867, 736, 125, 23);
        getContentPane().add(Ilum);
        Ilum.setFont(buttonFont);
        setButtonProperties(Ilum);
        Ilum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[36]); // Mostrar la ventana con la información
            }
        });
        
        JButton Wayland = new JButton("wayland");
        Wayland.setForeground(new Color(128, 255, 0));
        Wayland.setBounds(839, 598, 125, 23);
        getContentPane().add(Wayland);
        Wayland.setFont(buttonFont);
        setButtonProperties(Wayland);
        Wayland.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[35]); // Mostrar la ventana con la información
            }
        });
        
        JButton Bakura = new JButton("bakura");
        Bakura.setForeground(new Color(128, 255, 0));
        Bakura.setBounds(912, 478, 125, 23);
        getContentPane().add(Bakura);
        Bakura.setFont(buttonFont);
        setButtonProperties(Bakura);
        Bakura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[34]); // Mostrar la ventana con la información
            }
        });
        
               
        JButton Rishi = new JButton("rishi");
        Rishi.setForeground(new Color(128, 255, 0));
        Rishi.setBounds(877, 386, 125, 23);
        getContentPane().add(Rishi);
        Rishi.setFont(buttonFont);
        setButtonProperties(Rishi);
        Rishi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[33]); // Mostrar la ventana con la información
            }
        });
        
        JButton Hapes = new JButton("hapes");
        Hapes.setForeground(new Color(128, 255, 0));
        Hapes.setBounds(680, 563, 125, 23);
        getContentPane().add(Hapes);
        Hapes.setFont(buttonFont);
        setButtonProperties(Hapes);
        Hapes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[32]); // Mostrar la ventana con la información
            }
        });
        
        JButton Dathomir = new JButton("dathomir");
        Dathomir.setForeground(new Color(128, 255, 0));
        Dathomir.setBounds(770, 449, 125, 23);
        getContentPane().add(Dathomir);
        Dathomir.setFont(buttonFont);
        setButtonProperties(Dathomir);
        Dathomir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[31]); // Mostrar la ventana con la información
            }
        });
        
        JButton Onderon = new JButton("onderon");
        Onderon.setForeground(new Color(128, 255, 0));
        Onderon.setBounds(877, 296, 125, 23);
        getContentPane().add(Onderon);
        Onderon.setFont(buttonFont);
        setButtonProperties(Onderon);
        Onderon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[30]); // Mostrar la ventana con la información
            }
        });
        
        JButton Manaan = new JButton("manaan");
        Manaan.setForeground(new Color(128, 255, 0));
        Manaan.setBounds(812, 207, 125, 23);
        getContentPane().add(Manaan);
        Manaan.setFont(buttonFont);
        setButtonProperties(Manaan);
        Manaan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[29]); // Mostrar la ventana con la información
            }
        });
        
        JButton Mygeeto = new JButton("mygeeto");
        Mygeeto.setForeground(new Color(128, 255, 0));
        Mygeeto.setBounds(738, 350, 125, 23);
        getContentPane().add(Mygeeto);
        Mygeeto.setFont(buttonFont);
        setButtonProperties(Mygeeto);
        Mygeeto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[28]); // Mostrar la ventana con la información
            }
        });
        
        JButton Zeltros = new JButton("zeltros");
        Zeltros.setForeground(new Color(128, 255, 0));
        Zeltros.setBounds(709, 253, 125, 23);
        getContentPane().add(Zeltros);
        Zeltros.setFont(buttonFont);
        setButtonProperties(Zeltros);
        Zeltros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[27]); // Mostrar la ventana con la información
            }
        });
        
        JButton Malachor = new JButton("malachor");
        Malachor.setForeground(new Color(128, 255, 0));
        Malachor.setBounds(680, 499, 125, 23);
        getContentPane().add(Malachor);
        Malachor.setFont(buttonFont);
        setButtonProperties(Malachor);
        Malachor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[26]); // Mostrar la ventana con la información
            }
        });
        
        JButton Kessel = new JButton("kessel");
        Kessel.setForeground(new Color(128, 255, 0));
        Kessel.setBounds(602, 397, 125, 23);
        getContentPane().add(Kessel);
        Kessel.setFont(buttonFont);
        setButtonProperties(Kessel);
        Kessel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[25]); // Mostrar la ventana con la información
            }
        });
        
        JButton Mon_Cala = new JButton("mon cala");
        Mon_Cala.setForeground(new Color(128, 255, 0));
        Mon_Cala.setBounds(568, 286, 125, 23);
        getContentPane().add(Mon_Cala);
        Mon_Cala.setFont(buttonFont);
        setButtonProperties(Mon_Cala);
        Mon_Cala.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[24]); // Mostrar la ventana con la información
            }
        });
        
        JButton Lothal = new JButton("lothal");
        Lothal.setForeground(new Color(255, 255, 0));
        Lothal.setBounds(462, 780, 125, 23);
        getContentPane().add(Lothal);
        Lothal.setFont(buttonFont);
        setButtonProperties(Lothal);
        Lothal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[23]); // Mostrar la ventana con la información
            }
        });
        
        JButton Nal_Hutta = new JButton("nal hutta");
        Nal_Hutta.setForeground(new Color(255, 255, 0));
        Nal_Hutta.setBounds(491, 619, 125, 23);
        getContentPane().add(Nal_Hutta);
        Nal_Hutta.setFont(buttonFont);
        setButtonProperties(Nal_Hutta);
        Nal_Hutta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[22]); // Mostrar la ventana con la información
            }
        });
        
        JButton Taris = new JButton("taris");
        Taris.setForeground(new Color(255, 255, 0));
        Taris.setBounds(340, 680, 89, 23);
        getContentPane().add(Taris);
        Taris.setFont(buttonFont);
        setButtonProperties(Taris);
        Taris.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[21]); // Mostrar la ventana con la información
            }
        });
        
        JButton Felucia = new JButton("felucia");
        Felucia.setForeground(new Color(255, 255, 0));
        Felucia.setBounds(419, 466, 125, 23);
        getContentPane().add(Felucia);
        Felucia.setFont(buttonFont);
        setButtonProperties(Felucia);
        Felucia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[20]); // Mostrar la ventana con la información
            }
        });
        
        JButton Dantooine = new JButton("dantooine");
        Dantooine.setForeground(new Color(255, 255, 0));
        Dantooine.setBounds(284, 466, 125, 23);
        getContentPane().add(Dantooine);
        Dantooine.setFont(buttonFont);
        setButtonProperties(Dantooine);
        Dantooine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[19]); // Mostrar la ventana con la información
            }
        });
        
        JButton Mandalore = new JButton("mandalore");
        Mandalore.setForeground(new Color(255, 255, 0));
        Mandalore.setBounds(127, 563, 135, 23);
        getContentPane().add(Mandalore);
        Mandalore.setFont(buttonFont);
        setButtonProperties(Mandalore);
        Mandalore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[18]); // Mostrar la ventana con la información
            }
        });
        
        JButton Ryloth = new JButton("ryloth");
        Ryloth.setForeground(new Color(255, 255, 0));
        Ryloth.setBounds(54, 747, 125, 23);
        getContentPane().add(Ryloth);
        Ryloth.setFont(buttonFont);
        setButtonProperties(Ryloth);
        Ryloth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[17]); // Mostrar la ventana con la información
            }
        });
        
        JButton Sullust = new JButton("sullust");
        Sullust.setForeground(new Color(255, 255, 0));
        Sullust.setBounds(54, 478, 125, 23);
        getContentPane().add(Sullust);
        Sullust.setFont(buttonFont);
        setButtonProperties(Sullust);
        Sullust.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[16]); // Mostrar la ventana con la información
            }
        });
        
        JButton Corellia = new JButton("corellia");
        Corellia.setForeground(new Color(255, 255, 0));
        Corellia.setBounds(284, 308, 125, 23);
        getContentPane().add(Corellia);
        Corellia.setFont(buttonFont);
        setButtonProperties(Corellia);
        Corellia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[15]); // Mostrar la ventana con la información
            }
        });
        
        JButton Chandrilla = new JButton("chandrilla");
        Chandrilla.setForeground(new Color(255, 255, 0));
        Chandrilla.setBounds(182, 253, 135, 23);
        getContentPane().add(Chandrilla);
        Chandrilla.setFont(buttonFont);
        setButtonProperties(Chandrilla);
        Chandrilla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[14]); // Mostrar la ventana con la información
            }
        });
        
        JButton Jakku = new JButton("jakku");
        Jakku.setForeground(new Color(255, 255, 0));
        Jakku.setBounds(295, 228, 125, 23);
        getContentPane().add(Jakku);
        Jakku.setFont(buttonFont);
        setButtonProperties(Jakku);
        Jakku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[13]); // Mostrar la ventana con la información
            }
        });
        
        JButton Utapau = new JButton("utapau");
        Utapau.setForeground(new Color(255, 255, 0));
        Utapau.setBounds(54, 184, 125, 23);
        getContentPane().add(Utapau);
        Utapau.setFont(buttonFont);
        setButtonProperties(Utapau);
        Utapau.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[12]); // Mostrar la ventana con la información
            }
        });
        
        JButton Yavin = new JButton("yavin");
        Yavin.setForeground(new Color(0, 255, 255));
        Yavin.setBounds(829, 22, 125, 23);
        getContentPane().add(Yavin);
        Yavin.setFont(buttonFont);
        setButtonProperties(Yavin);
        Yavin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[11]); // Mostrar la ventana con la información
            }
        });
        
        JButton Dagobah = new JButton("dagobah");
        Dagobah.setForeground(new Color(0, 255, 255));
        Dagobah.setBounds(626, 161, 125, 23);
        getContentPane().add(Dagobah);
        Dagobah.setFont(buttonFont);
        setButtonProperties(Dagobah);
        Dagobah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[10]); // Mostrar la ventana con la información
            }
        });
        
        JButton Mustafar = new JButton("mustafar");
        Mustafar.setForeground(new Color(0, 255, 255));
        Mustafar.setBounds(709, 67, 125, 23);
        getContentPane().add(Mustafar);
        Mustafar.setFont(buttonFont);
        setButtonProperties(Mustafar);
        Mustafar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[9]); // Mostrar la ventana con la información
            }
        });
        
        JButton Geonosis = new JButton("geonosis");
        Geonosis.setForeground(new Color(0, 255, 255));
        Geonosis.setBounds(614, 123, 125, 23);
        getContentPane().add(Geonosis);
        Geonosis.setFont(buttonFont);
        setButtonProperties(Geonosis);
        Geonosis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[8]); // Mostrar la ventana con la información
            }
        });
        
        JButton Kamino = new JButton("kamino");
        Kamino.setForeground(new Color(0, 255, 255));
        Kamino.setBounds(385, 194, 125, 23);
        getContentPane().add(Kamino);
        Kamino.setFont(buttonFont);
        setButtonProperties(Kamino);
        Kamino.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[7]); // Mostrar la ventana con la información
            }
        });
        
        JButton Naboo = new JButton("naboo");
        Naboo.setForeground(new Color(0, 255, 255));
        Naboo.setBounds(602, 11, 125, 23);
        getContentPane().add(Naboo);
        Naboo.setFont(buttonFont);
        setButtonProperties(Naboo);
        Naboo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[6]); // Mostrar la ventana con la información
            }
        });
        
        JButton Hoth = new JButton("hoth");
        Hoth.setForeground(new Color(0, 255, 255));
        Hoth.setBounds(366, 133, 89, 23);
        getContentPane().add(Hoth);
        Hoth.setFont(buttonFont);
        setButtonProperties(Hoth);
        Hoth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[5]); // Mostrar la ventana con la información
            }
        });
        
        JButton Endor = new JButton("endor");
        Endor.setForeground(new Color(0, 255, 255));
        Endor.setBounds(462, 82, 125, 23);
        getContentPane().add(Endor);
        Endor.setFont(buttonFont);
        setButtonProperties(Endor);
        Endor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[4]); // Mostrar la ventana con la información
            }
        });
        
        JButton Kashyyyk = new JButton("kashyyyk");
        Kashyyyk.setForeground(new Color(0, 255, 255));
        Kashyyyk.setBounds(352, 0, 125, 23);
        getContentPane().add(Kashyyyk);
        Kashyyyk.setFont(buttonFont);
        setButtonProperties(Kashyyyk);
        Kashyyyk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[3]); // Mostrar la ventana con la información
            }
        });
        
        JButton Alderaan = new JButton("alderaan");
        Alderaan.setForeground(new Color(0, 255, 255));
        Alderaan.setBounds(237, 143, 125, 23);
        getContentPane().add(Alderaan);
        Alderaan.setFont(buttonFont);
        setButtonProperties(Alderaan);
        Alderaan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[2]); // Mostrar la ventana con la información
            }
        });
        
        JButton Tatooine = new JButton("tatooine");
        Tatooine.setForeground(new Color(0, 255, 255));
        Tatooine.setBounds(196, 33, 125, 23);
        getContentPane().add(Tatooine);
        Tatooine.setFont(buttonFont);
        setButtonProperties(Tatooine);
        Tatooine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[1]); // Mostrar la ventana con la información
            }
        });
        
        JButton Coruscant = new JButton("coruscant");
        Coruscant.setForeground(new Color(0, 255, 255));
        Coruscant.setBounds(29, 22, 125, 23);
        getContentPane().add(Coruscant);
        Coruscant.setFont(buttonFont);
        setButtonProperties(Coruscant);
        Coruscant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarVentana(ciudades[0]); // Mostrar la ventana con la información
            }
        });
        
        JLabel Mapa = new JLabel("");
        Mapa.setForeground(new Color(0, 128, 255));
        Mapa.setBounds(0, 0, 1264, 985);
        Mapa.setIcon(new ImageIcon("Mapa_conquista_final.jpg"));
        getContentPane().add(Mapa);
              
        setVisible(true);
        
	}

	private Font loadFont(String path) {
	    try {
	        return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(Font.PLAIN, 12);
	    } catch (IOException | FontFormatException e) {
	        e.printStackTrace();
	        // Si hay un error al cargar la fuente, devuelve una fuente por defecto (Tahoma)
	        return new Font("Tahoma", Font.PLAIN, 12);
	    }
}

	private void setButtonProperties(JButton button) {
		button.setOpaque(false); // Hace que el botón sea transparente
    	button.setContentAreaFilled(false); // Hace que el área de contenido del botón sea transparente
    	button.setBorderPainted(false); // Quita el borde del botón
	}
	
	// Método para mostrar una ventana con el nombre de la ciudad y el nivel de infección
	private void mostrarVentana(Ciudad ciudad) {
	    JFrame ventana = new JFrame();
	    JLabel etiquetaCiudad = new JLabel("planeta : " + ciudad.getnombre());
	    JLabel etiquetaNivel = new JLabel("nivel de conquista : " + ciudad.getinfeccion());
	    JButton reconquistarButton = new JButton("reconquistar");
	    reconquistarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(ciudad.getinfeccion() != 0) {
            		ciudad.setinfeccion(ciudad.getinfeccion() - 1);
            		
            	}else {
            		JOptionPane.showMessageDialog(null, "No puedes reconquistar ya que ya es 0");
            	}
                
            }
        });

	    Font customFont = loadFont("Starjedi.ttf");
    	Font buttonFont = customFont.deriveFont(Font.PLAIN, 14);
	    
	    etiquetaCiudad.setFont(buttonFont);
	    etiquetaNivel.setFont(buttonFont);
	    reconquistarButton.setFont(buttonFont);
	    
	    // Configurar el color de fondo de la ventana
	    ventana.getContentPane().setBackground(Color.BLACK);

	    // Configurar el color del texto de las etiquetas y del botón
	    etiquetaCiudad.setForeground(Color.WHITE);
	    etiquetaNivel.setForeground(Color.WHITE);
	    reconquistarButton.setForeground(Color.WHITE);

	    ventana.getContentPane().setLayout(new GridBagLayout());

	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.insets = new Insets(10, 10, 10, 10);
	    ventana.getContentPane().add(etiquetaCiudad, gbc);

	    gbc.gridy = 1;
	    ventana.getContentPane().add(etiquetaNivel, gbc);

	    gbc.gridy = 2;
	    ventana.getContentPane().add(reconquistarButton, gbc);

	    ventana.setSize(400, 250);
	    ventana.setLocationRelativeTo(null);
	    ventana.setVisible(true);

	    // Aplicar propiedades al botón "Reconquistar"
	    setButtonProperties(reconquistarButton);
	}


}