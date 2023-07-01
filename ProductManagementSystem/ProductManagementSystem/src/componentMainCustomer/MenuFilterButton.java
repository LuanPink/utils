package componentMainCustomer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MenuFilterButton extends JButton {

	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public MenuFilterButton(String text, int index) {
		this.index = index;
		setText(text);
		setBorder(new EmptyBorder(1, 20, 1, 1));
		init();
	}
	
	public void init() {
		setOpaque(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setForeground(new Color(0,0,0));
		
		setFont(new Font("Roboto", Font.PLAIN, 18));
		setHorizontalAlignment(JButton.LEFT);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

}
