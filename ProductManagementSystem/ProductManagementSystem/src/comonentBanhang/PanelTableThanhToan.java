package comonentBanhang;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import componentMainCustomer.Arrow2;
import animation.TextField;
import color.ColorBackground;
import dao.DAOHDBHCT;
import dao.DAOCustomers;
import dao.DAOEmployee;
import dao.DAOHDBH;
import dao.DAOProducts;
import model.ModelHDBHCT;
import model.ModelCustomerList;
import model.ModelEmployee;
import model.ModelHDBH;
import model.ModelProduct;
import model.ModelProductId;
import model.ModelProductQuantity;
import view.MainForm;
import view.PanelMode;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.awt.Color;
import componentCreateProduct.ButtonCheckedSizeAndColor;
import componentCreateProduct.Combobox;
import componentDialog.DialogQuestion;

public class PanelTableThanhToan extends JPanel {
	private JScrollPane scrollPane;
	private TableThanhToan table;
	private TextField txtTotalPrice;
	private TextField txtGiveCustomer;
	private TextField txtTienTra;
	private JLabel lblNewLabel;
	private JLabel lblKhchHng;
	private JLabel lblTngTin;
	private JLabel lblTinKhcha;
	private JLabel lblTinTrLi;
	private DefaultComboBoxModel comBoxModel;
	private Combobox comboBox;
	Color color1 = ColorBackground.colorDark;
	Color color2 = new Color(207, 106, 119);
	private ButtonCheckedSizeAndColor btnTT;
	public ButtonCheckedSizeAndColor btnCancel;
	private ButtonCheckedSizeAndColor btnDelete;
	private List<ModelProduct> list = new ArrayList<ModelProduct>();
	private ArrayList<ModelCustomerList> customerLists = new ArrayList<ModelCustomerList>();
	private DAOCustomers dao = new DAOCustomers();
	int totalPrice = 0;
	int giveCustomer = 0;
	int tienTra = 0;
	private int indexSelected = -1;
	private DialogQuestion question = new DialogQuestion(null);
	int cursor = -1;
	private JLabel lblCnThiu;
	private DAOProducts daoProduct = new DAOProducts();
	private DAOHDBH daohdbh = new DAOHDBH();
	private DAOHDBHCT daocthdbh = new DAOHDBHCT();
	private ArrayList<ModelHDBH> hdbhs = new ArrayList<ModelHDBH>();
	public PanelTableThanhToan() {
		setOpaque(false);

		table = new TableThanhToan();

		scrollPane = new JScrollPane(table);
		table.addTableStyle(scrollPane);

		lblNewLabel = new JLabel("Thanh Toán");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNewLabel.setForeground(ColorBackground.colorLight);

		comboBox = new Combobox();

		lblKhchHng = new JLabel("Khách hàng");
		lblKhchHng.setForeground(new Color(252, 252, 252));
		lblKhchHng.setFont(new Font("Roboto", Font.BOLD, 14));

		lblTngTin = new JLabel("Tổng tiền");
		lblTngTin.setForeground(new Color(252, 252, 252));
		lblTngTin.setFont(new Font("Roboto", Font.BOLD, 14));

		lblTinKhcha = new JLabel("Tiền khách đưa");
		lblTinKhcha.setForeground(new Color(252, 252, 252));
		lblTinKhcha.setFont(new Font("Roboto", Font.BOLD, 14));

		lblTinTrLi = new JLabel("Tiền trả lại");
		lblTinTrLi.setForeground(new Color(252, 252, 252));
		lblTinTrLi.setFont(new Font("Roboto", Font.BOLD, 14));

		txtTotalPrice = new TextField();
		txtTotalPrice.setColumns(10);
		txtTotalPrice.setBorder(null);
		txtTotalPrice.setForeground(new Color(252, 252, 252));
		txtTotalPrice.setFont(new Font("Roboto", Font.BOLD, 14));
		txtTotalPrice.setCaretColor(new Color(252, 252, 252));

		txtGiveCustomer = new TextField();
		txtGiveCustomer.setColumns(10);
		txtGiveCustomer.setBorder(null);
		txtGiveCustomer.setForeground(new Color(252, 252, 252));
		txtGiveCustomer.setFont(new Font("Roboto", Font.BOLD, 14));
		txtGiveCustomer.setCaretColor(new Color(252, 252, 252));

		txtTienTra = new TextField();
		txtTienTra.setColumns(10);
		txtTienTra.setBorder(null);
		txtTienTra.setForeground(new Color(252, 252, 252));
		txtTienTra.setFont(new Font("Roboto", Font.BOLD, 14));
		txtTienTra.setCaretColor(new Color(252, 252, 252));

		Arrow2 line1 = new Arrow2();
		line1.setColor(new Color(207, 106, 119));

		Arrow2 line2 = new Arrow2();
		line2.setColor(new Color(207, 106, 119));

		Arrow2 line3 = new Arrow2();
		line3.setColor(new Color(207, 106, 119));

		btnDelete = new ButtonCheckedSizeAndColor(0);
		btnDelete.setText("Xóa");
		btnDelete.setForeground(new Color(252, 252, 252));
		btnDelete.setFont(new Font("Roboto", Font.PLAIN, 14));

		btnCancel = new ButtonCheckedSizeAndColor(0);
		btnCancel.setText("Hủy");
		btnCancel.setForeground(new Color(252, 252, 252));
		btnCancel.setFont(new Font("Roboto", Font.PLAIN, 14));

		btnTT = new ButtonCheckedSizeAndColor(0);
		btnTT.setText("Thanh Toán");
		btnTT.setForeground(new Color(252, 252, 252));
		btnTT.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		lblCnThiu = new JLabel("Còn Thiếu");
		lblCnThiu.setForeground(new Color(207,106,119));
		lblCnThiu.setVisible(false);
		lblCnThiu.setFont(new Font("Roboto", Font.ITALIC, 14));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(601, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblKhchHng, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 582, Short.MAX_VALUE)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(scrollPane)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(line1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblTngTin, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtTotalPrice, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
						.addComponent(lblCnThiu, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(txtGiveCustomer, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
							.addComponent(lblTinKhcha, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
							.addComponent(line3, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(417)
							.addComponent(btnTT, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTinTrLi, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(698, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtTienTra, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(671))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(line2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(671))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblKhchHng, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(33)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblTngTin, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTinKhcha, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtTotalPrice, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtGiveCustomer, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(line1, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
										.addComponent(line3, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)))
								.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(lblTinTrLi, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTienTra, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(line2, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCnThiu, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTT, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		setLayout(groupLayout);
		if (MainForm.mode == "Light") {
			setColorModeLight();
		} else {
			setColorModeDark();
		}
		txtTotalPrice.setFocusable(false);
		txtTienTra.setFocusable(false);
		btnDelete.setEnabled(false);
		btnTT.setEnabled(false);
		action();
		initCombobox();
	}

	public void initCombobox() {
		comBoxModel = new DefaultComboBoxModel();
		customerLists = dao.SelectCustomer();
		comBoxModel.addElement("");
		for (ModelCustomerList customerList : customerLists) {
			comBoxModel.addElement(customerList.getName());
		}
		comboBox.setModel(comBoxModel);
	}

	public void init(List data) {
		list = data;
		fillTable();
	}

	public void fillTable() {
		table.tableModel.setRowCount(0);
		totalPrice = 0;
		for (ModelProduct datas : list) {
			long roundValue = Math.round(datas.getProductPrice().getPrice());
			table.tableModel.addRow(new Object[] { datas.getId().getId(), datas.getProductName().getProductName(),
					datas.getProductType().getNameType(), datas.getProductSize().getNameSize(),
					datas.getProductColor().getNameColor(), datas.getProductMaterial().getNameMeterial(), roundValue,
					datas.getProductQuantity().getQuantity() });

			totalPrice += datas.getProductPrice().getPrice() * datas.getProductQuantity().getQuantity();
		}
		prepareTheBill();
	}

	public void prepareTheBill() {
		txtTotalPrice.setText(totalPrice + "");
		if(txtGiveCustomer.getText().length()>0) {
			totalPrice();
		}

	}

	private void setColorModeDark() {
		lblNewLabel.setForeground(ColorBackground.colorLight);
		lblKhchHng.setForeground(ColorBackground.colorLight);
		lblTinKhcha.setForeground(ColorBackground.colorLight);
		lblTinTrLi.setForeground(ColorBackground.colorLight);
		lblTngTin.setForeground(ColorBackground.colorLight);
		txtTotalPrice.setForeground(ColorBackground.colorLight);
		txtGiveCustomer.setForeground(ColorBackground.colorLight);
		txtTienTra.setForeground(ColorBackground.colorLight);
		comboBox.setForeground(ColorBackground.colorLight);
	}

	private void setColorModeLight() {
		// TODO Auto-generated method stub
		lblNewLabel.setForeground(ColorBackground.colorDark);
		lblKhchHng.setForeground(ColorBackground.colorDark);
		lblTinKhcha.setForeground(ColorBackground.colorDark);
		lblTinTrLi.setForeground(ColorBackground.colorDark);
		lblTngTin.setForeground(ColorBackground.colorDark);
		txtTotalPrice.setForeground(ColorBackground.colorDark);
		txtGiveCustomer.setForeground(ColorBackground.colorDark);
		txtTienTra.setForeground(ColorBackground.colorDark);
		comboBox.setForeground(ColorBackground.colorDark);
	}

	public void action() {
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 1) {
					indexSelected = table.getSelectedRow();
					btnDelete.setEnabled(true);
				}
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (indexSelected < 0) {
					return;
				}
				btnDelete.setEnabled(true);

				PanelTableLuuTam.list.remove(indexSelected);
				PanelTableLuuTam.fillTable();
				init(PanelTableLuuTam.list);

				question.lblTextMessage.setText("Đã Xóa");
				int x = 650;
				int y = 290;
				MainForm.setLocationDialog(x, y);
				MainForm.setLocationMouseDragged(x, y);
				question.setLocation(MainForm.xScreen, MainForm.yScreen);
				question.setAlwaysOnTop(true);
				question.setVisible(true);
				btnDelete.setEnabled(false);

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

		setKeyTextField(txtTotalPrice);
		setKeyTextField(txtTienTra);
		setKeyTextField(txtGiveCustomer);

		txtGiveCustomer.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				if (txtGiveCustomer.getText().equals("")) {
					return;
				}
				totalPrice();
			}
		});	
		
		txtTienTra.addCaretListener(new CaretListener() {	
			@Override
			public void caretUpdate(CaretEvent e) {
				if(txtTienTra.getText().equals("")) {
					return;
				}
				
				if(Integer.parseInt(txtTienTra.getText())>0) {
					btnTT.setEnabled(true);
				}else {
					btnTT.setEnabled(false);
				}
			}
		});
		
		txtGiveCustomer.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				if(txtGiveCustomer.getText().equals("")) {
					txtTienTra.setText("");
					lblCnThiu.setVisible(false);
				}
			}
		});
		
		btnTT.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = comboBox.getSelectedIndex() - 1;
				if(index<0) {
					question.lblTextMessage.setText("Vui lòng chọn khách hàng");
					int x = 650;
					int y = 290;
					MainForm.setLocationDialog(x, y);
					MainForm.setLocationMouseDragged(x, y);
					question.setLocation(MainForm.xScreen, MainForm.yScreen);
					question.setAlwaysOnTop(true);
					question.setVisible(true);
					return;
				}
				
				String maKH = customerLists.get(index).getId();
				DAOEmployee daoEmployee = new DAOEmployee();
				ArrayList<ModelEmployee> employees = new ArrayList<ModelEmployee>();
				employees = daoEmployee.selectByEmail(MainForm.email);						
				String maNV = employees.get(0).getIdEmployee();	
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String date = sdf.format(new Date());	
				double total = Double.parseDouble(txtTotalPrice.getText());
				
				if(daohdbh.insert(new ModelHDBH("", maKH, maNV, date, total))>0) {
					hdbhs = daohdbh.selectTopOne();
					for (ModelProduct data : list) {
						int MaHDBH = Integer.parseInt(hdbhs.get(0).getMaHDBH());
						String MaSP = data.getId().getId();
						int quantity = data.getProductQuantity().getQuantity();
						double totalPrice = data.getProductPrice().getPrice() * quantity;
						String size = data.getProductSize().getNameSize();
						String color = data.getProductColor().getNameColor();
						String material = data.getProductMaterial().getNameMeterial();
						String type = data.getProductType().getNameType();
						daocthdbh.insert(new ModelHDBHCT("", MaHDBH+"", MaSP, quantity, totalPrice, size, color, material, type));
						daoProduct.updateQuantityMinus(new ModelProduct(new ModelProductId(MaSP), null, null, new ModelProductQuantity(quantity), null, null, null, null, null, null, null, null, null, null));
					}
					question.lblTextMessage.setText("Thanh Toán Sản Phẩm Thành Công");
					int x = 650;
					int y = 290;
					MainForm.setLocationDialog(x, y);
					MainForm.setLocationMouseDragged(x, y);
					question.setLocation(MainForm.xScreen, MainForm.yScreen);
					question.setAlwaysOnTop(true);
					question.setVisible(true);	
					PanelTableBanHang.init();
					clear();
				}
			}
		});
	}
	
	public void clear() {
		txtTotalPrice.setText("0");
		txtGiveCustomer.setText("");
		txtTienTra.setText("");
		btnTT.setEnabled(false);
		PanelTableLuuTam.list.clear();
		init(PanelTableLuuTam.list);
		comboBox.setSelectedIndex(0);
	}
	
	public void totalPrice() {
		 tienTra = Integer.parseInt(txtGiveCustomer.getText()) - totalPrice;
		 txtTienTra.setText(tienTra + "");
		 if(Integer.parseInt(txtTienTra.getText())<0) {
			 lblCnThiu.setVisible(true);
		 }else {
			 lblCnThiu.setVisible(false);
		 }
	}

	public void setKeyTextField(TextField text) {
		text.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cursor = text.getCaretPosition();
			}
		});
		
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume();
				}else {
					if(text.getText().length()>8) {
						e.consume();
					}
				}
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color2);
		g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		g2.setColor(color1);
		g2.fillRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 15, 15);
		super.paintComponent(g);
	}

	public Color getColor1() {
		return color1;
	}

	public void setColor1(Color color1) {
		this.color1 = color1;
		repaint();
	}
}
