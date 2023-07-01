package componentSignUp;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import animation.TextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import animation.TextPasswordField;
import dao.DAOsignup;
import model.ModelSignupPerson;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.KeyAdapter;

public class PanelSignUp extends JPanel {
	private DAOsignup daOsignup=new DAOsignup();
	private JButton btnSignUpNow;
	private JCheckBox checkBox;
	private TextField txtPhoneNumber;
	private JLabel lblErrorPhone;
	private TextField txtEmail;
	private JLabel lblErrorEmail;
	private JLabel lblErrorPasswordConfirm;
	private TextPasswordField txtPasswordConfirm;
	private JLabel lblErrorPassword;
	private TextPasswordField txtPassword;
	private JLabel lblErrorUsername;
	private TextField txtUsername;
	private JLabel lblSignUp;
	
	public PanelSignUp() {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color(250, 250, 250));
		panel.setBounds(0, 0, 735, 537);
		add(panel);

		txtUsername = new TextField();
		txtUsername.setSelectionColor(new Color(0, 40, 255));
		txtUsername.setForeground(new Color(150, 150, 150));
		txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblErrorUsername = new JLabel("");
		lblErrorUsername.setForeground(new Color(220, 20, 20));
		lblErrorUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtPassword = new TextPasswordField();
		txtPassword.setSelectionColor(new Color(0, 40, 255));
		txtPassword.setForeground(new Color(150, 150, 150));
		txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblErrorPassword = new JLabel("");
		lblErrorPassword.setForeground(new Color(220, 20, 20));
		lblErrorPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtPasswordConfirm = new TextPasswordField();
		txtPasswordConfirm.setSelectionColor(new Color(0, 40, 255));
		txtPasswordConfirm.setForeground(new Color(150, 150, 150));
		txtPasswordConfirm.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblErrorPasswordConfirm = new JLabel("");
		lblErrorPasswordConfirm.setForeground(new Color(220, 20, 20));
		lblErrorPasswordConfirm.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtEmail = new TextField();
		txtEmail.setSelectionColor(new Color(0, 40, 255));
		txtEmail.setForeground(new Color(150, 150, 150));
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblErrorEmail = new JLabel("");
		lblErrorEmail.setForeground(new Color(220, 20, 20));
		lblErrorEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtPhoneNumber = new TextField();
		txtPhoneNumber.setSelectionColor(new Color(0, 40, 255));
		txtPhoneNumber.setForeground(new Color(150, 150, 150));
		txtPhoneNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblErrorPhone = new JLabel("");
		lblErrorPhone.setForeground(new Color(220, 20, 20));
		lblErrorPhone.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		checkBox = new JCheckBox("");
		checkBox.setOpaque(false);
		checkBox.setForeground(new Color(150, 150, 150));
		checkBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		checkBox.setFocusPainted(false);

		btnSignUpNow = new JButton("");
		
		btnSignUpNow.setForeground(new Color(230, 230, 230));
		btnSignUpNow.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnSignUpNow.setFocusPainted(false);
		btnSignUpNow.setBorder(null);
		btnSignUpNow.setBackground(new Color(220, 20, 20));

		lblSignUp = new JLabel("");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		GroupLayout gl_panelVietnamese = new GroupLayout(panel);
		gl_panelVietnamese.setHorizontalGroup(gl_panelVietnamese.createParallelGroup(Alignment.LEADING)
				.addGap(0, 735, Short.MAX_VALUE)
				.addGroup(gl_panelVietnamese.createSequentialGroup().addGroup(gl_panelVietnamese
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelVietnamese.createSequentialGroup().addGap(125)
								.addGroup(gl_panelVietnamese.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtUsername, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 483,
												Short.MAX_VALUE)
										.addComponent(lblErrorUsername, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 483,
												Short.MAX_VALUE)
										.addComponent(lblErrorPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												483, Short.MAX_VALUE)
										.addComponent(txtPasswordConfirm, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												483, Short.MAX_VALUE)
										.addComponent(lblErrorPasswordConfirm, Alignment.LEADING,
												GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
										.addComponent(txtEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 483,
												Short.MAX_VALUE)
										.addComponent(lblErrorEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 483,
												Short.MAX_VALUE)
										.addComponent(txtPhoneNumber, Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
												483, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblErrorPhone, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 483,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(checkBox, Alignment.LEADING).addComponent(btnSignUpNow,
												Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)))
						.addGroup(gl_panelVietnamese.createSequentialGroup().addContainerGap().addComponent(lblSignUp,
								GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_panelVietnamese.setVerticalGroup(gl_panelVietnamese.createParallelGroup(Alignment.LEADING)
				.addGap(0, 537, Short.MAX_VALUE)
				.addGroup(gl_panelVietnamese.createSequentialGroup().addGap(19)
						.addComponent(lblSignUp, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblErrorUsername, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblErrorPassword, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtPasswordConfirm, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblErrorPasswordConfirm, GroupLayout.PREFERRED_SIZE, 20,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblErrorEmail, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtPhoneNumber, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblErrorPhone, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(checkBox).addGap(18)
						.addComponent(btnSignUpNow, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(26, Short.MAX_VALUE)));
		panel.setLayout(gl_panelVietnamese);
	
		if (MainSignUp.language == "VN") {
			setLanguageVietnamese();
			
		} else {
			setLanguageEnglish();
			
		}
		mouseRegister();
		key();
		
	}
	
	
	
	
	
	
	
	
	public void setLanguageVietnamese() {
		lblSignUp.setText("Đăng ký");
		txtUsername.setHint("Tên tài khoản");
		txtPassword.setHint("Mật khẩu");
		txtPasswordConfirm.setHint("Nhập lại mật khẩu");
		txtEmail.setHint("Email");
		txtPhoneNumber.setHint("Số điện thoại");
		checkBox.setText("Tôi đồng ý với Điều khoản Dịch Vụ và Chính Sách Bảo Mật");
		btnSignUpNow.setText("Đăng Ký Ngay");
	}
	public void setLanguageEnglish() {
		lblSignUp.setText("Resgistration");
		txtUsername.setHint("Username");
		txtPassword.setHint("Password");
		txtPasswordConfirm.setHint("Re-enter password");
		txtEmail.setHint("Email");
		txtPhoneNumber.setHint("Phone Number");
		checkBox.setText("I agree to the Term of Service and Privacy Policy");
		btnSignUpNow.setText("Register Now");
	}
	
	public void vietnam() {
		if(lblErrorUsername.getText()!=null) {
			if(lblErrorUsername.getText().equalsIgnoreCase("Please enter your username")){
				lblErrorUsername.setText("Xin nhập tên tài khoản");
			}else if(lblErrorUsername.getText().equalsIgnoreCase("Username must be between 8 and 20 characters in length")){
				lblErrorUsername.setText("Tên tài khoản phải từ 8 đến 20 ký tự");
			}else if(lblErrorUsername.getText().equalsIgnoreCase("Username already taken")){
				lblErrorUsername.setText("Tên tài khoản đã đăng ký");
			}
		}else {
			lblErrorUsername.setText("");
		}
		//
		if(lblErrorPassword.getText()!=null) {
			if(lblErrorPassword.getText().equalsIgnoreCase("Please enter your password")) {
				lblErrorPassword.setText("Xin nhập mật khẩu");
			}else if(lblErrorPassword.getText().equalsIgnoreCase("The password must contain 8 characters")) {
				lblErrorPassword.setText("Mật khẩu phải từ 8 ký tự trở lên");
			}
		}else {
			lblErrorPassword.setText("");
		}
		
		//
		if(lblErrorPasswordConfirm.getText()!=null) {
			if(lblErrorPasswordConfirm.getText().equalsIgnoreCase("Please enter your re-password")) {
				lblErrorPasswordConfirm.setText("Xin nhập lại mật khẩu");
			}else if(lblErrorPasswordConfirm.getText().equalsIgnoreCase("Mismatched password")) {
				lblErrorPasswordConfirm.setText("Mật khẩu không khớp");
			}
		}else {
			lblErrorPasswordConfirm.setText("");
		}
		//
		if(lblErrorEmail.getText()!=null) {
			if(lblErrorEmail.getText().equalsIgnoreCase("Please enter your email")) {
				lblErrorEmail.setText("Xin nhập email");
			}else if(lblErrorEmail.getText().equalsIgnoreCase("Invalid email format")) {
				lblErrorEmail.setText("Sai định dạng email");
			}else if(lblErrorEmail.getText().equalsIgnoreCase("Email is registered")) {
				lblErrorEmail.setText("Email đã đăng ký");
			}
		}else {
			lblErrorEmail.setText("");
		}
		//
		if(lblErrorPhone.getText()!=null) {
			if(lblErrorPhone.getText().equalsIgnoreCase("Please enter your Phonenumber")) {
				lblErrorPhone.setText("Xin nhập số điện thoại");
			}else if(lblErrorPhone.getText().equalsIgnoreCase("Phone number must be 10 digits")) {
				lblErrorPhone.setText("Số điện thoại phải là 10 số");
			}else if(lblErrorPhone.getText().equalsIgnoreCase("Phonenumber is registered")) {
				lblErrorPhone.setText("Số điện thoại đã đăng ký");
			}
		}else {
			lblErrorPhone.setText("");
		}
	}
		
		
		
		
	
	public void English() {
		if(lblErrorUsername.getText()!=null) {
			if(lblErrorUsername.getText().equalsIgnoreCase("Xin nhập tên tài khoản")){
				lblErrorUsername.setText("Please enter your username");
			}else if(lblErrorUsername.getText().equalsIgnoreCase("Tên tài khoản phải từ 8 đến 20 ký tự")){
				lblErrorUsername.setText("Username must be between 8 and 20 characters in length");
			}else if(lblErrorUsername.getText().equalsIgnoreCase("Tên tài khoản đã đăng ký")){
				lblErrorUsername.setText("Username already taken");
			}
		}else {
			lblErrorUsername.setText("");
		}
		//
		if(lblErrorPassword.getText()!=null) {
			if(lblErrorPassword.getText().equalsIgnoreCase("Xin nhập mật khẩu")) {
				lblErrorPassword.setText("Please enter your password");
			}else if(lblErrorPassword.getText().equalsIgnoreCase("Mật khẩu phải từ 8 ký tự trở lên")) {
				lblErrorPassword.setText("The password must contain 8 characters");
			}
		}else {	
			lblErrorPassword.setText("");
		}
		
		//
		if(lblErrorPasswordConfirm.getText()!=null) {
			if(lblErrorPasswordConfirm.getText().equalsIgnoreCase("Xin nhập lại mật khẩu")) {
				lblErrorPasswordConfirm.setText("Please enter your re-password");
			}else if(lblErrorPasswordConfirm.getText().equalsIgnoreCase("Mật khẩu không khớp")) {
				lblErrorPasswordConfirm.setText("Mismatched password");
			}
		}else {
			lblErrorPasswordConfirm.setText("");
		}
		//
		if(lblErrorEmail.getText()!=null) {
			if(lblErrorEmail.getText().equalsIgnoreCase("Xin nhập email")) {
				lblErrorEmail.setText("Please enter your email");
			}else if(lblErrorEmail.getText().equalsIgnoreCase("Sai định dạng email")) {
				lblErrorEmail.setText("Invalid email format");
			}else if(lblErrorEmail.getText().equalsIgnoreCase("Email đã đăng ký")) {
				lblErrorEmail.setText("Email is registered");
			}
		}else {
			lblErrorEmail.setText("");
		}
		//
		if(lblErrorPhone.getText()!=null) {
			if(lblErrorPhone.getText().equalsIgnoreCase("Xin nhập số điện thoại")) {
				lblErrorPhone.setText("Please enter your Phonenumber");
			}else if(lblErrorPhone.getText().equalsIgnoreCase("Số điện thoại phải là 10 số")) {
				lblErrorPhone.setText("Phone number must be 10 digits");
			}else if(lblErrorPhone.getText().equalsIgnoreCase("Số điện thoại đã đăng ký")) {
				lblErrorPhone.setText("Phonenumber is registered");
			}
		}else {
			lblErrorPhone.setText("");
		}
	}
	
	public ModelSignupPerson checktiengviet() {
		ModelSignupPerson person=new ModelSignupPerson();
	
			String tentaikhoan=txtUsername.getText();
			if(tentaikhoan.length()==0) {
				lblErrorUsername.setText("Xin nhập tên tài khoản");
			}else {
				String reg1="[a-zA-Z0-9]{8,20}";
				if(!tentaikhoan.matches(reg1)) {
					lblErrorUsername.setText("Tên tài khoản phải từ 8 đến 20 ký tự");
				}else {
					if(daOsignup.checkID(tentaikhoan)) {
						lblErrorUsername.setText("Tên tài khoản đã đăng ký");
					}else {
						person.setTentaikhoan(tentaikhoan);
						lblErrorUsername.setText(null);
					}
				
				}
			}
			String matkhau=new String(txtPassword.getText());
			if(matkhau.length()==0) {
				
				lblErrorPassword.setText("Xin nhập mật khẩu");
			}else {
				String reg2="[a-zA-Z0-9]{8,}";
				if(!matkhau.matches(reg2)) {
					lblErrorPassword.setText("Mật khẩu phải từ 8 ký tự trở lên");
				}else {
					
					lblErrorPassword.setText(null);
				}
			}
			String nhaplaimatkhau=new String(txtPasswordConfirm.getPassword());
			if(nhaplaimatkhau.length()==0) {
				lblErrorPasswordConfirm.setText("Xin nhập lại mật khẩu");
			}else {
				if(!nhaplaimatkhau.equals(matkhau)) {
					lblErrorPasswordConfirm.setText("Mật khẩu không khớp");
				}else {
					person.setMatkhau(nhaplaimatkhau);
					lblErrorPasswordConfirm.setText(null);
				}
			}
			String email=txtEmail.getText();
			if(email.length()==0) {
				lblErrorEmail.setText("Xin nhập email");
			}else {
				String reg3="[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]{5,}@gmail.com";
				if(!email.matches(reg3)) {
					lblErrorEmail.setText("Sai định dạng email");
				}else {
					if(daOsignup.checkmail(email)) {
						lblErrorEmail.setText("Email đã đăng ký");
					}else {
						person.setEmail(email);
						lblErrorEmail.setText(null);
					}
				}
			}
			String sdt=txtPhoneNumber.getText();
			if(sdt.length()==0) {
				lblErrorPhone.setText("Xin nhập số điện thoại");
			}else {
				String reg4="0\\d{9}";
				if(!sdt.matches(reg4)) {
					lblErrorPhone.setText("Số điện thoại phải là 10 số");
				}else {
					if(daOsignup.checkphone(sdt)) {
						lblErrorPhone.setText("Số điện thoại đã đăng ký");
					}else {
						person.setSdt(sdt);
						lblErrorPhone.setText(null);
					}
				}
			}
			if(person.getTentaikhoan()!=null) {
				if(person.getMatkhau()!=null) {
					if(person.getEmail()!=null) {
						if(person.getSdt()!=null) {
							return person;
						}
					}
				}
			}
			return null;
}		
	

	public ModelSignupPerson checktienganh() {
		ModelSignupPerson person=new ModelSignupPerson();
	
			String tentaikhoan=txtUsername.getText();
			if(tentaikhoan.length()==0) {
				lblErrorUsername.setText("Please enter your username");
			}else {
				String reg1="[a-zA-Z0-9]{8,20}";
				if(!tentaikhoan.matches(reg1)) {
					lblErrorUsername.setText("Username must be between 8 and 20 characters in length");
				}else {
					if(daOsignup.checkID(tentaikhoan)) {
						lblErrorUsername.setText("Username already taken");
					}else {
						person.setTentaikhoan(tentaikhoan);
						lblErrorUsername.setText(null);
					}
				}
			}
		
		
		String matkhau=new String(txtPassword.getText());
		if(matkhau.length()==0) {
			
			lblErrorPassword.setText("Please enter your password");
		}else {
			String reg2="[a-zA-Z0-9]{8,}";
			if(!matkhau.matches(reg2)) {
				lblErrorPassword.setText("The password must contain 8 characters");
			}else {
				
				lblErrorPassword.setText(null);
			}
		}
		String nhaplaimatkhau=new String(txtPasswordConfirm.getText());
		if(nhaplaimatkhau.length()==0) {
			lblErrorPasswordConfirm.setText("Please enter your re-password");
		}else {
			if(!nhaplaimatkhau.equals(matkhau)) {
				lblErrorPasswordConfirm.setText("Mismatched password");
			}else {
				person.setMatkhau(nhaplaimatkhau);
				lblErrorPasswordConfirm.setText(null);
			}
		}
		String email=txtEmail.getText();
		if(email.length()==0) {
			lblErrorEmail.setText("Please enter your email");
		}else {
			String reg3="[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]{5,}@gmail.com";
			if(!email.matches(reg3)) {
				lblErrorEmail.setText("Invalid email format");
			}else {
				if(daOsignup.checkmail(email)) {
					lblErrorEmail.setText("Email is registered");
				}else {
					person.setEmail(email);
					lblErrorEmail.setText(null);
				}
			}
		}
		String sdt=txtPhoneNumber.getText();
		if(sdt.length()==0) {
			lblErrorPhone.setText("Please enter your Phonenumber");
		}else {
			String reg4="0\\d{9}";
			if(!sdt.matches(reg4)) {
				lblErrorPhone.setText("Phone number must be 10 digits");
			}else {
				if(daOsignup.checkphone(sdt)) {
					lblErrorPhone.setText("Phonenumber is registered");
				}else {
					person.setSdt(sdt);
					lblErrorPhone.setText(null);
				}
			}
		}
		if(person.getTentaikhoan()!=null) {
			if(person.getMatkhau()!=null) {
				if(person.getEmail()!=null) {
					if(person.getSdt()!=null) {
						return person;
					}
				}
			}
		}
	
		return null;
	}
	public void Register() {
		if(MainSignUp.language=="VN") {
			if(checkBox.isSelected()) {
				if(checktiengviet() != null) {
					daOsignup.insert(checktiengviet());
					JOptionPane.showMessageDialog(new MainSignUp(),"Đăng ký thành công");
				}
			}
		}else {
			if(checkBox.isSelected()) {
				if(checktienganh()!=null) {
					daOsignup.insert(checktienganh());
					JOptionPane.showMessageDialog(new MainSignUp(),"Register Success");
				}
			}
		}
	}
	
	public void mouseRegister() {
		btnSignUpNow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Register();
			}
		});
	}
	public void key() {
		checkBox.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					if(!checkBox.isSelected()) {
						
					}else {
						Register();
					}
				}	
			}
		});
	}

}
