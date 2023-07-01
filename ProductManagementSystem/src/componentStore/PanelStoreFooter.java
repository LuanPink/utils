package componentStore;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import color.ColorBackground;
import componentProduct.ButtonProductList;
import componentProduct.IconEditProduct;
import java.awt.Font;

public class PanelStoreFooter extends JPanel {

	private Icon iconPrev = new ImageIcon(ButtonProductList.class.getResource("/icon/arrow-right.png"));
	private Icon iconNext = new ImageIcon(ButtonProductList.class.getResource("/icon/arrow-right.png"));

	private Icon iconPrevBlue = new ImageIcon(ButtonProductList.class.getResource("/icon/arrow-right-blue.png"));
	private Icon iconNextBlue = new ImageIcon(ButtonProductList.class.getResource("/icon/arrow-right-blue.png"));
	public static IconEditProduct btnPrev;
	public static IconEditProduct btnNext;
	public static JLabel lblIndex;

	public PanelStoreFooter() {
		setOpaque(false);

	}
	
	
}
