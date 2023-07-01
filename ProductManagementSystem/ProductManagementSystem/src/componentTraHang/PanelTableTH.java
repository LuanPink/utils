package componentTraHang;

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
import dao.DAOHDBHCT;
import dao.DAOHDTH;
import dao.DAOHDTHCT;
import dao.DAOProducts;
import dia.DialogShowOption;
import dia.PanelOptionConfirm;
import model.ModelHDBHCT;
import model.ModelHDTH;
import model.ModelHDTHCT;
import model.ModelProduct;
import model.ModelProductId;
import model.ModelProductQuantity;
import view.MainForm;
import view.PanelMode;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import componentCreateProduct.PanelTitle;
import componentCreateProduct.ButtonCheckedSizeAndColor;

public class PanelTableTH extends JPanel {
	private Color color = ColorBackground.colorDark;
	private JScrollPane scrollPane;
	private TableHDTH tableHD;
	private JLabel lblThngTinHa;
	private JLabel lblDanhSch;
	private TableTH tableTH;
	private JScrollPane scrollPaneHDCT;
	private JLabel lblNewLabel;
	private TextField txtSearch;
	private DAOHDBHCT daocthdbh = new DAOHDBHCT();
	private DAOHDTH daohdth = new DAOHDTH();
	private DAOHDTHCT daohdthct = new DAOHDTHCT();
	private DAOProducts daoProducts = new DAOProducts();
	private ArrayList<ModelHDBHCT> cthdbhs = new ArrayList<ModelHDBHCT>();
	private ArrayList<ModelHDBHCT> listTH = new ArrayList<ModelHDBHCT>();
	private ArrayList<ModelHDTH> hdths = new ArrayList<ModelHDTH>();
	private int indexSelectedTableHDBH = -1;
	private int indexSelectedTableTH = -1;
	private int indexRow = -1;
	private int x = 650;
	private int y = 290;
	private Color color1 = ColorBackground.colorDark;
	private Color color2 = new Color(207, 106, 119);
	private DialogShowOption dialogShowOption = new DialogShowOption(null);
	private DialogQuestion question = new DialogQuestion(null);
	private PanelOptionConfirm optionConfirm = new PanelOptionConfirm();
	private JLabel lblName;
	private JLabel lblMaHDBH;
	private JLabel lblTotal;
	private long total;
	private ButtonCheckedSizeAndColor btnTH;
	private ButtonCheckedSizeAndColor btnDelete;
	Map<String, ModelHDBHCT> productMap = new HashMap<>();

	public PanelTableTH() {
		setOpaque(false);
		tableHD = new TableHDTH();
		tableTH = new TableTH();
		scrollPane = new JScrollPane(tableHD);
		tableHD.addTableStyle(scrollPane);

		lblNewLabel = new JLabel("Trả Hàng");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel.setForeground(ColorBackground.colorLight);

		lblThngTinHa = new JLabel("Thông tin hóa đơn");
		lblThngTinHa.setForeground(new Color(252, 252, 252));
		lblThngTinHa.setFont(new Font("Dialog", Font.BOLD, 14));

		lblDanhSch = new JLabel("Danh sách sản phẩm");
		lblDanhSch.setForeground(new Color(252, 252, 252));
		lblDanhSch.setFont(new Font("Dialog", Font.BOLD, 14));

		scrollPaneHDCT = new JScrollPane(tableTH);
		tableTH.addTableStyle(scrollPaneHDCT);

		PanelTitle panelFind = new PanelTitle();

		txtSearch = new TextField();
		txtSearch.setHint("Tìm kiếm hóa đơn...");
		txtSearch.setForeground(new Color(252, 252, 252));
		txtSearch.setFont(new Font("Roboto", Font.ITALIC, 12));
		txtSearch.setCaretColor(new Color(252, 252, 252));
		txtSearch.setBorder(null);
		GroupLayout gl_panelFind = new GroupLayout(panelFind);
		gl_panelFind.setHorizontalGroup(gl_panelFind.createParallelGroup(Alignment.LEADING)
				.addGap(0, 216, Short.MAX_VALUE).addGroup(gl_panelFind.createSequentialGroup().addContainerGap()
						.addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)));
		gl_panelFind.setVerticalGroup(gl_panelFind.createParallelGroup(Alignment.LEADING).addGap(0, 28, Short.MAX_VALUE)
				.addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE));
		panelFind.setLayout(gl_panelFind);

		JPanel panel = new JPanel() {
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
		};
		panel.setOpaque(false);

		btnDelete = new ButtonCheckedSizeAndColor(0);
		btnDelete.setText("Xóa");
		btnDelete.setForeground(new Color(252, 252, 252));
		btnDelete.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnDelete.setEnabled(false);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel).addGap(18)
								.addComponent(panelFind, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 65,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(scrollPaneHDCT, GroupLayout.PREFERRED_SIZE, 615,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
						.addComponent(lblDanhSch, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblThngTinHa, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelFind, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblThngTinHa, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblDanhSch, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE).addGap(11)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(scrollPaneHDCT, GroupLayout.PREFERRED_SIZE, 156,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(11, Short.MAX_VALUE)));

		JLabel lblKhchHng = new JLabel("Khách Hàng");
		lblKhchHng.setForeground(new Color(147, 147, 147));
		lblKhchHng.setFont(new Font("Roboto", Font.BOLD, 14));

		JLabel lblMHan = new JLabel("Mã Hóa Đơn");
		lblMHan.setForeground(new Color(147, 147, 147));
		lblMHan.setFont(new Font("Roboto", Font.BOLD, 14));

		JLabel lblTinHonTr = new JLabel("Tiền Hoàn Trả");
		lblTinHonTr.setForeground(new Color(147, 147, 147));
		lblTinHonTr.setFont(new Font("Roboto", Font.BOLD, 14));

		lblTotal = new JLabel("0 VNĐ");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setForeground(new Color(207, 106, 119));
		lblTotal.setFont(new Font("Roboto", Font.BOLD, 18));

		btnTH = new ButtonCheckedSizeAndColor(0);
		btnTH.setText("Hoàn Trả");
		btnTH.setForeground(new Color(252, 252, 252));
		btnTH.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnTH.setEnabled(false);

		lblName = new JLabel("");
		lblName.setForeground(new Color(252, 252, 252));
		lblName.setFont(new Font("Roboto", Font.BOLD, 14));

		lblMaHDBH = new JLabel("");
		lblMaHDBH.setForeground(new Color(252, 252, 252));
		lblMaHDBH.setFont(new Font("Roboto", Font.BOLD, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblTinHonTr)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblTotal, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(lblMHan, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblKhchHng, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(36)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblMaHDBH).addComponent(lblName)))
								.addComponent(btnTH, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 90,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblKhchHng)
								.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMHan, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMaHDBH, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(18).addComponent(lblTinHonTr,
										GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
						.addComponent(btnTH, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		if (MainForm.mode == "Light") {
			setColorModeLight();
		} else {
			setColorModeDark();
		}

		action();
	}

	public void init(String MAHDBH) {
		cthdbhs = daocthdbh.Find(new ModelHDBHCT(MAHDBH));
		fillTable();
	}

	public void fillTable() {
		tableHD.tableModel.setRowCount(0);
		for (ModelHDBHCT data : cthdbhs) {
			long roundValue = Math.round(data.getTotalPrice());
			tableHD.tableModel.addRow(new Object[] { data.getMaHDBH(), data.getMaSP(), data.getTenSP(), data.getSize(),
					data.getColor(), data.getMaterial(), data.getQuantity(), roundValue });
		}
	}

	private void setColorModeDark() {
		lblNewLabel.setForeground(ColorBackground.colorLight);
		txtSearch.setForeground(ColorBackground.colorLight);
		lblThngTinHa.setForeground(ColorBackground.colorLight);
		lblDanhSch.setForeground(ColorBackground.colorLight);
	}

	private void setColorModeLight() {
		lblNewLabel.setForeground(ColorBackground.colorDark);
		txtSearch.setForeground(ColorBackground.colorDark);
		lblThngTinHa.setForeground(ColorBackground.colorDark);
		lblDanhSch.setForeground(ColorBackground.colorDark);
	}

	public void action() {
		tableHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 1) {
					indexSelectedTableHDBH = tableHD.getSelectedRow();
					dialogShowOption.showForm(optionConfirm);
					optionConfirm.lblTitle.setText("Xác Nhận");
					optionConfirm.lblContent.setText("Nhập số lượng muốn trả");
					MainForm.setLocationDialog(x, y);
					MainForm.setLocationMouseDragged(x, y);
					dialogShowOption.setLocation(MainForm.xScreen, MainForm.yScreen);
					dialogShowOption.setModalityType(ModalityType.MODELESS);
					dialogShowOption.setAlwaysOnTop(true);
					dialogShowOption.setVisible(true);

				}
			}
		});

		tableTH.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 1) {
					indexSelectedTableTH = tableTH.getSelectedRow();
					btnDelete.setEnabled(true);
					indexRow = listTH.get(indexSelectedTableTH).getIndexRow();
				}
			}
		});

		optionConfirm.btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (optionConfirm.text.getText().length() < 0) {
					question.lblTextMessage.setText("Không Được Để Trống Số Lượng Trả");
					setLocationDiaLogQuestion();
				} else {
					String MaHDBHCT = cthdbhs.get(indexSelectedTableHDBH).getId();
					String MaHDBH = cthdbhs.get(indexSelectedTableHDBH).getMaHDBH();
					String MaSP = cthdbhs.get(indexSelectedTableHDBH).getMaSP();
					String nameSP = cthdbhs.get(indexSelectedTableHDBH).getTenSP();
					int quatity = Integer.parseInt(optionConfirm.text.getText());
					String size = cthdbhs.get(indexSelectedTableHDBH).getSize();
					String color = cthdbhs.get(indexSelectedTableHDBH).getColor();
					String material = cthdbhs.get(indexSelectedTableHDBH).getMaterial();
					double total = cthdbhs.get(indexSelectedTableHDBH).getTotalPrice() * quatity;
					indexRow = indexSelectedTableHDBH;
					initTableTH(new ModelHDBHCT(MaHDBHCT, MaHDBH, "", "", MaSP, nameSP, quatity, total, size, color, material, "",
							indexRow));
					dialogShowOption.setVisible(false);
					String nameKH = cthdbhs.get(indexSelectedTableHDBH).getTenKH();
					String maHDBH = cthdbhs.get(indexSelectedTableHDBH).getMaHDBH();

					tableHD.setValueAt(
							Integer.parseInt(tableHD.getValueAt(indexSelectedTableHDBH, 6).toString()) - quatity,
							indexSelectedTableHDBH, 6);
					optionConfirm.text.setText("");
					lblName.setText(nameKH);
					lblMaHDBH.setText(maHDBH);
					btnTH.setEnabled(true);
				}
			}
		});

		optionConfirm.text.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				if (optionConfirm.text.getText().equals("")) {
					return;
				}

				int quantityText = Integer.parseInt(optionConfirm.text.getText());
				int quantityData = Integer.parseInt(tableHD.getValueAt(indexSelectedTableHDBH, 6).toString());

				if (quantityData == 0) {
					question.lblTextMessage.setText("Hết Số Lượng Để Trả");
					optionConfirm.btnOK.setEnabled(false);
					setLocationDiaLogQuestion();
					return;
				}

				if (quantityText > quantityData) {
					question.lblTextMessage.setText("Không Lớn Hơn Số Lượng Ban Đầu");
					setLocationDiaLogQuestion();
					optionConfirm.btnOK.setEnabled(false);
				} else {
					optionConfirm.btnOK.setEnabled(true);
				}

			}
		});

		optionConfirm.btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogShowOption.setVisible(false);
			}
		});

		txtSearch.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				init(txtSearch.getText());
				clear();
			}
		});

		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume();
				}
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int quatityTableTH = Integer.parseInt(tableTH.getValueAt(indexSelectedTableTH, 2).toString());
				int quatityTableHD = Integer.parseInt(tableHD.getValueAt(indexRow, 6).toString());
				tableHD.setValueAt(quatityTableHD + quatityTableTH, indexRow, 6);
				
				listTH.remove(indexSelectedTableTH);
				
				if (listTH.size() - 1 < 0) {
					lblName.setText("");
					lblMaHDBH.setText("");
					btnTH.setEnabled(false);
				}
				fillTableHDTH();
				btnDelete.setColorhover1(new Color(39, 43, 48));
				btnDelete.setEnabled(false);
				indexSelectedTableTH = -1;
				question.lblTextMessage.setText("Đã Xóa");
				setLocationDiaLogQuestion();
			}
		});
		
		btnTH.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
	
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String date = sdf.format(new Date());	
				String text = lblTotal.getText().replace(" ", "").replace("VNĐ", "");
				double totalPrice = Double.parseDouble(text);
				String note = "";
				String MaKH = cthdbhs.get(indexSelectedTableHDBH).getMaKH();
				
				if(daohdth.insert(new ModelHDTH("", date, totalPrice, note, MaKH))>0) {
					hdths = daohdth.selectAllTopOne();
					
					String MaHDTH = hdths.get(0).getMaHDTraHang().toString();
				
					try {
					for (ModelHDBHCT data : listTH) {
						String MaHDBHCT = data.getId();
						String MaHDBH = data.getMaHDBH();
						String MaSP = data.getMaSP();
						int quantity = data.getQuantity();
						String size = data.getSize();
						String color = data.getColor();
						String material = data.getMaterial();
						double totals = data.getTotalPrice();
						daohdthct.insert(new ModelHDTHCT("", MaHDTH, MaSP, quantity, size, color, material, totals));
						daoProducts.updateQuantityPlus(new ModelProduct(
								new ModelProductId(MaSP), 
								null, 
								null, 
								new ModelProductQuantity(quantity), 
								null, 
								null, 
								null, 
								null, 
								null, 
								null, 
								null, 
								null, 
								null, 
								null));
						
						daocthdbh.update(new ModelHDBHCT(MaHDBHCT, MaHDBH, MaSP, quantity,totals, "", "", "", ""));
					}
					}catch(Exception e1) {
						System.out.println(e1);
					}
					clear();
					question.lblTextMessage.setText("Trả Hàng Thành Công");
					setLocationDiaLogQuestion();
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
	}

	public void initTableTH(ModelHDBHCT mode) {
		listTH.add(mode);
		fillTableHDTH();
	}

	public void clear() {
		optionConfirm.text.setText("");
		lblName.setText("");
		lblMaHDBH.setText("");
		btnTH.setEnabled(false);
		btnDelete.setEnabled(false);
		listTH.clear();
		fillTableHDTH();
	}

	public void fillTableHDTH() {
		tableTH.tableModel.setRowCount(0);
		total = 0;
		for (ModelHDBHCT data : listTH) {
			long roundValue = Math.round(data.getTotalPrice());
			total += roundValue;
			boolean found = false;
			for (int i = 0; i < tableTH.tableModel.getRowCount(); i++) {
				String maSP = tableTH.getValueAt(i, 0).toString();
				if (maSP.equals(data.getMaSP())) {
					int quantity = Integer.parseInt(tableTH.getValueAt(i, 2).toString());
					long totalPrice = Long.parseLong(tableTH.getValueAt(i, 6).toString());
					quantity += data.getQuantity();
					totalPrice += roundValue;
					tableTH.tableModel.setValueAt(quantity, i, 2);
					tableTH.tableModel.setValueAt(totalPrice, i, 6);
					found = true;
					break;
				}
			}
			if (!found) {
				tableTH.tableModel.addRow(new Object[] { data.getMaSP(), data.getTenSP(), data.getQuantity(),
						data.getSize(), data.getColor(), data.getMaterial(), roundValue });
			}
		}

		lblTotal.setText(total + " VNĐ");
	}

	public void setLocationDiaLogQuestion() {
		MainForm.setLocationDialog(x, y);
		MainForm.setLocationMouseDragged(x, y);
		question.setLocation(MainForm.xScreen, MainForm.yScreen);
		question.setModalityType(ModalityType.MODELESS);
		question.setAlwaysOnTop(true);
		question.setVisible(true);
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
