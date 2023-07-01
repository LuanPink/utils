package componentStore;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

import color.ColorBackground;
import componentProduct.PanelOverviewProductDashboard;
import componentProduct.PanelProductList;
import net.miginfocom.swing.MigLayout;
import view.MainForm;
import view.PanelMode;

public class PanelHomeStore extends JPanel {

	private PanelBodyStore panelListProduct;
	private JLabel lblTitle;
	
	
	public PanelHomeStore() {
		setOpaque(false);
		lblTitle = new JLabel("Bảng Điều Khiển Sản Phẩm");

		lblTitle.setFont(new Font("Roboto", Font.BOLD, 30));
		lblTitle.setForeground(ColorBackground.colorLight);

		panelListProduct = new PanelBodyStore();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelListProduct, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 928,
										Short.MAX_VALUE)
								.addComponent(lblTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 928,
										Short.MAX_VALUE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panelListProduct, GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
						.addContainerGap()));

		setLayout(groupLayout);
		
		if(MainForm.mode == "Dark") {
			setColorModeDark();
		}else {
			setColorModeLight();
		}
		action();
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
		lblTitle.setForeground(ColorBackground.colorLight);
	}

	public void setColorModeLight() {
		lblTitle.setForeground(ColorBackground.colorDark);
	}
}
