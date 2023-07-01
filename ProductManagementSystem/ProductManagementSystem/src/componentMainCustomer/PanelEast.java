package componentMainCustomer;

import javax.swing.JPanel;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelEast extends JPanel {


	ImageIcon icon = new ImageIcon(new ImageIcon(PanelEast.class.getResource("/icon/message-custom.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
	private PanelMessenger panel;
	
	DialogMessenger messenger = new DialogMessenger(null);
	
	public PanelEast() {
		setOpaque(false);
		
		panel = new PanelMessenger("Nhắn tin!");
		panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.setFont(new Font("Roboto",Font.BOLD,16));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout
								.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(505, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblMessenger = new JLabel("");
		
				
				lblMessenger.setIcon(icon);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(160, Short.MAX_VALUE)
					.addComponent(lblMessenger))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblMessenger)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		action();
	}
	
	public void action() {
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// show Dialog messenger
				messenger.setVisible(true);
				messenger.setModalityType(ModalityType.APPLICATION_MODAL);
				messenger.setLocationRelativeTo(null);
				
			}
		});
		
		messenger.closeDialog(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				messenger.setVisible(false);
			}
		});
	}
}
