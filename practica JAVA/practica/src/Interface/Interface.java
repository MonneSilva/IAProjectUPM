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
import java.util.Stack;
import javax.swing.JTextField;

public class Interface extends Metro{

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
    public String horario;
    public String tiempo;
    public String metros;
    public int modo = 0;
    private JTextField textField, estRec, dist;
    public double distancia;

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
        metro.createGraph();
        Metro.setBounds(0, 0, 1000, 700);
        Metro.setLocationRelativeTo(new JFrame());
        Metro.getContentPane().setBackground(new Color(190, 190, 190));
        Metro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Metro.getContentPane().setLayout(null);
        Metro.setResizable(false);
        Metro.setIconImage(new ImageIcon(getClass().getResource("../resources/FIM.gif")).getImage());

        ImageIcon leyenda = new ImageIcon(getClass().getResource("../resources/bandera.jpg"));
        JLabel panelLeyenda = new JLabel(leyenda);
        panelLeyenda.setBounds(280, 540, 707, 115);
        Metro.getContentPane().add(panelLeyenda);
        panelLeyenda.setLayout(null);

        //MAP
        dibujo = new Map();
        dibujo.setBackground(Color.BLACK);
        dibujo.repaint(100, 100, 15, 15);
        dibujo.setSize(707, 512);
        dibujo.setLocation(280, 17);
        Metro.getContentPane().add(dibujo);

        //Origen
        JPanel panelOrigen = new JPanel();
        panelOrigen.setBounds(20, 15, 240, 30);
        Metro.getContentPane().add(panelOrigen);
        panelOrigen.setBackground(new Color(190, 190, 190));
        panelOrigen.setLayout(null);

        //@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
        final JComboBox originStation = new JComboBox(metro.getStationsN().toArray());
        originStation.setBounds(70, 0, 170, 30);
        panelOrigen.add(originStation);

        JLabel lblSeleccionLaEstacion = new JLabel("From:");
        lblSeleccionLaEstacion.setBounds(4, 7, 45, 15);
        panelOrigen.add(lblSeleccionLaEstacion);

        //destino
        JPanel panelDestino = new JPanel();
        panelDestino.setLayout(null);
        panelDestino.setBounds(20, 60, 240, 30);
        panelDestino.setBackground(new Color(190, 190, 190));
        Metro.getContentPane().add(panelDestino);

        //@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
        Metro T = new Metro();
        /* T.createStations();
        T.createGraph();
        
        StarA A = new StarA();
        A.starASearch(T.getMetro().getNode(T.ueno), T.getMetro().getNode(T.suidobashi));*/

        final JComboBox detinyStation = new JComboBox(metro.getStationsN().toArray());
        detinyStation.setBounds(70, 0, 170, 30);
        panelDestino.add(detinyStation);

        JLabel label = new JLabel("To:");
        label.setBounds(4, 7, 50, 15);
        panelDestino.add(label);

        //Horas
        JPanel panelHoras = new JPanel();
        panelHoras.setBounds(20, 105, 240, 45);
        panelHoras.setBackground(new Color(190, 190, 190));
        Metro.getContentPane().add(panelHoras);
        panelHoras.setLayout(null);

        /*JLabel lblSeleccionaLaHora = new JLabel("Hora salida:");
		lblSeleccionaLaHora.setBounds(4, 7, 70, 15);
		panelHoras.add(lblSeleccionaLaHora);
		JLabel lblInfoHora = new JLabel("*:Hora punta. Menor tiempo espera");
		lblInfoHora.setBounds(4, 30, 240, 15);
		panelHoras.add(lblInfoHora);

		@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
		final JComboBox desplegableHora = new JComboBox(metro.);
		desplegableHora.setBounds(140, 0, 100, 30);
		panelHoras.add(desplegableHora);

		//N� estaciones recorridas
		JPanel panelRecorridas = new JPanel();
		panelRecorridas.setBounds(20, 360, 240, 40);
		panelRecorridas.setBackground(new Color(190,190,190));
		Metro.getContentPane().add(panelRecorridas);
		panelRecorridas.setLayout(null);
		estRec = new JTextField();
		estRec.setBounds(0, 18, 240, 25);
		estRec.setEditable(false);
		panelRecorridas.add(estRec);

		JLabel numEstRec = new JLabel(":");
		numEstRec.setBounds(0, 0, 197, 15);
		panelRecorridas.add(numEstRec);
         */
        //Lista estaciones recorridas
        JPanel panelListado = new JPanel();
        panelListado.setBounds(20, 418, 240, 237);
        Metro.getContentPane().add(panelListado);
        panelListado.setLayout(null);
        panelListado.setBackground(new Color(190, 190, 190));
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(0, 20, 240, 217);
        panelListado.add(scrollPane);

        JLabel lblEstacionesRecorrer1 = new JLabel("Stations List:");
        lblEstacionesRecorrer1.setBounds(0, 0, 220, 15);
        panelListado.add(lblEstacionesRecorrer1);

        //distancia
        JPanel panelDistancia = new JPanel();
        panelDistancia.setBounds(20, 250, 240, 40);
        Metro.getContentPane().add(panelDistancia);
        panelDistancia.setLayout(null);
        dist = new JTextField();
        dist.setBounds(0, 18, 240, 25);
        dist.setEditable(false);
        panelDistancia.add(dist);
        panelDistancia.setBackground(new Color(190, 190, 190));

        JLabel lblDistancia = new JLabel("Distance travel: ");
        lblDistancia.setBounds(0, 0, 191, 15);
        panelDistancia.add(lblDistancia);

        //Duracion
        JPanel panelDuracion = new JPanel();
        panelDuracion.setBounds(20, 305, 240, 40);
        Metro.getContentPane().add(panelDuracion);
        panelDuracion.setLayout(null);
        textField = new JTextField();
        textField.setBounds(0, 18, 240, 25);
        textField.setEditable(false);
        panelDuracion.add(textField);
        panelDuracion.setBackground(new Color(190, 190, 190));

        JLabel lblTiempoEstimadoEn = new JLabel("Time Travel:");
        lblTiempoEstimadoEn.setBounds(0, 0, 191, 15);
        panelDuracion.add(lblTiempoEstimadoEn);

        final JButton botonReset = new JButton("New Search");
        Metro.getContentPane().add(botonReset);
        botonReset.setEnabled(false);
        //boton calcular
        final JButton botonCalcular = new JButton("Search");
        botonCalcular.setBounds(86, 165, 95, 30);
        Metro.getContentPane().add(botonCalcular);
        botonCalcular.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
            public void actionPerformed(ActionEvent arg0) {

                stationF = originStation.getSelectedItem().toString();
                stationT = detinyStation.getSelectedItem().toString();
                resultado = StarA.Search(metro.getMetro().getNode(stationF), metro.getMetro().getNode(stationT));
                Graphics g = dibujo.getGraphics();
                g.setColor(Color.BLUE);
                Node N,lastN = null;
                double distan=0;
                int j=resultado.size();
                for (int i=0;i<j;i++) {
                    N=resultado.pop();
                	if(i==(j-1))
                		distan=N.getG();
                    if (lastN != null) {
                        if (lastN.getStation().equals(N.getStation())) {
                            imp += "intercambio" + "\n";
                        }
                    }      
                    
                    imp += N.getStation().getName() + "\n";
                        lastN = N;
                }
               
                //FUNCTION TO FILL THE PIXEL kl
                //g.fillRect(82, 42, 5, 5);
                //}
                double tempo=distan/35; //tiempo en horas
                tempo=tempo*3600;
                int minuts= (int)tempo/60;
                int secs= (int)tempo-(minuts*60);
                textArea.setText(imp);
                textField.setText("minutes:"+minuts+";  seconds:"+secs);
                DecimalFormat df = new DecimalFormat("#.000");;
                dist.setText( df.format(distan)+ " km");
                botonCalcular.setEnabled(false);
                botonReset.setEnabled(true);
                
            }
        });

        //boton nueva busqueda
        botonReset.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
            public void actionPerformed(ActionEvent arg0) {

                //metro.limpiarVariables();
                imp = "";
                tiempo = "";
                metros = "";
                stationF = null;
                stationT = null;
                resultado = null;
                textArea.setText(imp);
                textField.setText(tiempo);
                dist.setText("");
                dibujo.repaint();
                botonReset.setEnabled(false);
                botonCalcular.setEnabled(true);

            }
        });
        botonReset.setBounds(86, 210, 115, 30);
        Metro.getContentPane().add(botonReset);
    }

    public static String distanciaRedondeada(double distancia) {
        double parteEntera, resultado;
        resultado = distancia / 1000;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, 2);
        resultado = Math.round(resultado);
        //resultado=(resultado/Math.pow(10, 2))+parteEntera;
        return (int) parteEntera + " kil�metros " + (int) ((resultado / Math.pow(10, 2)) * 1000) + " metros ";
    }
}
