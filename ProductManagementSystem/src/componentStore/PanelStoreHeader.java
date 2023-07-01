package componentStore;

import javax.swing.JPanel;

import icon.ImageAvatar;
import view.MainForm;
import view.PanelMode;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import color.ColorBackground;
import componentCreateProduct.ButtonCheckedSizeAndColor;
import componentCustomers.LablePurchase;

import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class PanelStoreHeader extends JPanel {

	private JLabel lblName;
	private JLabel lblContent;
	private ButtonCheckedSizeAndColor btnFilter;
	public static DialogFilterStoreProduct dialog;

	private Icon iconFilterWhite = new ImageIcon(PanelStoreHeader.class.getResource("/icon/filter-white.png"));
	private Icon iconFilterGray = new ImageIcon(PanelStoreHeader.class.getResource("/icon/filter-gray.png"));

	public PanelStoreHeader() {
		setOpaque(false);

		JPanel panel = new JPanel();
		panel.setOpaque(false);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup().addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 928,
												Short.MAX_VALUE)
										.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 928,
												Short.MAX_VALUE))
								.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(panel_1, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(55, Short.MAX_VALUE)));

		LablePurchase lblProductName = new LablePurchase("Sản Phẩm");
		lblProductName.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductName.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblProductName.setForeground(ColorBackground.colorLight);
		lblProductName.setColor(ColorBackground.colorGRB43122222);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(lblProductName, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(562, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(lblProductName, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(32, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		ImageAvatar avatar = new ImageAvatar();

		lblName = new JLabel("Chelsie Haley");
		lblName.setFont(new Font("SansSerif", Font.BOLD, 28));
		lblName.setForeground(ColorBackground.colorLight);

		lblContent = new JLabel("Dream big. Think different. Do great!");
		lblContent.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblContent.setForeground(new Color(111, 118, 126));

		btnFilter = new ButtonCheckedSizeAndColor(1);
		btnFilter.setIcon(iconFilterWhite);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addComponent(avatar, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblName)
						.addGroup(gl_panel.createSequentialGroup().addComponent(lblContent)
								.addPreferredGap(ComponentPlacement.RELATED, 462, Short.MAX_VALUE)
								.addComponent(btnFilter, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(avatar, GroupLayout.PREFERRED_SIZE, 72, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnFilter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 50,
												Short.MAX_VALUE)
										.addComponent(lblContent, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE))))
				.addContainerGap()));
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		if (MainForm.mode == "Dark") {
			setColorModeDark();
		} else {
			setColorModeLight();
		}

		action();
	}

	public void action() {

		btnFilter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFilter.setColorBackground(new Color(42, 133, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (MainForm.mode == "Dark") {
					btnFilter.setColorBackground(ColorBackground.colorDark);
				} else {
					btnFilter.setColorBackground(ColorBackground.colorLight);
				}
			}
		});

		PanelMode.actionButonModeLight(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setColorModeLight();
			}
		});

		PanelMode.actionButonModeDark(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setColorModeDark();
			}
		});

		btnFilter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog = new DialogFilterStoreProduct(null);
				dialog.setModalityType(ModalityType.APPLICATION_MODAL);
				int x = 1010;
				int y = 210;
				MainForm.setLocationDialog(x, y);
				MainForm.setLocationMouseDragged(x, y);
				dialog.setLocation(MainForm.xScreen, MainForm.yScreen);
				dialog.setVisible(true);

			}
		});

	}

	public void setColorModeDark() {
		lblName.setForeground(ColorBackground.colorLight);

		btnFilter.setIcon(iconFilterWhite);
		setColorButtonModeDark(btnFilter);
	}

	public void setColorModeLight() {
		lblName.setForeground(ColorBackground.colorDark);

		btnFilter.setIcon(iconFilterGray);
		setColorButtonModeLight(btnFilter);
	}

	public void setColorButtonModeDark(ButtonCheckedSizeAndColor button) {
		button.setColorBackground(ColorBackground.colorDark);
		button.setColorhover1(ColorBackground.colorGRB394348);
	}

	public void setColorButtonModeLight(ButtonCheckedSizeAndColor button) {
		button.setColorBackground(ColorBackground.colorLight);
		button.setColorhover1(ColorBackground.colorGRB181228202);
	}
}
