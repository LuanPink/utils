package componentDoanhThu;

import javax.swing.JPanel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import componentProduct.ButtonProductList;
import componentProduct.IconEditProduct;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

import color.ColorBackground;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
import componentHeader.ButtonShowAllNotification;
import componentCreateProduct.ButtonCheckedSizeAndColor;
import componentCreateProduct.Combobox;
import componentCreateProduct.PanelManufacturerProduct;

public class PanelFilterDoanhThu extends JPanel {
	private Color colorBackground = ColorBackground.colorGRB000;
	private Color color = ColorBackground.colorDark;

	private Icon iconDeleteWhite = new ImageIcon(ButtonProductList.class.getResource("/icon/close.png"));
	public Combobox comboBox;
	public DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
	public static ButtonShowAllNotification btnApply;
	public static ButtonCheckedSizeAndColor btnNo;
	public static ButtonCheckedSizeAndColor btnYes;
	private Color colorBackgroundButton = new Color(42, 133, 255);
	private int year;
	private boolean option = false;
	int index;
	int indexButton = - 1;
	
	public PanelFilterDoanhThu() {
		setOpaque(false);
		IconEditProduct btnClose = new IconEditProduct(iconDeleteWhite);

		JLabel lblTitle = new JLabel("Bộ lọc tìm kiếm");
		lblTitle.setForeground(new Color(252, 252, 252));
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 16));

		JLabel lblShow = new JLabel("Đang hiển thị");
		lblShow.setForeground(SystemColor.windowBorder);
		lblShow.setFont(new Font("SansSerif", Font.BOLD, 14));

		JLabel lblNm = new JLabel("Năm");
		lblNm.setForeground(new Color(252, 252, 252));
		lblNm.setFont(new Font("Roboto", Font.PLAIN, 15));

		comboBox = new Combobox();

		JLabel lblBiu = new JLabel("Biểu Đồ");
		lblBiu.setForeground(new Color(252, 252, 252));
		lblBiu.setFont(new Font("Roboto", Font.PLAIN, 15));

		btnYes = new ButtonCheckedSizeAndColor(1);

		JLabel lblYes = new JLabel("Có");
		lblYes.setForeground(new Color(252, 252, 252));
		lblYes.setFont(new Font("Roboto", Font.PLAIN, 15));

		btnNo = new ButtonCheckedSizeAndColor(0);

		JLabel lblNo = new JLabel("Không");
		lblNo.setForeground(new Color(252, 252, 252));
		lblNo.setFont(new Font("Roboto", Font.PLAIN, 15));

		btnApply = new ButtonShowAllNotification("Áp dụng");

		ButtonCheckedSizeAndColor btnReset = new ButtonCheckedSizeAndColor(4);
		btnReset.setText("Đặt lại");
		btnReset.setForeground(new Color(252, 252, 252));
		btnReset.setFont(new Font("SansSerif", Font.BOLD, 15));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, Alignment.TRAILING, 0, 250, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
								.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblBiu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addComponent(btnYes, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblYes)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnNo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblNo, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnApply, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNm)
						.addComponent(lblShow, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblShow, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNm, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblBiu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnYes, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblYes, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnApply, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		setLayout(groupLayout);
		init();
		action();
	}
	
	public void init() {
		comboBoxModel.addElement("");
		comboBoxModel.addElement("2021");
		comboBoxModel.addElement("2022");
		comboBoxModel.addElement("2023");
		comboBoxModel.addElement("2024");
		comboBoxModel.addElement("2025");
		
		comboBox.setModel(comboBoxModel);
		
		comboBoxModel.setSelectedItem(year);
	}
	
	public void action(){
		actionButton(btnYes,btnNo);
		actionButton(btnNo,btnYes);
		
	}
	
	public void actionButton(ButtonCheckedSizeAndColor button, ButtonCheckedSizeAndColor buttons) {
		index = 1;
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				index++;
				if (index % 2 == 0) {
					indexButton = button.index;
					button.setIcon(new ImageIcon(PanelManufacturerProduct.class.getResource("/icon/check-white.png")));
					button.setColorBackground(colorBackgroundButton);

					buttons.setIcon(null);
					buttons.setColorBackground(color);
					
					index = 1;
				}

			}
		});

	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isOption() {
		return option;
	}

	public void setOption(boolean option) {
		this.option = option;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(colorBackground);
		g2.fillRoundRect(1, 1, getWidth(), getHeight(), 15, 15);
		g2.setColor(color);
		g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		super.paintComponent(g);
	}
}
