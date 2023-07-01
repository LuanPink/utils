package componentMainCustomer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class ButtonChecked extends JLabel {

	private Color color = new Color(200,200,200);
	private Color color1 = new Color(217,106,119);
	private int index = 1;
	private Icon icon = new ImageIcon(ButtonChecked.class.getResource("/icon/check-white.png"));
	
	private boolean isSelected = false;
	
	public ButtonChecked() {
		setBorder(null);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setHorizontalAlignment(JLabel.CENTER);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index++;
				if(index %2 == 0) {
					isSelected = true;
				}else {
					isSelected = false;
				}
				repaint();
			}
		});
		
		
	}
	
	public void setIconAll() {
		setIcon(icon);
		color1 = new Color(217,106,119);
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1,15,15);
		setIcon(null);
		if(index %2 == 0) {
			setIcon(icon);
			g2.setColor(color1);
			g2.fillRoundRect(0, 0, getWidth(), getHeight(),15,15);
		}
		super.paintComponent(g);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
		repaint();
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	
	
}
