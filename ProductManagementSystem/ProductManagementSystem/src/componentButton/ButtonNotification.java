package componentButton;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import componentHeader.DialogProfile;
import componentLogin.MainLogin;
import icon.ImageAvatar;
import view.MainForm;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import net.miginfocom.swing.MigLayout;

public class ButtonNotification extends JButton {

	private int indexSelected;
	private Color color1 = new Color(103,118,126);
	private Color color2 = new Color(252,252,252);
	private Color color3 = new Color(17,19,21);
	private Color color4 = new Color(51,56,63);
	
	private Icon icon;
	private String name;
	private String comment;
	private String bieuTuong;
	private String email;
	private String time;
	
	public ButtonNotification(Icon icon,String name,String comment,String bieuTuong, String email,String time,int index) {
		this.icon = icon;
		this.indexSelected = index;
		this.name = name;
		this.comment = comment;
		this.bieuTuong = bieuTuong;
		this.email = email;
		this.time = time;
		setOpaque(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		
		
		setHorizontalAlignment(SwingConstants.LEFT);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		ImageAvatar avatar = new ImageAvatar();
		avatar.setImage(icon);
		
		JLabel lblTime = new JLabel(time);
		lblTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblTime.setForeground(color1);
		lblTime.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(avatar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTime)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(lblTime, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addComponent(avatar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		
		JLabel lblUsername = new JLabel(name);
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setForeground(color2);
		lblUsername.setFont(new Font("Roboto", Font.BOLD, 14));
		
		JLabel lblEmail = new JLabel(email);
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setForeground(color1);
		lblEmail.setFont(new Font("Roboto", Font.BOLD, 14));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lblUsername)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblComment = new JLabel(comment);
		lblComment.setForeground(color1);
		lblComment.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		JLabel lblCommentAbount = new JLabel(bieuTuong);
		lblCommentAbount.setForeground(color2);
		lblCommentAbount.setFont(new Font("Roboto", Font.BOLD, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblComment)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCommentAbount, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblComment, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCommentAbount, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
			
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setOpaque(true);
				setBackground(color4);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setOpaque(false);
			}
		});
		
//		addActionListener(new ActionListener() {		
//			@Override
//			public void actionPerformed(ActionEvent e) {
//						
//	
//			}
//		});
	}
	
	

	public int getIndexSelected() {
		return indexSelected;
	}

	public void setIndexSelected(int indexSelected) {
		this.indexSelected = indexSelected;
	}
}
