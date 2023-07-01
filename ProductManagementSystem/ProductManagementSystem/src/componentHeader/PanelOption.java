package componentHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import color.ColorBackground;
import view.MainForm;
import view.PanelMode;

import javax.swing.ImageIcon;

public class PanelOption extends JPanel {

	private Color color = new Color(17, 19, 21);
	private Color color1 = new Color(39, 43, 49);
	private ButtonOption btnCheckReading;
	private ButtonOption btnDelete;
	
	Icon iconCheckWhite = new ImageIcon(PanelOption.class.getResource("/icon/check-white.png"));
	Icon iconDeleteWhite = new ImageIcon(PanelOption.class.getResource("/icon/delete-white.png"));
	
	
	Icon iconCheckBlack = new ImageIcon(PanelOption.class.getResource("/icon/check-black.png"));
	Icon iconDeleteBlack = new ImageIcon(PanelOption.class.getResource("/icon/delete-black.png"));
	
	
	public PanelOption() {
		setOpaque(false);
		btnCheckReading = new ButtonOption();
		btnCheckReading.setIcon(iconCheckWhite);
		btnCheckReading.setFont(new Font("Roboto", Font.BOLD, 16));
		btnCheckReading.setText("   Đánh dấu đã đọc");

		btnDelete = new ButtonOption();
		btnDelete.setIcon(iconDeleteWhite);
		btnDelete.setFont(new Font("Roboto", Font.BOLD, 16));
		btnDelete.setText("   Xóa thông báo");

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnCheckReading, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(btnDelete, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(btnCheckReading, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		setLayout(groupLayout);
		
		if (MainForm.mode == "Dark") {
			setColorModeDark();
		} else {
			setColorModeLight();
		}

	}

	public void action() {
		PanelMode.actionButonModeDark(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setColorModeDark();

			}
		});

		PanelMode.actionButonModeLight(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setColorModeLight();

			}
		});
	}

	public void setColorModeDark() {
		setColor(ColorBackground.colorDark);

		setColor1(ColorBackground.colorGRB394348);
		btnCheckReading.setIcon(iconCheckWhite);
		btnDelete.setIcon(iconDeleteWhite);
	}

	public void setColorModeLight() {
		setColor(ColorBackground.colorLight);

		setColor1(ColorBackground.colorGRB181228202);
		
		btnCheckReading.setIcon(iconCheckBlack);
		btnDelete.setIcon(iconDeleteBlack);

	}

	public void addActionButtonCheck(ActionListener event) {
		btnCheckReading.addActionButton(event);
	}

	public void addActionButtonDelete(ActionListener event) {
		btnDelete.addActionButton(event);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(color1);
		int[] x = { 240, 250, 260 };
		int[] y = { 8, 0, 8 };
		g2.fillPolygon(x, y, 3);

		g2.setColor(color);
		g2.fillRoundRect(1, 8, getWidth(), getHeight() - 8, 25, 25);

		g2.setColor(color1);
		g2.drawRoundRect(0, 8, getWidth() - 1, getHeight() - 9, 25, 25);
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
