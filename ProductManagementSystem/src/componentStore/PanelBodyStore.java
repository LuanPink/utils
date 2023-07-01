package componentStore;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import color.ColorBackground;
import componentLogin.MainLogin;
import componentProduct.ButtonProductList;
import dao.DAOProducts;
import model.ModelProduct;
import model.ModelProductList;
import net.miginfocom.swing.MigLayout;
import view.MainForm;
import view.PanelMode;

public class PanelBodyStore extends JPanel {

	private JPanel panel;
	private JPanel header;
	private JPanel body;
	private JPanel footer;
	private MigLayout layout;
	private ArrayList<ModelProduct> datas = new ArrayList<ModelProduct>();
	private DAOProducts dao = new DAOProducts();
	private Color color = ColorBackground.colorDark;
	private int index = 0;
	private JPanel panelBody;
	private PanelStoreHeader panelHeader;
	private int indexRow = 0;

	public PanelBodyStore() {
		setOpaque(false);
		setLayout(new MigLayout("fill"));
		panel = new JPanel();
		panel.setOpaque(false);
		layout = new MigLayout("fill, wrap, inset 2", "[fill]", "[150!,fill][fill,100%][::60% ,shrink 0]");
		panel.setLayout(layout);

		header = createHeader();

		body = createBody();

		footer = createFooter();

		panel.add(header);

		panel.add(body);

		panel.add(footer);

		add(panel, "push,grow");
		
		if(MainForm.mode =="Dark") {
			setColorModeDark();
		}else {
			setColorModeLight();
		}
	
		action();
	}

	public JPanel createHeader() {
		panelHeader = new PanelStoreHeader();

		return panelHeader;
	}

	public JPanel createBody() {
		panelBody = new JPanel();
		panelBody.setOpaque(false);
		panelBody.setLayout(new MigLayout("fillx"));

		init();

		return panelBody;
	}

	public JPanel createFooter() {
		PanelStoreFooter panelFooter = new PanelStoreFooter();

		return panelFooter;
	}

	public void init() {
		datas = dao.SelectAll();
		fillPanelBody();
	}

	public void fillPanelBody() {
		panelBody.removeAll();
		panelBody.repaint();
		panelBody.revalidate();

		String attribute = "";
		for (ModelProduct data : datas) {

			ImageIcon imgProduct = new ImageIcon(
					new ImageIcon(PanelBodyStore.class.getResource("/icon/" + data.getProductImage().getProductImage())).getImage()
							.getScaledInstance(305, 189, Image.SCALE_SMOOTH));

			ButtonStoreProduct btn = new ButtonStoreProduct(imgProduct, data.getProductName().getProductName(), data.getProductPrice().getPrice() + "");

			index++;
			attribute = (index % 3 == 0) ? "wrap" : "";
			
			panelBody.add(btn, attribute);

		}
	}

	public void action() {
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
	
	public void setColorModeDark() {
		color = ColorBackground.colorDark;
		repaint();
	}

	public void setColorModeLight() {
		color = ColorBackground.colorLight;
		repaint();
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
