package componentDoiHang;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import color.ColorBackground;
import componentCreateProduct.ButtonCheckedSizeAndColor;
import componentCreateProduct.PanelTitle;
import componentDialog.DialogQuestion;
import componentScrollPane.ScrollBarMenu;
import componentStore.DialogFilterStoreProduct;
import componentStore.PanelStoreHeader;
import dao.DAOHDBH;
import dao.DAOHDBHCT;
import dao.DAOHDDH;
import dao.DAOHDDHCT;
import dao.DAOHDTH;
import dia.DiaLogShowPanel;
import dia.DialogShowOption;
import dia.PanelOptionConfirm;
import model.ModelHDBHCT;
import model.ModelHDDH;
import model.ModelHDDHCT;
import model.ModelHDBH;
import model.ModelHDTH;
import model.ModelHDTHCT;
import model.ModelProduct;
import net.miginfocom.swing.MigLayout;
import view.MainForm;
import view.PanelMode;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
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

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import animation.TextField;

public class PanelTableHDDH extends JPanel {
	private Color color = ColorBackground.colorDark;
	private Color color2 = new Color(207, 106, 119);
	private JScrollPane scrollPane;
	private TableHDDH table;
	private Icon iconFilterWhite = new ImageIcon(PanelTableHDDH.class.getResource("/icon/filter-white.png"));
	private JLabel lblNewLabel;
	private Icon iconFilterGray = new ImageIcon(PanelTableHDDH.class.getResource("/icon/filter-gray.png"));
	private TextField txtSearch;
	private DAOHDBHCT daohdbhct = new DAOHDBHCT();
	private DAOHDDH daohddh = new DAOHDDH();
	private DAOHDDHCT daohddhct = new DAOHDDHCT();
	private static ArrayList<ModelHDBHCT> cthdbhs = new ArrayList<ModelHDBHCT>();
	private static ArrayList<ModelProduct> products = new ArrayList<ModelProduct>();
	private ArrayList<String[]> listMaHDBHCT = new ArrayList<String[]>();
	private ArrayList<ModelHDDH> hddhs = new ArrayList<ModelHDDH>();

	private PanelOptionConfirm optionConfirm = new PanelOptionConfirm();
	private static DiaLogShowPanel dialogShow = new DiaLogShowPanel(null);
	private DialogQuestion question = new DialogQuestion(null);
	private DialogShowOption dialogShowOption = new DialogShowOption(null);
	private PanelHDDH panelCTHDTH = new PanelHDDH();
	private PanelChooseSP chooseSP = new PanelChooseSP();
	public static TableSP tableSPDoi = new TableSP();
	private JLabel lblSnPhmi;
	private static int indexSeleted = -1;
	private int x = 650;
	private int y = 290;
	private static JPanel panelName;
	private static JLabel lblMaHDBH;
	private static JLabel lblName;
	private static ButtonCheckedSizeAndColor btnDH;
	private static JLabel lblTotal;

	public PanelTableHDDH() {
		setOpaque(false);
		table = new TableHDDH();
		scrollPane = new JScrollPane(table);
		table.addTableStyle(scrollPane);
		lblNewLabel = new JLabel("Hóa Đơn Đổi Hàng");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel.setForeground(ColorBackground.colorLight);

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

		lblSnPhmi = new JLabel("Sản Phẩm Đổi");
		lblSnPhmi.setForeground(new Color(252, 252, 252));
		lblSnPhmi.setFont(new Font("Dialog", Font.BOLD, 14));

		JScrollPane scrollPaneHDCT = new JScrollPane(tableSPDoi);
		tableSPDoi.addTableStyle(scrollPaneHDCT);

		JPanel panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(color2);
				g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
				g2.setColor(color);
				g2.fillRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 15, 15);
				super.paintComponent(g);
			}
		};
		panel.setOpaque(false);

		JLabel lblTinHonTr = new JLabel("Tiền Hoàn Trả");
		lblTinHonTr.setForeground(new Color(147, 147, 147));
		lblTinHonTr.setFont(new Font("Roboto", Font.BOLD, 14));

		lblTotal = new JLabel("");
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setForeground(new Color(207, 106, 119));
		lblTotal.setFont(new Font("Roboto", Font.BOLD, 18));

		JLabel lblMHan = new JLabel("Mã Hóa Đơn");
		lblMHan.setForeground(new Color(147, 147, 147));
		lblMHan.setFont(new Font("Roboto", Font.BOLD, 14));

		JLabel lblKhchHng = new JLabel("Khách Hàng");
		lblKhchHng.setForeground(new Color(147, 147, 147));
		lblKhchHng.setFont(new Font("Roboto", Font.BOLD, 14));

		lblMaHDBH = new JLabel("");
		lblMaHDBH.setForeground(new Color(252, 252, 252));
		lblMaHDBH.setFont(new Font("Roboto", Font.BOLD, 14));

		lblName = new JLabel("");
		lblName.setForeground(new Color(252, 252, 252));
		lblName.setFont(new Font("Roboto", Font.BOLD, 14));

		btnDH = new ButtonCheckedSizeAndColor(0);
		btnDH.setText("Đổi Hàng");
		btnDH.setForeground(new Color(252, 252, 252));
		btnDH.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnDH.setEnabled(false);

		JLabel lblSnPhmi_1 = new JLabel("Sản Phẩm Đổi");
		lblSnPhmi_1.setForeground(new Color(147, 147, 147));
		lblSnPhmi_1.setFont(new Font("Roboto", Font.BOLD, 14));
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.addTableStyle(scrollPane);
		
		panelName = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(ColorBackground.colorDark);
				g2.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		panelName.setOpaque(false);
	
		
		JScrollPane scrollPaneName = new JScrollPane(panelName);
		scrollPaneName.getViewport().setOpaque(false);
		scrollPaneName.setBorder(null);
		scrollPaneName.setViewportBorder(null);
	
		
		panelName.setLayout(new MigLayout("fillx,insets 0"));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSnPhmi_1)
								.addComponent(scrollPaneName, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDH, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblTinHonTr)
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblMHan)
										.addGap(36))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblKhchHng, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED))))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
								.addComponent(lblTotal, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
								.addComponent(lblMaHDBH, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKhchHng))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblMHan, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMaHDBH, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(lblTinHonTr, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblSnPhmi_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
							.addComponent(btnDH, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(scrollPaneName, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(panelFind, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblSnPhmi)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(scrollPaneHDCT, GroupLayout.PREFERRED_SIZE, 615,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)))
				.addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(panelFind, GroupLayout.PREFERRED_SIZE, 28,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26,
														GroupLayout.PREFERRED_SIZE)
												.addGap(20)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblSnPhmi, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPaneHDCT, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
										.addComponent(panel, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
								.addContainerGap()));
		setLayout(groupLayout);
		if (MainForm.mode == "Light") {
			setColorModeLight();
		} else {
			setColorModeDark();
		}
		optionConfirm.btnOK.setEnabled(false);
		action();

	}

	public void init(String MaHDBH) {
		cthdbhs = daohdbhct.Find(new ModelHDBHCT(MaHDBH));
		fillTable();
	}

	public void fillTable() {
		table.tableModel.setRowCount(0);
		for (ModelHDBHCT data : cthdbhs) {
			long roundValue = Math.round(data.getTotalPrice());
			table.tableModel.addRow(new Object[] { data.getMaHDBH(), data.getMaSP(), data.getTenSP(), data.getSize(),
					data.getColor(), data.getMaterial(), data.getType(), data.getQuantity(), roundValue });
		}
	}

	private void setColorModeDark() {
		lblNewLabel.setForeground(ColorBackground.colorLight);
		txtSearch.setForeground(ColorBackground.colorLight);

	}

	private void setColorModeLight() {
		lblNewLabel.setForeground(ColorBackground.colorDark);
		txtSearch.setForeground(ColorBackground.colorDark);
	}

	public void action() {
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 1) {
					indexSeleted = table.getSelectedRow();
					dialogShowOption.showForm(optionConfirm);
					optionConfirm.text.setText("");
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

		optionConfirm.btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int quantity = Integer.parseInt(optionConfirm.text.getText());

				int quantityTable = Integer.parseInt(table.getValueAt(indexSeleted, 7).toString());

				if (quantity > quantityTable) {
					question.lblTextMessage.setText("Số Lượng Không Được Quá Lớn");
					setLocationDiaLogQuestion();
				} else {
					String maHDBHCT = cthdbhs.get(indexSeleted).getId();
					String maHDBH = cthdbhs.get(indexSeleted).getMaHDBH();
					String maSP = cthdbhs.get(indexSeleted).getMaSP();
					double total = cthdbhs.get(indexSeleted).getTotalPrice() * quantity;

					String[] data = new String[] { maHDBHCT,maHDBH, maSP, quantity + "",total+"" };

					listMaHDBHCT.add(data);

					dialogShowOption.setVisible(false);
					table.setValueAt(quantityTable - quantity, indexSeleted, 7);
					dialogShow.showForm(chooseSP);
					double totalPrice = 0;
					if (tableSPDoi.getRowCount() <= 0) {

						chooseSP.clear();
						totalPrice = cthdbhs.get(indexSeleted).getTotalPrice() * quantity;
					} else {
						double priceReturn = Double.parseDouble(lblTotal.getText().replace(" ", "").replace("VNĐ", ""));
						totalPrice = cthdbhs.get(indexSeleted).getTotalPrice() * quantity + priceReturn;
					}

					chooseSP.setPriceReturn(totalPrice);
					int x = 400;
					int y = 80;
					MainForm.setLocationDialog(x, y);
					MainForm.setLocationMouseDragged(x, y);
					dialogShow.setLocation(MainForm.xScreen, MainForm.yScreen);
					dialogShow.setModalityType(ModalityType.MODELESS);
					dialogShow.setVisible(true);
				}
			}

		});

		btnDH.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doiHang();

			}
		});

		optionConfirm.btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialogShowOption.setVisible(false);

			}
		});

		chooseSP.btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialogShow.setVisible(false);
			}
		});

		txtSearch.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				init(txtSearch.getText());
				fillTable();

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

	public static void fillTableFromTableChoose(ArrayList<ModelProduct> list, double price) {
		products = list;
		String nameKH = cthdbhs.get(indexSeleted).getTenKH();
		String maHD = cthdbhs.get(indexSeleted).getMaHDBH();
		String nameSP = cthdbhs.get(indexSeleted).getTenSP();

		lblName.setText(nameKH);
		lblMaHDBH.setText(maHD);
		dialogShow.setVisible(false);
		btnDH.setEnabled(true);
		long round = Math.round(price);
		lblTotal.setText(round + " VNĐ");
		fillTableDoiSP();
	}

	public void doiHang() {
		double totalPrice = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(new Date());
		String MaKH = cthdbhs.get(indexSeleted).getMaKH();
		
		for (int i = 0; i < products.size(); i++) {			
			totalPrice =products.get(i).getProductPrice().getPrice() * products.get(i).getProductQuantity().getQuantity();
			
		}
		if (daohddh.insert(new ModelHDDH("", date, totalPrice, MaKH)) > 0) {
			hddhs = daohddh.selectTopOne();
			String MaHDDH = hddhs.get(0).getMaHDDH();
			for (ModelProduct data : products) {
				String MaSP = data.getId().getId();
				int quantity = data.getProductQuantity().getQuantity();
				String size = data.getProductSize().getNameSize();
				String color = data.getProductColor().getNameColor();
				String material = data.getProductMaterial().getNameMeterial();
				double price = data.getProductPrice().getPrice();
				daohddhct.insert(new ModelHDDHCT("", MaHDDH, MaSP, quantity, size, color, material, price));
			}
			
			for (String[] s : listMaHDBHCT) {
				
				System.out.println(s[1]);
				
				
				System.out.println(s[4]);
				
				
				daohdbhct.update(new ModelHDBHCT(s[0], s[1], s[2], Integer.parseInt(s[3]), Double.parseDouble(s[4]), "", "", "", ""));
			}

			clear();
			question.lblTextMessage.setText("Đổi Hàng Thành Công");
			setLocationDiaLogQuestion();
		}
	}

	public static void fillTableDoiSP() {
		tableSPDoi.tableModel.setRowCount(0);
		panelName.removeAll();
		for (ModelProduct data : products) {
			long roundValue = Math.round(data.getProductPrice().getPrice());
			tableSPDoi.tableModel.addRow(new Object[] { data.getId().getId(), data.getProductName().getProductName(),
					data.getProductQuantity().getQuantity(), data.getProductSize().getNameSize(),
					data.getProductColor().getNameColor(), data.getProductMaterial().getNameMeterial(), roundValue });
			
			panelName.add(new LabelSP(data.getProductName().getProductName()),"wrap");
		}
	}

	public void clear() {
		lblName.setText("");
		lblMaHDBH.setText("");
		panelName.removeAll();
		btnDH.setEnabled(false);
		lblTotal.setText("");
		products.clear();
		fillTableDoiSP();

	}

	public void setLocationDiaLogQuestion() {
		MainForm.setLocationDialog(x, y);
		MainForm.setLocationMouseDragged(x, y);
		question.setLocation(MainForm.xScreen, MainForm.yScreen);
		question.setModalityType(ModalityType.MODELESS);
		question.setAlwaysOnTop(true);
		question.setVisible(true);
	}

	public void setColorButtonModeDark(ButtonCheckedSizeAndColor button) {
		button.setColorBackground(ColorBackground.colorDark);
		button.setColorhover1(ColorBackground.colorGRB394348);
	}

	public void setColorButtonModeLight(ButtonCheckedSizeAndColor button) {
		button.setColorBackground(ColorBackground.colorLight);
		button.setColorhover1(ColorBackground.colorGRB181228202);
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
