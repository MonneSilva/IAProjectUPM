import java.awt.*;
import javax.swing.*;

public class ImagenMapa extends JPanel {

	private static final long serialVersionUID = 1L;
	EstacionesMonterrey metro2 = new EstacionesMonterrey();

	public ImagenMapa(){
		this.setBackground(Color.green);
	}

	public void paint(Graphics g) {
		super.paint(g);
		ImageIcon icono=new ImageIcon(getClass().getResource("/resources/metrojapon.jpg"));
		Image imagen=icono.getImage();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		
	}
}