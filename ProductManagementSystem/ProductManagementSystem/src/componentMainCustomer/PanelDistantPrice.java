package componentMainCustomer;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class PanelDistantPrice extends JPanel {

	public static JLabel lblLastPrice;
	public static JLabel lblFirstPrice;

	public PanelDistantPrice() {
		setOpaque(false);

		lblFirstPrice = new JLabel("1000");
		lblFirstPrice.setForeground(new Color(207, 106, 119));
		lblFirstPrice.setFont(new Font("Roboto", Font.PLAIN, 14));

		JLabel lblĐ1 = new JLabel("đ");
		lblĐ1.setForeground(new Color(207, 106, 119));
		lblĐ1.setFont(new Font("Roboto", Font.BOLD, 14));

		lblLastPrice = new JLabel("1000");
		lblLastPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastPrice.setForeground(new Color(207, 106, 119));
		lblLastPrice.setFont(new Font("Roboto", Font.PLAIN, 14));

		JLabel lblĐ2 = new JLabel("đ");
		lblĐ2.setForeground(new Color(207, 106, 119));
		lblĐ2.setFont(new Font("Roboto", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblFirstPrice)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblĐ1, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addComponent(lblĐ2, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLastPrice)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirstPrice, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblĐ1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLastPrice, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblĐ2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}


	
}
