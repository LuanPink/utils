package componentCreateProduct;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import color.ColorBackground;
import model.ModelProductSize;
import view.MainForm;

public class ButtonCheckedSizeAndColor2 extends JButton {
	private Color colorBackground = new Color(26, 29, 31);

	private Color colorhover1 = new Color(39, 43, 48);
	private Color colorhover2 = new Color(42, 133, 255);
	public int index;
	
	public ButtonCheckedSizeAndColor2(int index) {
		this.index = index;
		setOpaque(false);
		setFocusPainted(false);
		setBorder(null);
		setCursor(new Cursor(Cursor.HAND_CURSOR));

		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				 PanelManufacturerProduct.indexselected2=index;
				
				 PanelManufacturerProduct.get_Color();
				
			}
		});

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				colorhover1 = colorhover2;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (MainForm.mode == "Dark") {
					colorhover1 = ColorBackground.colorGRB394348;
				} else {
					colorhover1 = ColorBackground.colorGRB181228202;
				}
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(colorBackground);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		g2.setColor(colorhover1);
		g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		super.paintComponent(g);
	}	
	public Color getColorBackground() {
		return colorBackground;
	}

	public void setColorBackground(Color colorBackground) {
		this.colorBackground = colorBackground;
		repaint();
	}

	public Color getColorhover1() {
		return colorhover1;
	}

	public void setColorhover1(Color colorhover1) {
		this.colorhover1 = colorhover1;
		repaint();
	}

	public Color getColorhover2() {
		return colorhover2;
	}

	public void setColorhover2(Color colorhover2) {
		this.colorhover2 = colorhover2;
		repaint();
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
}
