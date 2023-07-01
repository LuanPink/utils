package componentMainCustomer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class MenuFilterItem extends JPanel {

	private int index;
	private JCheckBox com;
	private boolean isSelected = false;
	private int i = 1;
	private String text;
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public MenuFilterItem(String text, int index) {
		setOpaque(false);
		setLayout(new MigLayout("fillx"));
		com = new JCheckBox();
		com.setFont(new Font("Roboto", Font.PLAIN, 16));
		com.setFocusPainted(false);
		com.setCursor(new Cursor(Cursor.HAND_CURSOR));
		com.setForeground(new Color(207, 106, 119));
		com.setText("   " + text);
		add(com);
		action();
	}

	public void action() {
		com.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				i++;
				if (i % 2 == 0) {
					isSelected = true;
					System.out.println(com.getText());;
				}else {
					isSelected =false;
				}
			}
		});
	}

	public JCheckBox getCom() {
		return com;
	}

	public void setCom(JCheckBox com) {
		this.com = com;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	

}
