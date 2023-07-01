package componentIncome;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.*;

import color.ColorBackground;

public class LabelIconIncome extends JLabel {
	private Color color = ColorBackground.colorGRB181228202;

	public LabelIconIncome() {
		setOpaque(false);		
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		int w = getWidth() ;
		int h = getHeight() ;
		g2.fillOval(0, 0, w, h);

		super.paintComponent(g);
	}

}
