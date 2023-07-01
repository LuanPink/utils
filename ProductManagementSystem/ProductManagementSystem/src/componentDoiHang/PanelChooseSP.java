package componentDoiHang;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import color.ColorBackground;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import componentCreateProduct.ButtonCheckedSizeAndColor;
import componentDialog.DialogQuestion;
import dao.DAOProducts;
import dia.DialogShowOption;
import dia.PanelOptionConfirm;
import model.ModelProduct;
import model.ModelProductColor;
import model.ModelProductId;
import model.ModelProductMaterial;
import model.ModelProductName;
import model.ModelProductPrice;
import model.ModelProductQuantity;
import model.ModelProductSize;
import view.MainForm;

import java.awt.Font;
import javax.swing.JLabel;

public class PanelChooseSP extends JPanel {
	private Color color = ColorBackground.colorDark;
	private Color color2 = new Color(207, 106, 119);
	private DAOProducts daoProducts = new DAOProducts();
	private ArrayList<ModelProduct> products = new ArrayList<ModelProduct>();
	public ArrayList<ModelProduct> productsDoi = new ArrayList<ModelProduct>();
	private TableSP tableSP = new TableSP();
	private TableSP tableSPDoi = new TableSP();
	public ButtonCheckedSizeAndColor btnCancel;
	private JLabel lblPrice;
	private int indexSelected = -1;
	private DialogQuestion question = new DialogQuestion(null);
	private PanelOptionConfirm optionConfirm = new PanelOptionConfirm();
	private DialogShowOption dialogShowOption = new DialogShowOption(null);
	private int x = 650;
	private int y = 290;
	private ButtonCheckedSizeAndColor btnHT;

	public PanelChooseSP() {
		setOpaque(false);

		JScrollPane scrollPane = new JScrollPane(tableSP);
		tableSP.addTableStyle(scrollPane);

		JScrollPane scrollPaneHDCT = new JScrollPane(tableSPDoi);
		tableSPDoi.addTableStyle(scrollPaneHDCT);

		ButtonCheckedSizeAndColor btnDelete = new ButtonCheckedSizeAndColor(0);
		btnDelete.setText("Xóa");
		btnDelete.setForeground(new Color(252, 252, 252));
		btnDelete.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnDelete.setEnabled(false);

		JLabel lblTinHonTr = new JLabel("Tiền Hoàn Trả");
		lblTinHonTr.setForeground(new Color(147, 147, 147));
		lblTinHonTr.setFont(new Font("Roboto", Font.BOLD, 14));

		btnCancel = new ButtonCheckedSizeAndColor(0);
		btnCancel.setText("Hủy");
		btnCancel.setForeground(new Color(252, 252, 252));
		btnCancel.setFont(new Font("Roboto", Font.PLAIN, 14));

		btnHT = new ButtonCheckedSizeAndColor(0);
		btnHT.setText("Hoàn Thành");
		btnHT.setForeground(new Color(252, 252, 252));
		btnHT.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnHT.setEnabled(false);

		lblPrice = new JLabel("");
		lblPrice.setForeground(new Color(207, 106, 119));
		lblPrice.setFont(new Font("Roboto", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 65,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(
												scrollPaneHDCT, GroupLayout.PREFERRED_SIZE, 529,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
												.addComponent(btnHT, GroupLayout.PREFERRED_SIZE, 90,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnCancel,
														GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(lblTinHonTr, GroupLayout.PREFERRED_SIZE, 91,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(lblPrice)))))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnHT, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 28,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblTinHonTr, GroupLayout.PREFERRED_SIZE, 17,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 17,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(
														scrollPaneHDCT, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
												.addGap(7)
												.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 28,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 28,
																GroupLayout.PREFERRED_SIZE))))))
				.addContainerGap()));
		setLayout(groupLayout);
		optionConfirm.btnOK.setEnabled(false);
		init();
		action();
	}

	public void init() {
		products = daoProducts.SelectAll();
		fillTable();
	}

	public void setPriceReturn(double price) {
		long roundValue = Math.round(price);
		lblPrice.setText(roundValue + " VNĐ");
	}

	public void fillTable() {
		tableSP.tableModel.setRowCount(0);
		for (ModelProduct data : products) {	
			long vat = Math.round(Double.parseDouble(data.getProductVAT().getVat()));
			long roundValue = Math.round(data.getProductPrice().getPrice());		
			long total = roundValue + roundValue * vat / 100;

			tableSP.tableModel.addRow(new Object[] { data.getId().getId(), data.getProductName().getProductName(),
					data.getProductQuantity().getQuantity(), data.getProductSize().getNameSize(),
					data.getProductColor().getNameColor(), data.getProductMaterial().getNameMeterial(), total });

		}
	}

	public void action() {
		tableSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				indexSelected = tableSP.getSelectedRow();
				double priceTable = products.get(indexSelected).getProductPrice().getPrice();
				double priceReturn = Integer.parseInt(lblPrice.getText().replace(" ", "").replace("VNĐ", ""));
				if (priceTable > priceReturn) {
					question.lblTextMessage.setText("SP Chọn Giá Không Được Vượt Quá");
					setLocationDiaLogQuestion();
					indexSelected = -1;
				} else {
					dialogShowOption.showForm(optionConfirm);
					optionConfirm.lblTitle.setText("Xác Nhận");
					optionConfirm.lblContent.setText("Nhập số lượng sản phẩm");
					MainForm.setLocationDialog(x, y);
					MainForm.setLocationMouseDragged(x, y);
					dialogShowOption.setLocation(MainForm.xScreen, MainForm.yScreen);
					dialogShowOption.setModalityType(ModalityType.MODELESS);
					dialogShowOption.setAlwaysOnTop(true);
					dialogShowOption.setVisible(true);

				}
			}
		});

		optionConfirm.btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					int quatityTable = Integer.parseInt(tableSP.getValueAt(indexSelected, 2).toString());
					
					double priceTable = products.get(indexSelected).getProductPrice().getPrice();

					double priceReturn = Integer.parseInt(lblPrice.getText().replace(" ", "").replace("VNĐ", ""));
					int quantityReturn = Integer.parseInt(optionConfirm.text.getText());

					double totalSP = priceTable * quantityReturn;

					if (quantityReturn > quatityTable) {
						question.lblTextMessage.setText("Số Lượng Tồn Không Đủ");
						setLocationDiaLogQuestion();
					} else {
						if (totalSP > priceReturn) {
							question.lblTextMessage.setText("Tổng tiền quá lớn với số dư");
							setLocationDiaLogQuestion();
						} else {
							String masp = products.get(indexSelected).getId().getId();
							String name = products.get(indexSelected).getProductName().getProductName();
							int quantity = Integer.parseInt(optionConfirm.text.getText());
							String size = products.get(indexSelected).getProductSize().getNameSize();
							String color = products.get(indexSelected).getProductColor().getNameColor();
							String material = products.get(indexSelected).getProductMaterial().getNameMeterial();
							double total = products.get(indexSelected).getProductPrice().getPrice();

							ModelProduct data = new ModelProduct(new ModelProductId(masp), new ModelProductName(name),
									new ModelProductPrice(total), new ModelProductQuantity(quantity), null, null, null,
									null, null, null, null, new ModelProductSize(size), new ModelProductColor(color),
									new ModelProductMaterial(material));
							productsDoi.add(data);

							
							tableSP.setValueAt(quatityTable - quantity, indexSelected, 2);
							
							double priceCon = priceReturn - totalSP;
							long roundValue = Math.round(priceCon);

							lblPrice.setText(roundValue + " VNĐ");
							optionConfirm.text.setText("");
							dialogShowOption.setVisible(false);						
							fillTableSPDoi();
							btnHT.setEnabled(true);
						}

					
				}
			}
		});

		optionConfirm.btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogShowOption.setVisible(false);

			}
		});
		

		optionConfirm.text.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				if (optionConfirm.text.getText().equals("")) {
					optionConfirm.btnOK.setEnabled(false);
				} else {
					optionConfirm.btnOK.setEnabled(true);

				}
			}
		});
		
		
		btnHT.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				double priceReturn = Double.parseDouble(lblPrice.getText().replace(" ", " ").replace("VNĐ", ""));
				PanelTableHDDH.fillTableFromTableChoose(productsDoi, priceReturn);
				
				
				
			}
		});

	}

	public void fillTableSPDoi() {
		tableSPDoi.tableModel.setRowCount(0);
		for (ModelProduct data : productsDoi) {
			long roundValue = Math.round(data.getProductPrice().getPrice());
			tableSPDoi.tableModel.addRow(new Object[] { data.getId().getId(), data.getProductName().getProductName(),
					data.getProductQuantity().getQuantity(), data.getProductSize().getNameSize(),
					data.getProductColor().getNameColor(), data.getProductMaterial().getNameMeterial(), roundValue });

		}
	}

	public void setLocationDiaLogQuestion() {
		MainForm.setLocationDialog(x, y);
		MainForm.setLocationMouseDragged(x, y);
		question.setLocation(MainForm.xScreen, MainForm.yScreen);
		question.setModalityType(ModalityType.MODELESS);
		question.setAlwaysOnTop(true);
		question.setVisible(true);
	}

	public void clear() {
		lblPrice.setText("");
		productsDoi.clear();
		fillTableSPDoi();
		init();
	}
	
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color2);
		g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		g2.setColor(color);
		g2.fillRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 15, 15);
		super.paintComponent(g);
	}
}
