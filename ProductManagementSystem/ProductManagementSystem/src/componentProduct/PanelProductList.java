package componentProduct;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import color.ColorBackground;
import componentScrollPane.ScrollBarMenu;
import componentTable.CellAction;
import componentTable.CellProductColor;
import componentTable.CellProductDescriber;
import componentTable.CellProductImage;
import componentTable.CellProductMaterial;
import componentTable.CellProductName;
import componentTable.CellProductPrice;
import componentTable.CellProductQuantity;
import componentTable.CellProductSize;
import componentTable.CellProductStatus;
import componentTable.CellProductSupplier;
import componentTable.CellProductType;
import componentTable.CellProductVat;
import componentTable.CellProductWarranty;
import componentTable.CellidProduct;
import componentTable.TableProductList;
import dao.DAOProducts;
import model.ModelProductName;
import model.ModelProduct;
import model.ModelProductColor;
import model.ModelProductDescriber;
import model.ModelProductId;
import model.ModelProductImage;
import model.ModelProductList;
import model.ModelProductMaterial;
import model.ModelProductPrice;
import model.ModelProductQuantity;
import model.ModelProductSize;
import model.ModelProductStatus;
import model.ModelProductType;
import model.ModelProductVAT;
import model.ModelProductWarranty;
import model.ModelSupplier;
import net.miginfocom.swing.MigLayout;
import view.MainForm;
import view.PanelMode;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import animation.TextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import componentHeader.ButtonShowAllNotification;
import componentCreateProduct.PanelTitle;

public class PanelProductList extends JPanel {
	private Color color = ColorBackground.colorDark;
	private JPanel panel;
	private JPanel header;
	private JPanel body;
	private JPanel bottom;
	private static JPanel panelBody;

	private static ArrayList<ModelProduct> datas = new ArrayList<ModelProduct>();
	private static DAOProducts dao = new DAOProducts();
	private static ButtonProductList btnProduct;
	private JScrollPane scrollPane;
	private TableProductList table;
	private JLabel lblNewLabel;
	int i = 0;
	private TextField txtSearch;
	private PanelTitle panelFind;
	public PanelProductList() {
		setOpaque(false);
		panel = new JPanel();
		panel.setOpaque(false);

		header = new JPanel();
		header.setOpaque(false);
		
		body = createPanelBody();
		GroupLayout gl_panelBody = new GroupLayout(panelBody);
		gl_panelBody.setHorizontalGroup(
			gl_panelBody.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE)
		);
		gl_panelBody.setVerticalGroup(
			gl_panelBody.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
		);
		panelBody.setLayout(gl_panelBody);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1037, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
					.addContainerGap())
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(2)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panelBody, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(header, GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(2)
					.addComponent(header, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelBody, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE))
		);
		
		lblNewLabel = new JLabel("Sản Phẩm");
		lblNewLabel.setForeground(ColorBackground.colorLight);
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 18));
		
		panelFind = new PanelTitle();
		
		txtSearch = new TextField();
		txtSearch.setHint("Tìm kiếm sản phẩm...");
		txtSearch.setForeground(new Color(252, 252, 252));
		txtSearch.setFont(new Font("Roboto", Font.ITALIC, 12));
		txtSearch.setCaretColor(new Color(252, 252, 252));
		txtSearch.setBorder(null);
		GroupLayout gl_panelFind = new GroupLayout(panelFind);
		gl_panelFind.setHorizontalGroup(
			gl_panelFind.createParallelGroup(Alignment.LEADING)
				.addGap(0, 430, Short.MAX_VALUE)
				.addGroup(gl_panelFind.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
		);
		gl_panelFind.setVerticalGroup(
			gl_panelFind.createParallelGroup(Alignment.LEADING)
				.addGap(0, 30, Short.MAX_VALUE)
				.addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
		);
		panelFind.setLayout(gl_panelFind);
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(panelFind, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(502, Short.MAX_VALUE))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
				.addComponent(panelFind, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
		);
		header.setLayout(gl_header);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		if(MainForm.mode == "Dark") {
			setColorModeDark();
			table.setColorModeDark();
		}else {
			setColorModeLight();
			table.setColorModeLight();
		}
		
		action();
	
	}

	public JPanel createPanelBody() {
		panelBody = new JPanel();
		panelBody.setOpaque(false);
		panelBody.setBorder(null);
		init();

		return panelBody;

	}

	public void init() {
		datas = dao.SelectAll();
		fillPanelBody();

	}

	public void fillPanelBody() {
		table = new TableProductList();
		
		scrollPane = new JScrollPane(table);	
		table.addTableStyle(scrollPane);
		
		panelBody.add(scrollPane);
		
		initDataTable();
		
	}

	public void initDataTable() {
		table.addTableCell(new CellidProduct(), 0);
		table.addTableCell(new CellProductName(), 1);
		table.addTableCell(new CellProductPrice(), 2);
		table.addTableCell(new CellProductQuantity(), 3);
		table.addTableCell(new CellProductWarranty(), 4);
		table.addTableCell(new CellProductVat(), 5);
		table.addTableCell(new CellProductImage(), 6);
		table.addTableCell(new CellProductDescriber(), 7);
		table.addTableCell(new CellProductStatus(), 8);
		table.addTableCell(new CellProductSupplier(), 9);
		table.addTableCell(new CellProductType(), 10);
		table.addTableCell(new CellProductSize(), 11);
		table.addTableCell(new CellProductColor(), 12);
		table.addTableCell(new CellProductMaterial(), 13);
		table.addTableCell(new CellAction(), 14);
		
		initData();
	}
	
	public void initData() {
		for (ModelProduct data : datas) {
			table.addRow(new ModelProduct(
					new ModelProductId(data.getId().getId()),
					new ModelProductName(data.getProductName().getProductName()),
					new ModelProductPrice(data.getProductPrice().getPrice()),
					new ModelProductQuantity(data.getProductQuantity().getQuantity()),
					new ModelProductWarranty(data.getProductWarranty().getWarranty()),
					new ModelProductVAT(data.getProductVAT().getVat()),	
					new ModelProductDescriber(data.getDescriber().getDescriber()),
					new ModelProductImage(data.getProductImage().getProductImage()),		
					new ModelProductStatus(data.getProductStatus().getNameStatus()),
					new ModelSupplier(data.getSupplier().getId(), data.getSupplier().getName()),
					new ModelProductType(data.getProductType().getId(), data.getProductType().getNameType()),
					new ModelProductSize(data.getProductSize().getId(), data.getProductSize().getNameSize()),
					new ModelProductColor(data.getProductColor().getId(), data.getProductColor().getNameColor()),
					new ModelProductMaterial(data.getProductMaterial().getId(), data.getProductMaterial().getNameMeterial())),
					false);
		}
	}
	
	
	public void action() {
		txtSearch.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				String name = txtSearch.getText();
				
				if(name == "") {
					return;
				}else {
					datas = dao.SelectByNameProduct(name);
					table.removeAllRows();
					initData();
					
				}
			}
		});

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
		lblNewLabel.setForeground(ColorBackground.colorLight);
		txtSearch.setCaretColor(ColorBackground.colorLight);
		txtSearch.setForeground(ColorBackground.colorLight);
		panelFind.setColorBackground(ColorBackground.colorGRB394348);
		panelFind.setColorClick(ColorBackground.colorGRB394348);
		setColor(ColorBackground.colorDark);
		
		PanelProductDashboard.lblTitle.setForeground(ColorBackground.colorLight);
	}
	
	public void setColorModeLight() {
		lblNewLabel.setForeground(ColorBackground.colorGRB147147147);
		txtSearch.setCaretColor(ColorBackground.colorDark);
		txtSearch.setForeground(ColorBackground.colorDark);
		
		panelFind.setColorClick(ColorBackground.colorGRB239239239);
		panelFind.setColorBackground(ColorBackground.colorGRB239239239);
		setColor(ColorBackground.colorLight);
		
		PanelProductDashboard.lblTitle.setForeground(ColorBackground.colorDark);
	}
	

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

		super.paintComponent(g);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		repaint();
	}
}
