package componentForgot;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import animation.TextField;

public class PanelContinueChangePassword extends JPanel {

	private static JLabel lblChangePassword;
	private static TextField txtOldPassword;
	private static TextField txtNewPassword;
	private static JLabel lblErrorOldPassword;
	private static JLabel lblErrorNewPassword;
	private static JButton btnChange;
	private static TextField txtConfirmPassword;
	private static JLabel lblErrorConfirmPassword;

	public PanelContinueChangePassword() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 250, 250));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE));

		lblChangePassword = new JLabel("");
		lblChangePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePassword.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		txtOldPassword = new TextField();
		txtOldPassword.setSelectionColor(new Color(0, 40, 255));

		txtOldPassword.setForeground(new Color(150, 150, 150));
		txtOldPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtNewPassword = new TextField();
		txtNewPassword.setSelectionColor(new Color(0, 40, 255));
		txtNewPassword.setForeground(new Color(150, 150, 150));
		txtNewPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblErrorOldPassword = new JLabel("");
		lblErrorOldPassword.setForeground(new Color(220, 20, 20));
		lblErrorOldPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblErrorNewPassword = new JLabel("");
		lblErrorNewPassword.setForeground(new Color(220, 20, 20));
		lblErrorNewPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnChange = new JButton("");
		btnChange.setForeground(new Color(230, 230, 230));
		btnChange.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnChange.setFocusPainted(false);
		btnChange.setBorder(null);
		btnChange.setBackground(new Color(220, 20, 20));

		txtConfirmPassword = new TextField();
		txtConfirmPassword.setSelectionColor(new Color(0, 40, 255));
		txtConfirmPassword.setForeground(new Color(150, 150, 150));
		txtConfirmPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblErrorConfirmPassword = new JLabel("");
		lblErrorConfirmPassword.setForeground(new Color(220, 20, 20));
		lblErrorConfirmPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtOldPassword, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
								.addComponent(lblErrorOldPassword, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
								.addComponent(txtNewPassword, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
								.addComponent(lblErrorNewPassword, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
								.addComponent(btnChange, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
								.addComponent(txtConfirmPassword, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 430,
										Short.MAX_VALUE)
								.addComponent(lblErrorConfirmPassword, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
										430, Short.MAX_VALUE)
								.addComponent(lblChangePassword, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 430,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(21)
				.addComponent(lblChangePassword, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(txtOldPassword, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblErrorOldPassword, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(txtNewPassword, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(lblErrorNewPassword, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtConfirmPassword, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(lblErrorConfirmPassword, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
				.addComponent(btnChange, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		if (MainForgot.language == "VN") {
			setLanguageVietNamese();
		} else {
			setLanguageEnglish();
		}

	}

	public static void setLanguageVietNamese() {
		lblChangePassword.setText("Thay đổi mật khẩu");
		txtOldPassword.setHint("Nhập mật khẩu cũ");
		txtNewPassword.setHint("Nhập mật khẩu mới");
		txtConfirmPassword.setHint("Xác nhận mật khẩu mới");
		btnChange.setText("Thay đổi");
	}

	public static void setLanguageEnglish() {
		lblChangePassword.setText("Change Password");
		txtOldPassword.setHint("Enter old password");
		txtNewPassword.setHint("Enter new password");
		txtConfirmPassword.setHint("Confirm new password");
		btnChange.setText("Change");
	}
	

	
	
}
