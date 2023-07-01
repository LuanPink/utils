package componentCreateProduct;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.UIManager;

import color.ColorBackground;
import view.MainForm;
import view.PanelMode;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class PanelManufacturerProduct extends JPanel {
	private static Color color = ColorBackground.colorDark;

	private Color colorBackgroundButton = new Color(42, 133, 255);
	private ButtonCheckedSizeAndColor btnWhite;
	private ButtonCheckedSizeAndColor btnBlack;
	private int index;

	private ButtonGroup buttonGroup;
	private Combobox comboBox;
	private JLabel lblTitle;
	private JLabel lblName;
	private JLabel lblSize;
	private JLabel lblProductColor;
	private JLabel lblBlack;
	private JLabel lblWhite;
	private JLabel lblSize41;
	private JLabel lblSize40;
	private JLabel lblSize39;
	private JLabel lblSize38;
	private JLabel lblSizeXl;
	private JLabel lblSizeL;
	private JLabel lblSizeM;
	private JLabel lblSizeS;

	public static ButtonCheckedSizeAndColor btnSizeS;
	public static ButtonCheckedSizeAndColor btnSizeL;
	public static ButtonCheckedSizeAndColor btnSizeM;
	public static ButtonCheckedSizeAndColor btnSize38;
	public static ButtonCheckedSizeAndColor btnSize39;
	public static ButtonCheckedSizeAndColor btnSize40;
	public static ButtonCheckedSizeAndColor btnSizeXL;
	public static ButtonCheckedSizeAndColor btnSize41;

	public PanelManufacturerProduct() {
		setOpaque(false);

		lblTitle = new JLabel("Hãng Sản Xuất & Kích Cỡ & Màu Sản Phẩm");
		lblTitle.setForeground(new Color(252, 252, 252));
		lblTitle.setFont(new Font("Roboto", Font.BOLD, 18));

		lblName = new JLabel("Tên hãng sản xuất");
		lblName.setForeground(new Color(252, 252, 252));
		lblName.setFont(new Font("Roboto", Font.BOLD, 14));

		comboBox = new Combobox();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement("Space Ver29");
		model.addElement("The Blue Exchange");
		model.addElement("Canifa");
		comboBox.setModel(model);

		lblSize = new JLabel("Kích cỡ sản phẩm");
		lblSize.setForeground(new Color(252, 252, 252));
		lblSize.setFont(new Font("Roboto", Font.BOLD, 14));

		btnSizeS = new ButtonCheckedSizeAndColor(1);

		btnSizeM = new ButtonCheckedSizeAndColor(2);

		btnSizeL = new ButtonCheckedSizeAndColor(3);

		btnSizeXL = new ButtonCheckedSizeAndColor(4);

		btnSize38 = new ButtonCheckedSizeAndColor(5);

		btnSize39 = new ButtonCheckedSizeAndColor(6);

		btnSize40 = new ButtonCheckedSizeAndColor(7);

		btnSize41 = new ButtonCheckedSizeAndColor(8);

		lblSizeS = new JLabel("Size S");
		lblSizeS.setForeground(new Color(252, 252, 252));
		lblSizeS.setFont(new Font("Roboto", Font.BOLD, 14));

		lblSizeL = new JLabel("Size L");
		lblSizeL.setForeground(new Color(252, 252, 252));
		lblSizeL.setFont(new Font("Roboto", Font.BOLD, 14));

		lblSizeM = new JLabel("Size M");
		lblSizeM.setForeground(new Color(252, 252, 252));
		lblSizeM.setFont(new Font("Roboto", Font.BOLD, 14));

		lblSizeXl = new JLabel("Size XL");
		lblSizeXl.setForeground(new Color(252, 252, 252));
		lblSizeXl.setFont(new Font("Roboto", Font.BOLD, 14));

		lblSize38 = new JLabel("Size 38");
		lblSize38.setForeground(new Color(252, 252, 252));
		lblSize38.setFont(new Font("Roboto", Font.BOLD, 14));

		lblSize39 = new JLabel("Size 39");
		lblSize39.setForeground(new Color(252, 252, 252));
		lblSize39.setFont(new Font("Roboto", Font.BOLD, 14));

		lblSize40 = new JLabel("Size 40");
		lblSize40.setForeground(new Color(252, 252, 252));
		lblSize40.setFont(new Font("Roboto", Font.BOLD, 14));

		lblSize41 = new JLabel("Size 41");
		lblSize41.setForeground(new Color(252, 252, 252));
		lblSize41.setFont(new Font("Roboto", Font.BOLD, 14));
		buttonGroup = new ButtonGroup();
		btnWhite = new ButtonCheckedSizeAndColor(9);

		lblWhite = new JLabel("Màu trắng");
		lblWhite.setForeground(new Color(252, 252, 252));
		lblWhite.setFont(new Font("Roboto", Font.BOLD, 14));

		btnBlack = new ButtonCheckedSizeAndColor(10);

		buttonGroup.add(btnWhite);
		buttonGroup.add(btnBlack);

		lblBlack = new JLabel("Màu đen");
		lblBlack.setForeground(new Color(252, 252, 252));
		lblBlack.setFont(new Font("Roboto", Font.BOLD, 14));

		lblProductColor = new JLabel("Màu sản phẩm");
		lblProductColor.setForeground(new Color(252, 252, 252));
		lblProductColor.setFont(new Font("Roboto", Font.BOLD, 14));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout
								.createSequentialGroup().addGap(
										29)
								.addGroup(
										groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblProductColor, Alignment.TRAILING,
														GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
												.addComponent(comboBox, 0, 796, Short.MAX_VALUE)
												.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 796,
														Short.MAX_VALUE)
												.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
												.addComponent(lblSize, GroupLayout.PREFERRED_SIZE, 796, Short.MAX_VALUE)
												.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
														.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
																.addGroup(groupLayout
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(btnSizeS,
																				GroupLayout.PREFERRED_SIZE, 28,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(btnSizeM,
																				GroupLayout.PREFERRED_SIZE, 28,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(btnSizeL,
																				GroupLayout.PREFERRED_SIZE, 28,
																				GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addGroup(groupLayout
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblSizeS).addComponent(lblSizeL)
																		.addComponent(lblSizeM)))
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(btnSizeXL, GroupLayout.PREFERRED_SIZE, 28,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(lblSizeXl))
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(btnWhite, GroupLayout.PREFERRED_SIZE, 28,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(lblWhite)))
														.addGap(99)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(
																				btnBlack, GroupLayout.PREFERRED_SIZE,
																				28, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(lblBlack,
																				GroupLayout.PREFERRED_SIZE, 65,
																				GroupLayout.PREFERRED_SIZE))
																.addGroup(groupLayout
																		.createParallelGroup(Alignment.LEADING, false)
																		.addGroup(groupLayout.createSequentialGroup()
																				.addComponent(btnSize41,
																						GroupLayout.PREFERRED_SIZE, 28,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						ComponentPlacement.UNRELATED)
																				.addComponent(lblSize41,
																						GroupLayout.PREFERRED_SIZE, 47,
																						GroupLayout.PREFERRED_SIZE))
																		.addGroup(groupLayout.createSequentialGroup()
																				.addComponent(btnSize40,
																						GroupLayout.PREFERRED_SIZE, 28,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						ComponentPlacement.UNRELATED)
																				.addComponent(lblSize40,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE))
																		.addGroup(groupLayout.createSequentialGroup()
																				.addComponent(btnSize39,
																						GroupLayout.PREFERRED_SIZE, 28,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						ComponentPlacement.UNRELATED)
																				.addComponent(lblSize39,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE))
																		.addGroup(groupLayout.createSequentialGroup()
																				.addComponent(btnSize38,
																						GroupLayout.PREFERRED_SIZE, 28,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						ComponentPlacement.UNRELATED)
																				.addComponent(lblSize38))))
														.addGap(37)))
								.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(28)
						.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lblSize, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblSizeS, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 28,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(btnSizeS, Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
														28, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(btnSizeM, GroupLayout.PREFERRED_SIZE, 28,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblSizeM, GroupLayout.PREFERRED_SIZE, 28,
														GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(
												groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(
																lblSizeL, GroupLayout.PREFERRED_SIZE, 28,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(btnSizeL, GroupLayout.PREFERRED_SIZE, 28,
																GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(btnSize38, GroupLayout.PREFERRED_SIZE, 28,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblSize38, GroupLayout.PREFERRED_SIZE, 28,
														GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(btnSize39, GroupLayout.PREFERRED_SIZE, 28,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblSize39, GroupLayout.PREFERRED_SIZE, 28,
														GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblSize40, GroupLayout.PREFERRED_SIZE, 28,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(btnSize40, GroupLayout.PREFERRED_SIZE, 28,
														GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSizeXL, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSize41, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSizeXl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSize41, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(lblProductColor, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnWhite, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblWhite, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBlack, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBlack, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(106, Short.MAX_VALUE)));
		setLayout(groupLayout);
		if(MainForm.mode == "Dark") {
			setColorModeDark();
		}else {
			setColorModeLight();
		}
		action();
	}

	public void action() {
		ButtonCheckedSizeAndColor[] btn1 = new ButtonCheckedSizeAndColor[] { btnSizeM, btnSizeL, btnSizeXL };
		actionButtonSize(btnSizeS, btn1);

		ButtonCheckedSizeAndColor[] btn2 = new ButtonCheckedSizeAndColor[] { btnSizeS, btnSizeL, btnSizeXL };
		actionButtonSize(btnSizeM, btn2);

		ButtonCheckedSizeAndColor[] btn3 = new ButtonCheckedSizeAndColor[] { btnSizeS, btnSizeM, btnSizeXL };
		actionButtonSize(btnSizeL, btn3);

		ButtonCheckedSizeAndColor[] btn4 = new ButtonCheckedSizeAndColor[] { btnSizeS, btnSizeM, btnSizeL };
		actionButtonSize(btnSizeXL, btn4);

		ButtonCheckedSizeAndColor[] btn5 = new ButtonCheckedSizeAndColor[] { btnSize39, btnSize40, btnSize41 };
		actionButtonSize(btnSize38, btn5);

		ButtonCheckedSizeAndColor[] btn6 = new ButtonCheckedSizeAndColor[] { btnSize38, btnSize40, btnSize41 };
		actionButtonSize(btnSize39, btn6);

		ButtonCheckedSizeAndColor[] btn7 = new ButtonCheckedSizeAndColor[] { btnSize38, btnSize39, btnSize41 };
		actionButtonSize(btnSize40, btn7);

		ButtonCheckedSizeAndColor[] btn8 = new ButtonCheckedSizeAndColor[] { btnSize38, btnSize39, btnSize40 };
		actionButtonSize(btnSize41, btn8);

		actionButtonColor(btnWhite, btnBlack);
		actionButtonColor(btnBlack, btnWhite);

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
		setColor(ColorBackground.colorDark);

		lblTitle.setForeground(ColorBackground.colorLight);
		lblName.setForeground(ColorBackground.colorLight);
		lblSize.setForeground(ColorBackground.colorLight);
		lblProductColor.setForeground(ColorBackground.colorLight);

		comboBox.setColorBackground(ColorBackground.colorGRB394348);
		comboBox.setColorBackground1(ColorBackground.colorLight);
		comboBox.setColor(ColorBackground.colorGRB000);
		comboBox.setColor2(ColorBackground.colorLight);

		setColorLabelModeDark(lblSizeS);
		setColorLabelModeDark(lblSizeM);
		setColorLabelModeDark(lblSizeL);
		setColorLabelModeDark(lblSizeXl);
		setColorLabelModeDark(lblSize38);
		setColorLabelModeDark(lblSize39);
		setColorLabelModeDark(lblSize40);
		setColorLabelModeDark(lblSize41);
		setColorLabelModeDark(lblWhite);
		setColorLabelModeDark(lblBlack);
		
		setColorButtonModeDark(btnSizeS);
		setColorButtonModeDark(btnSizeM);
		setColorButtonModeDark(btnSizeL);
		setColorButtonModeDark(btnSizeXL);
		setColorButtonModeDark(btnSize38);
		setColorButtonModeDark(btnSize39);
		setColorButtonModeDark(btnSize40);
		setColorButtonModeDark(btnSize41);
		setColorButtonModeDark(btnBlack);
		setColorButtonModeDark(btnWhite);
	}

	public void setColorModeLight() {
		setColor(ColorBackground.colorLight);

		lblTitle.setForeground(ColorBackground.colorDark);
		lblName.setForeground(ColorBackground.colorGRB147147147);
		lblSize.setForeground(ColorBackground.colorGRB147147147);
		lblProductColor.setForeground(ColorBackground.colorGRB147147147);

		comboBox.setColorBackground(ColorBackground.colorGRB239239239);
		comboBox.setColorBackground1(ColorBackground.colorGRB147147147);
		comboBox.setColor(ColorBackground.colorGRB240242245);
		comboBox.setColor2(ColorBackground.colorGRB147147147);

		setColorLabelModeLight(lblSizeS);
		setColorLabelModeLight(lblSizeM);
		setColorLabelModeLight(lblSizeL);
		setColorLabelModeLight(lblSizeXl);
		setColorLabelModeLight(lblSize38);
		setColorLabelModeLight(lblSize39);
		setColorLabelModeLight(lblSize40);
		setColorLabelModeLight(lblSize41);
		setColorLabelModeLight(lblWhite);
		setColorLabelModeLight(lblBlack);

		setColorButtonModeLight(btnSizeS);
		setColorButtonModeLight(btnSizeM);
		setColorButtonModeLight(btnSizeL);
		setColorButtonModeLight(btnSizeXL);
		setColorButtonModeLight(btnSize38);
		setColorButtonModeLight(btnSize39);
		setColorButtonModeLight(btnSize40);
		setColorButtonModeLight(btnSize41);
		setColorButtonModeLight(btnBlack);
		setColorButtonModeLight(btnWhite);
	}

	public void setColorButtonModeDark(ButtonCheckedSizeAndColor button) {
		button.setColorBackground(ColorBackground.colorDark);	
		button.setColorhover1(ColorBackground.colorGRB394348);
	}

	public void setColorLabelModeDark(JLabel label) {
		label.setForeground(ColorBackground.colorLight);
	}

	public void setColorButtonModeLight(ButtonCheckedSizeAndColor button) {
		button.setColorBackground(ColorBackground.colorLight);
		button.setColorhover1(ColorBackground.colorGRB181228202);
	}

	public void setColorLabelModeLight(JLabel label) {
		label.setForeground(ColorBackground.colorGRB147147147);
	}

	public static void setEnableButton(boolean option) {
		btnSizeS.setEnabled(option);
		btnSizeM.setEnabled(option);
		btnSizeL.setEnabled(option);
		btnSizeXL.setEnabled(option);

		btnSize38.setEnabled(option);
		btnSize39.setEnabled(option);
		btnSize40.setEnabled(option);
		btnSize41.setEnabled(option);

		if (option == false) {
			btnSizeS.setIcon(null);
			btnSizeM.setIcon(null);
			btnSizeL.setIcon(null);
			btnSizeXL.setIcon(null);

			btnSize38.setIcon(null);
			btnSize39.setIcon(null);
			btnSize40.setIcon(null);
			btnSize41.setIcon(null);

			btnSizeS.setColorBackground(color);
			btnSizeM.setColorBackground(color);
			btnSizeL.setColorBackground(color);
			btnSizeXL.setColorBackground(color);

			btnSize38.setColorBackground(color);
			btnSize39.setColorBackground(color);
			btnSize40.setColorBackground(color);
			btnSize41.setColorBackground(color);
		}

	}

	public static void showButtonSizeChar(boolean option1, boolean option2) {
		btnSize38.setEnabled(option1);
		btnSize39.setEnabled(option1);
		btnSize40.setEnabled(option1);
		btnSize41.setEnabled(option1);

		btnSize38.setIcon(null);
		btnSize39.setIcon(null);
		btnSize40.setIcon(null);
		btnSize41.setIcon(null);

		btnSize38.setColorBackground(color);
		btnSize39.setColorBackground(color);
		btnSize40.setColorBackground(color);
		btnSize41.setColorBackground(color);

		btnSizeS.setEnabled(option2);
		btnSizeM.setEnabled(option2);
		btnSizeL.setEnabled(option2);
		btnSizeXL.setEnabled(option2);

	}

	public static void showButtonSizeNumber(boolean option1, boolean option2) {
		btnSizeS.setEnabled(option1);
		btnSizeM.setEnabled(option1);
		btnSizeL.setEnabled(option1);
		btnSizeXL.setEnabled(option1);

		btnSizeS.setIcon(null);
		btnSizeM.setIcon(null);
		btnSizeL.setIcon(null);
		btnSizeXL.setIcon(null);

		btnSizeS.setColorBackground(color);
		btnSizeM.setColorBackground(color);
		btnSizeL.setColorBackground(color);
		btnSizeXL.setColorBackground(color);

		btnSize38.setEnabled(option2);
		btnSize39.setEnabled(option2);
		btnSize40.setEnabled(option2);
		btnSize41.setEnabled(option2);

	}

	public void actionButtonSize(ButtonCheckedSizeAndColor button, ButtonCheckedSizeAndColor[] buttons) {
		index = 1;
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				index++;
				if (index % 2 == 0) {
					
					button.setIcon(new ImageIcon(PanelManufacturerProduct.class.getResource("/icon/check-white.png")));
					button.setColorBackground(colorBackgroundButton);

					buttons[0].setIcon(null);
					buttons[0].setColorBackground(color);

					buttons[1].setIcon(null);
					buttons[1].setColorBackground(color);

					buttons[2].setIcon(null);
					buttons[2].setColorBackground(color);

					index = 1;
				}

			}
		});

	}

	public void actionButtonColor(ButtonCheckedSizeAndColor button1, ButtonCheckedSizeAndColor button2) {
		index = 1;

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				index++;
				if (index % 2 == 0) {
					button1.setIcon(new ImageIcon(PanelManufacturerProduct.class.getResource("/icon/check-white.png")));
					button1.setColorBackground(colorBackgroundButton);

					button2.setIcon(null);
					button2.setColorBackground(color);
					index = 1;
				}

			}
		});

	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		super.paintComponent(g);
	}

	public static Color getColor() {
		return color;
	}

	public static void setColor(Color color) {
		PanelManufacturerProduct.color = color;

	}

}
