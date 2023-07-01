package componentStore;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import color.ColorBackground;
import componentCreateProduct.ButtonCheckedSizeAndColor;
import componentCreateProduct.PanelManufacturerProduct;
import componentCreateProduct.PanelTitle;
import componentHeader.ButtonShowAllNotification;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;

import componentProduct.ButtonProductList;
import componentProduct.IconEditProduct;
import componentProduct.PanelCustomers;
import view.MainForm;
import view.PanelMode;

import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import animation.TextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelDialogFilterStoreProduct extends JPanel {
	private Color colorBackground = ColorBackground.colorGRB000;

	private Icon iconDeleteWhite = new ImageIcon(ButtonProductList.class.getResource("/icon/close.png"));
	private Icon iconDeleteGray = new ImageIcon(ButtonProductList.class.getResource("/icon/close-gray.png"));
	private Icon iconDeleteBlue = new ImageIcon(ButtonProductList.class.getResource("/icon/close-blue.png"));

	private IconEditProduct btnClose;

	private ButtonCheckedSizeAndColor btnAllProduct;

	private ButtonCheckedSizeAndColor btnNewProduct;

	private ButtonCheckedSizeAndColor btnLastProduct;

	private Color color = ColorBackground.colorDark;

	private Color colorBackgroundButton = new Color(42, 133, 255);

	private int index = 1;

	RangeSlider rangeSlider = new RangeSlider();
	private JLabel rangeSliderLabel1 = new JLabel();
	private JLabel rangeSliderValue1 = new JLabel();
	private JLabel rangeSliderLabel2 = new JLabel();
	private JLabel rangeSliderValue2 = new JLabel();

	int firstValue = 0;
	int secondValue = 0;

	boolean dialogShown = false;
	
	private TextField txtSearch;

	private JLabel lblLastProduct;

	private JLabel lblNewProduct;

	private JLabel lblAllProduct;

	private JLabel lblShow;

	private ButtonShowAllNotification btnApply;

	private ButtonCheckedSizeAndColor btnReset;

	private JLabel lblPrice;

	private JLabel lblTitle;

	private PanelTitle panelFind;

	public PanelDialogFilterStoreProduct() {
		setOpaque(false);

		lblTitle = new JLabel("Bộ lọc tìm kiếm");
		lblTitle.setForeground(new Color(252, 252, 252));
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 16));

		panelFind = new PanelTitle();
		panelFind.setOpaque(false);
		

		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(PanelDialogFilterStoreProduct.class.getResource("/icon/search.png")));
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);

		txtSearch = new TextField();
		txtSearch.setHint("Tìm kiếm sản phẩm");
		txtSearch.setSelectionColor(new Color(82,147,242));
		txtSearch.setForeground(new Color(191, 191, 191));
		txtSearch.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtSearch.setCaretColor(new Color(252, 252, 252));
		txtSearch.setBorder(null);
		txtSearch.setBackground(new Color(39, 43, 48));
		GroupLayout gl_panelFind = new GroupLayout(panelFind);
		gl_panelFind
				.setHorizontalGroup(
						gl_panelFind.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelFind.createSequentialGroup()
										.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtSearch,
												GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		gl_panelFind.setVerticalGroup(gl_panelFind.createParallelGroup(Alignment.LEADING)
				.addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
				.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));
		panelFind.setLayout(gl_panelFind);

		rangeSliderLabel1.setText("Lower value:");
		rangeSliderLabel2.setText("Upper value:");
		rangeSliderValue1.setHorizontalAlignment(JLabel.LEFT);
		rangeSliderValue2.setHorizontalAlignment(JLabel.LEFT);

		rangeSlider.setPreferredSize(new Dimension(240, rangeSlider.getPreferredSize().height));
		rangeSlider.setMinimum(0);
		rangeSlider.setMaximum(100);

		int value = 50;
		rangeSlider.addChangeListener(new ChangeListener() {
			private DialogShowPriceProduct dialog;

			public void stateChanged(ChangeEvent e) {

				RangeSlider slider = (RangeSlider) e.getSource();
				rangeSliderValue1.setText(String.valueOf(slider.getValue()));
				rangeSliderValue2.setText(String.valueOf(slider.getUpperValue()));

				int priceLength = rangeSliderValue2.getText().length();

				firstValue = Integer.parseInt(rangeSliderValue1.getText());
				secondValue = Integer.parseInt(rangeSliderValue2.getText());

//				if (slider.getUpperValue() > value || slider.getUpperValue() < value) {
//
//					if (priceLength >= 1 && priceLength <= 8) {
//						width = 70 + priceLength * 10;
//						if (!dialogShown) {
//							dialog = new DialogShowPriceProduct(null, width, price);
//							dialog.setLocation(x, y);
//							dialog.setVisible(true);
//							dialogShown = true;
//						}
//
//						if (dialogShown) {
////							dialog.setVisible(false);
//						}
//					}
//
//				}

			}

		});

		rangeSlider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

			}
		});

		// Initialize values.
		rangeSlider.setValue(0);
		rangeSlider.setUpperValue(10);

		// Initialize value display.
		rangeSliderValue1.setText(String.valueOf(rangeSlider.getValue()));
		rangeSliderValue2.setText(String.valueOf(rangeSlider.getUpperValue()));

		lblShow = new JLabel("Đang hiển thị");
		lblShow.setForeground(new Color(100, 100, 100));
		lblShow.setFont(new Font("SansSerif", Font.BOLD, 14));

		lblAllProduct = new JLabel("Tất cả sản phẩm");
		lblAllProduct.setForeground(new Color(252, 252, 252));
		lblAllProduct.setFont(new Font("Roboto", Font.PLAIN, 15));

		lblNewProduct = new JLabel("Mới");
		lblNewProduct.setForeground(new Color(252, 252, 252));
		lblNewProduct.setFont(new Font("Roboto", Font.PLAIN, 15));

		lblLastProduct = new JLabel("Cuối cùng");
		lblLastProduct.setForeground(new Color(252, 252, 252));
		lblLastProduct.setFont(new Font("Roboto", Font.PLAIN, 15));

		btnAllProduct = new ButtonCheckedSizeAndColor(1);

		btnNewProduct = new ButtonCheckedSizeAndColor(2);

		btnLastProduct = new ButtonCheckedSizeAndColor(3);

		lblPrice = new JLabel("Giá");
		lblPrice.setForeground(SystemColor.windowBorder);
		lblPrice.setFont(new Font("SansSerif", Font.BOLD, 14));

		btnApply = new ButtonShowAllNotification("Áp dụng");

		btnReset = new ButtonCheckedSizeAndColor(4);
		btnReset.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnReset.setForeground(new Color(252, 252, 252));
		btnReset.setText("Đặt lại");

		btnClose = new IconEditProduct(iconDeleteWhite);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblTitle)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(btnAllProduct, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(panelFind, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 253,
										Short.MAX_VALUE)
								.addComponent(btnNewProduct, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLastProduct, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblShow).addComponent(lblAllProduct).addComponent(lblNewProduct)
								.addComponent(lblLastProduct).addComponent(lblPrice))
								.addContainerGap(17, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 90,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnApply,
														GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
										.addComponent(rangeSlider, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
								.addGap(17)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panelFind, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lblShow, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAllProduct, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAllProduct, GroupLayout.PREFERRED_SIZE, 30,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewProduct, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblLastProduct,
												GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnNewProduct, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnLastProduct,
												GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
						.addGap(18).addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(rangeSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(55)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
								.addComponent(btnApply, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(139, Short.MAX_VALUE)));
		setLayout(groupLayout);
		if (MainForm.mode == "Dark") {
			setColorModeDark();
		} else {
			setColorModeLight();
		}
		action();
	}

	public void action() {
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelStoreHeader.dialog.setVisible(false);

			}

		});
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClose.setIcon(iconDeleteBlue);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnClose.setIcon(iconDeleteWhite);
			}
		});

		ButtonCheckedSizeAndColor[] btn1 = { btnNewProduct, btnLastProduct };
		addActionButtonChecked(btnAllProduct, btn1);

		ButtonCheckedSizeAndColor[] btn2 = { btnAllProduct, btnLastProduct };
		addActionButtonChecked(btnNewProduct, btn2);

		ButtonCheckedSizeAndColor[] btn3 = { btnAllProduct, btnNewProduct };
		addActionButtonChecked(btnLastProduct, btn3);

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

	}

	public void setColorModeDark() {
		setColorBackground(ColorBackground.colorGRB000);
		setColor(ColorBackground.colorDark);
		btnClose.setColor(ColorBackground.colorGRB394348);
		btnClose.setIcon(iconDeleteWhite);
		
		lblTitle.setForeground(ColorBackground.colorLight);
		
		panelFind.setColorBackground(ColorBackground.colorGRB394348);
		panelFind.setColorClick(ColorBackground.colorGRB394348);
		
		txtSearch.setCaretColor(ColorBackground.colorLight);
		txtSearch.setForeground(ColorBackground.colorLight);
		txtSearch.setBackground(ColorBackground.colorGRB394348);
		
		lblShow.setForeground(ColorBackground.colorLight);
		lblAllProduct.setForeground(ColorBackground.colorLight);
		lblNewProduct.setForeground(ColorBackground.colorLight);
		lblLastProduct.setForeground(ColorBackground.colorLight);
		lblPrice.setForeground(ColorBackground.colorLight);
		
		setColorButtonModeDark(btnAllProduct);
		setColorButtonModeDark(btnNewProduct);
		setColorButtonModeDark(btnLastProduct);
		setColorButtonModeDark(btnReset);
		btnReset.setForeground(ColorBackground.colorLight);
	}

	public void setColorModeLight() {
		setColorBackground(ColorBackground.colorLight);
		setColor(ColorBackground.colorGRB181228202);
		btnClose.setColor(ColorBackground.colorGRB181228202);
		btnClose.setIcon(iconDeleteWhite);
		
		lblTitle.setForeground(ColorBackground.colorDark);
		panelFind.setColorBackground(ColorBackground.colorLight);
		panelFind.setColorClick(ColorBackground.colorGRB239239239);
		
		txtSearch.setCaretColor(ColorBackground.colorDark);
		txtSearch.setForeground(ColorBackground.colorDark);
		txtSearch.setBackground(ColorBackground.colorGRB239239239);
		
		lblShow.setForeground(ColorBackground.colorGRB100100100);
		lblAllProduct.setForeground(ColorBackground.colorGRB147147147);
		lblNewProduct.setForeground(ColorBackground.colorGRB147147147);
		lblLastProduct.setForeground(ColorBackground.colorGRB147147147);
		lblPrice.setForeground(ColorBackground.colorGRB100100100);
		
		setColorButtonModeLight(btnAllProduct);
		setColorButtonModeLight(btnNewProduct);
		setColorButtonModeLight(btnLastProduct);
		setColorButtonModeLight(btnReset);
		btnReset.setForeground(ColorBackground.colorGRB147147147);
	}
	
	public void setColorButtonModeDark(ButtonCheckedSizeAndColor button) {
		button.setColorBackground(ColorBackground.colorDark);	
		button.setColorhover1(ColorBackground.colorGRB394348);
	}
	
	public void setColorButtonModeLight(ButtonCheckedSizeAndColor button) {
		button.setColorBackground(ColorBackground.colorLight);
		button.setColorhover1(ColorBackground.colorGRB181228202);
	}

	public void addActionButtonChecked(ButtonCheckedSizeAndColor button, ButtonCheckedSizeAndColor[] buttons) {

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				button.setIcon(new ImageIcon(PanelManufacturerProduct.class.getResource("/icon/check-white.png")));
				button.setColorBackground(colorBackgroundButton);

				buttons[0].setIcon(null);
				buttons[0].setColorBackground(color);

				buttons[1].setIcon(null);
				buttons[1].setColorBackground(color);

			}
		});
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

	public Color getColorBackground() {
		return colorBackground;
	}

	public void setColorBackground(Color colorBackground) {
		this.colorBackground = colorBackground;
		repaint();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		repaint();
	}

	
}
