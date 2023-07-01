package componentMainCustomer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class DottedCircle extends JComponent {

	private Color color1 = Color.decode("#D96A77");
	private Image image;
	private String text;
	private String hover = "";

	public DottedCircle(Image image, String text) {
		this.image = image;
		this.text = text;
		setOpaque(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hover = "Hover";
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {

				hover = "";
				repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		float[] dash = { 2.0f };
		Stroke dotted = new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10.0f, dash, 0.0f);
		g2.setColor(color1);
		g2.setStroke(dotted);
		if(hover == "") {
			g2.drawOval(0, 0, (getWidth() - 1) / 2, getHeight() - 1);
		}
		
		else{
			g2.drawRoundRect(0, 0, getWidth() - 2, getHeight() - 1, 75, 75);
		}

		g2.setColor(Color.decode("#D96A77"));
		g2.drawImage(image, (getWidth() / 2) - 63, getHeight() / 2 - 25, null);
		g2.setFont(new Font("Roboto", Font.BOLD, 18));
		g2.drawString(text, getWidth() / 2 + 5, getHeight() / 2 + 5);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
