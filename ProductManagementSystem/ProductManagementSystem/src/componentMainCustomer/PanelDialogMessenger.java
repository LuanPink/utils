package componentMainCustomer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import componentProduct.IconEditProduct;
import interfaces.ChatEvent;
import model.ModelMessenger;
import net.miginfocom.swing.MigLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelDialogMessenger extends JPanel {

	private JPanel panel;
	private PanelChat panelChat;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy, hh:mmaa");
	private JLabel lblTitle;
	private JLabel lblLogo;
	ImageIcon logo = new ImageIcon(new ImageIcon(PanelDialogMessenger.class.getResource("/icon/logo-shop.png"))
			.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
	
	ImageIcon image = new ImageIcon(new ImageIcon(PanelDialogMessenger.class.getResource("/icon/ThuHa.jpg"))
			.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
	
	
	private IconEditProduct btnClose;
	private JPanel panelHeader;

	public PanelDialogMessenger() {
		setOpaque(false);

		panel = new JPanel();
		panel.setOpaque(false);

		panelChat = new PanelChat();

		panel.setLayout(new MigLayout("fill"));

		panel.add(panelChat, "push, grow");
		
		panelHeader = new JPanel();
		panelHeader.setOpaque(false);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelHeader, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelHeader, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
		);
		
				lblLogo = new JLabel("");
				lblLogo.setIcon(logo);
		
				lblTitle = new JLabel("FASHION SHOP");
				lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitle.setFont(new Font("Roboto", Font.BOLD, 18));
				lblTitle.setForeground(Color.decode("#93291E"));
		
				btnClose = new IconEditProduct((Icon) null);
				btnClose.setColor(Color.decode("#93291E"));
				btnClose.setIcon(new ImageIcon(PanelDialogMessenger.class.getResource("/icon/close.png")));
		GroupLayout gl_panelHeader = new GroupLayout(panelHeader);
		gl_panelHeader.setHorizontalGroup(
			gl_panelHeader.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelHeader.createSequentialGroup()
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTitle)
					.addPreferredGap(ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
					.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelHeader.setVerticalGroup(
			gl_panelHeader.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelHeader.createSequentialGroup()
					.addComponent(btnClose, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panelHeader.createSequentialGroup()
					.addGroup(gl_panelHeader.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblLogo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelHeader.setLayout(gl_panelHeader);
		setLayout(groupLayout);

		init();
	}

	public void init() {
		panelChat.addEvent(new ChatEvent() {

			@Override
			public void mousePressedSendButton(ActionEvent event) {
				// TODO Auto-generated method stub
				String date = sdf.format(new Date());
				String messenger = panelChat.getTxtMessenger().getText().trim();

				panelChat.addChatBox(new ModelMessenger(image, "Vũ Lee", date, messenger), ChatBox.BoxType.RIGHT);
				panelChat.clearTextAndGrabFocus();
			}

			@Override
			public void mousePressedFileButton(ActionEvent event) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent event) {
				// TODO Auto-generated method stub

			}
		});
		
	}

	public void closeDialog(ActionListener event) {
		btnClose.addActionListener(event);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.decode("#93291E"));
		g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
		g2.setColor(new Color(255, 255, 255));
		g2.fillRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 15, 15);

		super.paintComponent(g);
	}
}
