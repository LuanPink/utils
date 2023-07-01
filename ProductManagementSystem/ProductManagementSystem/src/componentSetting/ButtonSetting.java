package componentSetting;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
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
import view.PanelMode;

public class ButtonSetting extends JButton {

	private int indexSelected;
	private Color color = ColorBackground.colorDark;
	private Color color1 = new Color(78, 79, 81);

	private Color color3 = ColorBackground.colorGRB147147147;
	String text;

	public ButtonSetting(int index, String text) {
		this.indexSelected = index;
		this.text = text;
		setOpaque(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setForeground(color1);

		setHorizontalAlignment(SwingConstants.LEFT);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (MainForm.mode == "Dark") {
					color1 = ColorBackground.colorGRB252252239;
					repaint();
				} else {
					color1 = ColorBackground.colorGRB394348;
					repaint();
				}

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (MainForm.mode == "Dark") {
					color1 = new Color(78, 79, 81);
				} else {
					color1 = ColorBackground.colorGRB147147147;
				}
				repaint();
			}
		});

	}

	public int getIndexSelected() {
		return indexSelected;
	}

	public void setIndexSelected(int indexSelected) {
		this.indexSelected = indexSelected;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		g2.setColor(color1);
		int w = getWidth() - getWidth() * 90 / 100;
		g2.drawString(text, w, getHeight() / 2 + 5);
		super.paintComponent(g);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		repaint();
	}

	public Color getColor1() {
		return color1;
	}

	public void setColor1(Color color1) {
		this.color1 = color1;
		repaint();
	}

}
