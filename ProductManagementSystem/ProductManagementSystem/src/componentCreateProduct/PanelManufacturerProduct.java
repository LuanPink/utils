package componentCreateProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.UIManager;

import color.ColorBackground;
import dao.DAOProductMaterial;
import dao.DAOSupplier;
import model.ModelProductMaterial;
import model.ModelProductSize;
import model.ModelProductType;
import model.ModelSupplier;
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
	public static String modelsize = null;
	private Color colorBackgroundButton = new Color(42, 133, 255);
	private ButtonCheckedSizeAndColor2 btnWhite;
	private ButtonCheckedSizeAndColor2 btnBlack;
	public static int indexofsize=0;
	public static int indexofcolor=0;
	public ModelProductSize modelProductSize = new ModelProductSize();
	private DAOSupplier daoSupplier = new DAOSupplier();
	private DAOProductMaterial daoProductMaterial = new DAOProductMaterial();
	private ButtonGroup buttonGroup;
	private Combobox cbohsx;
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
	public static String KSize = "";
	public static String MSize = "";
	public static ButtonCheckedSizeAndColor btnSizeS;
	public static ButtonCheckedSizeAndColor btnSizeL;
	public static ButtonCheckedSizeAndColor btnSizeM;
	public static ButtonCheckedSizeAndColor btnSize38;
	public static ButtonCheckedSizeAndColor btnSize39;
	public static ButtonCheckedSizeAndColor btnSize40;
	public static ButtonCheckedSizeAndColor btnSizeXL;
	public static ButtonCheckedSizeAndColor btnSize41;
	public static int indexselected;

	private JLabel lblyel;

	private JLabel lblred;

	private JLabel lblorange;

	private JLabel lblpur;

	private JLabel lblhong;

	private JLabel lblgreen;

	private JLabel lblbrown;

	private JLabel lblgrey;

	private ButtonCheckedSizeAndColor2 btnyellow;

	private ButtonCheckedSizeAndColor2 btnred;

	private ButtonCheckedSizeAndColor2 btnorange;

	private ButtonCheckedSizeAndColor2 btnpurple;

	private ButtonCheckedSizeAndColor2 btnpink;

	private ButtonCheckedSizeAndColor2 btngreen;

	private ButtonCheckedSizeAndColor2 btnbrown;

	private ButtonCheckedSizeAndColor2 btngrey;
	private Combobox cbochatlieu;
	private static JPanel panelSize=new JPanel();
	private static JPanel panelColor=new JPanel();
	public static int indexselected2;
	private JLabel lblertenhangsanxuat;
	private JLabel lblerchatlieu;
	private JLabel lblertenhangsanxuat_2;
	private JLabel lblerkichco;
	private JLabel lblermau;

	public PanelManufacturerProduct() {
		setOpaque(false);

		lblTitle = new JLabel("Hãng Sản Xuất & Kích Cỡ & Màu Sản Phẩm");
		lblTitle.setForeground(new Color(252, 252, 252));
		lblTitle.setFont(new Font("Roboto", Font.BOLD, 18));

		lblName = new JLabel("Tên hãng sản xuất");
		lblName.setForeground(new Color(252, 252, 252));
		lblName.setFont(new Font("Roboto", Font.BOLD, 14));

		cbohsx = new Combobox();
		buttonGroup = new ButtonGroup();

		
		panelSize.setOpaque(false);
		
		
		panelColor.setOpaque(false);
		
		lblertenhangsanxuat = new JLabel("");
		lblertenhangsanxuat.setForeground(new Color(255, 0, 0));
		lblertenhangsanxuat.setFont(new Font("Dialog", Font.ITALIC, 12));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelColor, GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(cbohsx, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
								.addComponent(panelSize, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblTitle, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblertenhangsanxuat, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE))))))
					.addGap(53))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblertenhangsanxuat, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbohsx, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelSize, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelColor, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
					.addGap(75))
		);
		
				lblProductColor = new JLabel("Màu sản phẩm");
				lblProductColor.setForeground(new Color(252, 252, 252));
				lblProductColor.setFont(new Font("Roboto", Font.BOLD, 14));
				btnWhite = new ButtonCheckedSizeAndColor2(9);
				
						buttonGroup.add(btnWhite);
						
								btnyellow = new ButtonCheckedSizeAndColor2(11);
								
										lblWhite = new JLabel("Màu trắng");
										lblWhite.setForeground(new Color(252, 252, 252));
										lblWhite.setFont(new Font("Roboto", Font.BOLD, 14));
										
												lblyel = new JLabel("Màu vàng");
												lblyel.setForeground(new Color(252, 252, 252));
												lblyel.setFont(new Font("Dialog", Font.BOLD, 14));
												
														btnBlack = new ButtonCheckedSizeAndColor2(10);
														buttonGroup.add(btnBlack);
														
																btnpurple = new ButtonCheckedSizeAndColor2(14);
																
																		lblBlack = new JLabel("Màu đen");
																		lblBlack.setForeground(new Color(252, 252, 252));
																		lblBlack.setFont(new Font("Roboto", Font.BOLD, 14));
																		
																				lblpur = new JLabel("Màu tím");
																				lblpur.setForeground(new Color(252, 252, 252));
																				lblpur.setFont(new Font("Dialog", Font.BOLD, 14));
																				
																						btnbrown = new ButtonCheckedSizeAndColor2(17);
																						
																								btngrey = new ButtonCheckedSizeAndColor2(18);
																								
																										lblbrown = new JLabel("Màu nâu");
																										lblbrown.setForeground(new Color(252, 252, 252));
																										lblbrown.setFont(new Font("Dialog", Font.BOLD, 14));
																										
																												lblgrey = new JLabel("Màu xám");
																												lblgrey.setForeground(new Color(252, 252, 252));
																												lblgrey.setFont(new Font("Dialog", Font.BOLD, 14));
																												
																														btnred = new ButtonCheckedSizeAndColor2(12);
																														
																																btnorange = new ButtonCheckedSizeAndColor2(13);
																																
																																		lblred = new JLabel("Màu đỏ");
																																		lblred.setForeground(new Color(252, 252, 252));
																																		lblred.setFont(new Font("Dialog", Font.BOLD, 14));
																																		
																																				lblorange = new JLabel("Màu cam");
																																				lblorange.setForeground(new Color(252, 252, 252));
																																				lblorange.setFont(new Font("Dialog", Font.BOLD, 14));
																																				
																																						btnpink = new ButtonCheckedSizeAndColor2(15);
																																						

																																						btngreen = new ButtonCheckedSizeAndColor2(16);
																																						
																																								lblhong = new JLabel("Màu hồng");
																																								lblhong.setForeground(new Color(252, 252, 252));
																																								lblhong.setFont(new Font("Dialog", Font.BOLD, 14));
																																								
																																										lblgreen = new JLabel("Màu xanh");
																																										lblgreen.setForeground(new Color(252, 252, 252));
																																										lblgreen.setFont(new Font("Dialog", Font.BOLD, 14));
																																										
																																										lblermau = new JLabel("");
																																										lblermau.setForeground(Color.RED);
																																										lblermau.setFont(new Font("Dialog", Font.ITALIC, 12));
																																										GroupLayout gl_panelColor = new GroupLayout(panelColor);
																																										gl_panelColor.setHorizontalGroup(
																																											gl_panelColor.createParallelGroup(Alignment.LEADING)
																																												.addGroup(gl_panelColor.createSequentialGroup()
																																													.addGap(10)
																																													.addGroup(gl_panelColor.createParallelGroup(Alignment.LEADING)
																																														.addGroup(gl_panelColor.createSequentialGroup()
																																															.addComponent(btnWhite, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																															.addGap(10)
																																															.addComponent(lblWhite, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
																																															.addGap(10)
																																															.addComponent(btnBlack, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																															.addGap(10)
																																															.addComponent(lblBlack, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
																																															.addGap(1)
																																															.addComponent(btnbrown, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																															.addGap(10)
																																															.addGroup(gl_panelColor.createParallelGroup(Alignment.LEADING)
																																																.addGroup(gl_panelColor.createSequentialGroup()
																																																	.addGap(66)
																																																	.addComponent(btnred, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
																																																.addComponent(lblbrown, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
																																															.addGap(10)
																																															.addComponent(lblred, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
																																															.addGap(2)
																																															.addComponent(btnpink, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																															.addGap(10)
																																															.addComponent(lblhong, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
																																														.addGroup(gl_panelColor.createSequentialGroup()
																																															.addComponent(btnyellow, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																															.addGap(10)
																																															.addComponent(lblyel)
																																															.addGap(10)
																																															.addComponent(btnpurple, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																															.addGap(10)
																																															.addGroup(gl_panelColor.createParallelGroup(Alignment.LEADING)
																																																.addComponent(lblpur, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
																																																.addGroup(gl_panelColor.createSequentialGroup()
																																																	.addGap(66)
																																																	.addComponent(btngrey, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
																																															.addGap(10)
																																															.addGroup(gl_panelColor.createParallelGroup(Alignment.LEADING)
																																																.addComponent(lblgrey, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
																																																.addGroup(gl_panelColor.createSequentialGroup()
																																																	.addGap(66)
																																																	.addComponent(btnorange, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
																																															.addGap(10)
																																															.addComponent(lblorange, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
																																															.addGap(2)
																																															.addComponent(btngreen, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																															.addGap(10)
																																															.addComponent(lblgreen, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
																																														.addGroup(gl_panelColor.createSequentialGroup()
																																															.addComponent(lblProductColor, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
																																															.addPreferredGap(ComponentPlacement.RELATED)
																																															.addComponent(lblermau, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)))
																																													.addGap(315))
																																										);
																																										gl_panelColor.setVerticalGroup(
																																											gl_panelColor.createParallelGroup(Alignment.LEADING)
																																												.addGroup(gl_panelColor.createSequentialGroup()
																																													.addContainerGap()
																																													.addGroup(gl_panelColor.createParallelGroup(Alignment.TRAILING)
																																														.addComponent(lblProductColor, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
																																														.addComponent(lblermau, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
																																													.addGap(10)
																																													.addGroup(gl_panelColor.createParallelGroup(Alignment.LEADING)
																																														.addComponent(btnWhite, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																														.addComponent(lblWhite, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																														.addComponent(btnBlack, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																														.addComponent(lblBlack, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																														.addComponent(btnbrown, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																														.addComponent(btnred, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																														.addComponent(lblbrown, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																														.addComponent(lblred, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																														.addComponent(btnpink, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																														.addComponent(lblhong, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
																																													.addGap(10)
																																													.addGroup(gl_panelColor.createParallelGroup(Alignment.LEADING)
																																														.addComponent(btnyellow, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																														.addComponent(lblyel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																														.addComponent(btnpurple, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																														.addComponent(lblpur, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																														.addComponent(btngrey, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																														.addComponent(lblgrey, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																														.addComponent(btnorange, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																														.addComponent(lblorange, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																														.addComponent(btngreen, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																																														.addComponent(lblgreen, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
																																										);
																																										panelColor.setLayout(gl_panelColor);

		lblSize = new JLabel("Kích cỡ sản phẩm");
		lblSize.setForeground(new Color(252, 252, 252));
		lblSize.setFont(new Font("Roboto", Font.BOLD, 14));

		btnSizeS = new ButtonCheckedSizeAndColor(1);

		btnSizeM = new ButtonCheckedSizeAndColor(2);

		btnSizeL = new ButtonCheckedSizeAndColor(3);

		btnSizeXL = new ButtonCheckedSizeAndColor(4);

		lblSizeS = new JLabel("Size S");
		lblSizeS.setForeground(new Color(252, 252, 252));
		lblSizeS.setFont(new Font("Roboto", Font.BOLD, 14));

		lblSizeM = new JLabel("Size M");
		lblSizeM.setForeground(new Color(252, 252, 252));
		lblSizeM.setFont(new Font("Roboto", Font.BOLD, 14));

		lblSizeL = new JLabel("Size L");
		lblSizeL.setForeground(new Color(252, 252, 252));
		lblSizeL.setFont(new Font("Roboto", Font.BOLD, 14));

		lblSizeXl = new JLabel("Size XL");
		lblSizeXl.setForeground(new Color(252, 252, 252));
		lblSizeXl.setFont(new Font("Roboto", Font.BOLD, 14));

		btnSize38 = new ButtonCheckedSizeAndColor(5);

		btnSize39 = new ButtonCheckedSizeAndColor(6);

		btnSize40 = new ButtonCheckedSizeAndColor(7);

		btnSize41 = new ButtonCheckedSizeAndColor(8);

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
		
		cbochatlieu = new Combobox();
		
		JLabel lblChtLiu = new JLabel("Chất liệu");
		lblChtLiu.setForeground(new Color(252, 252, 252));
		lblChtLiu.setFont(new Font("Dialog", Font.BOLD, 14));
		
		lblerchatlieu = new JLabel("");
		lblerchatlieu.setForeground(Color.RED);
		lblerchatlieu.setFont(new Font("Dialog", Font.ITALIC, 12));
		
		lblertenhangsanxuat_2 = new JLabel("");
		lblertenhangsanxuat_2.setForeground(Color.RED);
		lblertenhangsanxuat_2.setFont(new Font("Dialog", Font.ITALIC, 12));
		
		lblerkichco = new JLabel("");
		lblerkichco.setForeground(Color.RED);
		lblerkichco.setFont(new Font("Dialog", Font.ITALIC, 12));
		GroupLayout gl_panelSize = new GroupLayout(panelSize);
		gl_panelSize.setHorizontalGroup(
			gl_panelSize.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSize.createSequentialGroup()
					.addGroup(gl_panelSize.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSize.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panelSize.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSize, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelSize.createSequentialGroup()
									.addGroup(gl_panelSize.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelSize.createSequentialGroup()
											.addComponent(btnSizeM, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
											.addGap(10)
											.addComponent(lblSizeM))
										.addGroup(gl_panelSize.createSequentialGroup()
											.addGap(38)
											.addComponent(lblSizeL, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panelSize.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_panelSize.createParallelGroup(Alignment.LEADING)
												.addComponent(btnSizeL, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_panelSize.createSequentialGroup()
													.addComponent(btnSizeXL, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(lblSizeXl, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))))
										.addGroup(gl_panelSize.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnSizeS, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblSizeS, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
									.addGap(90)
									.addGroup(gl_panelSize.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnSize40, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnSize41, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnSize39, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnSize38, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panelSize.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSize41, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSize39, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSize38, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSize40, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
							.addGroup(gl_panelSize.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblerchatlieu, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblertenhangsanxuat_2, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelSize.createSequentialGroup()
									.addComponent(lblChtLiu, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
									.addGap(88))
								.addComponent(cbochatlieu, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelSize.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblerkichco, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panelSize.setVerticalGroup(
			gl_panelSize.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSize.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panelSize.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSize, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblChtLiu, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panelSize.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSize.createSequentialGroup()
							.addComponent(cbochatlieu, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblerchatlieu, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblertenhangsanxuat_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSize.createSequentialGroup()
							.addGroup(gl_panelSize.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblSizeS, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSize38, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSize38, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSizeS, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(gl_panelSize.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSizeM, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSizeM, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSize39, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSize39, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelSize.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelSize.createSequentialGroup()
									.addGroup(gl_panelSize.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSize40, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnSize40, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panelSize.createParallelGroup(Alignment.LEADING)
										.addComponent(btnSize41, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSize41, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panelSize.createSequentialGroup()
									.addGroup(gl_panelSize.createParallelGroup(Alignment.LEADING)
										.addComponent(btnSizeL, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSizeL, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panelSize.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSizeXl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnSizeXL, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))))
					.addGap(18)
					.addComponent(lblerkichco, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelSize.setLayout(gl_panelSize);
		setLayout(groupLayout);
		if (MainForm.mode == "Dark") {
			setColorModeDark();
		} else {
			setColorModeLight();
		}
		action();
		fillcomboboxhsx();
		fillcomboboxchatlieu();

	}

	public void fillcomboboxhsx() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement("");
		for (ModelSupplier sup : daoSupplier.SelectAll()) {
			model.addElement(sup.getName());
		}
		cbohsx.setModel(model);
	}

	public void fillcomboboxchatlieu() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement("");
		for (ModelProductMaterial sup : daoProductMaterial.SelectAll()) {
			model.addElement(sup.getNameMeterial());
		}
		cbochatlieu.setModel(model);
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
		setColor(ColorBackground.colorDark);

		lblTitle.setForeground(ColorBackground.colorLight);
		lblName.setForeground(ColorBackground.colorLight);
		lblSize.setForeground(ColorBackground.colorLight);
		lblProductColor.setForeground(ColorBackground.colorLight);

		cbohsx.setColorBackground(ColorBackground.colorGRB394348);
		cbohsx.setColorBackground1(ColorBackground.colorLight);
		cbohsx.setColor(ColorBackground.colorGRB000);
		cbohsx.setColor2(ColorBackground.colorLight);

		cbochatlieu.setColorBackground(ColorBackground.colorGRB394348);
		cbochatlieu.setColorBackground1(ColorBackground.colorLight);
		cbochatlieu.setColor(ColorBackground.colorGRB000);
		cbochatlieu.setColor2(ColorBackground.colorLight);

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
		setColorLabelModeDark(lblyel);
		setColorLabelModeDark(lblpur);
		setColorLabelModeDark(lblhong);
		setColorLabelModeDark(lblbrown);
		setColorLabelModeDark(lblgreen);
		setColorLabelModeDark(lblgrey);
		setColorLabelModeDark(lblorange);
		setColorLabelModeDark(lblred);

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
		setColorButtonModeDark(btnyellow);
		setColorButtonModeDark(btnbrown);
		setColorButtonModeDark(btngreen);
		setColorButtonModeDark(btngrey);
		setColorButtonModeDark(btnorange);
		setColorButtonModeDark(btnred);
		setColorButtonModeDark(btnpink);
		setColorButtonModeDark(btnpurple);
	}

	public void setColorModeLight() {
		setColor(ColorBackground.colorLight);

		lblTitle.setForeground(ColorBackground.colorDark);
		lblName.setForeground(ColorBackground.colorGRB147147147);
		lblSize.setForeground(ColorBackground.colorGRB147147147);
		lblProductColor.setForeground(ColorBackground.colorGRB147147147);

		cbohsx.setColorBackground(ColorBackground.colorGRB239239239);
		cbohsx.setColorBackground1(ColorBackground.colorGRB147147147);
		cbohsx.setColor(ColorBackground.colorGRB240242245);
		cbohsx.setColor2(ColorBackground.colorGRB147147147);

		cbochatlieu.setColorBackground(ColorBackground.colorGRB239239239);
		cbochatlieu.setColorBackground1(ColorBackground.colorGRB147147147);
		cbochatlieu.setColor(ColorBackground.colorGRB240242245);
		cbochatlieu.setColor2(ColorBackground.colorGRB147147147);

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
		setColorLabelModeLight(lblyel);
		setColorLabelModeLight(lblpur);
		setColorLabelModeLight(lblhong);
		setColorLabelModeLight(lblbrown);
		setColorLabelModeLight(lblgreen);
		setColorLabelModeLight(lblgrey);
		setColorLabelModeLight(lblorange);
		setColorLabelModeLight(lblred);

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
		setColorButtonModeLight(btnyellow);
		setColorButtonModeLight(btnbrown);
		setColorButtonModeLight(btngreen);
		setColorButtonModeLight(btngrey);
		setColorButtonModeLight(btnorange);
		setColorButtonModeLight(btnred);
		setColorButtonModeLight(btnpink);
		setColorButtonModeLight(btnpurple);
	}

	public void setColorButtonModeDark(ButtonCheckedSizeAndColor button) {
		button.setColorBackground(ColorBackground.colorDark);
		button.setColorhover1(ColorBackground.colorGRB394348);
	}
	public void setColorButtonModeDark(ButtonCheckedSizeAndColor2 button) {
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
	public void setColorButtonModeLight(ButtonCheckedSizeAndColor2 button) {
		button.setColorBackground(ColorBackground.colorLight);
		button.setColorhover1(ColorBackground.colorGRB181228202);
	}

	public void setColorLabelModeLight(JLabel label) {
		label.setForeground(ColorBackground.colorGRB147147147);
	}

	public String Checkhangsanxuat() {
		String hsx = cbohsx.getSelectedItem() + "";
		String hsxT = null;
		if (cbohsx.getSelectedItem() == "") {
			lblertenhangsanxuat.setText("Xin chọn tên hãng sản xuất");
		} else {
			hsxT = hsx;
			lblertenhangsanxuat.setText("");
		}
		return hsxT;
	}

	public String Checkchatlieu() {
		
		String nccT=null;
		
		for (ModelProductMaterial ms : daoProductMaterial.SelectAll()) {
			if(cbochatlieu.getSelectedItem().equals(ms.getNameMeterial())) {
				nccT=ms.getId();
			}
		}
		
		
		if(nccT==null) {
			lblerchatlieu.setText("Xin chọn chất liệu");
		}else {
			lblerchatlieu.setText("");
			return nccT;
		}
		return null;
		
		
	}

	public static void get_Size() {
		for (Component comp : panelSize.getComponents()) {
			if (comp instanceof ButtonCheckedSizeAndColor) {
				ButtonCheckedSizeAndColor btn = (ButtonCheckedSizeAndColor) comp;
				if (btn.index == indexselected) {
					btn.setColorBackground(new Color(43, 122, 255));
					btn.setIcon(new ImageIcon(PanelManufacturerProduct.class.getResource("/icon/check-white.png")));
					indexofsize=indexselected;
					
				} else {
					btn.setColorBackground(ColorBackground.colorDark);
					btn.setIcon(null);
				}
			}
		}
	}
	public static void get_Color() {
		for (Component comp : panelColor.getComponents()) {
			if (comp instanceof ButtonCheckedSizeAndColor2) {
				ButtonCheckedSizeAndColor2 btn = (ButtonCheckedSizeAndColor2) comp;
				if (btn.index == indexselected2) {
					btn.setColorBackground(new Color(43, 122, 255));
					btn.setIcon(new ImageIcon(PanelManufacturerProduct.class.getResource("/icon/check-white.png")));
					indexofcolor=indexselected2;
					
				} else {
					btn.setColorBackground(ColorBackground.colorDark);
					btn.setIcon(null);
				}
			}
		}
	}
	public int Size() {
		if(indexofsize==1) {
			return 7;
		}else if(indexofsize==2) {
			return 8;
		}else if(indexofsize==3) {
			return 9;
		}else if(indexofsize==4) {
			return 10;
		}else if(indexofsize==5) {
			return 1;
		}else if(indexofsize==6) {
			return 2;
		}else if(indexofsize==7) {
			return 3;
		}else if(indexofsize==8) {
			return 4;
		}
		return 0;
	}
	public int Color() {
		if(indexofcolor==9) {
			return 2;
		}else if(indexofcolor==10) {
			return 1;
		}else if(indexofcolor==17) {
			return 9;
		}else if(indexofcolor==12) {
			return 4;
		}else if(indexofcolor==15) {
			return 7;//
		}else if(indexofcolor==11) {
			return 3;
		}else if(indexofcolor==14) {
			return 6;
		}else if(indexofcolor==18) {
			return 10;
		}else if(indexofcolor==13) {
			return 5;
		}else if(indexofcolor==16) {
			return 8;
		}
		return 0;
	}
	public int checkSize() {
		if(Size()==0) {
			lblerkichco.setText("Xin chọn kích cỡ");
			
		}else {
			lblerkichco.setText("");
			return Size();
		}
		return 0;
	}
	public int checkCol() {
		if(Color()==0) {
			lblermau.setText("Xin chọn màu");
			
		}else {
			lblermau.setText("");
			return  Color();
		}
		return 0;
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
