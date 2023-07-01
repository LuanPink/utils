package componentMainCustomer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import componentMainCustomer.Arrow2;
import componentMainCustomer.PanelHome;
import dao.DAOCustomers;
import dao.DAOItemCart;
import model.ModelCustomerList;
import model.ModelItemCart;
import view.MainFormCustomer;

import javax.swing.LayoutStyle.ComponentPlacement;

import componentDialog.DialogQuestion;

import java.awt.Font;

public class ButtonProduct extends JPanel {
	private Color color = Color.decode("#F6F6F6");
	
	ImageIcon heartCustom = new ImageIcon(
			new ImageIcon(PanelHome.class.getResource("/icon/heart-custom.png")).getImage()
					.getScaledInstance(32, 32, Image.SCALE_SMOOTH));
	ImageIcon heartOutline = new ImageIcon(
			new ImageIcon(PanelHome.class.getResource("/icon/heart-outline.png")).getImage()
					.getScaledInstance(32, 32, Image.SCALE_SMOOTH));
	
	ImageIcon shoppingOutline = new ImageIcon(
			new ImageIcon(PanelHome.class.getResource("/icon/shopping-outline.png")).getImage()
					.getScaledInstance(32, 32, Image.SCALE_SMOOTH));
	ArrayList<ModelCustomerList> customerLists = new ArrayList<ModelCustomerList>();
	private JLabel lblNameProduct;
	private JLabel lblPrice;
	private ButtonAddToCard btnAdd;
	private ImageIcon img;
	private String name;
	private String price;
	private String id;
	private DAOCustomers daoCustomers = new DAOCustomers();
	DAOItemCart dao = new DAOItemCart();
	ArrayList<ModelItemCart> datas = new ArrayList<ModelItemCart>();
	
	DialogQuestion question = new DialogQuestion(null);
	public ButtonProduct(ImageIcon image,String id,String name,String price) {
		this.img = image;
		this.name = name;
		this.price = price;
		this.id =id;
		setOpaque(false);
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(image);
		
		lblNameProduct = new JLabel("Áo Sơ Mi Nam Trắng");
		lblNameProduct.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNameProduct.setForeground(Color.decode("#00000"));
		lblNameProduct.setText(name);
		
		lblPrice = new JLabel("350,000 Đ");
		lblPrice.setForeground(new Color(217, 106, 119));
		lblPrice.setFont(new Font("Roboto", Font.BOLD, 16));
		lblPrice.setText(price+" Đ");
		
		ButtonLikeProduct btnLike = new ButtonLikeProduct("Thích",heartOutline.getImage(),heartCustom.getImage());
		
		Arrow2 lblArrow2 = new Arrow2();
		lblArrow2.setColor(Color.decode("#D96A77"));
		
		Arrow lblArrow = new Arrow();
		lblArrow.setColor(Color.decode("#D96A77"));
		
		btnAdd = new ButtonAddToCard("Add To Card",shoppingOutline.getImage());
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblImage, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(lblPrice, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(31, Short.MAX_VALUE)
					.addComponent(lblNameProduct, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnLike, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblArrow, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
				.addComponent(lblArrow2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNameProduct, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPrice)
					.addGap(10)
					.addComponent(lblArrow2, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
						.addComponent(lblArrow, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLike, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		setLayout(groupLayout);
		action();
	}
	
	public void action() {
		btnAdd.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				customerLists = daoCustomers.SelectByEmail(MainFormCustomer.email);
				String customerId = customerLists.get(0).getId();
				
				String productId = id;
				
				int quatity = 1;
				double p = Double.parseDouble(price);
			
				Date now = new Date(System.currentTimeMillis());

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				

				datas = dao.SelectByIdProduct(productId,customerId);
				
				System.out.println(productId);
				
				
				if(datas.size()>0) {
					// update
					int quati = datas.get(0).getQuantity();
					quati++;
					if(dao.update(new ModelItemCart(quati,customerId, productId))>0){
						question.setVisible(true);
						question.setLocationRelativeTo(null);
						question.lblTextMessage.setText("Đã thêm sản phẩm vào giỏ hàng");
					}else {
						System.out.println("UP Fail");
					}
					
					
				}else {
					// insert
					if(dao.insert(new ModelItemCart(null,customerId,null,productId,null,null,null,null,null,null,p,quatity,sdf.format(now)))>0){
						question.setVisible(true);
						question.setLocationRelativeTo(null);
						question.lblTextMessage.setText("Đã thêm sản phẩm vào giỏ hàng");
					}else {
						System.out.println("IN Fail");
					}
					
				}
				
			}
		});
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
