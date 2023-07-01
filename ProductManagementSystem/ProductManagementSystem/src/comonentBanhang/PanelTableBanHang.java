package comonentBanhang;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import componentHeader.ButtonShowAllNotification;
import animation.TextField;
import color.ColorBackground;
import componentCustomers.PanelCustomerHeader;
import componentDialog.DialogQuestion;
import componentStore.DialogFilterStoreProduct;
import componentStore.PanelStoreHeader;
import dao.DAOProducts;
import dia.DiaLogShowPanel;
import model.ModelProduct;
import model.ModelProductColor;
import model.ModelProductId;
import model.ModelProductMaterial;
import model.ModelProductName;
import model.ModelProductPrice;
import model.ModelProductQuantity;
import model.ModelProductSize;
import model.ModelProductType;
import model.ModelProductWarranty;
import view.MainForm;
import view.PanelMode;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dialog.ModalityType;
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
import java.util.ArrayList;

import javax.swing.ImageIcon;

import componentCreateProduct.ButtonCheckedSizeAndColor;
import componentCreateProduct.PanelTitle;

public class PanelTableBanHang extends JPanel {
	private Color color = ColorBackground.colorDark;
	private JScrollPane scrollPane;
	private static TableBanHang table;
	private Icon iconFilterWhite = new ImageIcon(PanelStoreHeader.class.getResource("/icon/filter-white.png"));
	private TextField txtQuatity;
	private JLabel lblNewLabel;
	private TextField txtSearch;
	private static ArrayList<ModelProduct> datas = new ArrayList<ModelProduct>();
	private static DAOProducts dao = new DAOProducts();
	private ButtonCheckedSizeAndColor btnSave;
	private ButtonCheckedSizeAndColor btnProductSave;
	private PanelTitle panelFind;
	DiaLogShowPanel dialogShow = new DiaLogShowPanel(null);
	PanelTableLuuTam panelTableLuuTam = new PanelTableLuuTam();
	public ButtonCheckedSizeAndColor btnTT;
	private PanelTableThanhToan panelTableThanhToan = new PanelTableThanhToan();
	private int indexSelected = - 1;
	private DialogQuestion question = new DialogQuestion(null);
	public PanelTableBanHang() {
		setOpaque(false);
		table = new TableBanHang();
		scrollPane = new JScrollPane(table);
		table.addTableStyle(scrollPane);
		lblNewLabel = new JLabel("Thanh toán bán hàng");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel.setForeground(ColorBackground.colorLight);

		txtQuatity = new TextField();
		txtQuatity.setHint("Số lượng bán");
		txtQuatity.setForeground(new Color(147,147,147));
		txtQuatity.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtQuatity.setCaretColor(new Color(252, 252, 252));

		txtQuatity.setBackground(new Color(39, 43, 48));
		btnTT = new ButtonCheckedSizeAndColor(0);
		btnTT.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnTT.setText("Thanh toán");
		btnTT.setForeground(ColorBackground.colorLight);

		btnSave = new ButtonCheckedSizeAndColor(0);
		btnSave.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnSave.setText("Lưu tạm");
		btnSave.setForeground(ColorBackground.colorLight);

		btnProductSave = new ButtonCheckedSizeAndColor(0);
		btnProductSave.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnProductSave.setText("Sản phẩm đã lưu");
		btnProductSave.setForeground(ColorBackground.colorLight);

		panelFind = new PanelTitle();

		txtSearch = new TextField();
		txtSearch.setHint("Tìm kiếm sản phẩm...");
		txtSearch.setForeground(new Color(252, 252, 252));
		txtSearch.setFont(new Font("Roboto", Font.ITALIC, 12));
		txtSearch.setCaretColor(new Color(252, 252, 252));
		txtSearch.setBorder(null);
		GroupLayout gl_panelFind = new GroupLayout(panelFind);
		gl_panelFind.setHorizontalGroup(
				gl_panelFind.createParallelGroup(Alignment.LEADING).addGroup(gl_panelFind.createSequentialGroup()
						.addContainerGap().addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)));
		gl_panelFind.setVerticalGroup(gl_panelFind.createParallelGroup(Alignment.LEADING).addComponent(txtSearch,
				GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE));
		panelFind.setLayout(gl_panelFind);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(panelFind, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addComponent(txtQuatity, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnProductSave, GroupLayout.PREFERRED_SIZE, 141,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 343, Short.MAX_VALUE)
								.addComponent(btnTT, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(13)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelFind, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGap(21).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtQuatity, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnProductSave, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnTT, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		setLayout(groupLayout);
		if (MainForm.mode == "Light") {
			setColorModeLight();
		} else {
			setColorModeDark();
		}
		btnSave.setEnabled(false);
		txtQuatity.setFocusable(false);
		action();
		init();
	}

	public static void init() {
		datas = dao.SelectAll();
		fillTable();
	}

	public static void fillTable() {
		table.tableModel.setRowCount(0);
		for (ModelProduct data : datas) {
			long vat = Math.round(Double.parseDouble(data.getProductVAT().getVat()));
			long roundValue = Math.round(data.getProductPrice().getPrice());
			
			long total = roundValue + roundValue * vat / 100;
			
			table.tableModel.addRow(new Object[] { data.getId().getId(), data.getProductName().getProductName(),
					data.getProductType().getNameType(), data.getProductSize().getNameSize(),
					data.getProductColor().getNameColor(), data.getProductMaterial().getNameMeterial(),
					total, data.getProductQuantity().getQuantity()});
		}
	}

	private void setColorModeDark() {
		// TODO Auto-generated method stub
		lblNewLabel.setForeground(ColorBackground.colorLight);
		txtSearch.setForeground(ColorBackground.colorLight);
		txtQuatity.setForeground(ColorBackground.colorLight);
	}

	private void setColorModeLight() {
		lblNewLabel.setForeground(ColorBackground.colorDark);
		txtSearch.setForeground(ColorBackground.colorDark);
		txtQuatity.setForeground(ColorBackground.colorDark);
	}

	public void action() {
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getClickCount()==1) {
					indexSelected = table.getSelectedRow();
					txtQuatity.setFocusable(true);
				}
			}
		});
		
		txtQuatity.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				if(indexSelected<0) {
					return;
				}		
				int quatityProduct = datas.get(indexSelected).getProductQuantity().getQuantity();
				if(txtQuatity.getText().equals("")) {
					btnSave.setEnabled(false);
				}else {
					btnSave.setEnabled(true);
					int quatity = Integer.parseInt(txtQuatity.getText());
					
					if(quatity>quatityProduct) {
						btnSave.setEnabled(false);
						question.lblTextMessage.setText("Số Lượng Tồn Kho Không Đủ");
						int x = 650;
						int y = 290;
						MainForm.setLocationDialog(x, y);
						MainForm.setLocationMouseDragged(x, y);
						question.setLocation(MainForm.xScreen, MainForm.yScreen);
						question.setAlwaysOnTop(true);
						question.setVisible(true);
					}
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

		btnProductSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogShow.showForm(panelTableLuuTam);
				int x = 400;
				int y = 80;
				MainForm.setLocationDialog(x, y);
				MainForm.setLocationMouseDragged(x, y);
				dialogShow.setLocation(MainForm.xScreen, MainForm.yScreen);
				dialogShow.setModalityType(ModalityType.APPLICATION_MODAL);
				setColorButton(btnProductSave);
				dialogShow.setVisible(true);	
			}
		});

		panelTableLuuTam.btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogShow.setVisible(false);

			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
					panelTableLuuTam.init(new ModelProduct(
							new ModelProductId(datas.get(indexSelected).getId().getId()),
							new ModelProductName(datas.get(indexSelected).getProductName().getProductName()), 
							
							
							
							new ModelProductPrice(Double.parseDouble(table.getValueAt(indexSelected, 6).toString())),
							new ModelProductQuantity(Integer.parseInt(txtQuatity.getText())), 
							null,
							null , 
							null, 
							null, 
							null,
							null, 
							new ModelProductType(datas.get(indexSelected).getProductType().getNameType()), 
							new ModelProductSize(datas.get(indexSelected).getProductSize().getNameSize()), 
							new ModelProductColor(datas.get(indexSelected).getProductColor().getNameColor()), 
							new ModelProductMaterial(datas.get(indexSelected).getProductMaterial().getNameMeterial())));
					question.lblTextMessage.setText("Đã Lưu");
					int x = 650;
					int y = 290;
					MainForm.setLocationDialog(x, y);
					MainForm.setLocationMouseDragged(x, y);
					question.setLocation(MainForm.xScreen, MainForm.yScreen);
					question.setAlwaysOnTop(true);
					question.setVisible(true);
					txtQuatity.setFocusable(false);
					txtQuatity.setText("");
					btnSave.setEnabled(false);
					indexSelected = -1;
					setColorButton(btnSave);
			}
		});

		btnTT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogShow.showForm(panelTableThanhToan);
				panelTableThanhToan.init(panelTableLuuTam.getList());
				int x = 400;
				int y = 80;
				MainForm.setLocationDialog(x, y);
				MainForm.setLocationMouseDragged(x, y);
				dialogShow.setLocation(MainForm.xScreen, MainForm.yScreen);
				dialogShow.setModalityType(ModalityType.APPLICATION_MODAL);
				setColorButton(btnTT);
				dialogShow.setVisible(true);
				
			}
		});
		
		panelTableThanhToan.btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogShow.setVisible(false);

			}
		});
		
		txtSearch.addCaretListener(new CaretListener() {		
			@Override
			public void caretUpdate(CaretEvent e) {
				String name = txtSearch.getText();
				if(name.equals("")) {
					init();
				}else {
					datas = dao.SelectByNameProduct(name);
					fillTable();
				}
			}
		});
		
		
	}
	
	public void setColorButton(ButtonCheckedSizeAndColor button) {
		if(MainForm.mode == "Dark") {
			button.setColorhover1(new Color(39, 43, 48));
		}else {
			button.setColorhover1(ColorBackground.colorGRB181228202);
		}
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
