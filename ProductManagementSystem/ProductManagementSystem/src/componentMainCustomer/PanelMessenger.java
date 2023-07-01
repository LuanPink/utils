package componentMainCustomer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class PanelMessenger extends JPanel {
	private String text;
	public PanelMessenger(String text) {
		this.text = text;
		setOpaque(false);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(255,255,255));
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		g2.setColor(new Color(207,106,119));
		g2.setFont(getFont());
		g2.drawString(text, getWidth() - (getWidth()* 90 / 100), getHeight() / 2 + 5);
		super.paintComponent(g);
	}
}
