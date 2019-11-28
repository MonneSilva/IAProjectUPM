import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;

public class Interfaz extends EstacionesMonterrey{

	private AlgoritmoEstrella metro = new AlgoritmoEstrella();
	private JFrame Metro;
	public AtributosEstacion Psalida;
	public AtributosEstacion Pllegada;
	public AtributosEstacion[] resultado;
	public JTextArea textArea;
	public String imp="";
	public JPanel dibujo,dibujo2;
	public double minutos;
	public double segundos;
	public String horario;
	public String tiempo;
	public String metros;
	public int modo=0;
	private JTextField textField,estRec,dist;
	public double distancia;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.Metro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interfaz(){
		initialize();
	}

	private void initialize() {
		//marco
		Metro = new JFrame();
		Metro.setTitle("Metro de Monterrey");
		Metro.setBounds(0, 0, 1000, 700);
		Metro.setLocationRelativeTo(new JFrame());
		Metro.getContentPane().setBackground(new Color(190,190,190));
		Metro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Metro.getContentPane().setLayout(null);
		Metro.setResizable(false);
		Metro.setIconImage(new ImageIcon(getClass().getResource("/resources/FIM.gif")).getImage());

		//leyenda
		ImageIcon leyenda = new ImageIcon (getClass().getResource("/resources/bandera.jpg"));		
		JLabel panelLeyenda = new JLabel(leyenda);
		panelLeyenda.setBounds(280, 540, 707, 115);
		Metro.getContentPane().add(panelLeyenda);
		panelLeyenda.setLayout(null);


		//imagen mapa
		dibujo=new ImagenMapa();
		dibujo.setBackground(Color.BLACK);
		dibujo.repaint(100, 100, 15, 15);
		dibujo.setSize(707, 512);
		dibujo.setLocation(280, 17);
		Metro.getContentPane().add(dibujo);

		//Origen
		JPanel panelOrigen = new JPanel();
		panelOrigen.setBounds(20, 15, 240, 30);
		Metro.getContentPane().add(panelOrigen);
		panelOrigen.setBackground(new Color(190,190,190));
		panelOrigen.setLayout(null);

		@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
		final JComboBox desplegableOrigen = new JComboBox(metro.Paradas);
		desplegableOrigen.setBounds(70, 0, 170, 30);
		panelOrigen.add(desplegableOrigen);

		JLabel lblSeleccionLaEstacion = new JLabel("Origen:");
		lblSeleccionLaEstacion.setBounds(4, 7, 45, 15);
		panelOrigen.add(lblSeleccionLaEstacion);

		//destino
		JPanel panelDestino = new JPanel();
		panelDestino.setLayout(null);
		panelDestino.setBounds(20, 60, 240, 30);
		panelDestino.setBackground(new Color(190,190,190));
		Metro.getContentPane().add(panelDestino);

		@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
		final JComboBox desplegableDestino = new JComboBox(metro.Paradas);
		desplegableDestino.setBounds(70, 0, 170, 30);
		panelDestino.add(desplegableDestino);

		JLabel label = new JLabel("Destino:");
		label.setBounds(4, 7, 50, 15);
		panelDestino.add(label);

		//Horas
		JPanel panelHoras = new JPanel();
		panelHoras.setBounds(20, 105, 240, 45);
		panelHoras.setBackground(new Color(190,190,190));
		Metro.getContentPane().add(panelHoras);
		panelHoras.setLayout(null);

		JLabel lblSeleccionaLaHora = new JLabel("Hora salida:");
		lblSeleccionaLaHora.setBounds(4, 7, 70, 15);
		panelHoras.add(lblSeleccionaLaHora);
		JLabel lblInfoHora = new JLabel("*:Hora punta. Menor tiempo espera");
		lblInfoHora.setBounds(4, 30, 240, 15);
		panelHoras.add(lblInfoHora);

		@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
		final JComboBox desplegableHora = new JComboBox(metro.horario);
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

		JLabel numEstRec = new JLabel("N�mero de estaciones recorridas:");
		numEstRec.setBounds(0, 0, 197, 15);
		panelRecorridas.add(numEstRec);

		//Lista estaciones recorridas
		JPanel panelListado = new JPanel();
		panelListado.setBounds(20, 418, 240, 237);
		Metro.getContentPane().add(panelListado);
		panelListado.setLayout(null);
		panelListado.setBackground(new Color(190,190,190));
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Arial", Font.PLAIN, 12));
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(0, 20, 240, 217);
		panelListado.add(scrollPane);

		JLabel lblEstacionesRecorrer1 = new JLabel("Lista de estaciones a recorrer:");
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
		panelDistancia.setBackground(new Color(190,190,190));

		JLabel lblDistancia = new JLabel("Distancia aproximada del viaje: ");
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
		panelDuracion.setBackground(new Color(190,190,190));

		JLabel lblTiempoEstimadoEn = new JLabel("Duraci�n aproximada del viaje: ");
		lblTiempoEstimadoEn.setBounds(0, 0, 191, 15);
		panelDuracion.add(lblTiempoEstimadoEn);

		final JButton botonReset = new JButton("Nuevo calculo");
		Metro.getContentPane().add(botonReset);
		botonReset.setEnabled(false);
		//boton calcular
		final JButton botonCalcular = new JButton("Calcular");
		botonCalcular.setBounds(86, 165, 95, 30);
		Metro.getContentPane().add(botonCalcular);
		botonCalcular.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {

				Psalida = (AtributosEstacion) desplegableOrigen.getSelectedItem();
				Pllegada= (AtributosEstacion) desplegableDestino.getSelectedItem();
				horario=(String) desplegableHora.getSelectedItem();
				int i=0;
				if(modo!=2)
				{
					if(horario=="7:00-9:30*"||horario=="13:00-15:00*"||horario=="19:00-21:30*"){
						modo=0;	
					}

					if(horario=="5:00-7:00"||horario=="9:30-13:00"||horario=="15:00-19:00"||horario=="21:30-23:00"){
						modo=1;	
					}
				}
				resultado=metro.AlgoritmoAEstrella(Psalida,Pllegada,modo);
				minutos=metro.getTiempo();
				segundos=metro.getSegundos();
				distancia=metro.getDistancia();
				Graphics g = dibujo.getGraphics();
				g.setColor(Color.BLUE);
				while(i<resultado.length){


					if (resultado.length==1){
						imp="Origen: "+resultado[i]+"\n";
						imp=imp+"Destino: "+resultado[i];
					} else {
						if (i==0)
							imp="Origen: "+resultado[i]+"\n";
						else if(i==(resultado.length-1))
							imp=imp+"Destino: "+resultado[i];
						else
							imp=imp+" -> "+resultado[i]+"\n";
						if (i!=0 && i!=(resultado.length-1) && resultado[i-1].getLineas().length==1 && resultado[i+1].getLineas().length==1
								&& !resultado[i-1].getLineas()[0].equals(resultado[i+1].getLineas()[0]))
							imp=imp+"Transbordo con la l�nea "+resultado[i+1].getLineas()[0]+".\n";
					}

					//Linea Amarilla
					if(resultado[i]==Talleres){
						g.fillRect(82, 42, 5, 5);}
					if(resultado[i]==San_Bernabe){
						g.fillRect(131, 91, 5, 5);}
					if(resultado[i]==Unidad_Modelo){
						g.fillRect(164, 124, 5, 5);}
					if(resultado[i]==Aztlan){
						g.fillRect(196, 156, 5, 5);}
					if(resultado[i]==Penitenciaria){
						g.fillRect(223, 191, 5, 5);}
					if(resultado[i]==Alfonso_Reyes){
						g.fillRect(223, 227, 5, 5);}
					if(resultado[i]==Mitras){
						g.fillRect(223, 260, 5, 5);}
					if(resultado[i]==Simon_Bolivar){
						g.fillRect(223, 298, 5, 5);}
					if(resultado[i]==Hospital){
						g.fillRect(223, 333, 5, 5);}
					if(resultado[i]==Edison){
						g.fillRect(262, 346, 5, 5);}
					if(resultado[i]==Central){
						g.fillRect(306, 346, 5, 5);}
					if(resultado[i]==Cuauhtemoc){
						g.fillRect(358, 346, 5, 5);}
					if(resultado[i]==Del_Golfo){
						g.fillRect(410, 346, 5, 5);}
					if(resultado[i]==Felix_U_Gomez){
						g.fillRect(458, 346, 5, 5);}
					if(resultado[i]==Parque_Fundidora){
						g.fillRect(506, 346, 5, 5);}
					if(resultado[i]==Y_Griega){
						g.fillRect(551, 346, 5, 5);}
					if(resultado[i]==Eloy_Cavazos){
						g.fillRect(595, 357, 5, 5);}
					if(resultado[i]==Lerdo_de_Tejada){
						g.fillRect(638, 357, 5, 5);}
					if(resultado[i]==Exposicion){
						g.fillRect(680, 357, 5, 5);}

					//Linea Verde
					if(resultado[i]==Sendero){
						g.fillRect(374, 4, 5, 5);}
					if(resultado[i]==Santiago_Tapia){
						g.fillRect(374, 43, 5, 5);}
					if(resultado[i]==San_Nicolas){
						g.fillRect(374, 80, 5, 5);}
					if(resultado[i]==Anahuac){
						g.fillRect(374, 120, 5, 5);}
					if(resultado[i]==Universidad){
						g.fillRect(374, 179, 5, 5);}
					if(resultado[i]==Ninos_Heroes){
						g.fillRect(374, 213, 5, 5);}  
					if(resultado[i]==Regina){
						g.fillRect(358, 250, 5, 5);}  
					if(resultado[i]==General_Anaya){
						g.fillRect(358, 291, 5, 5);}
					if(resultado[i]==Alameda){
						g.fillRect(358, 413, 5, 5);}  
					if(resultado[i]==Fundadores){
						g.fillRect(358, 460, 5, 5);}  
					if(resultado[i]==Padre_Mier){
						g.fillRect(376, 488, 5, 5);}                       
					if(resultado[i]==General_I_Zaragoza){
						g.fillRect(414, 488, 5, 5); 
					}

					//Linea Rosa
					if(resultado[i]==Hospital_Metropolitano){
						g.fillRect(569, 141, 5, 5);}
					if(resultado[i]==Los_angeles){
						g.fillRect(538, 172, 5, 5);}
					if(resultado[i]==Ruiz_Cortines){
						g.fillRect(505, 205, 5, 5);}
					if(resultado[i]==Violeta){
						g.fillRect(470, 240, 5, 5);}
					if(resultado[i]==Conchello){
						g.fillRect(458, 290, 5, 5);}                   
					if(resultado[i]==Adolfo_Prieto){
						g.fillRect(458, 409, 5, 5);}                   
					if(resultado[i]==Santa_Lucia){
						g.fillRect(458, 464, 5, 5);}

					i++;

				}

				textArea.setText(imp);
				tiempo=(int)minutos+" minutos "+(int)segundos+" segundos";
				textField.setText(tiempo);
				estRec.setText(Integer.toString(i));
				botonCalcular.setEnabled(false);
				botonReset.setEnabled(true);
				metros=distanciaRedondeada(distancia);
				dist.setText(metros);
			}
		});



		//boton nueva busqueda
		botonReset.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {

				metro.limpiarVariables();
				imp="";
				tiempo="";
				metros="";
				Psalida=null;
				Pllegada=null;
				resultado=null;
				textArea.setText(imp);
				textField.setText(tiempo);
				dist.setText(metros);
				estRec.setText("");
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
		resultado = distancia/1000;
		parteEntera = Math.floor(resultado);
		resultado=(resultado-parteEntera)*Math.pow(10, 2);
		resultado=Math.round(resultado);
		//resultado=(resultado/Math.pow(10, 2))+parteEntera;
		return (int)parteEntera+" kil�metros "+(int)((resultado/Math.pow(10, 2))*1000)+" metros ";
	}
}