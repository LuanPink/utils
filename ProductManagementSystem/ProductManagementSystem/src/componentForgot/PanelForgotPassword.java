package componentForgot;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import animation.TextField;
import componentLogin.MainLogin;

import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class PanelForgotPassword extends JPanel {

	public JButton btnContinue;

	public String language = "";

	private JLabel lblChangePassword;

	private TextField txtUsername;

	private TextField txtPhoneNumber;

	private JLabel lblErrorUsername;

	private JLabel lblErrorPhoneNumber;
	public boolean selectedButtonContinue = false;

	public PanelForgotPassword() {

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

		txtUsername = new TextField();
		txtUsername.setSelectionColor(new Color(0, 40, 255));

		txtUsername.setForeground(new Color(150, 150, 150));
		txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtPhoneNumber = new TextField();
		txtPhoneNumber.setSelectionColor(new Color(0, 40, 255));
		txtPhoneNumber.setForeground(new Color(150, 150, 150));
		txtPhoneNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblErrorUsername = new JLabel("");
		lblErrorUsername.setForeground(new Color(220, 20, 20));
		lblErrorUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblErrorPhoneNumber = new JLabel("");
		lblErrorPhoneNumber.setForeground(new Color(220, 20, 20));
		lblErrorPhoneNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnContinue = new JButton("");
		btnContinue.setForeground(new Color(230, 230, 230));
		btnContinue.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnContinue.setFocusPainted(false);
		btnContinue.setBorder(null);
		btnContinue.setBackground(new Color(220, 20, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
								.addComponent(lblChangePassword, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
								.addComponent(lblErrorUsername, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
								.addComponent(txtPhoneNumber, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
								.addComponent(lblErrorPhoneNumber, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
								.addComponent(btnContinue, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(21)
						.addComponent(lblChangePassword, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblErrorUsername, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtPhoneNumber, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblErrorPhoneNumber, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnContinue, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(33, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		if (MainForgot.language == "VN") {
			setLanguageVietNamese();
		} else {
			setLanguageEnglish();
		}
		action();
	}

	public void setLanguageVietNamese() {
		lblChangePassword.setText("Thay đổi mật khẩu");
		btnContinue.setText("Tiếp Theo");
		txtUsername.setHint("Tên đăng nhập/Email");
		txtPhoneNumber.setHint("Số điện thoại");
	}

	public void setLanguageEnglish() {
		lblChangePassword.setText("Reset password");
		btnContinue.setText("Continue");
		txtUsername.setHint("Username/Email");
		txtPhoneNumber.setHint("Phone Number");
	}
	
	

	public void action() {
		btnContinue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedButtonContinue=true;
				MainForgot.addComponent(new PanelContinueChangePassword());
			}
		});
	}

	public JButton getBtnContinue() {
		return btnContinue;
	}

	public void setBtnContinue(JButton btnContinue) {
		this.btnContinue = btnContinue;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public JLabel getLblChangePassword() {
		return lblChangePassword;
	}

	public void setLblChangePassword(JLabel lblChangePassword) {
		this.lblChangePassword = lblChangePassword;
	}

	public TextField getTxtUsername() {
		return txtUsername;
	}

	public void setTxtUsername(TextField txtUsername) {
		this.txtUsername = txtUsername;
	}

	public TextField getTxtPhoneNumber() {
		return txtPhoneNumber;
	}

	public void setTxtPhoneNumber(TextField txtPhoneNumber) {
		this.txtPhoneNumber = txtPhoneNumber;
	}

	public JLabel getLblErrorUsername() {
		return lblErrorUsername;
	}

	public void setLblErrorUsername(JLabel lblErrorUsername) {
		this.lblErrorUsername = lblErrorUsername;
	}

	public JLabel getLblErrorPhoneNumber() {
		return lblErrorPhoneNumber;
	}

	public void setLblErrorPhoneNumber(JLabel lblErrorPhoneNumber) {
		this.lblErrorPhoneNumber = lblErrorPhoneNumber;
	}

}
