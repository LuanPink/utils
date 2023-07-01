package componentMainCustomer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class ButtonSeller extends JButton{
	private Color color = new Color(252,252,252) ;
	private Color color1 = new Color(0,0,0);
	private Color color2 = new Color(252,252,252);
	private String text;
	public ButtonSeller(String text) {
		this.text = text;
		setText(text);
		setForeground(color1);
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("Roboto",Font.BOLD,18));
		setOpaque(false);
		setBorder(null);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setFocusPainted(false);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setForeground(color2);
				color = Color.decode("#D96A77");
				repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setForeground(color1);
				color = new Color(252,252,252);
				repaint();
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(),15,15);
		super.paintComponent(g);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
