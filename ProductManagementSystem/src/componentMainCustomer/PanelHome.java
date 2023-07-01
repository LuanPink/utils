package componentMainCustomer;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import componentTable.CellProductImage;
import dao.DAOProducts;
import model.ModelProduct;
import net.miginfocom.swing.MigLayout;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;
import javax.swing.JComponent;

public class PanelHome extends JPanel {
	private Color color = new Color(252,252,252) ;
	
	ImageIcon banner = new ImageIcon(
			new ImageIcon(PanelHome.class.getResource("/icon/banner-home.jpg")).getImage()
					.getScaledInstance(980, 200, Image.SCALE_SMOOTH));
	
	ImageIcon logo = new ImageIcon(
			new ImageIcon(PanelHome.class.getResource("/icon/logo-shop.png")).getImage()
					.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
	
	ImageIcon trouser = new ImageIcon(
			new ImageIcon(PanelHome.class.getResource("/icon/trouser.jpg")).getImage()
					.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
	
	ImageIcon shirt = new ImageIcon(
			new ImageIcon(PanelHome.class.getResource("/icon/shirt.jpg")).getImage()
					.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
	
	ImageIcon shoes = new ImageIcon(
			new ImageIcon(PanelHome.class.getResource("/icon/shoes.jpeg")).getImage()
					.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
	
	ImageIcon seller = new ImageIcon(
			new ImageIcon(PanelHome.class.getResource("/icon/background-black.png")).getImage()
					.getScaledInstance(980, 80, Image.SCALE_SMOOTH));

	private JPanel panelProduct;
	private JPanel header;
	private JPanel body;
	private JPanel bottom;

	private static JPanel panelBody;
	private DAOProducts dao = new DAOProducts();
	public static ArrayList<ModelProduct> datas = new ArrayList<ModelProduct>();
	public static int index = 0;

	public JPanel footer;
	
	public PanelHome() {
		setOpaque(false);
		setLayout(new MigLayout("fill"));
		panelProduct = new JPanel();
		panelProduct.setOpaque(false);
		panelProduct.setLayout(new MigLayout("fill, wrap, inset 0", "[fill]", "[580!,fill][fill,50%][::50% ,shrink 0]"));
		
		header = createHeaderProduct();
	
		body = createBodyProduct();
		
		bottom = createBottomProduct();

		panelProduct.add(header);
		panelProduct.add(body);
		panelProduct.add(bottom);
		
		add(panelProduct, "push,grow");
	}
	
	public void initPanelProduct() {

	}
	
	public JPanel createHeaderProduct() {
		PanelHeaderProduct panelHeader = new PanelHeaderProduct();
		return panelHeader;
	}
	
	public JPanel createBodyProduct() {
		panelBody = new JPanel();
		panelBody.setLayout(new MigLayout("fillx"));
		init();
		return panelBody;
	}
	
	public JPanel createBottomProduct() {
		footer = new JPanel();
		footer.setOpaque(false);
		
		return footer;
	}
	
	public void showFormProduct() {
		footer.removeAll();
		footer.repaint();
		footer.revalidate();
	}
	
	public void init() {
		datas = dao.SelectAll();
		fillBodyProduct();
	}
	
	public static void fillBodyProduct() {
		panelBody.removeAll();
		panelBody.repaint();
		panelBody.revalidate();
		String attribute = "";
		for (ModelProduct data : datas) {
			ImageIcon image = new ImageIcon(
					new ImageIcon(PanelHome.class.getResource("/icon/"+data.getProductImage().getProductImage())).getImage()
							.getScaledInstance(300, 350, Image.SCALE_SMOOTH));
			
			String name = data.getProductName().getProductName();
			double price = data.getProductPrice().getPrice();
			long roundPrice = Math.round(price);
			ButtonProduct product = new ButtonProduct(image,name,roundPrice+"",index);
			index++;
			attribute = (index % 3 == 0) ? "wrap" : "";
			panelBody.add(product,attribute);
			
		}
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
}
