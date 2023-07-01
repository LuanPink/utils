package componentMainCustomer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.*;

import componentMainCustomer.PanelHome;

public class ButtonAddToCard extends JButton {
	private Color color = new Color(252,252,252);
	String text;
	Image image;
	private Graphics2D g2;
	
	public ButtonAddToCard(String text,Image img) {
		this.text = text;
		this.image = img;
		
		setOpaque(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g2 = (Graphics2D)g;
		super.paintComponent(g);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.drawImage(image, 0, 0, null);
		g2.setColor(Color.decode("#00000"));
		g2.setFont(new Font("Roboto",Font.PLAIN,16));
		g2.drawString(text, getWidth() / 3, getHeight() / 2 + 5);
		
	}
}
