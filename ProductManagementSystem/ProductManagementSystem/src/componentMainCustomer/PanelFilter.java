package componentMainCustomer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import interfaces.EventMenu;
import interfaces.EventMenuSelected;
import interfaces.ShowPopup;
import model.ModelFilter;
import model.ModelProduct;
import model.ModelProductColor;
import model.ModelProductMaterial;
import model.ModelProductSize;
import net.miginfocom.swing.MigLayout;
import view.MainForm;
import view.MenuAnimation;
import view.MenuButtonItem;
import view.MenuItem;
import view.MenuItemFilter;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import color.ColorBackground;
import componentScrollPane.ScrollBarMainCustomer;
import componentScrollPane.ScrollBarMenu;
import componentStore.RangeSlider;
import dao.DAOProductColor;
import dao.DAOProductMaterial;
import dao.DAOProductSize;
import dao.DAOProducts;

import javax.swing.JComboBox;

public class PanelFilter extends JPanel {

	private MigLayout layout;
	private JScrollPane scrollPane;
	private JPanel panel;
	private boolean enable = true;
	private boolean showFilter = true;
	private ShowPopup showPopup;
	private EventMenuSelected event;
	DAOProductSize daoSize = new DAOProductSize();
	ArrayList<ModelProductSize> datasSize = new ArrayList<ModelProductSize>();
	
	DAOProductColor daoColor = new DAOProductColor();
	ArrayList<ModelProductColor> datasColor = new ArrayList<ModelProductColor>();
	
	DAOProductMaterial daoMaterial = new DAOProductMaterial();
	ArrayList<ModelProductMaterial> datasMaterial = new ArrayList<ModelProductMaterial>();
	
	
	String[] item;
	public RangeSlider rangeSlider;
	public PanelDistantPrice panelDistant;

	public PanelFilter() {
		setOpaque(false);

		layout = new MigLayout("fillx, wrap, insets 0", "[fill]", "[]0[]");
		panel = new JPanel();
		panel.setBackground(new Color(252,252,252));

		scrollPane = new JScrollPane(panel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBar(new ScrollBarMainCustomer());
		scrollPane.setOpaque(true);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.setViewportBorder(null);
		scrollPane.setBackground(new Color(252,252,252));

		panel.setLayout(layout);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(5)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE).addContainerGap()));
		setLayout(groupLayout);
	}

	public void initFilterItem() {
		init();

		Vector<String> sizes = new Vector<String>();
		for (ModelProductSize data : datasSize) {
			sizes.add(data.getNameSize());
		}
		addMenuFilter(new ModelFilter("Size", 0, sizes.toArray(new String[0])));

		Vector<String> colors = new Vector<String>();
		for (ModelProductColor data : datasColor) {
			colors.add(data.getNameColor());
		}
		addMenuFilter(new ModelFilter("Màu Sắc", 1, colors.toArray(new String[0])));
		
		Vector<String> materials = new Vector<String>();
		for (ModelProductMaterial data : datasMaterial) {
			materials.add(data.getNameMeterial());
		}
		addMenuFilter(new ModelFilter("Chất Liệu", 2, materials.toArray(new String[0])));
		
		addMenuFilter(new ModelFilter("Giá", 3));
		rangeSlider = new RangeSlider();
		
		rangeSlider.setMinimum(0);
		rangeSlider.setMaximum(1000000);
		rangeSlider.setValue(0);
		rangeSlider.setUpperValue(1000000);
		
		panelDistant = new PanelDistantPrice();
		panelDistant.lblFirstPrice.setText(rangeSlider.getValue()+"");
		panelDistant.lblLastPrice.setText(rangeSlider.getUpperValue()+"");
		
		panel.add(rangeSlider, "wrap,w 140!");
		panel.add(panelDistant,"w 150!");
		
	}

	public void addMenuFilter(ModelFilter menu) {
		panel.add(new MenuItemFilter(menu, getEventMenu(), event, panel.getComponentCount()), "h 40!");
	}

	public void init() {
		datasSize = daoSize.SelectAll();
		datasColor = daoColor.SelectAll();
		datasMaterial = daoMaterial.SelectAll();
	}

	public EventMenu getEventMenu() {
		return new EventMenu() {
			@Override
			public boolean menuPressed(Component com, boolean open) {
				if (enable) {
					if (showFilter) {
						if (open) {
							new MenuFilterAnimation(layout, com).openMenu();
						} else {
							new MenuFilterAnimation(layout, com).closeMenu();
						}
						return true;
					} else {
						showPopup.showPopup(com);
					}
				}
				return false;
			}
		};
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(252,252,252));

		g2.fillRect(0, 0, getWidth(), getHeight());

		super.paintComponent(g);
	}

	public MigLayout getLayout() {
		return layout;
	}

	public void setLayout(MigLayout layout) {
		this.layout = layout;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public boolean isShowFilter() {
		return showFilter;
	}

	public void setShowFilter(boolean showFilter) {
		this.showFilter = showFilter;
	}

	public ShowPopup getShowPopup() {
		return showPopup;
	}

	public void setShowPopup(ShowPopup showPopup) {
		this.showPopup = showPopup;
	}

	public EventMenuSelected getEvent() {
		return event;
	}

	public void addEvent(EventMenuSelected event) {
		this.event = event;
	}

}
