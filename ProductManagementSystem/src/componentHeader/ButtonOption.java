package componentHeader;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import color.ColorBackground;
import componentLogin.MainLogin;
import view.MainForm;

public class ButtonOption extends JButton {
	private int indexSelected;
	private Color color1 = new Color(78, 79, 81);
	private Color color2 = new Color(252, 252, 252);
	private Color color3 = new Color(17, 19, 21);

	public ButtonOption() {
		setOpaque(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setBorder(new EmptyBorder(8, 20, 8, 5));

		setHorizontalAlignment(SwingConstants.LEFT);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (MainForm.mode == "Dark") {
					setForeground(color2);
				} else {
					setForeground(color1);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (MainForm.mode == "Dark") {
					setForeground(color1);
				} else {
					setForeground(ColorBackground.colorGRB147147147);
				}
			}
		});

	}

	public void addActionButton(ActionListener event) {
		addActionListener(event);
	}

	public int getIndexSelected() {
		return indexSelected;
	}

	public void setIndexSelected(int indexSelected) {
		this.indexSelected = indexSelected;
	}

}
