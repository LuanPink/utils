package componentCreateProduct;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import color.ColorBackground;
import dao.DAOProductMaterial;
import dao.DAOProductType;
import dao.DAOProducts;
import event.EventHandler;
import model.ModelProductType;
import model.ModelSupplier;
import view.MainForm;
import view.PanelMode;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class PanelPriceProduct extends JPanel {
	private Color color = new Color(26, 29, 31);
	private JTextField txtPrice;
	private PanelTitle panePrice;
	private JTextField txtAmount;
	private PanelTitle panelAmount;
	private JLabel lblLoai;
	public Combobox comboBox;
	private DAOProductMaterial daoProductMateriall;
	private DefaultComboBoxModel cbbModel;
	private DAOProductType daoProductType=new DAOProductType();
	EventHandler<ArrayList<Integer>> eventHandler = new EventHandler<ArrayList<Integer>>();
	
	public int indexSelectedComboBox = 0;
	private JLabel lblTitle;
	private JLabel lblPrice;
	private JLabel lblAmount;
	private JLabel lblerprice;
	private JLabel lblerquantity;
	private JLabel lblerloaisanpham;

	public PanelPriceProduct() {
		setOpaque(false);

		lblTitle = new JLabel("Giá & Số Lượng Sản Phẩm");
		lblTitle.setForeground(new Color(252, 252, 252));
		lblTitle.setFont(new Font("Roboto", Font.BOLD, 18));

		lblPrice = new JLabel("Đơn Giá");
		lblPrice.setForeground(new Color(252, 252, 252));
		lblPrice.setFont(new Font("Roboto", Font.BOLD, 14));

		panePrice = new PanelTitle();
		panePrice.setBackground(color);

		txtPrice = new JTextField();
		txtPrice.setOpaque(false);
		txtPrice.setForeground(Color.WHITE);
		txtPrice.setFont(new Font("Roboto", Font.BOLD, 14));
		txtPrice.setCaretColor(Color.WHITE);
		txtPrice.setBorder(null);
		GroupLayout gl_panePrice = new GroupLayout(panePrice);
		gl_panePrice.setHorizontalGroup(gl_panePrice.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panePrice.createSequentialGroup().addContainerGap()
						.addComponent(txtPrice, GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE).addContainerGap()));
		gl_panePrice.setVerticalGroup(gl_panePrice.createParallelGroup(Alignment.LEADING).addComponent(txtPrice,
				GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE));
		panePrice.setLayout(gl_panePrice);

		lblAmount = new JLabel("Số Lượng");
		lblAmount.setForeground(new Color(252, 252, 252));
		lblAmount.setFont(new Font("Roboto", Font.BOLD, 14));

		panelAmount = new PanelTitle();
		panelAmount.setBackground(color);

		txtAmount = new JTextField();
		txtAmount.setOpaque(false);
		txtAmount.setForeground(Color.WHITE);
		txtAmount.setFont(new Font("Roboto", Font.BOLD, 14));
		txtAmount.setCaretColor(Color.WHITE);
		txtAmount.setBorder(null);
		GroupLayout gl_panelAmount = new GroupLayout(panelAmount);
		gl_panelAmount.setHorizontalGroup(gl_panelAmount.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 846, Short.MAX_VALUE).addGroup(gl_panelAmount.createSequentialGroup().addContainerGap()
						.addComponent(txtAmount, GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE).addContainerGap()));
		gl_panelAmount
				.setVerticalGroup(gl_panelAmount.createParallelGroup(Alignment.LEADING).addGap(0, 49, Short.MAX_VALUE)
						.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE));
		panelAmount.setLayout(gl_panelAmount);

		lblLoai = new JLabel("Loại Sản Phẩm");
		lblLoai.setForeground(new Color(252, 252, 252));
		lblLoai.setFont(new Font("Roboto", Font.BOLD, 14));

		comboBox = new Combobox();

		cbbModel = new DefaultComboBoxModel();
		
		
		lblerprice = new JLabel("");
		lblerprice.setForeground(new Color(255, 0, 0));
		lblerprice.setFont(new Font("Dialog", Font.BOLD, 12));
		
		lblerquantity = new JLabel("");
		lblerquantity.setForeground(Color.RED);
		lblerquantity.setFont(new Font("Dialog", Font.BOLD, 12));
		
		lblerloaisanpham = new JLabel("");
		lblerloaisanpham.setForeground(Color.RED);
		lblerloaisanpham.setFont(new Font("Dialog", Font.BOLD, 12));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblerloaisanpham, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblerquantity, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblerprice, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrice, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
						.addComponent(lblTitle, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
						.addComponent(panelAmount, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
						.addComponent(panePrice, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
						.addComponent(lblAmount, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
						.addComponent(comboBox, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
						.addComponent(lblLoai, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panePrice, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblerprice, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(lblAmount, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelAmount, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblerquantity, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(lblLoai, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblerloaisanpham, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(141, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		if (MainForm.mode == "Dark") {
			setColorModeDark();
		} else {
			setColorModeLight();
		}
		action();
		fillcbo();
	}
	public void fillcbo() {
		cbbModel.addElement("");
		
		comboBox.setModel(cbbModel);
		for (ModelProductType t : daoProductType.SelectAll()) {
			cbbModel.addElement(t.getNameType());
		}
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

		addMouseListenerText(txtPrice, panePrice);
		addMouseListenerText(txtAmount, panelAmount);
	}

	public void addMouseListenerText(JTextField text, PanelTitle panel) {
		text.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (MainForm.mode == "Dark") {
					panel.setColorBackground(ColorBackground.colorGRB000);
					panel.setColorClick(new Color(82, 147, 242));
				} else {
					panel.setColorBackground(ColorBackground.colorLight);
					panel.setColorClick(new Color(82, 147, 242));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (MainForm.mode == "Dark") {
					panel.setColorBackground(ColorBackground.colorGRB394348);
					panel.setColorClick(ColorBackground.colorGRB394348);
				} else {
					panel.setColorBackground(ColorBackground.colorGRB240242245);
					panel.setColorClick(ColorBackground.colorGRB239239239);
				}
			}
		});
	}

	public void setColorModeDark() {
		setColor(ColorBackground.colorDark);

		lblTitle.setForeground(ColorBackground.colorLight);
		lblAmount.setForeground(ColorBackground.colorLight);
		lblPrice.setForeground(ColorBackground.colorLight);
		lblLoai.setForeground(ColorBackground.colorLight);

		panePrice.setColorClick(ColorBackground.colorGRB394348);
		panePrice.setColorBackground(ColorBackground.colorGRB394348);

		panelAmount.setColorClick(ColorBackground.colorGRB394348);
		panelAmount.setColorBackground(ColorBackground.colorGRB394348);

		txtPrice.setCaretColor(ColorBackground.colorLight);
		txtPrice.setForeground(ColorBackground.colorLight);
		txtPrice.setBackground(ColorBackground.colorGRB000);

		txtAmount.setCaretColor(ColorBackground.colorLight);
		txtAmount.setForeground(ColorBackground.colorLight);
		txtAmount.setBackground(ColorBackground.colorGRB000);

		comboBox.setColorBackground(ColorBackground.colorGRB394348);
		comboBox.setColorBackground1(ColorBackground.colorLight);
		comboBox.setColor(ColorBackground.colorGRB000);
		comboBox.setColor2(ColorBackground.colorLight);
	}

	public void setColorModeLight() {
		setColor(ColorBackground.colorLight);

		lblTitle.setForeground(ColorBackground.colorDark);
		lblAmount.setForeground(ColorBackground.colorGRB147147147);
		lblPrice.setForeground(ColorBackground.colorGRB147147147);
		lblLoai.setForeground(ColorBackground.colorGRB147147147);

		panePrice.setColorClick(ColorBackground.colorGRB239239239);
		panePrice.setColorBackground(ColorBackground.colorGRB239239239);

		panelAmount.setColorClick(ColorBackground.colorGRB239239239);
		panelAmount.setColorBackground(ColorBackground.colorGRB239239239);

		txtPrice.setCaretColor(ColorBackground.colorDark);
		txtPrice.setForeground(ColorBackground.colorDark);
		txtPrice.setBackground(ColorBackground.colorGRB239239239);

		txtAmount.setCaretColor(ColorBackground.colorDark);
		txtAmount.setForeground(ColorBackground.colorDark);
		txtAmount.setBackground(ColorBackground.colorGRB239239239);

		comboBox.setColorBackground(ColorBackground.colorGRB239239239);
		comboBox.setColorBackground1(ColorBackground.colorGRB147147147);
		comboBox.setColor(ColorBackground.colorGRB240242245);
		comboBox.setColor2(ColorBackground.colorGRB147147147);

	}
	public Double Prices() {
		Double price=0.0;
		String Price=txtPrice.getText();
		if(Price.length()==0) {
			lblerprice.setText("Xin nhập đơn giá");
			
		}else {
			String reg="\\d+";
			if(!Price.matches(reg)) {
				lblerprice.setText("Đơn giá phải là số");
				
			}else {
				price=Double.valueOf(Price);
				lblerprice.setText("");
				
			}
		}
		return price;
	}
	public Integer Quantitys() {
		Integer qtt=0;
		String Quantity=txtAmount.getText();
		if(Quantity.length()==0) {
			lblerquantity.setText("Xin nhập số lượng");
		}else {
			String reg="[1-9]+";
			if(!Quantity.matches(reg)) {
				lblerquantity.setText("Số lượng phải là số");
			}else {
				 qtt=Integer.valueOf(Quantity);
				 lblerquantity.setText("");
				return qtt;
			}
		}
		return 0;
	}
	public String ProductType() {
		String nccT=null;
		
		for (ModelProductType ms : daoProductType.SelectAll()) {
			if(cbbModel.getSelectedItem().equals(ms.getNameType())) {
				nccT=ms.getId();
			}
		}
		
		
		if(nccT==null) {
			lblerloaisanpham.setText("Xin chọn loại");
		}else {
			lblerloaisanpham.setText("");
			return nccT;
		}
		return null;
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
