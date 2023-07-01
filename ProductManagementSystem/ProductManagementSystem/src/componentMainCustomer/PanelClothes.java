package componentMainCustomer;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import dao.DAOProducts;
import model.ModelProduct;
import net.miginfocom.swing.MigLayout;

public class PanelClothes extends JPanel {
	
	JPanel panel;
		
	JPanel header;
	JPanel body;
	JPanel footter;

	public PanelBottomProduct panelFootter;
	ArrayList<ModelProduct> datas = new ArrayList<ModelProduct>();
	DAOProducts dao = new DAOProducts();
	private JPanel panelBody;
	private int index = 0;
	private String gender;
	public PanelClothes(String gender) {
		setOpaque(false);
		this.gender = gender;
		setLayout(new MigLayout("fill"));
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new MigLayout("fill, wrap, inset 0","[fill]","[300!,fill][fill,50%][::100% ,shrink 0]"));
		
		header = createHeader();
		
		body = createBody();
		
		footter = createFootter();
		
		panel.add(header);
		panel.add(body);
		panel.add(footter);
		
		add(panel,"push, grow");
	}
	
	
	public JPanel createHeader() {
		PanelHeaderClothes panelHeader = new PanelHeaderClothes(gender);
		
		return panelHeader;
	}
	
	public JPanel createBody() {
		panelBody = new JPanel();
		panelBody.setLayout(new MigLayout("fillx"));
		init();
		return panelBody;
	}
	
	public void init() {
		if(gender=="Nam") {
			datas = dao.SelectByName("Nam");
		}else {
			datas = dao.SelectByName("Nữ");
		}
		fillBody();
	}
	
	
	public void fillBody() {
		panelBody.removeAll();
		panelBody.repaint();
		panelBody.revalidate();
		String attribute = "";
		for (ModelProduct data : datas) {
			ImageIcon image = new ImageIcon(
					new ImageIcon(PanelHome.class.getResource("/icon/"+data.getProductImage().getProductImage())).getImage()
							.getScaledInstance(300, 350, Image.SCALE_SMOOTH));
			String id = data.getId().getId();
			String name = data.getProductName().getProductName();
			double price = data.getProductPrice().getPrice();
			long roundPrice = Math.round(price);
			ButtonProduct product = new ButtonProduct(image,id,name,roundPrice+"");
			index++;
			attribute = (index % 3 == 0) ? "wrap" : "";
			panelBody.add(product,attribute);
			
		}
	}
	
	public JPanel createFootter() {
		 panelFootter = new PanelBottomProduct();
		 panelFootter.setOpaque(false);
		return panelFootter;
	}
	
	

}
