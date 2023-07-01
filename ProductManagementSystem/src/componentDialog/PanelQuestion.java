package componentDialog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import color.ColorBackground;

public class PanelQuestion extends JPanel {
	private Color color = ColorBackground.colorGRB171921;
	
	public PanelQuestion() {
		setOpaque(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(),30,30);
		super.paintComponent(g);
	}

	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
		repaint();
	}
}
