package componentMainCustomer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import animation.TextField;
import view.MainForm;
import view.MainFormCustomer;

import javax.swing.JTextField;

public class PanelHeader extends JPanel {

	private ImageIcon logo = new ImageIcon(new ImageIcon(PanelHeader.class.getResource("/icon/logo-shop.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
	private TextField textField;
	private JLabel btnCart;
	private ImageIcon iconShoppingWhite = new ImageIcon(PanelHeader.class.getResource("/icon/shoping.png"));
	private ImageIcon iconShoppingPink = new ImageIcon(PanelHeader.class.getResource("/icon/shopping-outline-custom.png"));
	public LabelMenu lblHome;
	public LabelMenu lblMenClothes;
	public LabelMenu lblLadiClothes;
	
	public PanelHeader() {
		setOpaque(false);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(logo);
		
		JLabel lblFashsionShop = new JLabel("FASHSION SHOP");
		lblFashsionShop.setForeground(new Color(252, 252, 252));
		lblFashsionShop.setFont(new Font("Roboto", Font.PLAIN, 24));
		
		btnCart = new JLabel("");
		btnCart.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCart.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCart.setHorizontalAlignment(SwingConstants.CENTER);
		btnCart.setIcon(iconShoppingWhite);
		
		lblHome = new LabelMenu("Trang chủ");
		
		
		 lblMenClothes = new LabelMenu("Thời trang nam");
		
		
		 lblLadiClothes = new LabelMenu("Thời trang nữ");
		
		PanelFind panel_2 = new PanelFind();
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(169)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFashsionShop)
					.addGap(100)
					.addComponent(lblHome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(lblMenClothes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(lblLadiClothes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCart, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(162))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_3)
						.addComponent(lblFashsionShop, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblHome, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
							.addComponent(lblMenClothes, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblLadiClothes, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnCart, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))))
					.addContainerGap())
		);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(PanelHeader.class.getResource("/icon/search.png")));
		
		textField = new TextField();
		textField.setFont(new Font("Roboto", Font.ITALIC, 14));
		textField.setForeground(new Color(147,147,147));
		textField.setBorder(null);
		textField.setHint("Tìm kiếm sản phẩm...");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
				.addComponent(textField, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
		);
		panel_2.setLayout(gl_panel_2);
		panel_1.setLayout(gl_panel_1);
		
		Label lblNewLabel = new Label("Giới thiệu");
		
		Arrow lblNewLabel_1 = new Arrow();
		lblNewLabel_1.setForeground(new Color(252, 252, 252));
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		Label lblTiKhonCa = new Label("Dịch vụ");
		
		Arrow2 lblNewLabel_2 = new Arrow2();
		
		Arrow lblNewLabel_1_1 = new Arrow();
		lblNewLabel_1_1.setForeground(new Color(252, 252, 252));
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		Label lblTrGip = new Label("Trợ giúp");
		
		
		Label lblCit = new Label("Cài đặt");
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel();
		lblNewLabel_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setIcon(new ImageIcon(PanelHeader.class.getResource("/icon/cog-custom.png")));
		lblNewLabel_1_1_1.setForeground(new Color(252, 252, 252));
		lblNewLabel_1_1_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		Arrow lblNewLabel_1_1_2 = new Arrow();
		lblNewLabel_1_1_2.setForeground(new Color(252, 252, 252));
		lblNewLabel_1_1_2.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		Label lblTiKhonCa_1 = new Label("Tài khoản của tôi");
		
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel();
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(PanelHeader.class.getResource("/icon/account-circle-outline-custom.png")));
		lblNewLabel_1_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(new Color(252, 252, 252));
		lblNewLabel_1_1_1_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(167)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblTiKhonCa)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTrGip)
							.addPreferredGap(ComponentPlacement.RELATED, 552, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(lblTiKhonCa_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_1_1_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblCit)))
					.addGap(163))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblTiKhonCa, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTrGip, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCit, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTiKhonCa_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		
		action();
	}
	
	public void action() {
		btnCart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCart.setIcon(iconShoppingPink);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCart.setIcon(iconShoppingWhite);
			}
		});
		
		btnCart.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getClickCount()==1) {
					MainFormCustomer.showForm(new PanelItemCart());
				}
			}
			
		});
		
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gra = new GradientPaint(0, 0, Color.decode("#93291E"), 740, 370, Color.decode("#93291E"));
		g2.setPaint(gra);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
}
