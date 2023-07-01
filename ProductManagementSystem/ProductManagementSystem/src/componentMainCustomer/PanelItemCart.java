package componentMainCustomer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import componentDialog.DialogQuestion;
import componentScrollPane.ScrollBarMainCustomer;
import dao.DAOCustomers;
import dao.DAOHDBH;
import dao.DAOHDBHCT;
import dao.DAOItemCart;
import model.ModelCustomerList;
import model.ModelHDBH;
import model.ModelHDBHCT;
import model.ModelItemCart;
import net.miginfocom.swing.MigLayout;
import view.MainForm;
import view.MainFormCustomer;

public class PanelItemCart extends JPanel {
	private Color color = new Color(245, 245, 245);

	private JPanel panelCart;
	private JPanel header;
	private JPanel body;
	private JPanel bottom;
	public static ArrayList<ModelItemCart> datas = new ArrayList<ModelItemCart>();
	private DAOItemCart dao = new DAOItemCart();
	private DAOCustomers daoCustomers = new DAOCustomers();
	ArrayList<ModelHDBH> hdbhs = new ArrayList<ModelHDBH>();
	private DAOHDBH daohdbh = new  DAOHDBH();
	private DAOHDBHCT daohdbhct = new DAOHDBHCT();
	ArrayList<ModelCustomerList> customerLists = new ArrayList<ModelCustomerList>();
	JScrollPane scrollPane;
	private JPanel panelBody;
	int index = 0;
	int totalPrice = 0;
	private PanelItemCartFooter panelBottom;

	private ItemCart item;
	DialogQuestion question = new DialogQuestion(null);

	ArrayList<ItemCart> buttonItemCart = new ArrayList<ItemCart>();
	private Icon icon = new ImageIcon(ButtonChecked.class.getResource("/icon/check-white.png"));

	public PanelItemCart() {
		setOpaque(false);
		setLayout(new MigLayout("fill"));
		panelCart = new JPanel();
		panelCart.setOpaque(false);
		panelCart.setLayout(new MigLayout("fill, wrap, inset 2", "[fill]", "[fill,100!][fill,50%][shrink 0,::30%]"));

		header = createHeader();

		body = createBody();
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setViewportView(body);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBar(new ScrollBarMainCustomer());
		scrollPane.getViewport().setOpaque(false);
		scrollPane.getVerticalScrollBar().setValue(0);

		bottom = createBottom();

		panelCart.add(header);
		panelCart.add(scrollPane, "h 310!");
		panelCart.add(bottom);

		add(panelCart, "push,grow");
		action();
	}

	public JPanel createHeader() {
		PanelCartHeader panelHeader = new PanelCartHeader();
		return panelHeader;
	}

	public JPanel createBody() {
		panelBody = new JPanel();

		panelBody.setOpaque(false);
		panelBody.setLayout(new MigLayout("fillx"));

		init();
		return panelBody;
	}

	public void init() {
		customerLists = daoCustomers.SelectByEmail(MainFormCustomer.email);
		String MaKH =  customerLists.get(0).getId();
		datas = dao.SelectByName(MaKH);
		fillItemCart();

	}

	public void fillItemCart() {
		for (ModelItemCart data : datas) {
			ImageIcon imageProduct = new ImageIcon(new ImageIcon(PanelHome.class.getResource("/icon/" + data.getImg()))
					.getImage().getScaledInstance(90, 88, Image.SCALE_SMOOTH));
			double price = data.getPrice() + data.getPrice() * Double.parseDouble(data.getVat()) / 100;
			long priceValue = Math.round(price);

			double quantity = data.getQuantity();
			long quantityValue = Math.round(quantity);

			double totalPrice = price * quantity;
			long totalValue = Math.round(totalPrice);

			item = new ItemCart(data.getIdProduct(),data.getSize(),data.getColor(),data.getMaterial(),data.getType(),imageProduct, data.getProductName(), priceValue + "", quantityValue + "",
					totalValue + "", index);
			buttonItemCart.add(item);

			panelBody.add(item, "wrap");

			index++;
		}

	}

	public JPanel createBottom() {
		panelBottom = new PanelItemCartFooter();
		panelBottom.lblQuantityAll.setText(datas.size() + "");


		return panelBottom;

	}

	public void action() {
		panelBottom.btnCheckedAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (ItemCart itemCart : buttonItemCart) {
					if (panelBottom.btnCheckedAll.isSelected()) {
						itemCart.btnChecked.setIndex(2);
						itemCart.btnChecked.setSelected(true);
						String price = itemCart.getLblTotalPrice().getText().replace(" ", "").replace("Đ", "");
						totalPrice += Integer.parseInt(price);
						PanelItemCartFooter.lblTotalPrice.setText(totalPrice + " đ");
						PanelItemCartFooter.lblQuantityProduct.setText(datas.size() + "");
					} else {
						itemCart.btnChecked.setIndex(1);
						totalPrice = 0;
						PanelItemCartFooter.lblTotalPrice.setText(totalPrice + " đ");
						PanelItemCartFooter.lblQuantityProduct.setText("0");
					}
				}

			}
		});

		panelBottom.lblDeleteItemCart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Integer.parseInt(panelBottom.lblQuantityProduct.getText()) < 1) {
					question.setVisible(true);
					question.setLocationRelativeTo(null);
					question.lblTextMessage.setText("Vui lòng chọn sản phẩm");
				} else {
					
				}
			}
		});
		
		PanelItemCartFooter.btnBuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt(panelBottom.lblQuantityProduct.getText()) < 1) {
					question.setVisible(true);
					question.setLocationRelativeTo(null);
					question.lblTextMessage.setText("Vui lòng chọn sản phẩm");
				} else {
					for (ItemCart itemCart : buttonItemCart) {
						if(itemCart.btnChecked.isSelected()) {
							String maSP = itemCart.getMaSP();
							String MaKH = customerLists.get(0).getId();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
							String date = sdf.format(new Date());						
							double total = Double.parseDouble(PanelItemCartFooter.lblTotalPrice.getText().replace(" ", "").replace("đ", ""));
							
							
							int quantity = Integer.parseInt(itemCart.getTxtQuantity().getText());
							int totalPrice = Integer.parseInt(itemCart.getLblTotalPrice().getText().replace(" ", "").replace("Đ", ""));
							
							String size = itemCart.getSizes();
							String color = itemCart.getMauSac();
							String material = itemCart.getMaterial();
							String type = itemCart.getType();
							
							if(daohdbh.insert(new ModelHDBH("", MaKH, "1", date, total))>0) {
								hdbhs = daohdbh.selectTopOne();								
								String MaHDBH = hdbhs.get(0).getMaHDBH();
								
								daohdbhct.insert(new ModelHDBHCT("", MaHDBH, maSP, quantity, totalPrice, size, color, material, type));

								question.setLocationRelativeTo(null);
								question.lblTextMessage.setText("Mua Sản Phẩm Thành Công");
								question.setVisible(true);
							}
						}else {
							
						}
					}
				}
			}
		});
		

	
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(color);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}

}
