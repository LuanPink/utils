package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

import componentMainCustomer.PanelBottomProduct;
import componentMainCustomer.PanelHeader;
import componentMainCustomer.PanelHome;
import componentMainCustomer.PanelWest;
import componentMainCustomer.PanelClothes;
import componentMainCustomer.PanelEast;
import componentScrollPane.ScrollBarMainCustomer;
import componentScrollPane.ScrollBarMenu;
import net.miginfocom.swing.MigLayout;

public class MainFormCustomer extends JFrame {
	private Point point;

	private Point currCoords = null;
	private Point mouseDownCompCoords = null;
	
	private JPanel contentPane;

	private static MainFormCustomer frame;
	private JPanel body;

	private JScrollPane scrollPane;

	private PanelHeader header;

	private PanelHome home;

	private PanelNorth panelNorth;

	private static JPanel panel;
	private String email;
	public MainFormCustomer(String email) {
		this.email = email;
		setUndecorated(true);
		contentPane = new JPanel();

		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#93291E"));

		JPanel panelCenter = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
				.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)));

		PanelWest panelWest = new PanelWest();
		

		PanelEast panelEast = new PanelEast();
		

		JPanel panelBody = new JPanel();
		panelBody.setLayout(new MigLayout("fill, wrap, inset 0", "[fill]", "[fill,0!][fill,100%][shrink 0,::30%]"));

		body = createPanelBody();
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);		
		scrollPane.setViewportView(body);
		
		scrollPane.setVerticalScrollBar(new ScrollBarMainCustomer());
//		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getViewport().setOpaque(false);
		
		panelBody.add(new JPanel());

		panelBody.add(scrollPane);

		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addComponent(panelWest, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelBody, GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelEast, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.TRAILING)
				.addComponent(panelEast, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
				.addComponent(panelBody, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
				.addComponent(panelWest, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
		);
		panelCenter.setLayout(gl_panelCenter);

		panelNorth = new PanelNorth();

		JButton btnMinimize = new JButton("");
		btnMinimize.setIcon(new ImageIcon(MainFormCustomer.class.getResource("/icon/minus.png")));
		btnMinimize.setOpaque(false);
		btnMinimize.setForeground(SystemColor.scrollbar);
		btnMinimize.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnMinimize.setFocusPainted(false);
		btnMinimize.setBorder(null);

		JButton btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(MainFormCustomer.class.getResource("/icon/close.png")));
		btnExit.setOpaque(false);
		btnExit.setForeground(SystemColor.scrollbar);
		btnExit.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnExit.setFocusPainted(false);
		btnExit.setBorder(null);

		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
				gl_panelNorth.createParallelGroup(Alignment.TRAILING).addGap(0, 1360, Short.MAX_VALUE)
						.addGroup(gl_panelNorth.createSequentialGroup().addContainerGap(1260, Short.MAX_VALUE)
								.addComponent(btnMinimize, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)));
		gl_panelNorth.setVerticalGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGap(0, 25, Short.MAX_VALUE)
				.addGroup(gl_panelNorth.createSequentialGroup()
						.addGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING)
								.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnMinimize, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelNorth.setLayout(gl_panelNorth);

		header = new PanelHeader();
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panelNorth, GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
				.addComponent(header, GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(header, GroupLayout.PREFERRED_SIZE, 123, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		pack();
		action();
	}

	public JPanel createPanelBody() {
		panel = new JPanel();
		init();
		return panel;
	}

	public void init() {
		home = new PanelHome();
		showForm(home);
		home.showFormProduct();
		home.footer.add(new PanelBottomProduct());
		
	}
	
	
	public static void showForm(JComponent com) {
		panel.removeAll();
		panel.add(com);
		panel.repaint();
		panel.revalidate();
		
	}
	
	public void action() {
		addWindowListener(new WindowAdapter() {	
			@Override
			public void windowOpened(WindowEvent e) {
				scrollPane.getVerticalScrollBar().setValue(0);
			}
		});
		header.lblHome.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getClickCount()==1) {
					scrollPane.getVerticalScrollBar().setValue(0);
					init();
					
					
				}
			}
			
		});
		
		header.lblMenClothes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane.getVerticalScrollBar().setValue(0);
				PanelClothes menClothes = new PanelClothes("Nam");
				showForm(menClothes);
			}
		});
		
		header.lblLadiClothes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane.getVerticalScrollBar().setValue(0);
				PanelClothes menClothes = new PanelClothes("Nữ");
				showForm(menClothes);
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

			}
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					frame = new MainFormCustomer("");
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
