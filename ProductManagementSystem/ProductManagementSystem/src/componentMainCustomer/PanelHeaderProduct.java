package componentMainCustomer;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.DAOProducts;

public class PanelHeaderProduct extends JPanel {
	ImageIcon banner = new ImageIcon(
			new ImageIcon(PanelHome.class.getResource("/icon/banner-home.jpg")).getImage()
					.getScaledInstance(980, 200, Image.SCALE_SMOOTH));
	
	ImageIcon logo = new ImageIcon(
			new ImageIcon(PanelHome.class.getResource("/icon/logo-shop.png")).getImage()
					.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
	
	ImageIcon trouser = new ImageIcon(
			new ImageIcon(PanelHome.class.getResource("/icon/trouser.jpg")).getImage()
					.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
	
	ImageIcon shirt = new ImageIcon(
			new ImageIcon(PanelHome.class.getResource("/icon/shirt.jpg")).getImage()
					.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
	
	ImageIcon shoes = new ImageIcon(
			new ImageIcon(PanelHome.class.getResource("/icon/shoes.jpeg")).getImage()
					.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
	
	ImageIcon seller = new ImageIcon(
			new ImageIcon(PanelHome.class.getResource("/icon/background-black.png")).getImage()
					.getScaledInstance(980, 80, Image.SCALE_SMOOTH));

	private DAOProducts dao = new DAOProducts();
	
	private DottedCircle lblTrouser;

	private DottedCircle lblShirt;

	private DottedCircle lblShoes;

	private ButtonSeller btnShirt;

	private ButtonSeller btnTrouser;

	private ButtonSeller btnShoes;
	
	public PanelHeaderProduct() {
		setOpaque(false);
		
		JLabel lblBanner = new JLabel();
		lblBanner.setIcon(banner);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		
		JLabel lblNewLabel_3 = new JLabel("SAY HELLO");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(217, 106, 119));
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 18));
		
		Arrow2 lblNewLabel = new Arrow2();
		lblNewLabel.setColor(new Color(217, 106, 119));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(logo);
		
		Arrow2 lblNewLabel_2 = new Arrow2();
		lblNewLabel_2.setColor(new Color(217, 106, 119));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 880, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(243)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(192, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 86, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		
		lblTrouser = new DottedCircle(trouser.getImage(), "Quần");
		
		lblShirt = new DottedCircle(shirt.getImage(), "Áo");
		
		lblShoes = new DottedCircle(shoes.getImage(), "Giày");
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 880, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(260)
					.addComponent(lblTrouser, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblShirt, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblShoes, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(131, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 96, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblShirt, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(lblTrouser, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 75, Short.MAX_VALUE)
						.addComponent(lblShoes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		
		JLabel lblNewLabel_3_1 = new JLabel("BEST SELLERS");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(new Color(217, 106, 119));
		lblNewLabel_3_1.setFont(new Font("Roboto", Font.BOLD, 18));
		
		Arrow2 lblNewLabel_7 = new Arrow2();
		lblNewLabel_7.setColor(new Color(217, 106, 119));
		
		JLabel lblNewLabel_1_1 = new JLabel();
		lblNewLabel_1_1.setIcon(logo);
		
		Arrow2 lblNewLabel_2_1 = new Arrow2();
		lblNewLabel_2_1.setColor(new Color(217, 106, 119));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 880, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(243)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_3_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(192, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 86, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		PanelSeller panelSeller = new PanelSeller(seller.getImage());
		
		 btnShirt = new ButtonSeller("Áo");
		
		 btnTrouser = new ButtonSeller("Quần");
		
		 btnShoes = new ButtonSeller("Giày");
		 
		GroupLayout gl_panelSeller = new GroupLayout(panelSeller);
		gl_panelSeller.setHorizontalGroup(
			gl_panelSeller.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelSeller.createSequentialGroup()
					.addContainerGap(185, Short.MAX_VALUE)
					.addComponent(btnShirt, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnTrouser, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnShoes, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addGap(182))
		);
		gl_panelSeller.setVerticalGroup(
			gl_panelSeller.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSeller.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panelSeller.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnShoes, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTrouser, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnShirt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panelSeller.setLayout(gl_panelSeller);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelSeller, GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
						.addComponent(lblBanner, GroupLayout.PREFERRED_SIZE, 926, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblBanner, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelSeller, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		action();
	}
	
	public void action() {
		showFillBodyFormHomeByLabel(lblTrouser);
		showFillBodyFormHomeByLabel(lblShirt);
		showFillBodyFormHomeByLabel(lblShoes);
		
		showFillBodyFormHomeByButton(btnTrouser);	
		showFillBodyFormHomeByButton(btnShirt);
		showFillBodyFormHomeByButton(btnShoes);
	}
	
	public void showFillBodyFormHomeByLabel(DottedCircle label) {
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// show fill body Form Home
				PanelHome.datas = dao.SelectByKeyName(label.getText());
				PanelHome.index = 0;
				PanelHome.fillBodyProduct();	
			}
		});
	}
	
	public void showFillBodyFormHomeByButton(ButtonSeller button) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelHome.datas = dao.SelectByKeyName(button.getText());
				PanelHome.index = 0;
				PanelHome.fillBodyProduct();
			}
		});
	}
	
	
	
}
