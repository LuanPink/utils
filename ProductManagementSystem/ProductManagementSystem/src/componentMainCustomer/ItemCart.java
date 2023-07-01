package componentMainCustomer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;

import model.ModelSavePrice;
import model.ModelTotalPrice;
import model.ShoppingCart;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.awt.event.ActionEvent;

public class ItemCart extends JPanel {
	private Color color = new Color(255, 255, 255);
	private Color color1 = new Color(217, 106, 119);
	private JTextField txtQuantity;
	private JTextArea txtName;
	private JLabel lblPrice;
	private JLabel lblTotalPrice;
	private JButton btnPrev;
	private JButton btnNext;
	private ImageIcon image;
	private String name;
	private String price;
	private String quantity;
	private String totalPrice;
	public ButtonChecked btnChecked;
	private int index;
	private boolean request = false;

	private int totalCount = 0;
	int cursor = -1;
	private String MaSP;
	private String Size;
	private String mauSac;
	private String material;
	private String type;

	public ItemCart(String MaSP,String size,String mauSac,String material,String type,ImageIcon img, String name, String price, String quantity, String totalPrice, int index) {
		this.MaSP = MaSP;
		this.Size = size;
		this.mauSac = mauSac;
		this.material = material;
		this.type = type;
		this.image = img;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.index = index;
		setOpaque(false);

		JPanel panel = new JPanel();
		panel.setOpaque(false);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 92, Short.MAX_VALUE).addContainerGap()));

		btnChecked = new ButtonChecked();

		JLabel lblImage = new JLabel("");
		lblImage.setIcon(img);

		txtName = new JTextArea();
		txtName.setText("Áo sơ mi nam trắng");
		txtName.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtName.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtName.setFocusable(false);
		txtName.setLineWrap(true);
		txtName.setWrapStyleWord(true);
		txtName.setOpaque(false);
		txtName.setText(name);

		lblPrice = new JLabel("500000 Đ");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblPrice.setText(price + " Đ");

		txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuantity.setText(quantity);

		lblTotalPrice = new JLabel("500000 Đ");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalPrice.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblTotalPrice.setForeground(new Color(207, 106, 119));
		lblTotalPrice.setText(totalPrice + " Đ");

		btnPrev = new JButton() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(new Color(147, 147, 147));
				g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
				super.paintComponent(g);
			}
		};
		btnPrev.setBorder(null);
		btnPrev.setOpaque(false);
		btnPrev.setFocusPainted(false);
		btnPrev.setText("–");
		btnPrev.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPrev.setForeground(new Color(147, 147, 147));
		btnPrev.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnNext = new JButton() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(new Color(147, 147, 147));
				g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
				super.paintComponent(g);
			}
		};
		btnNext.setBorder(null);
		btnNext.setOpaque(false);
		btnNext.setText("+");
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNext.setFocusPainted(false);
		btnNext.setForeground(new Color(147, 147, 147));
		btnNext.setCursor(new Cursor(Cursor.HAND_CURSOR));

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(2)
					.addComponent(btnChecked, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addGap(176)
					.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtQuantity, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblTotalPrice, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblImage, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(28)
							.addComponent(btnChecked, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(13)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblPrice)
									.addComponent(lblTotalPrice)
									.addComponent(btnNext))
								.addComponent(txtQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		action();
	}

	public void action() {
		btnPrev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cursor = -1;

				String s = lblPrice.getText().replace(" ", "").replace("Đ", "");
				int quanlity = Integer.parseInt(txtQuantity.getText());

				int price = Integer.parseInt(s);
				if (quanlity <= 1) {
					btnPrev.setEnabled(false);
				} else {
					quanlity--;
					txtQuantity.setText(quanlity + "");

					int totalPrice = price * quanlity;

					lblTotalPrice.setText(totalPrice + " Đ");

					prev(price);
				}
			}
		});

		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cursor = -1;	

				btnPrev.setEnabled(true);

				String s = lblPrice.getText().replace(" ", "").replace("Đ", "");
				int price = Integer.parseInt(s);

				int quanlity = Integer.parseInt(txtQuantity.getText());
				quanlity++;
				txtQuantity.setText(quanlity + "");

				int totalPrice = price * quanlity;

				lblTotalPrice.setText(totalPrice + " Đ");

				next(price);

			}
		});

		txtQuantity.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				cursor = txtQuantity.getCaretPosition();
			}
		});

		txtQuantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (cursor == 0 && e.getKeyChar() == '0') {
					e.consume();
				} else {
					char c = e.getKeyChar();
					if (!Character.isDigit(c)) {
						e.consume();
					}
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (txtQuantity.getText().length() == 1 && 8 == e.getKeyCode()) {
					e.consume();
				}
			}
		});

		((AbstractDocument) txtQuantity.getDocument()).setDocumentFilter(new NoZeroSelectedFilter(txtQuantity));

		txtQuantity.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {
				if (cursor >= 0) {
					String s = lblPrice.getText().replace(" ", "").replace("Đ", "");
					int price = Integer.parseInt(s);
					
					int quanlity = Integer.parseInt(txtQuantity.getText());
					
					int totalPrice = price * quanlity;

					lblTotalPrice.setText(totalPrice + " Đ");


					if(btnChecked.isSelected()) {
						next(price);
					}else {
						
					}
					
					
				} else {
					System.out.println("UnFocus");
				}

			}
		});

		btnChecked.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s1 = lblTotalPrice.getText().replace(" ", "").replace("Đ", "");
				int price1 = Integer.parseInt(s1);

				String s2 = PanelItemCartFooter.lblTotalPrice.getText().replace(" ", "").replace("đ", "");
				int price2 = Integer.parseInt(s2);

				int total = 0;

				int count = 0;

				totalCount = Integer.parseInt(PanelItemCartFooter.lblQuantityProduct.getText());

				if (btnChecked.isSelected()) {
					total = price2 + price1;

					count = totalCount + 1;

					// String name = PanelItemCart.datas.get(index).getProductName();

				} else {
					total = price2 - price1;
					count = totalCount - 1;
				}

				PanelItemCartFooter.lblTotalPrice.setText(total + " đ");
				PanelItemCartFooter.lblQuantityProduct.setText(count + "");

			}
		});

	}

	public void next(int price) {
		String s2 = PanelItemCartFooter.lblTotalPrice.getText().replace(" ", "").replace("đ", "");
		int price2 = Integer.parseInt(s2);
		int total = 0;
		total = price2 + price;

		if (btnChecked.getIndex() % 2 == 0) {
			PanelItemCartFooter.lblTotalPrice.setText(total + " đ");
		}
	}

	public void prev(int price) {
		String s2 = PanelItemCartFooter.lblTotalPrice.getText().replace(" ", "").replace("đ", "");
		int price2 = Integer.parseInt(s2);
		int total = 0;
		total = price2 - price;

		if (btnChecked.getIndex() % 2 == 0) {
			PanelItemCartFooter.lblTotalPrice.setText(total + " đ");
		}
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	
	
	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	
	public JLabel getLblTotalPrice() {
		return lblTotalPrice;
	}

	public void setLblTotalPrice(JLabel lblTotalPrice) {
		this.lblTotalPrice = lblTotalPrice;
	}
	
	

	public String getMaSP() {
		return MaSP;
	}

	public void setMaSP(String maSP) {
		MaSP = maSP;
	}
	
	

	public JTextField getTxtQuantity() {
		return txtQuantity;
	}

	public void setTxtQuantity(JTextField txtQuantity) {
		this.txtQuantity = txtQuantity;
	}
	

	public String getSizes() {
		return Size;
	}

	public void setSize(String size) {
		this.Size = size;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		super.paintComponent(g);
	}
}
