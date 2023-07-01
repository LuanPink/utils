package componentCreateProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import color.ColorBackground;

public class Combobox extends JComboBox {

	private Color colorBackground = ColorBackground.colorGRB394348;
	private Color colorBackground1 = ColorBackground.colorLight;
	private Color color = ColorBackground.colorGRB000;
	private Color color2 = ColorBackground.colorLight;

	public Combobox() {
		setForeground(colorBackground1);
		setFocusable(false);
		setRenderer(new BasicComboBoxRenderer() {
			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				setFont(new Font("Roboto", Font.BOLD, 15));
				if (isSelected) {
					setBackground(colorBackground1);
					setForeground(color);
				} else {
					setBackground(color);
					setForeground(colorBackground1);
				}
				return this;
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(colorBackground);
		g2.fillRect(0, 0, getWidth(), getHeight());

		setMaximumRowCount(10);
		setFont(new Font("Roboto", Font.BOLD, 15));
		renderSelectedItem(g2);
		arrow(g2);

	}

	private void renderSelectedItem(Graphics2D g2) {
		int selectedIndex = getSelectedIndex();
		if (selectedIndex < 0) {
			return;
		}
		Object selectedItem = getItemAt(selectedIndex);
		String text = (selectedItem == null) ? "" : selectedItem.toString();
		g2.setColor(colorBackground1);
		g2.setFont(getFont());
		int textX = 20;
		int textY = (getHeight() + g2.getFontMetrics().getAscent() - 4) / 2;
		g2.drawString(text, textX, textY);
	}

	public void arrow(Graphics2D g2) {
//		g2.setColor(color2);
//		int x = getWidth() - 10;
//		int y = (getHeight() + g2.getFontMetrics().getAscent() - 4) / 2;
//		g2.drawLine(x, y - 3, x + 6, y - 9);
//		g2.drawLine(x - 6, y - 9, x, y - 3);
	}

	public Color getColorBackground() {
		return colorBackground;
	}

	public void setColorBackground(Color colorBackground) {
		this.colorBackground = colorBackground;
		repaint();
	}

	public Color getColorBackground1() {
		return colorBackground1;
	}

	public void setColorBackground1(Color colorBackground1) {
		this.colorBackground1 = colorBackground1;
		repaint();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		repaint();
	}

	public Color getColor2() {
		return color2;
	}

	public void setColor2(Color color2) {
		this.color2 = color2;
		repaint();
	}
	
	
	
	
}
