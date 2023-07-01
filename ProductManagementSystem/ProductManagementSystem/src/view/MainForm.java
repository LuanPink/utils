package view;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import color.ColorBackground;
import comonentBanhang.PanelDashBoardBanHang;
import componentCreateProduct.PanelSupplier;
import componentCustomers.PanelCustomerlList;
import componentDoanhThu.PanelDashboardDoanhThu;
import componentDoiHang.PanelDashboardHDDH;
import componentEmployee.PanelEmployee;
import componentHDBanHang.PanelDashboardHDBH;
import componentHDDoiHang.PanelDashboardHDDHCT;
import componentHDTraHang.PanelDashboardHDTH;
import componentHeader.DialogNotification;
import componentHeader.DialogNotificationOption;
import componentHeader.DialogProfile;
import componentProduct.PanelCreateProduct;
import componentProduct.PanelDashboard;
import componentProduct.PanelProductDashboard;
import componentScrollPane.ScrollBarMenu;
import componentStore.PanelHomeStore;
import componentTraHang.PanelDashboardTH;
import interfaces.EventMenuSelected;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainForm extends JFrame {
	public static String mode = "Dark";
	private JPanel contentPane;
	private Menu panelMenu;

	private Color colorMain = ColorBackground.colorDark;
	public static PanelBody panelBody;

	private static Point point;

	private static Point currCoords = null;
	private static Point mouseDownCompCoords = null;

	public static int xScreen;
	public static int yScreen;
	
	public static DialogProfile dialogProfile = new DialogProfile(null);
	public static DialogNotification dialogNotification = new DialogNotification(null);
	public static DialogNotificationOption dialogNotificationOption = new DialogNotificationOption(null);

	private PanelHeader panelHeader;
	private PanelNorth panelNorth;
	public static MainForm frame;

	private JPanel panelCenter;
	private JPanel panel;
	public static JScrollPane scrollPane;

	public static int menuIndexSelected;
	public static int subMenuIndexSelected;
	
	Icon iconHomeWhite = new ImageIcon(MainForm.class.getResource("/icon/home-white.png"));
	Icon iconProductWhite = new ImageIcon(MainForm.class.getResource("/icon/diamond-white.png"));
	Icon iconCustomerWhite = new ImageIcon(MainForm.class.getResource("/icon/user-white.png"));
	Icon iconStoreWhite = new ImageIcon(MainForm.class.getResource("/icon/store-white.png"));
	Icon iconIncomeWhite = new ImageIcon(MainForm.class.getResource("/icon/income-white.png"));
	Icon iconCaledarWhite = new ImageIcon(MainForm.class.getResource("/icon/calendar-white.png"));
	Icon iconHelpWhite = new ImageIcon(MainForm.class.getResource("/icon/help-white.png"));
	Icon[] iconModeDark = {iconHomeWhite,iconProductWhite,iconCustomerWhite,iconStoreWhite,iconIncomeWhite,iconCaledarWhite,iconHelpWhite};
	private JButton btnMinimize;
	private JButton btnExit;
	public static String role;
	public static String email;
	
	public MainForm(String email, String role) {
		this.role = role;
		this.email = email;
		setUndecorated(true);
		contentPane = new JPanel();
		setContentPane(contentPane);

		panel = new JPanel();
		panel.setBackground(colorMain);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE));

		panelNorth = new PanelNorth();

		panelCenter = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panelNorth, GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
				.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelCenter, GroupLayout.PREFERRED_SIZE, 569, Short.MAX_VALUE)));
		panelCenter.setLayout(new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0"));

		panelMenu = new Menu();

		panelHeader = new PanelHeader();

		panelBody = new PanelBody();
		scrollPane = new JScrollPane(panelBody);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		scrollPane.setVerticalScrollBar(new ScrollBarMenu());

		scrollPane.setOpaque(true);
		scrollPane.setBorder(null);
		scrollPane.setBackground(colorMain);

		panelCenter.add(panelMenu, "w 265!,spany 2");
		panelCenter.add(panelHeader, "h 80!, wrap");
		panelCenter.add(scrollPane, "w 100%, h 100%");

		btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(MainForm.class.getResource("/icon/close.png")));
		btnExit.setOpaque(false);
		btnExit.setForeground(SystemColor.scrollbar);
		btnExit.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnExit.setFocusPainted(false);
		btnExit.setBorder(null);

		btnMinimize = new JButton("");
		btnMinimize.setIcon(new ImageIcon(MainForm.class.getResource("/icon/minus.png")));
		btnMinimize.setOpaque(false);
		btnMinimize.setForeground(SystemColor.scrollbar);
		btnMinimize.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnMinimize.setFocusPainted(false);
		btnMinimize.setBorder(null);
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(gl_panelNorth.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelNorth.createSequentialGroup().addContainerGap(1104, Short.MAX_VALUE)
						.addComponent(btnMinimize, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)));
		gl_panelNorth.setVerticalGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
						.addGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING)
								.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnMinimize, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelNorth.setLayout(gl_panelNorth);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		pack();
		init();
		actionDialog();
		actionButtonMode();
	}

	public void init() {

		panelMenu.addEvent(new EventMenuSelected() {

			@Override
			public void menuSelected(int menuIndex, int subMenuIndex) {
				System.out.println("MenuIndex: "+menuIndex+" SubMenu: "+subMenuIndex);
				
				if (menuIndex == 0) {
					panelBody.showForm(new PanelDashboard());
				}
				if (menuIndex == 1) {
					if (subMenuIndex == 0) {
						panelBody.showForm(new PanelProductDashboard());
					}
					
					if (subMenuIndex == 2) {
						panelBody.showForm(new componentSupplier.PanelSupplier());
					}
				}

				if (menuIndex == 2) {
					if (subMenuIndex == 1) {
						panelBody.showForm(new PanelDashBoardBanHang());
					}
					
					if (subMenuIndex == 2) {
						panelBody.showForm(new PanelDashboardTH());
					}
					
					if (subMenuIndex == 3) {
						panelBody.showForm(new PanelDashboardHDDH());
					}
					
					if (subMenuIndex == 4) {
						panelBody.showForm(new PanelDashboardHDBH());
					}
					
					if (subMenuIndex == 5) {
					panelBody.showForm(new PanelDashboardHDDH());
					}
					
					if (subMenuIndex == 6) {
						panelBody.showForm( new PanelDashboardHDTH());
					}
					
					if (subMenuIndex == 7) {
						panelBody.showForm( new PanelDashboardHDDHCT());
					}
				}

				if (menuIndex == 3) {
					panelBody.showForm(new PanelHomeStore());
				}
				
				if (menuIndex == 4) {
					if (subMenuIndex == 0) {
						panelBody.showForm(new PanelDashboardDoanhThu());
					}
					
				}
							
				if(menuIndex == 5) {
					if(subMenuIndex ==0) {
						// show form Employee
						panelBody.showForm( new PanelEmployee());
					}
				}
				
				if(menuIndex == 6) {
					if(subMenuIndex ==0) {
						// show form Customer
						panelBody.showForm( new PanelCustomerlList());
					}
				}
				
				
				
				menuIndexSelected = menuIndex;
				subMenuIndexSelected = subMenuIndex;
			}
		});

		
		
		Color color = ColorBackground.colorLight;
		panelMenu.initMenuItem(color,iconModeDark);

	}

	public void actionDialog() {
		dialogNotification.actionButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 1040;
				int y = 135;
				setLocationDialog(x, y);
				setLocationMouseDragged(x, y);
				dialogNotificationOption.setLocation(MainForm.xScreen, MainForm.yScreen);
				dialogNotificationOption.setVisible(true);

			}
		});

		dialogNotificationOption.addActionButtonDelete(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialogNotification.deleteNotification();
			}
		});

		panelHeader.addActionAvatar(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 1) {
					int x = 1060;
					int y = 85;
					setLocationDialog(x, y);
					setLocationMouseDragged(x, y);
					dialogProfile.setLocation(MainForm.xScreen, MainForm.yScreen);
					dialogProfile.setVisible(true);
					dialogNotification.setVisible(false);
					dialogNotificationOption.setVisible(false);				
				} else {
					dialogProfile.setVisible(false);			
				}
			}
		});

		panelHeader.addActionNotification(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 1) {
					int x = 880;
					int y = 85;
					setLocationDialog(x, y);
					setLocationMouseDragged(x, y);
					dialogNotification.setLocation(MainForm.xScreen, MainForm.yScreen);
					dialogNotification.setVisible(true);
					dialogProfile.setVisible(false);
					dialogNotificationOption.setVisible(false);
					
				} else {
					dialogNotification.setVisible(false);
					dialogNotificationOption.setVisible(false);
					
				}
			}
		});

		panelHeader.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dialogProfile.setVisible(false);
				dialogNotification.setVisible(false);
				dialogNotificationOption.setVisible(false);
				
			}
		});

		panelHeader.addActionAddProduct(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelBody.showForm(new PanelCreateProduct());
			}
		});

		panelMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dialogProfile.setVisible(false);
				dialogNotification.setVisible(false);
				dialogNotificationOption.setVisible(false);
			
			}
		});

		panelBody.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dialogProfile.setVisible(false);
				dialogNotification.setVisible(false);
				dialogNotificationOption.setVisible(false);
				
			}
		});

		panelNorth.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseDownCompCoords = e.getPoint();
			}
		});

		panelNorth.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				currCoords = e.getLocationOnScreen();
				setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);

				dialogProfile.setVisible(false);
				dialogNotification.setVisible(false);
				dialogNotificationOption.setVisible(false);
				
			}

		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				point = e.getComponent().getLocationOnScreen();		
				
				scrollPane.getVerticalScrollBar().setValue(0);
			}

		});

	}
	
	public static void setLocationDialog(int x, int y) {
		xScreen = point.x + x;
		yScreen = point.y + y;
	}
	
	public static void setLocationMouseDragged(int x, int y) {
		if(currCoords==null) {
			return;
		}
		xScreen = currCoords.x - mouseDownCompCoords.x + x;
		yScreen  = currCoords.y - mouseDownCompCoords.y + y;
			
	}
	

	public void actionButtonMode() {

		PanelMode.actionButonModeLight(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mode = "Light";
				panel.setBackground(ColorBackground.colorLight);
				panelMenu.setColorMenu(ColorBackground.colorLight);
				panelMenu.scrollPane.setBackground(ColorBackground.colorLight);

				panelBody.setColorBody(ColorBackground.colorGRB240242245);

			}
		});

		PanelMode.actionButonModeDark(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mode = "Dark";
				panel.setBackground(ColorBackground.colorDark);

				panelMenu.setColorMenu(ColorBackground.colorDark);
				panelMenu.scrollPane.setBackground(ColorBackground.colorDark);

				panelBody.setColorBody(ColorBackground.colorGRB000);

			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		

		dialogProfile.action();
		dialogNotification.action();
		dialogNotificationOption.addActionPanelOption();
	}

	public static void setVisible(boolean option, Window setLocation) {
		dialogProfile.setVisible(option);
		frame.setVisible(option);
		frame.setLocationRelativeTo(setLocation);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					frame = new MainForm("","admin");
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
