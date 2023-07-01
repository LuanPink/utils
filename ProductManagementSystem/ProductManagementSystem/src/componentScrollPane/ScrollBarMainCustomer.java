package componentScrollPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JScrollBar;
import javax.swing.UIManager;



public class ScrollBarMainCustomer extends JScrollBar{
	
	public ScrollBarMainCustomer() {
		setUI(new ModelScrollBarUIMainCustomer());
		setPreferredSize(new Dimension(4,8));
		setUnitIncrement(50);
		setOpaque(true);
	}
	
}
