package componentIncome;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

import componentProduct.CardProductDashboard;

import javax.swing.JLabel;
import java.awt.Font;

public class PanelOverviewIncomeDashboard extends JPanel {
	private Color color = new Color(26, 29, 31);
	private ImageIcon icon = new ImageIcon(PanelOverviewIncomeDashboard.class.getResource("/icon/shopping-white.png"));
	
	public PanelOverviewIncomeDashboard() {
		setOpaque(false);
		
		CardProductDashboard panel1 = new CardProductDashboard(icon,"Thu nhập","100");
		panel1.setOpaque(false);
		
		CardProductDashboard panel2 = new CardProductDashboard(icon,"Thu nhập trung bình","100");
		panel2.setOpaque(false);
		
		CardProductDashboard panel3 = new CardProductDashboard(icon,"Tổng giá trị thu nhập","100");
		panel3.setOpaque(false);
		
		JLabel lblTngQuan = new JLabel("Tổng quan");
		lblTngQuan.setForeground(new Color(252, 252, 252));
		lblTngQuan.setFont(new Font("Roboto", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTngQuan, GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel3, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addComponent(lblTngQuan, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(123, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		
		super.paintComponent(g);
	}
}
