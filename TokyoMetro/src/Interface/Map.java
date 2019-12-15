package Interface;
import Metro.Station;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
public class Map extends JPanel {
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g) {
		super.paint(g);
		ImageIcon icono=new ImageIcon(getClass().getResource("metroJapon.jpg"));
		Image imagen=icono.getImage();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
        
}