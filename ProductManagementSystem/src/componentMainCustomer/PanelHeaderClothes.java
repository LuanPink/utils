package componentMainCustomer;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelHeaderClothes extends JPanel {
	ImageIcon banner = new ImageIcon(
			new ImageIcon(PanelHome.class.getResource("/icon/banner-home.jpg")).getImage()
					.getScaledInstance(980, 200, Image.SCALE_SMOOTH));
	
	ImageIcon logo = new ImageIcon(
			new ImageIcon(PanelHome.class.getResource("/icon/logo-shop.png")).getImage()
					.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
	private String gender;
	public PanelHeaderClothes(String gender) {
		this.gender = gender;
		setOpaque(false);
		
		JLabel lblBanner = new JLabel();
		lblBanner.setIcon(banner);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		
		JLabel lblClothes = new JLabel("Thời Trang "+gender);
		lblClothes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClothes.setForeground(new Color(217, 106, 119));
		lblClothes.setFont(new Font("Roboto", Font.BOLD, 18));
		
		Arrow2 lblNewLabel = new Arrow2();
		lblNewLabel.setColor(new Color(217, 106, 119));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(logo);
		
		Arrow2 lblNewLabel_2 = new Arrow2();
		lblNewLabel_2.setColor(new Color(217, 106, 119));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 928, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(243)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblClothes, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(241, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 86, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblClothes, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBanner, GroupLayout.PREFERRED_SIZE, 927, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 928, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblBanner, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(83, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
}
