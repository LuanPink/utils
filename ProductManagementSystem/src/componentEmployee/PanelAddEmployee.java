package componentEmployee;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;

import componentCreateProduct.ButtonCheckedSizeAndColor;
import componentCreateProduct.PanelTitle;
import componentDialog.DialogQuestion;
import componentMainCustomer.DialogMessenger;
import dao.DAOEmployee;
import model.ModelEmployee;
import view.MainForm;
import view.PanelMode;
import animation.TextField;
import color.ColorBackground;

import java.awt.Color;
import java.awt.Container;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class PanelAddEmployee extends JPanel {
	Color color1 = ColorBackground.colorDark;
	Color color2 = new Color(207, 106, 119);
	private DAOEmployee dao = new DAOEmployee();
	private JRadioButton rdbtnEmployee;
	private JRadioButton rdbtnManager;
	private JLabel lblCV;
	private JLabel lblTitle;
	private PanelTitle panelName;
	private TextField txtName;
	private TextField txtEmail;
	private JLabel lblErrorName;
	private PanelTitle panelEmail;
	private TextField txtPhone;
	private JLabel lblErrorEmail;
	private PanelTitle panelPhone;
	private TextField txtSalary;
	private PanelTitle panelSalary;
	private JLabel lblErrorPhone;
	private TextField txtUsername;
	private JLabel lblErrorSalary;
	private PanelTitle panelUser;
	public static TextField txtDate;
	private PanelTitle panelDate;
	private JLabel lblErrorUsername;
	private PanelTitle panelAddress;
	private JTextArea txtAddRess;
	private JLabel lblAddress;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnMale;
	private JLabel lblGender;
	private JLabel lblErrorAddress;
	private JLabel lblErrorDate;
	private TextField txtPassword;
	private JLabel lblErrorGender;
	private PanelTitle panelPassword;
	private ButtonGroup buttonGroup;
	private JLabel lblErrorPassword;
	private ButtonGroup btnGpRole;
	private ButtonCheckedSizeAndColor btnNew;
	private ButtonCheckedSizeAndColor btnAdd;
	private ButtonCheckedSizeAndColor btnEdit;
	public static ButtonCheckedSizeAndColor btnCancel = new ButtonCheckedSizeAndColor(0);
	private ModelEmployee employee;
	private String ID_EMPLOYEE;
	private DialogQuestion question = new DialogQuestion(null);
	private DialogCalenderEmployee calendar = new DialogCalenderEmployee(null);
	String pattern = "\\w{2,}@\\w{2,}(\\.[a-zA-z]{2,3}){1,2}";
	String regexPhone = "^0\\d{9}$";
	private ButtonCheckedSizeAndColor btnCalendar;
	private JLabel lblErrorRole;

	public PanelAddEmployee(ModelEmployee employee) {
		setOpaque(false);
		this.employee = employee;
		lblTitle = new JLabel("Thêm Nhân Viên");
		lblTitle.setFont(new Font("Roboto", Font.BOLD, 18));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(ColorBackground.colorLight);

		panelName = new PanelTitle();

		txtName = new TextField();
		txtName.setHint("Tên nhân viên");
		txtName.setForeground(new Color(252, 252, 252));
		txtName.setFont(new Font("Roboto", Font.ITALIC, 12));
		txtName.setCaretColor(new Color(252, 252, 252));
		txtName.setBorder(null);
		GroupLayout gl_panelName = new GroupLayout(panelName);
		gl_panelName.setHorizontalGroup(gl_panelName.createParallelGroup(Alignment.LEADING)
				.addGap(0, 216, Short.MAX_VALUE).addGroup(gl_panelName.createSequentialGroup().addContainerGap()
						.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)));
		gl_panelName.setVerticalGroup(gl_panelName.createParallelGroup(Alignment.LEADING).addGap(0, 28, Short.MAX_VALUE)
				.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE));
		panelName.setLayout(gl_panelName);

		lblErrorName = new JLabel("");
		lblErrorName.setFont(new Font("Roboto", Font.ITALIC, 12));
		lblErrorName.setForeground(new Color(207, 106, 119));

		panelEmail = new PanelTitle();

		txtEmail = new TextField();
		txtEmail.setHint("Email");
		txtEmail.setForeground(new Color(252, 252, 252));
		txtEmail.setFont(new Font("Roboto", Font.ITALIC, 12));
		txtEmail.setCaretColor(new Color(252, 252, 252));
		txtEmail.setBorder(null);
		GroupLayout gl_panelEmail = new GroupLayout(panelEmail);
		gl_panelEmail.setHorizontalGroup(gl_panelEmail.createParallelGroup(Alignment.LEADING)
				.addGap(0, 216, Short.MAX_VALUE).addGap(0, 216, Short.MAX_VALUE)
				.addGroup(gl_panelEmail.createSequentialGroup().addContainerGap().addComponent(txtEmail,
						GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)));
		gl_panelEmail.setVerticalGroup(gl_panelEmail.createParallelGroup(Alignment.LEADING)
				.addGap(0, 28, Short.MAX_VALUE).addGap(0, 28, Short.MAX_VALUE)
				.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE));
		panelEmail.setLayout(gl_panelEmail);

		lblErrorEmail = new JLabel("");
		lblErrorEmail.setForeground(new Color(207, 106, 119));
		lblErrorEmail.setFont(new Font("Roboto", Font.ITALIC, 12));

		panelPhone = new PanelTitle();

		txtPhone = new TextField();
		txtPhone.setHint("Số điện thoại");
		txtPhone.setForeground(new Color(252, 252, 252));
		txtPhone.setFont(new Font("Roboto", Font.ITALIC, 12));
		txtPhone.setCaretColor(new Color(252, 252, 252));
		txtPhone.setBorder(null);
		GroupLayout gl_panelPhone = new GroupLayout(panelPhone);
		gl_panelPhone.setHorizontalGroup(gl_panelPhone.createParallelGroup(Alignment.LEADING)
				.addGap(0, 216, Short.MAX_VALUE).addGap(0, 216, Short.MAX_VALUE)
				.addGroup(gl_panelPhone.createSequentialGroup().addContainerGap().addComponent(txtPhone,
						GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)));
		gl_panelPhone.setVerticalGroup(gl_panelPhone.createParallelGroup(Alignment.LEADING)
				.addGap(0, 28, Short.MAX_VALUE).addGap(0, 28, Short.MAX_VALUE)
				.addComponent(txtPhone, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE));
		panelPhone.setLayout(gl_panelPhone);

		lblErrorPhone = new JLabel("");
		lblErrorPhone.setForeground(new Color(207, 106, 119));
		lblErrorPhone.setFont(new Font("Roboto", Font.ITALIC, 12));

		panelSalary = new PanelTitle();

		txtSalary = new TextField();
		txtSalary.setHint("Lương");
		txtSalary.setForeground(new Color(252, 252, 252));
		txtSalary.setFont(new Font("Roboto", Font.ITALIC, 12));
		txtSalary.setCaretColor(new Color(252, 252, 252));
		txtSalary.setBorder(null);
		GroupLayout gl_panelSalary = new GroupLayout(panelSalary);
		gl_panelSalary.setHorizontalGroup(gl_panelSalary.createParallelGroup(Alignment.LEADING)
				.addGap(0, 216, Short.MAX_VALUE).addGap(0, 216, Short.MAX_VALUE).addGap(0, 216, Short.MAX_VALUE)
				.addGroup(gl_panelSalary.createSequentialGroup().addContainerGap().addComponent(txtSalary,
						GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)));
		gl_panelSalary.setVerticalGroup(gl_panelSalary.createParallelGroup(Alignment.LEADING)
				.addGap(0, 28, Short.MAX_VALUE).addGap(0, 28, Short.MAX_VALUE).addGap(0, 28, Short.MAX_VALUE)
				.addComponent(txtSalary, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE));
		panelSalary.setLayout(gl_panelSalary);

		lblErrorSalary = new JLabel("");
		lblErrorSalary.setForeground(new Color(207, 106, 119));
		lblErrorSalary.setFont(new Font("Roboto", Font.ITALIC, 12));

		panelUser = new PanelTitle();

		txtUsername = new TextField();
		txtUsername.setHint("Tên tài khoản");
		txtUsername.setForeground(new Color(252, 252, 252));
		txtUsername.setFont(new Font("Roboto", Font.ITALIC, 12));
		txtUsername.setCaretColor(new Color(252, 252, 252));
		txtUsername.setBorder(null);
		GroupLayout gl_panelUser = new GroupLayout(panelUser);
		gl_panelUser.setHorizontalGroup(gl_panelUser.createParallelGroup(Alignment.LEADING)
				.addGap(0, 216, Short.MAX_VALUE).addGap(0, 216, Short.MAX_VALUE).addGap(0, 216, Short.MAX_VALUE)
				.addGap(0, 216, Short.MAX_VALUE).addGroup(gl_panelUser.createSequentialGroup().addContainerGap()
						.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)));
		gl_panelUser.setVerticalGroup(gl_panelUser.createParallelGroup(Alignment.LEADING).addGap(0, 28, Short.MAX_VALUE)
				.addGap(0, 28, Short.MAX_VALUE).addGap(0, 28, Short.MAX_VALUE).addGap(0, 28, Short.MAX_VALUE)
				.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE));
		panelUser.setLayout(gl_panelUser);

		lblErrorUsername = new JLabel("");
		lblErrorUsername.setForeground(new Color(207, 106, 119));
		lblErrorUsername.setFont(new Font("Roboto", Font.ITALIC, 12));

		panelDate = new PanelTitle();

		txtDate = new TextField();
		txtDate.setHint("Ngày sinh");
		txtDate.setForeground(new Color(252, 252, 252));
		txtDate.setFont(new Font("Roboto", Font.ITALIC, 12));
		txtDate.setCaretColor(new Color(252, 252, 252));
		txtDate.setBorder(null);
		txtDate.setFocusable(false);

		btnCalendar = new ButtonCheckedSizeAndColor(0);
		btnCalendar.setIcon(new ImageIcon(PanelAddEmployee.class.getResource("/icon/calendar-white.png")));
		btnCalendar.setForeground(new Color(252, 252, 252));
		btnCalendar.setFont(new Font("Roboto", Font.PLAIN, 14));
		GroupLayout gl_panelDate = new GroupLayout(panelDate);
		gl_panelDate.setHorizontalGroup(gl_panelDate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDate.createSequentialGroup().addContainerGap()
						.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnCalendar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panelDate
				.setVerticalGroup(gl_panelDate.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING,
								gl_panelDate.createSequentialGroup()
										.addComponent(btnCalendar, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)
										.addGap(11))
						.addGroup(gl_panelDate.createSequentialGroup()
								.addComponent(txtDate, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
								.addContainerGap()));
		panelDate.setLayout(gl_panelDate);

		panelAddress = new PanelTitle();

		txtAddRess = new JTextArea();
		txtAddRess.setWrapStyleWord(true);
		txtAddRess.setOpaque(false);
		txtAddRess.setLineWrap(true);
		txtAddRess.setForeground(new Color(252, 252, 252));
		txtAddRess.setFont(new Font("Roboto", Font.ITALIC, 11));
		txtAddRess.setCaretColor(new Color(252, 252, 252));
		txtAddRess.setBorder(null);

		lblAddress = new JLabel("Địa chỉ");
		lblAddress.setForeground(new Color(252, 252, 252));
		lblAddress.setFont(new Font("Roboto", Font.ITALIC, 12));
		GroupLayout gl_panelAddress = new GroupLayout(panelAddress);
		gl_panelAddress.setHorizontalGroup(gl_panelAddress.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelAddress.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelAddress.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAddress, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 246,
										Short.MAX_VALUE)
								.addComponent(txtAddRess, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 246,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_panelAddress
				.setVerticalGroup(gl_panelAddress.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_panelAddress.createSequentialGroup().addContainerGap().addComponent(lblAddress)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtAddRess, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		panelAddress.setLayout(gl_panelAddress);

		lblErrorDate = new JLabel("");
		lblErrorDate.setForeground(new Color(207, 106, 119));
		lblErrorDate.setFont(new Font("Roboto", Font.ITALIC, 12));

		lblErrorAddress = new JLabel("");
		lblErrorAddress.setForeground(new Color(207, 106, 119));
		lblErrorAddress.setFont(new Font("Roboto", Font.ITALIC, 12));

		lblGender = new JLabel("Giới tính");
		lblGender.setForeground(new Color(252, 252, 252));
		lblGender.setFont(new Font("Roboto", Font.ITALIC, 12));

		rdbtnMale = new JRadioButton("Nam");
		rdbtnMale.setOpaque(false);
		rdbtnMale.setFont(new Font("Roboto", Font.PLAIN, 12));
		rdbtnMale.setForeground(new Color(252, 252, 252));
		rdbtnMale.setFocusPainted(false);

		rdbtnFemale = new JRadioButton("Nữ");
		rdbtnFemale.setOpaque(false);
		rdbtnFemale.setFont(new Font("Roboto", Font.PLAIN, 12));
		rdbtnFemale.setForeground(new Color(252, 252, 252));
		rdbtnFemale.setFocusPainted(false);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnFemale);
		buttonGroup.add(rdbtnMale);

		lblErrorGender = new JLabel("");
		lblErrorGender.setForeground(new Color(207, 106, 119));
		lblErrorGender.setFont(new Font("Roboto", Font.ITALIC, 12));

		panelPassword = new PanelTitle();

		txtPassword = new TextField();
		txtPassword.setHint("Mật khẩu");
		txtPassword.setForeground(new Color(252, 252, 252));
		txtPassword.setFont(new Font("Roboto", Font.ITALIC, 12));
		txtPassword.setCaretColor(new Color(252, 252, 252));
		txtPassword.setBorder(null);
		GroupLayout gl_panelPassword = new GroupLayout(panelPassword);
		gl_panelPassword.setHorizontalGroup(gl_panelPassword.createParallelGroup(Alignment.LEADING)
				.addGap(0, 266, Short.MAX_VALUE).addGap(0, 266, Short.MAX_VALUE).addGap(0, 266, Short.MAX_VALUE)
				.addGap(0, 266, Short.MAX_VALUE).addGroup(gl_panelPassword.createSequentialGroup().addContainerGap()
						.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)));
		gl_panelPassword
				.setVerticalGroup(gl_panelPassword.createParallelGroup(Alignment.LEADING).addGap(0, 28, Short.MAX_VALUE)
						.addGap(0, 28, Short.MAX_VALUE).addGap(0, 28, Short.MAX_VALUE).addGap(0, 28, Short.MAX_VALUE)
						.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE));
		panelPassword.setLayout(gl_panelPassword);

		lblErrorPassword = new JLabel("");
		lblErrorPassword.setForeground(new Color(207, 106, 119));
		lblErrorPassword.setFont(new Font("Roboto", Font.ITALIC, 12));

		lblCV = new JLabel("Chức vụ");
		lblCV.setForeground(new Color(252, 252, 252));
		lblCV.setFont(new Font("Roboto", Font.ITALIC, 12));

		btnGpRole = new ButtonGroup();

		rdbtnManager = new JRadioButton("Quản lí");
		rdbtnManager.setOpaque(false);
		rdbtnManager.setForeground(new Color(252, 252, 252));
		rdbtnManager.setFont(new Font("Roboto", Font.PLAIN, 12));
		rdbtnManager.setFocusPainted(false);

		rdbtnEmployee = new JRadioButton("Nhân viên");
		rdbtnEmployee.setOpaque(false);
		rdbtnEmployee.setForeground(new Color(252, 252, 252));
		rdbtnEmployee.setFont(new Font("Roboto", Font.PLAIN, 12));
		rdbtnEmployee.setFocusPainted(false);

		btnGpRole.add(rdbtnEmployee);
		btnGpRole.add(rdbtnManager);

		lblErrorRole = new JLabel("");
		lblErrorRole.setForeground(new Color(207, 106, 119));
		lblErrorRole.setFont(new Font("Roboto", Font.ITALIC, 12));

		btnCancel.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnCancel.setText("Hủy");
		btnCancel.setForeground(ColorBackground.colorLight);

		btnEdit = new ButtonCheckedSizeAndColor(0);
		btnEdit.setText("Sửa");
		btnEdit.setForeground(new Color(252, 252, 252));
		btnEdit.setFont(new Font("Roboto", Font.PLAIN, 14));

		btnAdd = new ButtonCheckedSizeAndColor(0);
		btnAdd.setText("Thêm");
		btnAdd.setForeground(new Color(252, 252, 252));
		btnAdd.setFont(new Font("Roboto", Font.PLAIN, 14));

		btnNew = new ButtonCheckedSizeAndColor(0);
		btnNew.setText("Làm mới");
		btnNew.setForeground(new Color(252, 252, 252));
		btnNew.setFont(new Font("Roboto", Font.PLAIN, 14));

		JLabel lblTao = new JLabel("Tạo tài khoản(nếu có)");
		lblTao.setHorizontalAlignment(SwingConstants.CENTER);
		lblTao.setForeground(new Color(207, 106, 119));
		lblTao.setFont(new Font("Roboto", Font.BOLD, 15));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup().addGap(10).addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(10)
										.addComponent(lblErrorPassword, GroupLayout.PREFERRED_SIZE, 256,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
										.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 85,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 65,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 65,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnCancel,
												GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
										.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(panelName, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
												.addComponent(panelEmail, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(panelPhone, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(panelSalary, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblErrorSalary, GroupLayout.PREFERRED_SIZE, 266,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED))
												.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(
														lblErrorName, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addGroup(groupLayout.createSequentialGroup().addGap(10)
														.addComponent(lblErrorEmail, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(
														lblErrorPhone, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
										.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
												.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblTao, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 266,
														Short.MAX_VALUE)
												.addComponent(panelUser, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
												.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(
														lblErrorUsername, GroupLayout.DEFAULT_SIZE, 256,
														Short.MAX_VALUE)))
												.addPreferredGap(ComponentPlacement.RELATED)))
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(
												groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
														.createParallelGroup(Alignment.TRAILING)
														.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
																.addGroup(groupLayout.createSequentialGroup()
																		.addGap(238)
																		.addGroup(groupLayout
																				.createParallelGroup(Alignment.TRAILING)
																				.addComponent(panelAddress, 0, 0,
																						Short.MAX_VALUE)
																				.addComponent(panelDate,
																						GroupLayout.PREFERRED_SIZE, 266,
																						GroupLayout.PREFERRED_SIZE)
																				.addGroup(groupLayout
																						.createSequentialGroup()
																						.addGap(10)
																						.addComponent(lblErrorDate,
																								GroupLayout.DEFAULT_SIZE,
																								256, Short.MAX_VALUE))))
																.addGroup(groupLayout.createSequentialGroup()
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addGroup(groupLayout
																				.createParallelGroup(Alignment.LEADING,
																						false)
																				.addComponent(lblGender,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(lblErrorAddress,
																						GroupLayout.DEFAULT_SIZE, 266,
																						Short.MAX_VALUE)
																				.addGroup(groupLayout
																						.createSequentialGroup()
																						.addComponent(rdbtnMale)
																						.addPreferredGap(
																								ComponentPlacement.UNRELATED)
																						.addComponent(rdbtnFemale,
																								GroupLayout.PREFERRED_SIZE,
																								53,
																								GroupLayout.PREFERRED_SIZE)))))
														.addGroup(groupLayout.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(lblErrorGender,
																		GroupLayout.PREFERRED_SIZE, 266,
																		GroupLayout.PREFERRED_SIZE)))
														.addGroup(groupLayout.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(groupLayout
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(groupLayout.createSequentialGroup()
																				.addComponent(rdbtnManager)
																				.addPreferredGap(
																						ComponentPlacement.UNRELATED)
																				.addComponent(rdbtnEmployee))
																		.addComponent(lblCV, GroupLayout.PREFERRED_SIZE,
																				266, GroupLayout.PREFERRED_SIZE))))
												.addGroup(groupLayout.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblErrorRole, GroupLayout.PREFERRED_SIZE, 266,
																GroupLayout.PREFERRED_SIZE))))
								.addComponent(panelPassword, GroupLayout.PREFERRED_SIZE, 266,
										GroupLayout.PREFERRED_SIZE))))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panelName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblErrorName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panelDate, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblErrorDate,
										GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panelEmail, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblErrorEmail, GroupLayout.PREFERRED_SIZE, 28,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(panelPhone, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelAddress, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup()
						.addComponent(lblErrorAddress, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(rdbtnMale)
								.addComponent(rdbtnFemale))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblErrorGender, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblErrorPhone, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(panelSalary, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblErrorSalary,
										GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblTao, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(panelUser, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblCV, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(rdbtnManager)
										.addComponent(rdbtnEmployee))))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblErrorRole, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addGap(65)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnEdit, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
												.addComponent(btnNew, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
										.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblErrorUsername, GroupLayout.PREFERRED_SIZE, 28,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(panelPassword, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblErrorPassword,
										GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		setLayout(groupLayout);
		if (MainForm.mode == "Dark") {
			setColorModeDark();
		} else {
			setColorModeLight();
		}
		btnEdit.setEnabled(false);
		init();
		action();

	}

	public void init() {
		if (employee != null) {
			ID_EMPLOYEE = employee.getIdEmployee();
			btnEdit.setEnabled(true);
			btnAdd.setEnabled(false);
			txtName.setText(employee.getName());
			txtEmail.setText(employee.getEmail());
			txtPhone.setText(employee.getPhone());
			txtAddRess.setText(employee.getAddRess());
			long roundValue = Math.round(employee.getSalary());
			txtSalary.setText(roundValue + "");
			txtDate.setText(employee.getNgaySinh());
			boolean gender = employee.isGender();
			if (gender) {
				rdbtnMale.setSelected(true);
			} else {
				rdbtnFemale.setSelected(true);
			}

			if (employee.getChucVu().equals("Quản Lí")) {
				rdbtnManager.setSelected(true);
			} else {
				rdbtnEmployee.setSelected(true);
			}
		}
	}

	public void action() {
		txtSalary.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume();
				}
			}
		});

		txtPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume();
				}
			}
		});

		PanelMode.actionButonModeDark(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setColorModeDark();
			}
		});

		PanelMode.actionButonModeLight(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setColorModeLight();
			}
		});

		btnNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});

		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				edit();
			}
		});

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				add();

			}
		});

		btnCalendar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 750;
				int y = 200;
				MainForm.setLocationDialog(x, y);
				MainForm.setLocationMouseDragged(x, y);
				calendar.setAlwaysOnTop(true);
				calendar.setLocation(MainForm.xScreen, MainForm.yScreen);
				calendar.setModalityType(ModalityType.TOOLKIT_MODAL);
				calendar.setVisible(true);
			}
		});

		PanelCalenderEmployee.btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelCalenderEmployee.index = 0;
				PanelCalenderEmployee.option = "Day";
				calendar.setVisible(false);
			}
		});

	}

	public void clearForm() {
		btnAdd.setEnabled(true);
		btnEdit.setEnabled(false);

		txtName.setText("");
		txtEmail.setText("");
		txtDate.setText("");
		txtPhone.setText("");
		txtSalary.setText("");
		txtUsername.setText("");
		txtAddRess.setText("");
		txtPassword.setText("");

		btnGpRole.clearSelection();
		buttonGroup.clearSelection();

	}

	public boolean validateForm() {
		String name = txtName.getText();
		String email = txtEmail.getText();
		String phone = txtPhone.getText();
		String salary = txtSalary.getText();
		String date = txtDate.getText();
		String addRess = txtAddRess.getText();

		if (name.equals("")) {
			lblErrorName.setText("Vui lòng nhập tên nhân viên");
			return false;
		} else {
			lblErrorName.setText("");
		}

		if (email.equals("")) {
			lblErrorEmail.setText("Vui lòng nhập email nhân viên");
			return false;
		} else {
			if (!email.matches(pattern)) {
				lblErrorEmail.setText("Email nhập sai định dạng");
				return false;
			} else {
				lblErrorEmail.setText("");
			}
		}

		if (phone.equals("")) {
			lblErrorPhone.setText("Vui lòng nhập số điện thoại");
			return false;
		} else {
			if (!phone.matches(regexPhone)) {
				lblErrorPhone.setText("Số điện thoại nhập sai định dạng");
				return false;
			} else {
				lblErrorPhone.setText("");
			}
		}

		if (salary.equals("")) {
			lblErrorSalary.setText("Vui lòng nhập lương nhân viên");
			return false;
		} else {
			lblErrorSalary.setText("");
		}

		if (date.equals("")) {
			lblErrorDate.setText("Vui lòng nhập ngày sinh");
			return false;
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			int yearNow = calendar.get(calendar.YEAR);
			int yearText = Integer.parseInt(date.substring(0, 4));
			if (yearNow - yearText < 18) {
				lblErrorDate.setText("Nhân viên chưa đủ 18 tuổi");
				return false;
			} else {
				lblErrorDate.setText("");
			}
		}

		if (addRess.equals("")) {
			lblErrorAddress.setText("Vui lòng nhập địa chỉ");
			return false;
		} else {
			lblErrorAddress.setText("");
		}

		if (!rdbtnMale.isSelected() && !rdbtnFemale.isSelected()) {
			lblErrorGender.setText("Vui lòng chọn giới tính");
			return false;
		} else {
			lblErrorGender.setText("");
		}

		if (!rdbtnEmployee.isSelected() && !rdbtnManager.isSelected()) {
			lblErrorRole.setText("Vui lòng chọn chức vụ");
			return false;
		} else {
			lblErrorRole.setText("");
		}

		return true;
	}

	public void edit() {
		// validate	
		if (validateForm()) {
			String cv = "";

			if (rdbtnManager.isSelected()) {
				cv = "1";
			} else {
				cv = "2";
			}

			boolean gender;
			if (rdbtnMale.isSelected()) {
				gender = true;
			} else {
				gender = false;
			}

			if (dao.update(new ModelEmployee(ID_EMPLOYEE, txtName.getText(), cv, gender, txtDate.getText(),
					txtAddRess.getText(), txtPhone.getText(), txtEmail.getText(),
					Double.parseDouble(txtSalary.getText()))) > 0) {
				PanelTableEmployee.init();

				question.lblTextMessage.setText("Chỉnh Sửa Nhân Viên Thành Công");
				int x = 650;
				int y = 290;
				MainForm.setLocationDialog(x, y);
				MainForm.setLocationMouseDragged(x, y);
				question.setLocation(MainForm.xScreen, MainForm.yScreen);
				question.setAlwaysOnTop(true);
				question.setVisible(true);

			} else {
				System.out.println("Edit fail");
			}

		}

	}

	public void add() {
		// validate
		if (validateForm()) {
			String cv = "";

			if (rdbtnManager.isSelected()) {
				cv = "1";
			} else {
				cv = "2";
			}

			boolean gender;
			if (rdbtnMale.isSelected()) {
				gender = true;
			} else {
				gender = false;
			}
			if (dao.insert(new ModelEmployee(ID_EMPLOYEE, txtName.getText(), cv, gender, txtDate.getText(),
					txtAddRess.getText(), txtPhone.getText(), txtEmail.getText(),
					Double.parseDouble(txtSalary.getText()))) > 0) {
				PanelTableEmployee.init();
				question.lblTextMessage.setText("Thêm Nhân Viên Thành Công");
				question.setLocationRelativeTo(null);
				question.setVisible(true);
			} else {
				System.out.println("insert fail");
			}
		}
	}

	public void setColorModeDark() {
		setColor1(ColorBackground.colorDark);
		lblTitle.setForeground(ColorBackground.colorLight);
		lblGender.setForeground(ColorBackground.colorLight);
		lblCV.setForeground(ColorBackground.colorLight);
		lblAddress.setForeground(ColorBackground.colorLight);

		setColorPanelAndTextModeDark(panelName, txtName);
		setColorPanelAndTextModeDark(panelEmail, txtEmail);
		setColorPanelAndTextModeDark(panelPhone, txtPhone);
		setColorPanelAndTextModeDark(panelSalary, txtSalary);
		setColorPanelAndTextModeDark(panelPassword, txtPassword);
		setColorPanelAndTextModeDark(panelDate, txtDate);
		setColorPanelAndTextModeDark(panelUser, txtUsername);

		panelAddress.setColorClick(ColorBackground.colorGRB394348);
		panelAddress.setColorBackground(ColorBackground.colorGRB394348);

		txtAddRess.setForeground(ColorBackground.colorLight);
		txtAddRess.setCaretColor(ColorBackground.colorLight);

		setColorButtonModeDark(btnAdd);
		setColorButtonModeDark(btnNew);
		setColorButtonModeDark(btnEdit);
		setColorButtonModeDark(btnCancel);

		setColorRadioButtonModeDark(rdbtnEmployee);
		setColorRadioButtonModeDark(rdbtnManager);
		setColorRadioButtonModeDark(rdbtnMale);
		setColorRadioButtonModeDark(rdbtnFemale);
	}

	public void setColorModeLight() {
		setColor1(ColorBackground.colorLight);
		lblTitle.setForeground(ColorBackground.colorGRB394348);
		lblGender.setForeground(ColorBackground.colorDark);
		lblCV.setForeground(ColorBackground.colorDark);
		lblAddress.setForeground(ColorBackground.colorDark);

		setColorPanelAndTextModeLight(panelName, txtName);
		setColorPanelAndTextModeLight(panelEmail, txtEmail);
		setColorPanelAndTextModeLight(panelPhone, txtPhone);
		setColorPanelAndTextModeLight(panelSalary, txtSalary);
		setColorPanelAndTextModeLight(panelPassword, txtPassword);
		setColorPanelAndTextModeLight(panelDate, txtDate);
		setColorPanelAndTextModeLight(panelUser, txtUsername);

		panelAddress.setColorClick(ColorBackground.colorGRB239239239);
		panelAddress.setColorBackground(ColorBackground.colorGRB239239239);

		txtAddRess.setForeground(ColorBackground.colorDark);
		txtAddRess.setCaretColor(ColorBackground.colorDark);

		setColorButtonModeLight(btnAdd);
		setColorButtonModeLight(btnNew);
		setColorButtonModeLight(btnEdit);
		setColorButtonModeLight(btnCancel);

		setColorRadioButtonModeLight(rdbtnEmployee);
		setColorRadioButtonModeLight(rdbtnManager);
		setColorRadioButtonModeLight(rdbtnMale);
		setColorRadioButtonModeLight(rdbtnFemale);
	}

	public void setColorPanelAndTextModeLight(PanelTitle panel, TextField text) {
		panel.setColorClick(ColorBackground.colorGRB239239239);
		panel.setColorBackground(ColorBackground.colorGRB239239239);
		text.setCaretColor(ColorBackground.colorDark);
		text.setForeground(ColorBackground.colorDark);
	}

	public void setColorPanelAndTextModeDark(PanelTitle panel, TextField text) {
		panel.setColorClick(ColorBackground.colorGRB394348);
		panel.setColorBackground(ColorBackground.colorGRB394348);
		text.setCaretColor(ColorBackground.colorLight);
		text.setForeground(ColorBackground.colorLight);
	}

	public void setColorButtonModeDark(ButtonCheckedSizeAndColor button) {
		button.setColorBackground(ColorBackground.colorDark);
		button.setColorhover1(ColorBackground.colorGRB394348);
		button.setForeground(ColorBackground.colorLight);
	}

	public void setColorButtonModeLight(ButtonCheckedSizeAndColor button) {
		button.setColorBackground(ColorBackground.colorLight);
		button.setColorhover1(ColorBackground.colorGRB181228202);
		button.setForeground(ColorBackground.colorDark);
	}

	public void setColorRadioButtonModeDark(JRadioButton button) {
		button.setForeground(ColorBackground.colorLight);
	}

	public void setColorRadioButtonModeLight(JRadioButton button) {
		button.setForeground(ColorBackground.colorDark);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color2);
		g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		g2.setColor(color1);
		g2.fillRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 15, 15);
		super.paintComponent(g);
	}

	public Color getColor1() {
		return color1;
	}

	public void setColor1(Color color1) {
		this.color1 = color1;
		repaint();
	}
}
