package componentCustomers;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import color.ColorBackground;
import componentButton.ButtonNotification;
import componentHeader.DialogNotification;
import componentScrollPane.ScrollBarMenu;
import componentsCurve.DatabaseConnection;
import dao.DAOCustomers;
import model.ModelCustomerList;
import model.ModelMessage;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;
import view.PanelHeader;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.lang.Math;

public class PanelTableCustomer extends JPanel {

	private MigLayout layout;
	private PanelCustomerHeader panelHeader;
	private JPanel body;
	private JPanel bottom;
	private JPanel panel;
	private JPanel panelBody;
	private Color color = new Color(252,252,232);
	private int countCustomers = -1;
	private ArrayList<ModelCustomerList> datas = new ArrayList<ModelCustomerList>();
	private DAOCustomers dao = new DAOCustomers();
	private Color colorCustomers = ColorBackground.colorDark;
	
	
	private JLabel lblCustomerList;


	public PanelTableCustomer() {
		setOpaque(false);
		setLayout(new MigLayout("fill"));
		panel = new JPanel();
		
		panel.setOpaque(false);
		
		layout = new MigLayout("fill,wrap,inset 2", "[fill]", "[150!,fill][fill,100%][::60%,shrink 0]");
		panel.setLayout(layout);
		
		panelHeader = new PanelCustomerHeader();
		
		body = createPanelBody();
		
		JScrollPane scrollPane = new JScrollPane(body);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setVerticalScrollBar(new ScrollBarMenu());
		
		panel.add(panelHeader);
		panel.add(scrollPane);
		
		

		add(panel, "push,grow");
	}
	
	public JPanel createPanelBody() {
		panelBody = new JPanel();
		panelBody.setOpaque(false);
		panelBody.setLayout(new MigLayout("wrap,fillx"));
		panelBody.setBorder(null);
		initData();
		
		return panelBody ;
		
	}
	

	
	public void initData() {
		datas = dao.SelectAll();
		countCustomers = datas.size();
		fillPanelBody();
		searchCustomers();
	}

	public void fillPanelBody() {
		panelBody.removeAll();
		panelBody.repaint();
		panelBody.revalidate();
		
		for (ModelCustomerList data : datas) {
			double total =data.getTotalMonney();
			long roundValue = Math.round(total);
			String avatar = data.getImage();
			if(avatar.equals("")) {
				if(data.isGender()) {
					avatar = "avatar-male.png";
					
				}else {
					avatar = "avatar-female.png";
				}
			}
			
			ImageIcon image = new ImageIcon(new ImageIcon(PanelTableCustomer.class.getResource("/icon/"+avatar)).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
			
			ButtonCustomerList button = new ButtonCustomerList(image,
			data.getName(),data.getEmail(),data.getPhone(),data.getBuys(),roundValue+"",data.getComment()+"",data.getLikes()+"");
			button.setBorder(null);
			button.setFont(new Font("Roboto", Font.BOLD, 17));
			button.setHorizontalAlignment(SwingConstants.LEFT);
			panelBody.add(button, "wrap,h 100!");
			
		}
		
	}
	
	
	public void searchCustomers() {
		panelHeader.addCaretListenerTextField(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent e) {
				String result = panelHeader.getTxtSearch().getText();
				if(result.equals("")) {
					datas = dao.SelectAll();
					fillPanelBody();
				}else {
					datas = dao.SelectByName(result);
					fillPanelBody();
				}
				
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(colorCustomers);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(),25,25);
		super.paintComponent(g);
	}

	public Color getColorCustomers() {
		return colorCustomers;
	}

	public void setColorCustomers(Color colorCustomers) {
		this.colorCustomers = colorCustomers;
	}
	
	
}
