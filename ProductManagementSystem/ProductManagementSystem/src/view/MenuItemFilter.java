package view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import componentMainCustomer.MenuFilterButton;
import componentMainCustomer.MenuFilterItem;
import interfaces.EventMenu;
import interfaces.EventMenuSelected;
import model.ModelFilter;
import net.miginfocom.swing.MigLayout;

public class MenuItemFilter extends JPanel {
	private ModelFilter filter;
	private int index;
	private float alpha;
	private boolean open;
	private EventMenuSelected eventMenuSelected;
	private MenuFilterButton itemFilter;

	public MenuItemFilter(ModelFilter filter, EventMenu event, EventMenuSelected eventMenuSelected, int index) {
		this.filter = filter;
		this.eventMenuSelected = eventMenuSelected;
		this.index = index;
		setOpaque(false);
		setLayout(new MigLayout("wrap, fillx, insets 0", "[fill]", "[fill, 40!]0[fill, 50!]"));

		itemFilter = new MenuFilterButton(filter.getNameFilter(), index);

		itemFilter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (filter.getItem().length > 0) {
					if (event.menuPressed(MenuItemFilter.this, !open)) {
						open = !open;
					}
				}
				eventMenuSelected.menuSelected(index, -1);
			}
		});

		add(itemFilter);
		int subMenuIndex = -1;

		for (String item : filter.getItem()) {
			subMenuIndex++;
			MenuFilterItem button = new MenuFilterItem(item, subMenuIndex);
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					eventMenuSelected.menuSelected(index, button.getIndex());
			
				}
			});

			add(button, "al right, width ::85%");
		}

	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int width = getWidth();
		int heigth = getPreferredSize().height;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(242,242,242));
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g2.fillRect(0, 2, width, 38);
		g2.setComposite(AlphaComposite.SrcOver);
		g2.fillRect(0, 40, width, heigth - 40);
		
		super.paintComponent(g);
	}

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

	
	
}
