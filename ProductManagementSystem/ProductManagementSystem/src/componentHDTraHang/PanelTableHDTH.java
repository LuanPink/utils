package componentHDTraHang;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import color.ColorBackground;
import componentCreateProduct.ButtonCheckedSizeAndColor;
import componentCreateProduct.PanelTitle;
import componentStore.DialogFilterStoreProduct;
import componentStore.PanelStoreHeader;
import dao.DAOHDBH;
import dao.DAOHDTH;
import dia.DiaLogShowPanel;
import model.ModelHDBHCT;
import model.ModelHDBH;
import model.ModelHDTH;
import model.ModelHDTHCT;
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
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import animation.TextField;

import javax.swing.JButton;

public class PanelTableHDTH extends JPanel {
	private Color color = ColorBackground.colorDark;
	private JScrollPane scrollPane;
	private TableHDTH table;
	private Icon iconFilterWhite = new ImageIcon(PanelTableHDTH.class.getResource("/icon/filter-white.png"));
	private JLabel lblNewLabel;
	private Icon iconFilterGray = new ImageIcon(PanelTableHDTH.class.getResource("/icon/filter-gray.png"));
	private TextField txtSearch;
	private DAOHDTH daohdth = new DAOHDTH();
	private ArrayList<ModelHDTH> hdths = new ArrayList<ModelHDTH>();
	DiaLogShowPanel dialogShow = new DiaLogShowPanel(null);
	PanelCTHDTH panelCTHDTH = new PanelCTHDTH();
	public PanelTableHDTH() {
		setOpaque(false);
		table  = new TableHDTH();
		scrollPane = new JScrollPane(table);
		table.addTableStyle(scrollPane);
		lblNewLabel = new JLabel("Hóa Đơn Trả Hàng");
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
		gl_panelFind.setHorizontalGroup(
			gl_panelFind.createParallelGroup(Alignment.LEADING)
				.addGap(0, 216, Short.MAX_VALUE)
				.addGroup(gl_panelFind.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
		);
		gl_panelFind.setVerticalGroup(
			gl_panelFind.createParallelGroup(Alignment.LEADING)
				.addGap(0, 28, Short.MAX_VALUE)
				.addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
		);
		panelFind.setLayout(gl_panelFind);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelFind, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelFind, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(20)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
		if(MainForm.mode == "Light") {
			setColorModeLight();
		}else {
			setColorModeDark();
		}
		init();
		action();
		
	}
	
	public void init() {
		hdths = daohdth.selectAll();
		fillTable();
	}
	
	public void fillTable() {
		table.tableModel.setRowCount(0);
		for (ModelHDTH data : hdths) {
			long roundValue = Math.round(data.getTotalPrice());
			table.tableModel.addRow(new Object[] {
					data.getMaHDTraHang(),data.getName(),data.getNgayTra(),roundValue
			});
		}
	}
	private void setColorModeDark() {
		lblNewLabel.setForeground(ColorBackground.colorLight);
		txtSearch.setForeground(ColorBackground.colorLight);

	}

	private void setColorModeLight() {
		// TODO Auto-generated method stub
		lblNewLabel.setForeground(ColorBackground.colorDark);
		txtSearch.setForeground(ColorBackground.colorDark);
	}
	public void action() {
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getClickCount() == 2) {
					int index = table.getSelectedRow();
					String MaHDTH = hdths.get(index).getMaHDTraHang();
					// show DialogCTHHBH
					dialogShow.showForm(panelCTHDTH);
					panelCTHDTH.init(new ModelHDTHCT(MaHDTH));
					int x = 400;
					int y = 80;
					MainForm.setLocationDialog(x, y);
					MainForm.setLocationMouseDragged(x, y);
					dialogShow.setLocation(MainForm.xScreen, MainForm.yScreen);
					dialogShow.setModalityType(ModalityType.APPLICATION_MODAL);
					dialogShow.setVisible(true);
				}
			}
		});
		
		txtSearch.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				if(txtSearch.getText().equals("")) {
					init();
				}else {
					hdths = daohdth.Find(new ModelHDTH(txtSearch.getText()));
					fillTable();
				}
			}
			
		});
		
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		
		panelCTHDTH.btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogShow.setVisible(false);
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
