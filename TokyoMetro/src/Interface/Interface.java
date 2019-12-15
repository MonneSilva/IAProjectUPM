package Interface;

import Graph.Node;
import Metro.Metro;
import Search.StarA;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

public class Interface extends Metro {

    private Metro metro = new Metro();
    private JFrame Metro;
    public String stationF;
    public String stationT;
    public Stack<Node> resultado;
    public JTextArea textArea;
    public String imp = "";
    public JPanel dibujo, dibujo2;
    public double minutos;
    public double segundos;
    private Font font = new Font("Agency FB", Font.BOLD, 14);
    public String horario;
    public String tiempo;
    public String metros;
    public int modo = 0;
    private JTextField textField, dist;
    public double distancia;
    ArrayList<String> StationsFinal;
    DefaultListModel listModel = new DefaultListModel();
    JList List;
    //boton calcular
        final JButton botonCalcular = new JButton("Search");

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interface window = new Interface();
                    window.Metro.setVisible(true);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Interface() {
        initialize();
    }

    private void initialize() {
        //marco
        Metro = new JFrame();
        Metro.setTitle("Tokyo RP Metro");
        metro.createStations();
        Metro.setBounds(0, 0, 1000, 590);
        Metro.setLocationRelativeTo(new JFrame());
        Metro.getContentPane().setBackground(new Color(190, 190, 190));
        Metro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Metro.getContentPane().setLayout(null);
        Metro.setResizable(false);
        Metro.setIconImage(new ImageIcon(getClass().getResource("../resources/FIM.gif")).getImage());

       
        //FROM
        JPanel panelOrigen = new JPanel();
        panelOrigen.setBounds(20, 15, 240, 30);
        Metro.getContentPane().add(panelOrigen);
        panelOrigen.setBackground(new Color(190, 190, 190));
        panelOrigen.setLayout(null);

        final JComboBox originStation = new JComboBox(metro.getStationsN().toArray());
        originStation.setFont(font);
        originStation.setBounds(70, 0, 170, 30);
        panelOrigen.add(originStation);

        JLabel lblSeleccionLaEstacion = new JLabel("From:");
        lblSeleccionLaEstacion.setBounds(4, 7, 45, 15);
        lblSeleccionLaEstacion.setFont(font);
        panelOrigen.add(lblSeleccionLaEstacion);
        
        //TO
        JPanel panelDestino = new JPanel();
        panelDestino.setLayout(null);
        panelDestino.setBounds(20, 60, 240, 30);
        panelDestino.setBackground(new Color(190, 190, 190));
        Metro.getContentPane().add(panelDestino);
        Metro T = new Metro();
        final JComboBox detinyStation = new JComboBox(metro.getStationsN().toArray());
        detinyStation.setFont(font);
        detinyStation.setBounds(70, 0, 170, 30);
        panelDestino.add(detinyStation);
        JLabel label = new JLabel("To:");
        label.setBounds(4, 7, 50, 15);
        label.setFont(font);
        panelDestino.add(label);   
        //HOURS
        JPanel panelHoras = new JPanel();
        panelHoras.setBounds(20, 105, 240, 45);
        panelHoras.setBackground(new Color(190, 190, 190));
        Metro.getContentPane().add(panelHoras);
        panelHoras.setLayout(null);

        //TRAVEL STATIONS
        JPanel panelListado = new JPanel();
        panelListado.setBounds(20, 290, 240, 237);
        Metro.getContentPane().add(panelListado);
        panelListado.setLayout(null);
        panelListado.setBackground(new Color(190, 190, 190));
        List = new JList();
        if(StationsFinal!=null){
        for (String S : this.StationsFinal) {
            listModel.addElement(S);
        }
        List.setModel(listModel);
        }
        JScrollPane scrollPane = new JScrollPane(List);
        scrollPane.setBounds(0, 20, 240, 217);
        panelListado.add(scrollPane);
        JLabel lblEstacionesRecorrer1 = new JLabel("Stations List:");
        lblEstacionesRecorrer1.setBounds(0, 0, 220, 15);
        panelListado.add(lblEstacionesRecorrer1);

        //DISTANCE
        JPanel panelDistancia = new JPanel();
        panelDistancia.setBounds(20, 150, 240, 40);
        Metro.getContentPane().add(panelDistancia);
        panelDistancia.setLayout(null);
        dist = new JTextField();
        dist.setBounds(0, 18, 240, 25);
        Font font = new Font("Agency FB", Font.BOLD, 14);
        dist.setFont(font);
        dist.setEditable(false);
        panelDistancia.add(dist);
        panelDistancia.setBackground(new Color(190, 190, 190));
        JLabel lblDistancia = new JLabel("Distance travel: ");
        lblDistancia.setBounds(0, 0, 191, 15);
        panelDistancia.add(lblDistancia);
        //Duracion
        JPanel panelDuracion = new JPanel();
        panelDuracion.setBounds(20, 205, 240, 40);
        Metro.getContentPane().add(panelDuracion);
        panelDuracion.setLayout(null);
        textField = new JTextField();
        textField.setBounds(0, 18, 240, 25);
        textField.setEditable(false);
        textField.setFont(font);
        panelDuracion.add(textField);
        panelDuracion.setBackground(new Color(190, 190, 190));

        JLabel lblTiempoEstimadoEn = new JLabel("Time Travel:");
        lblTiempoEstimadoEn.setBounds(0, 0, 191, 15);
        panelDuracion.add(lblTiempoEstimadoEn);
        
        
        botonCalcular.setBounds(86, 100, 95, 30);
        botonCalcular.setFont(font);
        Metro.getContentPane().add(botonCalcular);

        
        //MAP
        dibujo = new Map();
        dibujo.setBackground(Color.BLACK);
        dibujo.repaint(100, 100, 15, 15);
        dibujo.setSize(707, 512);
        dibujo.setLocation(280, 17);
        Metro.getContentPane().add(dibujo);

        originStation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imp = "";
                tiempo = "";
                metros = "";
                stationF = null;
                stationT = null;
                resultado = null;
                textField.setText(tiempo);           
                listModel.removeAllElements();
                dist.setText("");
                dibujo.repaint();
                  botonCalcular.setEnabled(true);

            }
        });
        detinyStation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imp = "";
                tiempo = "";
                metros = "";
                stationF = null;
                stationT = null;
                resultado = null;
                listModel.removeAllElements();
                textField.setText(tiempo);
                dist.setText("");
                dibujo.repaint();
                botonCalcular.setEnabled(true);

            }
        });
        botonCalcular.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
            public void actionPerformed(ActionEvent arg0) {
               StationsFinal = new ArrayList();
                stationF = originStation.getSelectedItem().toString();
                stationT = detinyStation.getSelectedItem().toString();
                metro.createGraph();
                resultado = StarA.Search(metro.getMetro().getNode(stationF), metro.getMetro().getNode(stationT));
                Graphics g = dibujo.getGraphics();
                g.setColor(Color.YELLOW);
                Node N, lastN = null;
                double distan = 0;
                int j = resultado.size();

                for (int i = 0; i < j; i++) {
                    N = resultado.pop();
                    g.fillOval(N.getXFromNode(), N.getYFromNode(), 10, 10);
                    if (i == (j - 1)) {
                        distan = N.getG();
                    }
                    if (lastN != null) {
                        if (!lastN.getStation().equals(N.getStation())) {
                            //imp += N.getStation().getName() + "\n";
                            StationsFinal.add(N.getStation().getName());
                        }
                    } else {
                        //imp += N.getStation() + "\n";
                        StationsFinal.add(N.getStation().getName());
                    }
                    lastN = N;
                }
                double time = distan / 35; //tiempo en horas
                time = time * 3600;
                int minuts = (int) time / 60;
                int secs = (int) time - (minuts * 60);
                updateSL();
                textField.setText("minutes:" + minuts + ";  seconds:" + secs);
                DecimalFormat df = new DecimalFormat("#.000");;
                dist.setText(df.format(distan) + " km");
                botonCalcular.setEnabled(false);
                

            }
        });

    }

    final public void updateSL() {
        for (String S : this.StationsFinal) {
            //Añadir cada elemento del ArrayList en el modelo de la lista
            listModel.addElement(S);
        }
//Asociar el modelo de lista al JList
        List.setModel(listModel);
    }

}
