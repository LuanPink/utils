package componentMainCustomer;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import componentCreateProduct.ButtonCheckedSizeAndColor;
import componentHeader.ButtonShowAllNotification;
import componentStore.RangeSlider;
import interfaces.EventMenuSelected;

import javax.swing.JScrollPane;
import javax.swing.JButton;

public class PanelWest extends JPanel {

	
	private PanelFilter panelFilter;
	private ButtonShowAllNotification btnApply;
	private ButtonCheckedSizeAndColor btnReset;
	
	private JLabel rangeSliderValue1 = new JLabel();
	private JLabel rangeSliderValue2 = new JLabel();
	public PanelWest() {
		setOpaque(false);
		
		JLabel lblFilter = new JLabel("Lọc");
		lblFilter.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilter.setForeground(new Color(207, 106, 119));
		lblFilter.setFont(new Font("Roboto", Font.BOLD, 18));
		
		panelFilter = new PanelFilter();
		
		btnApply = new ButtonShowAllNotification("Áp dụng");
		
		
		btnReset = new ButtonCheckedSizeAndColor(0);
		btnReset.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnReset.setForeground(new Color(252, 252, 252));
		btnReset.setText("Đặt lại");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFilter, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnApply, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
					.addContainerGap())
				.addComponent(panelFilter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFilter, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(panelFilter, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnApply, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
		);
		setLayout(groupLayout);
				
		init();
	}
	
	public void init() {
		panelFilter.addEvent(new EventMenuSelected() {
			@Override
			public void menuSelected(int menuIndex, int subMenuIndex) {
				System.out.println("Menu: "+menuIndex +"Sub: "+subMenuIndex);
				MenuFilterItem item = new MenuFilterItem("", 0);
				
				if(menuIndex == 0) {
					
				}
			}
		});
		
		panelFilter.initFilterItem();
		action();
	}
	
	public void action() {
		panelFilter.rangeSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				RangeSlider slider = (RangeSlider) e.getSource();
				rangeSliderValue1.setText(String.valueOf(slider.getValue()));
				rangeSliderValue2.setText(String.valueOf(slider.getUpperValue()));
				
				PanelDistantPrice.lblFirstPrice.setText(rangeSliderValue1.getText()+"");
				PanelDistantPrice.lblLastPrice.setText(rangeSliderValue2.getText()+"");
				
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(242,242,242));
		g2.fillRect(0, 0, getWidth(),getHeight());
		super.paintComponent(g);
	}
}
