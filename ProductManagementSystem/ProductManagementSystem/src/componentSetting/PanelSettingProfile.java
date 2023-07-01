package componentSetting;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import color.ColorBackground;
import componentProduct.PanelOverview;
import view.MainForm;
import view.PanelMode;

public class PanelSettingProfile extends JPanel {
	private Color color1 = new Color(252, 252, 252);
	private JLabel lblTitle;
	
	
	public PanelSettingProfile() {
		setOpaque(false);
		lblTitle = new JLabel("Cài đặt");
		lblTitle.setForeground(color1);
		lblTitle.setFont(new Font("Roboto", Font.BOLD, 30));
		
		PanelSetting panel = new PanelSetting();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
						.addComponent(lblTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		if(MainForm.mode == "Dark") {
			lblTitle.setForeground(ColorBackground.colorLight);
		}else {
			lblTitle.setForeground(ColorBackground.colorDark);
		}
		action();
	}
	public void action() {
		PanelMode.actionButonModeLight(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblTitle.setForeground(ColorBackground.colorDark);
				
			}
		});
		
		PanelMode.actionButonModeDark(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblTitle.setForeground(ColorBackground.colorLight);
				
			}
		});
	}

}
