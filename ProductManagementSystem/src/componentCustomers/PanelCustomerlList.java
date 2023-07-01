package componentCustomers;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

import color.ColorBackground;
import componentProduct.PanelOverviewProductDashboard;
import componentProduct.PanelProductList;
import view.MainForm;
import view.PanelMode;

import javax.swing.JTextField;

public class PanelCustomerlList extends JPanel {
	private Color color1 = new Color(252, 252, 252);
	private JLabel lblTitle;
	private PanelTableCustomer panelTable;
	

	public PanelCustomerlList() {
		setOpaque(false);
		lblTitle = new JLabel("Bảng Điều Khiển Khách Hàng");
		lblTitle.setForeground(color1);
		lblTitle.setFont(new Font("Roboto", Font.BOLD, 30));
		
		panelTable = new PanelTableCustomer();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelTable, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
						.addComponent(lblTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelTable, GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
		
		
		if(MainForm.mode == "Light") {
			lblTitle.setForeground(ColorBackground.colorDark);
			panelTable.setColorCustomers(ColorBackground.colorLight);
		}else {
			lblTitle.setForeground(ColorBackground.colorLight);
			panelTable.setColorCustomers(ColorBackground.colorDark);
		}
		
		action();
	}
	
	public void action() {
		PanelMode.actionButonModeLight(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblTitle.setForeground(ColorBackground.colorDark);
				panelTable.setColorCustomers(ColorBackground.colorLight);
			}
		});
		
		PanelMode.actionButonModeDark(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblTitle.setForeground(ColorBackground.colorLight);
				panelTable.setColorCustomers(ColorBackground.colorDark);
			}
		});
	}
}
