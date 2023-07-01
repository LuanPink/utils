package componentSupplier;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelSupplier extends JPanel {

	
	public PanelSupplier() {
		setOpaque(false);
		
		JLabel lblBngiuKhin = new JLabel("Bảng Điều Khiển Nhà Cung Cấp");
		lblBngiuKhin.setForeground(new Color(252, 252, 252));
		lblBngiuKhin.setFont(new Font("Roboto", Font.BOLD, 30));
		
		PanelTableSupplier panel = new PanelTableSupplier();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
						.addComponent(lblBngiuKhin, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBngiuKhin, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
		
	}
}
