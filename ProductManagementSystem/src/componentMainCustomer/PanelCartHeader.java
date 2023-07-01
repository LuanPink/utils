package componentMainCustomer;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelCartHeader extends JPanel {
	private Color color = new Color(255,255,252);
	
	public PanelCartHeader() {
		setOpaque(false);
		
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D)g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(color);
				g2.fillRoundRect(0, 0, getWidth(), getHeight(),15,15);
				super.paintComponent(g);
			}
		};
		panel.setOpaque(false);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		
		ButtonChecked btnNewButton = new ButtonChecked();
		
		JLabel lblNewLabel = new JLabel("Sản Phẩm");
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		JLabel lblnGi = new JLabel("Đơn giá");
		lblnGi.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblnGi.setForeground(new Color(200,200,200));
		
		JLabel lblSLng = new JLabel("Số Lượng");
		lblSLng.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblSLng.setForeground(new Color(200,200,200));
		
		JLabel lblGiTin = new JLabel("Giá Tiền");
		lblGiTin.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblGiTin.setForeground(new Color(200,200,200));
		
		JLabel lblNewLabel_1 = new JLabel("Giỏ Hàng");
		lblNewLabel_1.setForeground(new Color(207, 106, 119));
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 18));
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 402, Short.MAX_VALUE)
							.addComponent(lblnGi)
							.addGap(86)
							.addComponent(lblSLng)
							.addGap(96)
							.addComponent(lblGiTin, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblGiTin, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblnGi, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblSLng, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addGap(11))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
	}
}
