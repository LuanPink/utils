package componentMainCustomer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class PanelSeller extends JPanel {

	private Image image;
	public PanelSeller(Image image) {
		this.image = image;
		setOpaque(false);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.drawImage(image, 0, 0, null);
		super.paintComponent(g);
	}
}
