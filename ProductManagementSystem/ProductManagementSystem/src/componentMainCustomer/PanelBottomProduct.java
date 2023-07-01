package componentMainCustomer;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextArea;

public class PanelBottomProduct extends JPanel {

	ImageIcon footer = new ImageIcon(
			new ImageIcon(PanelBottomProduct.class.getResource("/icon/backgroundfooter.jpg")).getImage()
					.getScaledInstance(980, 200, Image.SCALE_SMOOTH));
	
	ImageIcon facebook = new ImageIcon(
			new ImageIcon(PanelBottomProduct.class.getResource("/icon/facebook-custom.png")).getImage()
					.getScaledInstance(35, 35, Image.SCALE_SMOOTH));
	
	ImageIcon twitter = new ImageIcon(
			new ImageIcon(PanelBottomProduct.class.getResource("/icon/twitter-custom.png")).getImage()
					.getScaledInstance(35, 35, Image.SCALE_SMOOTH));
	
	ImageIcon insta = new ImageIcon(
			new ImageIcon(PanelBottomProduct.class.getResource("/icon/instagram-custom.png")).getImage()
					.getScaledInstance(35, 35, Image.SCALE_SMOOTH));
	
	ImageIcon google = new ImageIcon(
			new ImageIcon(PanelBottomProduct.class.getResource("/icon/google-plus-custom.png")).getImage()
					.getScaledInstance(35, 35, Image.SCALE_SMOOTH));
	
	ImageIcon map = new ImageIcon(
			new ImageIcon(PanelBottomProduct.class.getResource("/icon/map-marker-custom.png")).getImage()
					.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
	
	ImageIcon contact = new ImageIcon(
			new ImageIcon(PanelBottomProduct.class.getResource("/icon/phone-custom.png")).getImage()
					.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
	
	ImageIcon email = new ImageIcon(
			new ImageIcon(PanelBottomProduct.class.getResource("/icon/email-custom.png")).getImage()
					.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
	
	private Color color = new Color(0,0,0);
	
	public PanelBottomProduct() {
		setOpaque(false);
		
		PanelSeller panelImage = new PanelSeller(footer.getImage());
		
		JPanel panelFooter = new JPanel();
		panelFooter.setOpaque(false);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelFooter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
						.addComponent(panelImage, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelImage, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelFooter, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		
		JLabel lblCuHi = new JLabel("CÂU HỎI?");
		lblCuHi.setForeground(new Color(252, 252, 252));
		lblCuHi.setFont(new Font("Roboto", Font.BOLD, 16));
		
		Label lblNewLabel = new Label("Vận chuyển");
		
		Label lblDchVKhch = new Label("Vận chuyển");
		lblDchVKhch.setText("Dịch vụ khách hàng / FAQ's");
		
		JLabel lblThngTin = new JLabel("THÔNG TIN?");
		lblThngTin.setForeground(new Color(252, 252, 252));
		lblThngTin.setFont(new Font("Roboto", Font.BOLD, 16));
		
		Label lblCuChuynCa = new Label("Vận chuyển");
		lblCuChuynCa.setText("Câu chuyện của chúng ta");
		
		Label lblcBlogCa = new Label("Vận chuyển");
		lblcBlogCa.setText("Đọc Blog của chúng tôi");
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCuHi)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDchVKhch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblThngTin)
						.addComponent(lblCuChuynCa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblcBlogCa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCuHi)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDchVKhch, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblThngTin, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCuChuynCa, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblcBlogCa, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(72, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setOpaque(false);
		
		JLabel lblAbout_1_1 = new JLabel("FASHION SHOP?");
		lblAbout_1_1.setForeground(new Color(252, 252, 252));
		lblAbout_1_1.setFont(new Font("Roboto", Font.BOLD, 16));
		
		Label lblMinPhVn = new Label("Vận chuyển");
		lblMinPhVn.setText("Miễn phí vận chuyển");
		
		Label lblTrHngTrong = new Label("Vận chuyển");
		lblTrHngTrong.setText("Trả hàng trong 30 ngày");
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1.setHorizontalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTrHngTrong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAbout_1_1)
						.addComponent(lblMinPhVn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		gl_panel_1_1.setVerticalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAbout_1_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMinPhVn, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTrHngTrong, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(148, Short.MAX_VALUE))
		);
		panel_1_1.setLayout(gl_panel_1_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setOpaque(false);
		
		JLabel lblAbout_1_2 = new JLabel("LIÊN HỆ PASHION SHOP");
		lblAbout_1_2.setForeground(new Color(252, 252, 252));
		lblAbout_1_2.setFont(new Font("Roboto", Font.BOLD, 16));
		
		JLabel lblMap = new JLabel("");
		lblMap.setIcon(map);
		
		Label lblContactShop = new Label("Vận chuyển");
		lblContactShop.setText("530 Nguyễn Oanh, P17, Q Gò Vấp, TPHCM");
		
		JLabel lblContact = new JLabel("");
		lblContact.setIcon(contact);
		
		JLabel lblEmail = new JLabel("");
		lblEmail.setIcon(email);
		
		Label lblPhoneShop = new Label("Vận chuyển");
		lblPhoneShop.setText("0352843864");
		
		Label lblEmailShop = new Label("Vận chuyển");
		lblEmailShop.setText("fashionshop@gmail.com");
		
		GroupLayout gl_panel_1_2 = new GroupLayout(panel_1_2);
		gl_panel_1_2.setHorizontalGroup(
			gl_panel_1_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1_2.createSequentialGroup()
							.addComponent(lblMap, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblContactShop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblAbout_1_2)
						.addGroup(gl_panel_1_2.createSequentialGroup()
							.addComponent(lblContact, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblPhoneShop, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
						.addGroup(gl_panel_1_2.createSequentialGroup()
							.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblEmailShop, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1_2.setVerticalGroup(
			gl_panel_1_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAbout_1_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblContactShop, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
						.addComponent(lblMap, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblContact, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPhoneShop, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmailShop, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		panel_1_2.setLayout(gl_panel_1_2);
		
		Arrow2 lblNewLabel_1 = new Arrow2();
		lblNewLabel_1.setColor(new Color(217, 106, 119));
		
		Circle lblFacebook = new Circle(facebook.getImage());
		
		Circle lblTwitter = new Circle(twitter.getImage());
		
		Circle lblInsta = new Circle(insta.getImage());
		
		Circle lblGoogle = new Circle(google.getImage());
		
		JLabel lblFashionShop = new JLabel("FASHION SHOP");
		lblFashionShop.setForeground(new Color(217, 106, 119));
		lblFashionShop.setFont(new Font("Roboto", Font.BOLD, 16));
		
		JLabel lblAbout_1 = new JLabel("@ 2023.");
		lblAbout_1.setForeground(new Color(252, 252, 252));
		lblAbout_1.setFont(new Font("Roboto", Font.BOLD, 16));
		
		LabelMenu lblPolicy = new LabelMenu("CHÍNH SÁCH BẢO MẬT");
		lblPolicy.setForeground(new Color(252, 252, 252));
		lblPolicy.setFont(new Font("Roboto", Font.BOLD, 16));
		
		LabelMenu lblContacts = new LabelMenu("LIÊN HỆ");
		lblContacts.setForeground(new Color(252, 252, 252));
		lblContacts.setFont(new Font("Roboto", Font.BOLD, 16));
		
		GroupLayout gl_panelFooter = new GroupLayout(panelFooter);
		gl_panelFooter.setHorizontalGroup(
			gl_panelFooter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelFooter.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_2, GroupLayout.PREFERRED_SIZE, 238, Short.MAX_VALUE))
				.addGroup(gl_panelFooter.createSequentialGroup()
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panelFooter.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFacebook, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblTwitter, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblInsta, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblGoogle, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(680, Short.MAX_VALUE))
				.addGroup(gl_panelFooter.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFashionShop)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAbout_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPolicy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblContacts, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(432, Short.MAX_VALUE))
		);
		gl_panelFooter.setVerticalGroup(
			gl_panelFooter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelFooter.createSequentialGroup()
					.addGroup(gl_panelFooter.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panelFooter.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFacebook, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTwitter, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInsta, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGoogle, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelFooter.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblFashionShop, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(lblAbout_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelFooter.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPolicy, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblContacts, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		JLabel lblAbout = new JLabel("VỀ FASHION SHOP");
		lblAbout.setFont(new Font("Roboto", Font.BOLD, 16));
		lblAbout.setForeground(new Color(252,252,252));
		
		JTextArea txtrFashionShopc = new JTextArea();
		txtrFashionShopc.setOpaque(false);
		txtrFashionShopc.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtrFashionShopc.setLineWrap(true);
		txtrFashionShopc.setWrapStyleWord(true);
		txtrFashionShopc.setText("Fashion Shop được ra mắt nhằm cung cấp cho người dùng trải nghiệm dễ dàng, an toàn và nhanh chống khi mua sắm trực tuyến thông qua hệ thống thanh toán và vận hành vững mạnh.");
		txtrFashionShopc.setForeground(new Color(200,200,200));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtrFashionShopc, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblAbout)
							.addContainerGap(61, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAbout)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtrFashionShopc, GroupLayout.PREFERRED_SIZE, 132, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		panelFooter.setLayout(gl_panelFooter);
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
