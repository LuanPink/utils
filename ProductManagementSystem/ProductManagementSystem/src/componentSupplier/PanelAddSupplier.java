package componentSupplier;

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
import dao.DAOSupplier;
import model.ModelEmployee;
import model.ModelSupplier;
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

public class PanelAddSupplier extends JPanel {
	Color color1 = ColorBackground.colorDark;
	Color color2 = new Color(207, 106, 119);
	private DAOSupplier dao = new DAOSupplier();
	private JLabel lblTitle;
	private PanelTitle panelName;
	private TextField txtName;
	private TextField txtAddress;
	private JLabel lblErrorName;
	private PanelTitle panelEmail;
	private TextField txtphone;
	private JLabel lblErrornote;
	private PanelTitle panelPhone;
	private JLabel lblErrorPhone;
	public static TextField txtemail;
	private PanelTitle panelDate;
	private PanelTitle panelAddress;
	private JTextArea txtnote;
	private JLabel lblnote;
	private JLabel lblErrorAddress;
	private JLabel lblErroremail;
	private JLabel lblErrorGender;
	private ButtonGroup buttonGroup;
	private ButtonGroup btnGpRole;
	private ButtonCheckedSizeAndColor btnNew;
	private ButtonCheckedSizeAndColor btnAdd;
	private ButtonCheckedSizeAndColor btnEdit;
	public static ButtonCheckedSizeAndColor btnCancel = new ButtonCheckedSizeAndColor(0);
	private ModelSupplier sup;
	
	private DialogQuestion question = new DialogQuestion(null);
	private DialogCalenderSupplier calendar = new DialogCalenderSupplier(null);
	String pattern = "\\w{2,}@\\w{2,}(\\.[a-zA-z]{2,3}){1,2}";
	String regexPhone = "^0\\d{9}$";
	DialogFormAddSupplier addSupplier;
	private String ID_Sup;
	public PanelAddSupplier(ModelSupplier sup) {
		setOpaque(false);
		this.sup = sup;
		lblTitle = new JLabel("Thêm Nhà Cung Cấp");
		lblTitle.setFont(new Font("Roboto", Font.BOLD, 18));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(ColorBackground.colorLight);

		panelName = new PanelTitle();

		txtName = new TextField();
		txtName.setHint("Name");
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

		txtAddress = new TextField();
		txtAddress.setHint("Address");
		txtAddress.setForeground(new Color(252, 252, 252));
		txtAddress.setFont(new Font("Roboto", Font.ITALIC, 12));
		txtAddress.setCaretColor(new Color(252, 252, 252));
		txtAddress.setBorder(null);
		GroupLayout gl_panelEmail = new GroupLayout(panelEmail);
		gl_panelEmail.setHorizontalGroup(gl_panelEmail.createParallelGroup(Alignment.LEADING)
				.addGap(0, 216, Short.MAX_VALUE).addGap(0, 216, Short.MAX_VALUE)
				.addGroup(gl_panelEmail.createSequentialGroup().addContainerGap().addComponent(txtAddress,
						GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)));
		gl_panelEmail.setVerticalGroup(gl_panelEmail.createParallelGroup(Alignment.LEADING)
				.addGap(0, 28, Short.MAX_VALUE).addGap(0, 28, Short.MAX_VALUE)
				.addComponent(txtAddress, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE));
		panelEmail.setLayout(gl_panelEmail);

		lblErrornote = new JLabel("");
		lblErrornote.setForeground(new Color(207, 106, 119));
		lblErrornote.setFont(new Font("Roboto", Font.ITALIC, 12));

		panelPhone = new PanelTitle();

		txtphone = new TextField();
		txtphone.setHint("Phone");
		txtphone.setForeground(new Color(252, 252, 252));
		txtphone.setFont(new Font("Roboto", Font.ITALIC, 12));
		txtphone.setCaretColor(new Color(252, 252, 252));
		txtphone.setBorder(null);
		GroupLayout gl_panelPhone = new GroupLayout(panelPhone);
		gl_panelPhone.setHorizontalGroup(gl_panelPhone.createParallelGroup(Alignment.LEADING)
				.addGap(0, 216, Short.MAX_VALUE).addGap(0, 216, Short.MAX_VALUE)
				.addGroup(gl_panelPhone.createSequentialGroup().addContainerGap().addComponent(txtphone,
						GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)));
		gl_panelPhone.setVerticalGroup(gl_panelPhone.createParallelGroup(Alignment.LEADING)
				.addGap(0, 28, Short.MAX_VALUE).addGap(0, 28, Short.MAX_VALUE)
				.addComponent(txtphone, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE));
		panelPhone.setLayout(gl_panelPhone);

		lblErrorPhone = new JLabel("");
		lblErrorPhone.setForeground(new Color(207, 106, 119));
		lblErrorPhone.setFont(new Font("Roboto", Font.ITALIC, 12));

		panelDate = new PanelTitle();

		txtemail = new TextField();
		txtemail.setHint("Email");
		txtemail.setForeground(new Color(252, 252, 252));
		txtemail.setFont(new Font("Roboto", Font.ITALIC, 12));
		txtemail.setCaretColor(new Color(252, 252, 252));
		txtemail.setBorder(null);
		
		GroupLayout gl_panelDate = new GroupLayout(panelDate);
		gl_panelDate.setHorizontalGroup(
			gl_panelDate.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelDate.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtemail, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
		);
		gl_panelDate.setVerticalGroup(
			gl_panelDate.createParallelGroup(Alignment.TRAILING)
				.addComponent(txtemail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
		);
		panelDate.setLayout(gl_panelDate);

		panelAddress = new PanelTitle();

		txtnote = new JTextArea();
		txtnote.setWrapStyleWord(true);
		txtnote.setOpaque(false);
		txtnote.setLineWrap(true);
		txtnote.setForeground(new Color(252, 252, 252));
		txtnote.setFont(new Font("Roboto", Font.ITALIC, 11));
		txtnote.setCaretColor(new Color(252, 252, 252));
		txtnote.setBorder(null);

		lblnote = new JLabel("Note");
		lblnote.setForeground(new Color(252, 252, 252));
		lblnote.setFont(new Font("Roboto", Font.ITALIC, 12));
		GroupLayout gl_panelAddress = new GroupLayout(panelAddress);
		gl_panelAddress.setHorizontalGroup(gl_panelAddress.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelAddress.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelAddress.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblnote, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 246,
										Short.MAX_VALUE)
								.addComponent(txtnote, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 246,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_panelAddress
				.setVerticalGroup(gl_panelAddress.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_panelAddress.createSequentialGroup().addContainerGap().addComponent(lblnote)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtnote, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		panelAddress.setLayout(gl_panelAddress);

		lblErroremail = new JLabel("");
		lblErroremail.setForeground(new Color(207, 106, 119));
		lblErroremail.setFont(new Font("Roboto", Font.ITALIC, 12));

		lblErrorAddress = new JLabel("");
		lblErrorAddress.setForeground(new Color(207, 106, 119));
		lblErrorAddress.setFont(new Font("Roboto", Font.ITALIC, 12));

		buttonGroup = new ButtonGroup();

		lblErrorGender = new JLabel("");
		lblErrorGender.setForeground(new Color(207, 106, 119));
		lblErrorGender.setFont(new Font("Roboto", Font.ITALIC, 12));

		btnGpRole = new ButtonGroup();
		

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

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(panelName, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
										.addComponent(panelEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(panelPhone, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addComponent(lblErrorName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addComponent(lblErrorPhone, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblErrorAddress, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblErrorGender, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(238)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblErrornote, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
												.addComponent(panelAddress, 0, 0, Short.MAX_VALUE)
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(10)
													.addComponent(lblErroremail, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
												.addComponent(panelDate, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE))))))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblErrorName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(panelDate, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblErroremail, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelEmail, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblErrorAddress, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(panelPhone, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelAddress, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblErrornote, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(53)
							.addComponent(lblErrorGender, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblErrorPhone, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(154)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnEdit, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
							.addComponent(btnNew, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
						.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
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
		if (sup != null) {
			ID_Sup = sup.getId();
			btnEdit.setEnabled(true);
			btnAdd.setEnabled(false);
			txtName.setText(sup.getName());
			txtAddress.setText(sup.getAddress());
			txtphone.setText(sup.getPhone());
			txtnote.setText(sup.getNote());
			txtemail.setText(sup.getEmail());
		}
	}

	public void action() {
		

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

		PanelCalenderSupplier.btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelCalenderSupplier.index = 0;
				PanelCalenderSupplier.option = "Day";
				calendar.setVisible(false);
			}
		});
		
	}

	public void clearForm() {
		btnAdd.setEnabled(true);
		btnEdit.setEnabled(false);

		txtName.setText("");
		txtAddress.setText("");
		txtemail.setText("");
		txtphone.setText("");
	
		txtnote.setText("");
		

		btnGpRole.clearSelection();
		buttonGroup.clearSelection();

	}

	public boolean validateForm() {
		String name = txtName.getText();
		String Address = txtAddress.getText();
		String phone = txtphone.getText();
		String email = txtemail.getText();
		String note = txtnote.getText();

		if (name.equals("")) {
			lblErrorName.setText("Vui lòng nhập tên nhà cung cấp");
			return false;
		} else {
			lblErrorName.setText("");
		}

		if (email.equals("")) {
			lblErroremail.setText("Vui lòng nhập email nhà cung cấp");
			return false;
		} else {
			if (!email.matches(pattern)) {
				lblErroremail.setText("Email nhập sai định dạng");
				return false;
			} else {
				lblErroremail.setText("");
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
		if (Address.equals("")) {
			lblErrorAddress.setText("Vui lòng nhập địa chỉ");
			return false;
		} else {
			lblErrorAddress.setText("");
		}
		if (note.equals("")) {
			lblErrornote.setText("Vui lòng nhập Ghi chú");
			return false;
		} else {
			lblErrorAddress.setText("");
		}

		return true;
	}

	public void edit() {
		// validate
		if (validateForm()) {
			if (dao.update(new ModelSupplier(ID_Sup, txtName.getText(),txtAddress.getText(), txtphone.getText(), txtemail.getText(),
					txtnote.getText()))>0) {
				PanelTableSupplier.init();

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
			if (dao.insert(new ModelSupplier(ID_Sup, txtName.getText(),txtAddress.getText(), txtphone.getText(), txtemail.getText(),
					txtnote.getText()))>0) {
				PanelTableSupplier.init();
				question.lblTextMessage.setText("Thêm Nhân Viên Thành Công");
				int x = 650;
				int y = 290;
				MainForm.setLocationDialog(x, y);
				MainForm.setLocationMouseDragged(x, y);
				question.setLocation(MainForm.xScreen, MainForm.yScreen);
				question.setAlwaysOnTop(true);
				question.setVisible(true);
			} else {
				System.out.println("insert fail");
			}
		}
	}

	public void setColorModeDark() {
		setColor1(ColorBackground.colorDark);
		lblTitle.setForeground(ColorBackground.colorLight);
		
		lblnote.setForeground(ColorBackground.colorLight);

		setColorPanelAndTextModeDark(panelName, txtName);
		setColorPanelAndTextModeDark(panelEmail, txtAddress);
		setColorPanelAndTextModeDark(panelPhone, txtphone);
		
	
		setColorPanelAndTextModeDark(panelDate, txtemail);
		

		panelAddress.setColorClick(ColorBackground.colorGRB394348);
		panelAddress.setColorBackground(ColorBackground.colorGRB394348);

		txtnote.setForeground(ColorBackground.colorLight);
		txtnote.setCaretColor(ColorBackground.colorLight);

		setColorButtonModeDark(btnAdd);
		setColorButtonModeDark(btnNew);
		setColorButtonModeDark(btnEdit);
		setColorButtonModeDark(btnCancel);

		
	}

	public void setColorModeLight() {
		setColor1(ColorBackground.colorLight);
		lblTitle.setForeground(ColorBackground.colorGRB394348);
		
		lblnote.setForeground(ColorBackground.colorDark);

		setColorPanelAndTextModeLight(panelName, txtName);
		setColorPanelAndTextModeLight(panelEmail, txtAddress);
		setColorPanelAndTextModeLight(panelPhone, txtphone);
	
		
		setColorPanelAndTextModeLight(panelDate, txtemail);
		

		panelAddress.setColorClick(ColorBackground.colorGRB239239239);
		panelAddress.setColorBackground(ColorBackground.colorGRB239239239);

		txtnote.setForeground(ColorBackground.colorDark);
		txtnote.setCaretColor(ColorBackground.colorDark);

		setColorButtonModeLight(btnAdd);
		setColorButtonModeLight(btnNew);
		setColorButtonModeLight(btnEdit);
		setColorButtonModeLight(btnCancel);

		
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
