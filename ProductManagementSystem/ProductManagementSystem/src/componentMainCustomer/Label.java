package componentMainCustomer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Label extends JLabel {

	public Label(String text) {
		setText(text);
		setForeground(new Color(252, 252, 252));
		setFont(new Font("Roboto", Font.PLAIN, 14));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				setForeground(new Color(246, 126, 155));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setForeground(new Color(252, 252, 252));
				
			}
		});
	}

}
