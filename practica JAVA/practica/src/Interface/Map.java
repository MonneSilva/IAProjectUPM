package Interface;



import Metro.Metro;
import java.awt.*;
import javax.swing.*;

public class Map extends JPanel {

	private static final long serialVersionUID = 1L;
	//Metro metro2 = new Metro();

	public Map(){
		this.setBackground(Color.green);
	}

	public void paint(Graphics g) {
		super.paint(g);
		ImageIcon icono=new ImageIcon(getClass().getResource("/resources/metroJapon.jpg"));
		Image imagen=icono.getImage();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		
	}
}