package componentMainCustomer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Stroke;

import javax.swing.JComponent;

public class Circle extends JComponent{
	
	private Image image;
	public Circle(Image img) {
		this.image = img;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.decode("#D96A77"));
		g2.drawOval(0, 0, getWidth() -1 , getHeight()-1);
		
		g2.drawImage(image,2, 2, null);
		

	}
}
