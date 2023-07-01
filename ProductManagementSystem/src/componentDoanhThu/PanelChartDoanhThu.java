package componentDoanhThu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import color.ColorBackground;
import net.miginfocom.swing.MigLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComponent;
import javax.swing.LayoutStyle.ComponentPlacement;
import componentCreateProduct.ButtonCheckedSizeAndColor;

public class PanelChartDoanhThu extends JPanel {
	Color color1 = ColorBackground.colorDark;
	Color color2 = new Color(207, 106, 119);
	private JPanel panel;
	public static ButtonCheckedSizeAndColor btnCancel;

	public PanelChartDoanhThu() {
		setOpaque(false);

		panel = new JPanel();
		panel.setOpaque(false);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
					.addContainerGap())
		);

		btnCancel = new ButtonCheckedSizeAndColor(0);
		btnCancel.setText("Hủy");
		btnCancel.setFont(new Font("Roboto", Font.PLAIN, 16));
		btnCancel.setForeground(ColorBackground.colorLight);

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel_1.createSequentialGroup().addContainerGap(667, Short.MAX_VALUE).addComponent(btnCancel,
						GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addComponent(btnCancel,
				GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE));
		panel_1.setLayout(gl_panel_1);

		setLayout(groupLayout);

	}

	public void showPanel(JComponent com) {
		panel.removeAll();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(com,
				GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(com,
				GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE));
		panel.setLayout(gl_panel);
		panel.revalidate();
		panel.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color2);
		g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		g2.setColor(color1);
		g2.fillRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 15, 15);
		super.paintComponent(g);
	}
}
