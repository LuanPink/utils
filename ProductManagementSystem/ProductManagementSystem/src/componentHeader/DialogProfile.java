package componentHeader;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import color.ColorBackground;
import componentButton.Button;
import componentButton.ButtonProfile;
import componentSetting.PanelSetting;
import componentSetting.PanelSettingProfile;
import view.MainForm;
import view.PanelMode;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class DialogProfile extends JDialog {

	private Color color1 = new Color(78, 79, 81);
	private ButtonProfile btnLogout;
	private ButtonProfile btnSetting;
	private ButtonProfile btnCalendar;
	private ButtonProfile btnEditProfile;
	private ButtonProfile btnProfile;
	private PanelDialogProfile panelDialog;

	public DialogProfile(JFrame parent) {
		super(parent, false);
		setUndecorated(true);
		init();
		setBackground(new Color(17, 19, 21, 0));
		setPreferredSize(new Dimension(300, 420));
		pack();
	}

	public void init() {
		panelDialog = new PanelDialogProfile();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panelDialog, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(18, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panelDialog, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE).addContainerGap()));

		btnProfile = new ButtonProfile(1);
		btnProfile.setBorder(null);
		btnProfile.setFont(new Font("Roboto", Font.BOLD, 17));
		btnProfile.setHorizontalAlignment(SwingConstants.LEFT);
		btnProfile.setForeground(color1);
		btnProfile.setText("Hồ sơ");

		btnEditProfile = new ButtonProfile(2);
		btnEditProfile.setText("Chỉnh sửa hồ sơ");
		btnEditProfile.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditProfile.setForeground(color1);
		btnEditProfile.setFont(new Font("Roboto", Font.BOLD, 17));
		btnEditProfile.setBorder(null);

		JLabel lbl1 = new JLabel("___________________________________");
		lbl1.setForeground(color1);

		btnCalendar = new ButtonProfile(3);
		btnCalendar.setText("Calendar");
		btnCalendar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCalendar.setForeground(color1);
		btnCalendar.setFont(new Font("Roboto", Font.BOLD, 17));
		btnCalendar.setBorder(null);

		btnSetting = new ButtonProfile(4);
		btnSetting.setText("Cài đặt tài khoản");
		btnSetting.setHorizontalAlignment(SwingConstants.LEFT);
		btnSetting.setForeground(color1);
		btnSetting.setFont(new Font("Roboto", Font.BOLD, 17));
		btnSetting.setBorder(null);

		btnLogout = new ButtonProfile(5);
		btnLogout.setText("Đăng Xuất");
		btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogout.setForeground(color1);
		btnLogout.setFont(new Font("Roboto", Font.BOLD, 17));
		btnLogout.setBorder(null);
		GroupLayout gl_panelDialog = new GroupLayout(panelDialog);
		gl_panelDialog.setHorizontalGroup(gl_panelDialog.createParallelGroup(Alignment.TRAILING).addGroup(gl_panelDialog
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panelDialog.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCalendar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
						.addComponent(btnSetting, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
						.addComponent(btnLogout, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
						.addComponent(btnProfile, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
						.addComponent(btnEditProfile, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 258,
								Short.MAX_VALUE)
						.addComponent(lbl1, GroupLayout.PREFERRED_SIZE, 252, Short.MAX_VALUE))
				.addContainerGap()));
		gl_panelDialog.setVerticalGroup(gl_panelDialog.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDialog.createSequentialGroup().addGap(45)
						.addComponent(btnProfile, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(btnEditProfile, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(lbl1).addGap(30)
						.addComponent(btnCalendar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnSetting, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(37, Short.MAX_VALUE)));
		panelDialog.setLayout(gl_panelDialog);
		getContentPane().setLayout(groupLayout);
		
	}

	public void action() {
		PanelMode.actionButonModeDark(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				panelDialog.setColor1(ColorBackground.colorGRB394348);
				panelDialog.setColor2(ColorBackground.colorGRB171921);
				
				
			}
		});

		PanelMode.actionButonModeLight(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelDialog.setColor1(ColorBackground.colorGRB181228202);
				panelDialog.setColor2(ColorBackground.colorLight);
				
			}
		});
		
		btnSetting.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainForm.panelBody.showForm(new PanelSettingProfile());
				
			}
		});
	}
}
