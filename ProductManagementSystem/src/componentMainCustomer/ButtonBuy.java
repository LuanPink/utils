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


public class ButtonBuy extends JButton {

	private Color color = Color.decode("#FF786B") ;
	private Color color1 = new Color(0,0,0);
	private Color color2 = new Color(252,252,252);
	
	private String text;
	public ButtonBuy(String text) {
		this.text = text;
		setText(text);
		setForeground(color2);
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("Roboto",Font.BOLD,18));
		setOpaque(false);
		setBorder(null);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				color = Color.decode("#D96A77");
				repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				color =  Color.decode("#FF786B");
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

}
