package componentMainCustomer;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import componentDialog.DialogQuestion;

import java.awt.Cursor;

public class PanelItemCartFooter extends JPanel {
	private Color color = new Color(255,255,252);
	public static ButtonBuy btnBuy;
	public static JLabel lblQuantityProduct;
	public static JLabel lblTotalPrice;
	private JLabel lblTotal_1;
	public static JLabel lblQuantityAll;
	private JLabel lblQuantityProduct_2;
	public JLabel lblDeleteItemCart;
	public static ButtonChecked btnCheckedAll;
	
	public PanelItemCartFooter() {
		setOpaque(false);
		
		JLabel lblTotal = new JLabel("Tổng thanh toán (");
		lblTotal.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		btnBuy = new ButtonBuy("Mua Hàng");
		
		lblQuantityProduct = new JLabel("0");
		lblQuantityProduct.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		lblTotalPrice = new JLabel("0 đ");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalPrice.setForeground(new Color(207, 106, 119));
		lblTotalPrice.setFont(new Font("Roboto", Font.PLAIN, 20));
		
		JLabel lblSnPhm = new JLabel("sản phẩm  )");
		lblSnPhm.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		lblTotal_1 = new JLabel("Chọn tất cả (");
		lblTotal_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		btnCheckedAll = new ButtonChecked();
		
		lblQuantityAll = new JLabel("0");
		lblQuantityAll.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		lblQuantityProduct_2 = new JLabel(")");
		lblQuantityProduct_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		lblDeleteItemCart = new JLabel("Xóa");
		lblDeleteItemCart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDeleteItemCart.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnCheckedAll, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblTotal_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblQuantityAll)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblQuantityProduct_2, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDeleteItemCart)
					.addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
					.addComponent(lblTotal)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblQuantityProduct)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSnPhm)
					.addGap(18)
					.addComponent(lblTotalPrice, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnBuy, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBuy, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTotalPrice, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSnPhm, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblQuantityProduct, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTotal_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblQuantityAll, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblQuantityProduct_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDeleteItemCart, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(btnCheckedAll, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
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
