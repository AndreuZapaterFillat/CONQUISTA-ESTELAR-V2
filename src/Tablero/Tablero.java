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
	
	int acciones  = 4;
	int ronda = 1;
	JLabel Rondas = new JLabel("ronda 1");
	JLabel Acciones = new JLabel("acciones: 4");
    JProgressBar progressBar_Vader = new JProgressBar();
    JProgressBar progressBar_Grievous = new JProgressBar();
    JProgressBar progressBar_Maul = new JProgressBar();
    JProgressBar progressBar_Sidious = new JProgressBar();
	
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
        Investigar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame ventanaSecundaria = new JFrame("Selección investigación");
                ventanaSecundaria.getContentPane().setLayout(new GridLayout(4, 1));

                
                JButton btnDarthVader = new JButton("Darth Vader");
                btnDarthVader.setForeground(new Color(255, 0, 0));
                btnDarthVader.setFont(buttonFont);
                setButtonProperties(btnDarthVader);
                btnDarthVader.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	investigarVacuna(vacuna[0], progressBar_Vader, porcVac, ciudades, infectadasRonda);
                    }
                });
                
                JButton btnDarthMaul = new JButton("Darth Maul");
                btnDarthMaul.setForeground(new Color(255, 255, 0));
                btnDarthMaul.setFont(buttonFont);
                setButtonProperties(btnDarthMaul);
                btnDarthMaul.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	investigarVacuna(vacuna[1], progressBar_Maul, porcVac, ciudades, infectadasRonda);
                    }
                });
                
                JButton btnGeneralGrievous = new JButton("General Grievous");
                btnGeneralGrievous.setForeground(new Color(128, 255, 0));
                btnGeneralGrievous.setFont(buttonFont);
                setButtonProperties(btnGeneralGrievous);
                btnGeneralGrievous.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	investigarVacuna(vacuna[2], progressBar_Grievous, porcVac, ciudades, infectadasRonda);
                    }
                });
                
                JButton btnDarthSidious = new JButton("Darth Sidious");
                btnDarthSidious.setForeground(new Color(0, 255, 255));
                btnDarthSidious.setFont(buttonFont);
                setButtonProperties(btnDarthSidious);
                btnDarthSidious.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	investigarVacuna(vacuna[3], progressBar_Sidious, porcVac, ciudades, infectadasRonda);
                    }
                });
                
                ventanaSecundaria.getContentPane().add(btnDarthVader);
                ventanaSecundaria.getContentPane().add(btnDarthMaul);
                ventanaSecundaria.getContentPane().add(btnGeneralGrievous);
                ventanaSecundaria.getContentPane().add(btnDarthSidious);

                ventanaSecundaria.getContentPane().setBackground(Color.BLACK);
                ventanaSecundaria.setSize(400, 200);
                ventanaSecundaria.setLocationRelativeTo(null);
                ventanaSecundaria.setVisible(true);
            }
        });
        
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
        
        
        Acciones.setHorizontalAlignment(SwingConstants.CENTER);
        Acciones.setForeground(new Color(255, 255, 255));
        Acciones.setBounds(1100, 850, 150, 30);
        getContentPane().add(Acciones);
        Acciones.setFont(buttonFont);
        
        
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
        

        
        progressBar_Grievous.setStringPainted(true);
        progressBar_Grievous.setForeground(new Color(128, 255, 0));
        progressBar_Grievous.setBounds(319, 915, 250, 30);
        getContentPane().add(progressBar_Grievous);
        progressBar_Grievous.setUI(new BasicProgressBarUI() {
            protected Color getSelectionForeground() {
                return Color.BLACK; // Cambiamos el color del texto del porcentaje
            }
        });
        

        progressBar_Maul.setForeground(new Color(255, 255, 0));
        progressBar_Maul.setStringPainted(true);
        progressBar_Maul.setBounds(12, 915, 250, 30);
        getContentPane().add(progressBar_Maul);
        progressBar_Maul.setUI(new BasicProgressBarUI() {
            protected Color getSelectionForeground() {
                return Color.BLACK; // Cambiamos el color del texto del porcentaje
            }
        });
        

        progressBar_Sidious.setForeground(new Color(0, 255, 255));
        progressBar_Sidious.setStringPainted(true);
        progressBar_Sidious.setBounds(12, 850, 250, 30);
        getContentPane().add(progressBar_Sidious);
        progressBar_Sidious.setUI(new BasicProgressBarUI() {
            protected Color getSelectionForeground() {
                return Color.BLACK; // Cambiamos el color del texto del porcentaje
            }
        });
        
        JButton Jedah = new JButton("jedah (" + ciudades[47].getinfeccion() + ")");
        Jedah.setForeground(new Color(255, 0, 0));
        Jedah.setBounds(1132, 769, 175, 23);
        getContentPane().add(Jedah);
        Jedah.setFont(buttonFont);
        setButtonProperties(Jedah);
        Jedah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[47], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Iego = new JButton("iego (" + ciudades[46].getinfeccion() + ")");
        Iego.setForeground(new Color(255, 0, 0));
        Iego.setBounds(1076, 429, 175, 23);
        getContentPane().add(Iego);
        Iego.setFont(buttonFont);
        setButtonProperties(Iego);
        Iego.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[46], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Scarif = new JButton("scarif (" + ciudades[45].getinfeccion() + ")");
        Scarif.setForeground(new Color(255, 0, 0));
        Scarif.setBounds(1076, 656, 175, 23);
        getContentPane().add(Scarif);
        Scarif.setFont(buttonFont);
        setButtonProperties(Scarif);
        Scarif.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[45], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Exegol = new JButton("exegol (" + ciudades[44].getinfeccion() + ")");
        Exegol.setForeground(new Color(255, 0, 0));
        Exegol.setBounds(1040, 184, 175, 23);
        getContentPane().add(Exegol);
        Exegol.setFont(buttonFont);
        setButtonProperties(Exegol);
        Exegol.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[44], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Crait = new JButton("crait (" + ciudades[43].getinfeccion() + ")");
        Crait.setForeground(new Color(255, 0, 0));
        Crait.setBounds(1132, 240, 175, 23);
        getContentPane().add(Crait);
        Crait.setFont(buttonFont);
        setButtonProperties(Crait);
        Crait.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[43], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Ahch_To = new JButton("ahch to (" + ciudades[42].getinfeccion() + ")");
        Ahch_To.setForeground(new Color(255, 0, 0));
        Ahch_To.setBounds(1076, 123, 175, 23);
        getContentPane().add(Ahch_To);
        Ahch_To.setFont(buttonFont);
        setButtonProperties(Ahch_To);
        Ahch_To.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[42], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Korriban = new JButton("korriban (" + ciudades[41].getinfeccion() + ")");
        Korriban.setForeground(new Color(255, 0, 0));
        Korriban.setBounds(1103, 22, 175, 23);
        getContentPane().add(Korriban);
        Korriban.setFont(buttonFont);
        setButtonProperties(Korriban);
        Korriban.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[41], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Ithor = new JButton("ithor (" + ciudades[40].getinfeccion() + ")");
        Ithor.setForeground(new Color(255, 0, 0));
        Ithor.setBounds(940, 40, 175, 23);
        getContentPane().add(Ithor);
        Ithor.setFont(buttonFont);
        setButtonProperties(Ithor);
        Ithor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[40], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Duro = new JButton("duro (" + ciudades[39].getinfeccion() + ")");
        Duro.setForeground(new Color(255, 0, 0));
        Duro.setBounds(925, 133, 175, 23);
        getContentPane().add(Duro);
        Duro.setFont(buttonFont);
        setButtonProperties(Duro);
        Duro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[39], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Bothawui = new JButton("bothawui (" + ciudades[38].getinfeccion() + ")");
        Bothawui.setForeground(new Color(255, 0, 0));
        Bothawui.setBounds(1006, 338, 175, 23);
        getContentPane().add(Bothawui);
        Bothawui.setFont(buttonFont);
        setButtonProperties(Bothawui);
        Bothawui.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[38], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Eriadu = new JButton("eriadu (" + ciudades[37].getinfeccion() + ")");
        Eriadu.setForeground(new Color(255, 0, 0));
        Eriadu.setBounds(971, 552, 175, 23);
        getContentPane().add(Eriadu);
        Eriadu.setFont(buttonFont);
        setButtonProperties(Eriadu);
        Eriadu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[37], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Ilum = new JButton("ilum (" + ciudades[36].getinfeccion() + ")");
        Ilum.setForeground(new Color(255, 0, 0));
        Ilum.setBounds(867, 736, 175, 23);
        getContentPane().add(Ilum);
        Ilum.setFont(buttonFont);
        setButtonProperties(Ilum);
        Ilum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[36], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Wayland = new JButton("wayland (" + ciudades[35].getinfeccion() + ")");
        Wayland.setForeground(new Color(128, 255, 0));
        Wayland.setBounds(823, 604, 175, 23);
        getContentPane().add(Wayland);
        Wayland.setFont(buttonFont);
        setButtonProperties(Wayland);
        Wayland.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[35], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Bakura = new JButton("bakura (" + ciudades[34].getinfeccion() + ")");
        Bakura.setForeground(new Color(128, 255, 0));
        Bakura.setBounds(894, 478, 175, 23);
        getContentPane().add(Bakura);
        Bakura.setFont(buttonFont);
        setButtonProperties(Bakura);
        Bakura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[34], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
               
        JButton Rishi = new JButton("rishi (" + ciudades[33].getinfeccion() + ")");
        Rishi.setForeground(new Color(128, 255, 0));
        Rishi.setBounds(877, 386, 175, 23);
        getContentPane().add(Rishi);
        Rishi.setFont(buttonFont);
        setButtonProperties(Rishi);
        Rishi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[33], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Hapes = new JButton("hapes (" + ciudades[32].getinfeccion() + ")");
        Hapes.setForeground(new Color(128, 255, 0));
        Hapes.setBounds(646, 573, 175, 23);
        getContentPane().add(Hapes);
        Hapes.setFont(buttonFont);
        setButtonProperties(Hapes);
        Hapes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[32], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Dathomir = new JButton("dathomir (" + ciudades[31].getinfeccion() + ")");
        Dathomir.setForeground(new Color(128, 255, 0));
        Dathomir.setBounds(763, 444, 175, 23);
        getContentPane().add(Dathomir);
        Dathomir.setFont(buttonFont);
        setButtonProperties(Dathomir);
        Dathomir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[31], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Onderon = new JButton("onderon (" + ciudades[30].getinfeccion() + ")");
        Onderon.setForeground(new Color(128, 255, 0));
        Onderon.setBounds(854, 286, 175, 23);
        getContentPane().add(Onderon);
        Onderon.setFont(buttonFont);
        setButtonProperties(Onderon);
        Onderon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[30], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Manaan = new JButton("manaan (" + ciudades[29].getinfeccion() + ")");
        Manaan.setForeground(new Color(128, 255, 0));
        Manaan.setBounds(799, 208, 175, 23);
        getContentPane().add(Manaan);
        Manaan.setFont(buttonFont);
        setButtonProperties(Manaan);
        Manaan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[29], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Mygeeto = new JButton("mygeeto (" + ciudades[28].getinfeccion() + ")");
        Mygeeto.setForeground(new Color(128, 255, 0));
        Mygeeto.setBounds(717, 352, 175, 23);
        getContentPane().add(Mygeeto);
        Mygeeto.setFont(buttonFont);
        setButtonProperties(Mygeeto);
        Mygeeto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[28], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Zeltros = new JButton("zeltros (" + ciudades[27].getinfeccion() + ")");
        Zeltros.setForeground(new Color(128, 255, 0));
        Zeltros.setBounds(697, 252, 175, 23);
        getContentPane().add(Zeltros);
        Zeltros.setFont(buttonFont);
        setButtonProperties(Zeltros);
        Zeltros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[27], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Malachor = new JButton("malachor (" + ciudades[26].getinfeccion() + ")");
        Malachor.setForeground(new Color(128, 255, 0));
        Malachor.setBounds(571, 510, 175, 23);
        getContentPane().add(Malachor);
        Malachor.setFont(buttonFont);
        setButtonProperties(Malachor);
        Malachor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[26], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Kessel = new JButton("kessel (" + ciudades[25].getinfeccion() + ")");
        Kessel.setForeground(new Color(128, 255, 0));
        Kessel.setBounds(584, 397, 175, 23);
        getContentPane().add(Kessel);
        Kessel.setFont(buttonFont);
        setButtonProperties(Kessel);
        Kessel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[25], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Mon_Cala = new JButton("mon cala (" + ciudades[24].getinfeccion() + ")");
        Mon_Cala.setForeground(new Color(128, 255, 0));
        Mon_Cala.setBounds(558, 286, 175, 23);
        getContentPane().add(Mon_Cala);
        Mon_Cala.setFont(buttonFont);
        setButtonProperties(Mon_Cala);
        Mon_Cala.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[24], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Lothal = new JButton("lothal (" + ciudades[23].getinfeccion() + ")");
        Lothal.setForeground(new Color(255, 255, 0));
        Lothal.setBounds(448, 786, 175, 23);
        getContentPane().add(Lothal);
        Lothal.setFont(buttonFont);
        setButtonProperties(Lothal);
        Lothal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[23], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Nal_Hutta = new JButton("nal hutta (" + ciudades[22].getinfeccion() + ")");
        Nal_Hutta.setForeground(new Color(255, 255, 0));
        Nal_Hutta.setBounds(491, 619, 175, 23);
        getContentPane().add(Nal_Hutta);
        Nal_Hutta.setFont(buttonFont);
        setButtonProperties(Nal_Hutta);
        Nal_Hutta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[22], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Taris = new JButton("taris (" + ciudades[21].getinfeccion() + ")");
        Taris.setForeground(new Color(255, 255, 0));
        Taris.setBounds(319, 680, 175, 23);
        getContentPane().add(Taris);
        Taris.setFont(buttonFont);
        setButtonProperties(Taris);
        Taris.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[21], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Felucia = new JButton("felucia (" + ciudades[20].getinfeccion() + ")");
        Felucia.setForeground(new Color(255, 255, 0));
        Felucia.setBounds(403, 466, 175, 23);
        getContentPane().add(Felucia);
        Felucia.setFont(buttonFont);
        setButtonProperties(Felucia);
        Felucia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[20], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Dantooine = new JButton("dantooine (" + ciudades[19].getinfeccion() + ")");
        Dantooine.setForeground(new Color(255, 255, 0));
        Dantooine.setBounds(270, 466, 175, 23);
        getContentPane().add(Dantooine);
        Dantooine.setFont(buttonFont);
        setButtonProperties(Dantooine);
        Dantooine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[19], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Mandalore = new JButton("mandalore (" + ciudades[18].getinfeccion() + ")");
        Mandalore.setForeground(new Color(255, 255, 0));
        Mandalore.setBounds(127, 563, 175, 23);
        getContentPane().add(Mandalore);
        Mandalore.setFont(buttonFont);
        setButtonProperties(Mandalore);
        Mandalore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[18], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Ryloth = new JButton("ryltoh (" + ciudades[17].getinfeccion() + ")");
        Ryloth.setForeground(new Color(255, 255, 0));
        Ryloth.setBounds(42, 748, 175, 23);
        getContentPane().add(Ryloth);
        Ryloth.setFont(buttonFont);
        setButtonProperties(Ryloth);
        Ryloth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[17], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Sullust = new JButton("sullust (" + ciudades[16].getinfeccion() + ")");
        Sullust.setForeground(new Color(255, 255, 0));
        Sullust.setBounds(54, 466, 175, 23);
        getContentPane().add(Sullust);
        Sullust.setFont(buttonFont);
        setButtonProperties(Sullust);
        Sullust.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[16], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Corellia = new JButton("corellia (" + ciudades[15].getinfeccion() + ")");
        Corellia.setForeground(new Color(255, 255, 0));
        Corellia.setBounds(284, 308, 175, 23);
        getContentPane().add(Corellia);
        Corellia.setFont(buttonFont);
        setButtonProperties(Corellia);
        Corellia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[15], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Chandrilla = new JButton("chandrilla (" + ciudades[14].getinfeccion() + ")");
        Chandrilla.setForeground(new Color(255, 255, 0));
        Chandrilla.setBounds(182, 253, 175, 23);
        getContentPane().add(Chandrilla);
        Chandrilla.setFont(buttonFont);
        setButtonProperties(Chandrilla);
        Chandrilla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[14], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Jakku = new JButton("jakku (" + ciudades[13].getinfeccion() + ")");
        Jakku.setForeground(new Color(255, 255, 0));
        Jakku.setBounds(284, 228, 175, 23);
        getContentPane().add(Jakku);
        Jakku.setFont(buttonFont);
        setButtonProperties(Jakku);
        Jakku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[13], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Utapau = new JButton("utapau (" + ciudades[12].getinfeccion() + ")");
        Utapau.setForeground(new Color(255, 255, 0));
        Utapau.setBounds(42, 184, 175, 23);
        getContentPane().add(Utapau);
        Utapau.setFont(buttonFont);
        setButtonProperties(Utapau);
        Utapau.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[12], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Yavin = new JButton("yavin (" + ciudades[11].getinfeccion() + ")");
        Yavin.setForeground(new Color(0, 255, 255));
        Yavin.setBounds(812, 22, 175, 23);
        getContentPane().add(Yavin);
        Yavin.setFont(buttonFont);
        setButtonProperties(Yavin);
        Yavin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[11], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Dagobah = new JButton("dagobah (" + ciudades[10].getinfeccion() + ")");
        Dagobah.setForeground(new Color(0, 255, 255));
        Dagobah.setBounds(602, 161, 175, 23);
        getContentPane().add(Dagobah);
        Dagobah.setFont(buttonFont);
        setButtonProperties(Dagobah);
        Dagobah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[10], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Mustafar = new JButton("mustafar (" + ciudades[9].getinfeccion() + ")");
        Mustafar.setForeground(new Color(0, 255, 255));
        Mustafar.setBounds(697, 67, 175, 23);
        getContentPane().add(Mustafar);
        Mustafar.setFont(buttonFont);
        setButtonProperties(Mustafar);
        Mustafar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[9], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Geonosis = new JButton("geonosis (" + ciudades[8].getinfeccion() + ")");
        Geonosis.setForeground(new Color(0, 255, 255));
        Geonosis.setBounds(602, 123, 175, 23);
        getContentPane().add(Geonosis);
        Geonosis.setFont(buttonFont);
        setButtonProperties(Geonosis);
        Geonosis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[8], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Kamino = new JButton("kamino (" + ciudades[7].getinfeccion() + ")");
        Kamino.setForeground(new Color(0, 255, 255));
        Kamino.setBounds(354, 194, 175, 23);
        getContentPane().add(Kamino);
        Kamino.setFont(buttonFont);
        setButtonProperties(Kamino);
        Kamino.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[7], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Naboo = new JButton("naboo (" + ciudades[6].getinfeccion() + ")");
        Naboo.setForeground(new Color(0, 255, 255));
        Naboo.setBounds(584, 11, 175, 23);
        getContentPane().add(Naboo);
        Naboo.setFont(buttonFont);
        setButtonProperties(Naboo);
        Naboo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[6], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Hoth = new JButton("hoth (" + ciudades[5].getinfeccion() + ")");
        Hoth.setForeground(new Color(0, 255, 255));
        Hoth.setBounds(319, 133, 175, 23);
        getContentPane().add(Hoth);
        Hoth.setFont(buttonFont);
        setButtonProperties(Hoth);
        Hoth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[5], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Endor = new JButton("endor (" + ciudades[4].getinfeccion() + ")");
        Endor.setForeground(new Color(0, 255, 255));
        Endor.setBounds(448, 82, 175, 23);
        getContentPane().add(Endor);
        Endor.setFont(buttonFont);
        setButtonProperties(Endor);
        Endor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[4], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Kashyyyk = new JButton("kashyyyk (" + ciudades[3].getinfeccion() + ")");
        Kashyyyk.setForeground(new Color(0, 255, 255));
        Kashyyyk.setBounds(340, 0, 175, 23);
        getContentPane().add(Kashyyyk);
        Kashyyyk.setFont(buttonFont);
        setButtonProperties(Kashyyyk);
        Kashyyyk.addActionListener(new ActionListener() {          public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[3], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Alderaan = new JButton("alderaan (" + ciudades[2].getinfeccion() + ")");
        Alderaan.setForeground(new Color(0, 255, 255));
        Alderaan.setBounds(228, 143, 175, 23);
        getContentPane().add(Alderaan);
        Alderaan.setFont(buttonFont);
        setButtonProperties(Alderaan);
        Alderaan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[2], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Tatooine = new JButton("tatooine (" + ciudades[1].getinfeccion() + ")");
        Tatooine.setForeground(new Color(0, 255, 255));
        Tatooine.setBounds(182, 40, 175, 23);
        getContentPane().add(Tatooine);
        Tatooine.setFont(buttonFont);
        setButtonProperties(Tatooine);
        Tatooine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarVentana(ciudades[1], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JButton Coruscant = new JButton("coruscant (" + ciudades[0].getinfeccion() + ")");
        Coruscant.setForeground(new Color(0, 255, 255));
        Coruscant.setBounds(12, 22, 175, 23);
        getContentPane().add(Coruscant);
        Coruscant.setFont(buttonFont);
        setButtonProperties(Coruscant);
        Coruscant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarVentana(ciudades[0], ciudades, infectadasRonda); // Mostrar la ventana con la información
            }
        });
        
        JLabel Mapa = new JLabel("");
        Mapa.setForeground(new Color(0, 128, 255));
        Mapa.setBounds(0, 0, 1264, 985);
        Mapa.setIcon(new ImageIcon("F:\\ILERNA\\CONQUISTA-ESTELAR\\Pandemic\\Mapa_conquista_final.jpg"));
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
	private void mostrarVentana(Ciudad ciudad, Ciudad [] ciudades, int infectadasRonda) {
	    JFrame ventana = new JFrame();
	    JLabel etiquetaCiudad = new JLabel("planeta : " + ciudad.getnombre());
	    JLabel etiquetaNivel = new JLabel("nivel de conquista : " + ciudad.getinfeccion());
	    JButton reconquistarButton = new JButton("reconquistar");
	    reconquistarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(ciudad.getinfeccion() != 0 && acciones != 0) {
            		ciudad.setinfeccion(ciudad.getinfeccion() - 1);
            		etiquetaNivel.setText("nivel de conquista : " + ciudad.getinfeccion());
            		acciones--;
            		modifcarAcciones();
            		if(acciones == 0) {
            			ronda++;
                		acciones = 4;
                		modifcarAcciones();
                		pasarRonda();
                		infectarCiudades(ciudades, infectadasRonda);
            		}
            	}else if(ciudad.getinfeccion() == 0 && acciones != 0){
            		JOptionPane.showMessageDialog(null, "Este planeta no esta conquistado");
            	}
                
            }
        });

	    Font customFont = loadFont("Starjedi.ttf");
    	Font buttonFont = customFont.deriveFont(Font.PLAIN, 14);
	    
	    etiquetaCiudad.setFont(buttonFont);
	    etiquetaNivel.setFont(buttonFont);
	    reconquistarButton.setFont(buttonFont);
	    
	    ventana.getContentPane().setBackground(Color.BLACK);

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
	
	private void infectarCiudades(Ciudad [] ciudades, int infectadasRonda) {
		int i = 0;
		int j = 0;
		
		while(j != infectadasRonda) {
			if((int)(Math.random()*20) == 2) {
				
				if(ciudades[i].getinfeccion() >= 0 && ciudades[i].getinfeccion() <= 3 ) {
					ciudades[i].setinfeccion(ciudades[i].getinfeccion() + 1);
					j++;
				}
			}
			
			if(i == 47) {
				i = 0;
			}else {
				i++;
			}
			
		}
	}

	private void modifcarAcciones() {
		Acciones.setText("acciones: " + acciones);
	}
	
	private void pasarRonda() {
		Rondas.setText("ronda " + ronda);
	}

	private void investigarVacuna(Vacunas vacuna, JProgressBar prog, int porcVac, Ciudad[] ciudades, int infectadasRonda) {
		if(vacuna.getporcentaje() >= 100) {
			JOptionPane.showMessageDialog(null, "Ya esta investigado");
		}else if(acciones !=4){
			JOptionPane.showMessageDialog(null, "No puedes investigar, no tienes acciones suficientes");
		}else {
			vacuna.setporcentaje( vacuna.getporcentaje() + porcVac);
			prog.setValue(vacuna.getporcentaje());
			ronda++;
			modifcarAcciones();
    		pasarRonda();
    		infectarCiudades(ciudades, infectadasRonda);
		}
	}
}