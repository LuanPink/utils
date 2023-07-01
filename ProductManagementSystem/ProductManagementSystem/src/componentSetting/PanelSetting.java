package componentSetting;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import animation.ToggleButton;
import color.ColorBackground;
import componentButton.ButtonProfile;
import componentCreateProduct.ButtonCheckedSizeAndColor;
import componentCreateProduct.PanelTitle;
import componentHeader.ButtonShowAllNotification;
import componentProduct.Avatar;
import componentScrollPane.ScrollBarMenu;
import view.MainForm;
import view.PanelMode;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Cursor;

public class PanelSetting extends JPanel {
	private Color color = new Color(26, 29, 31);
	private Color color1 = new Color(78, 79, 81);
	private Color color2 = ColorBackground.colorLight;
	private Color color3 = ColorBackground.colorGRB147147147;
	private Color color4 = ColorBackground.colorGRB707070;

	private ButtonSetting btnProfile;
	private ButtonSetting btnAccount;
	private ButtonSetting btnNotification;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtOldPassword;
	private JTextField txtNewPassword;
	private JTextField txtConfirmPassword;
	private JScrollPane scrollPane;
	private JPanel panelNotification;
	private JLabel lblNotification;
	private JLabel lblProduct;
	private JLabel lblCmt;
	private JLabel lblMarket;
	private JLabel lblBuy;
	private ToggleButton btnToggleProduct;
	private ToggleButton btnToggleCmt;
	private ToggleButton btnMaket;
	private ToggleButton btnToggleBuy;
	private PanelTitle panelOldPassword;
	private JLabel lblLogin;
	private JLabel lblOldPassword;
	private PanelTitle panelNewPassword;
	private JLabel lblNewPassword;
	private PanelTitle panelConfirmPassword;
	private JLabel lblConfirmPassword;
	private ButtonCheckedSizeAndColor btnUpdatePassword;
	private JLabel lblInformation;
	private Avatar avatar;
	private ButtonCheckedSizeAndColor btnRemoveAvatar;
	private JLabel lblShow;
	private PanelTitle panelName;
	private JLabel lblEmail;
	private PanelTitle panelEmail;
	private JLabel lblPhone;
	private PanelTitle panelPhone;
	private JPanel panelEast;
	private JLabel lblArrow5;
	private JLabel lblArrow4;
	private JLabel lblArrow3;
	private JLabel lblArrow1;
	private JLabel lblArrow2;
	private int index = 0;

	public PanelSetting() {
		setOpaque(false);

		JPanel panelWest = new JPanel();
		panelWest.setOpaque(false);

		panelEast = new JPanel();
		panelEast.setOpaque(false);

		scrollPane = new JScrollPane(panelEast);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBar(new ScrollBarMenu());
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBar(new ScrollBarMenu());
		scrollPane.setOpaque(true);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.setViewportBorder(null);
		scrollPane.setBackground(ColorBackground.colorDark);

		JPanel panelInfo = new JPanel();
		panelInfo.setOpaque(false);

		lblArrow1 = new JLabel(
				"_____________________________________________________________________________________________________________");
		lblArrow1.setForeground(color4);
		JPanel panelAccount = new JPanel();
		panelAccount.setOpaque(false);

		lblArrow2 = new JLabel(
				"_____________________________________________________________________________________________________________");
		lblArrow2.setForeground(color4);

		panelNotification = new JPanel();
		panelNotification.setOpaque(false);

		GroupLayout gl_panelEast = new GroupLayout(panelEast);
		gl_panelEast.setHorizontalGroup(gl_panelEast.createParallelGroup(Alignment.LEADING)
				.addComponent(panelInfo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
				.addGroup(gl_panelEast.createSequentialGroup().addContainerGap()
						.addComponent(lblArrow1, GroupLayout.PREFERRED_SIZE, 642, Short.MAX_VALUE).addContainerGap())
				.addComponent(panelAccount, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(panelNotification, GroupLayout.PREFERRED_SIZE, 662, Short.MAX_VALUE)
				.addGroup(gl_panelEast.createSequentialGroup().addContainerGap()
						.addComponent(lblArrow2, GroupLayout.PREFERRED_SIZE, 648, Short.MAX_VALUE).addContainerGap()));
		gl_panelEast.setVerticalGroup(gl_panelEast.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEast.createSequentialGroup()
						.addComponent(panelInfo, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblArrow1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panelAccount, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblArrow2, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panelNotification, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		lblNotification = new JLabel("Thông báo");
		lblNotification.setForeground(new Color(252, 252, 252));
		lblNotification.setFont(new Font("Roboto", Font.BOLD, 18));

		lblProduct = new JLabel("Cập nhật sản phẩm và thông báo");
		lblProduct.setForeground(new Color(147, 147, 147));
		lblProduct.setFont(new Font("Roboto", Font.BOLD, 15));

		lblArrow3 = new JLabel(
				"____________________________________________________________________________________________________________");
		lblArrow3.setForeground(color4);

		lblMarket = new JLabel("Bản tin thị trường");
		lblMarket.setForeground(new Color(147, 147, 147));
		lblMarket.setFont(new Font("Roboto", Font.BOLD, 15));

		lblArrow4 = new JLabel(
				"____________________________________________________________________________________________________________");
		lblArrow4.setForeground(color4);

		lblCmt = new JLabel("Bình luận");
		lblCmt.setForeground(color3);
		lblCmt.setFont(new Font("Roboto", Font.BOLD, 15));

		lblArrow5 = new JLabel(
				"____________________________________________________________________________________________________________");
		lblArrow5.setForeground(color4);

		lblBuy = new JLabel("Mua hàng");
		lblBuy.setForeground(new Color(147, 147, 147));
		lblBuy.setFont(new Font("Roboto", Font.BOLD, 15));

		btnToggleProduct = new ToggleButton();
		btnToggleProduct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnToggleProduct.setSelected(true);

		btnMaket = new ToggleButton();
		btnMaket.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMaket.setSelected(true);

		btnToggleCmt = new ToggleButton();
		btnToggleCmt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnToggleCmt.setSelected(true);

		btnToggleBuy = new ToggleButton();
		btnToggleBuy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnToggleBuy.setSelected(true);

		GroupLayout gl_panelNotification = new GroupLayout(panelNotification);
		gl_panelNotification.setHorizontalGroup(gl_panelNotification.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNotification.createSequentialGroup().addContainerGap().addGroup(gl_panelNotification
						.createParallelGroup(Alignment.LEADING)
						.addComponent(lblArrow5, GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
						.addComponent(lblArrow4, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 642, Short.MAX_VALUE)
						.addComponent(lblArrow3, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 642, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING,
								gl_panelNotification.createSequentialGroup()
										.addComponent(lblProduct, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnToggleProduct,
												GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNotification, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING,
								gl_panelNotification.createSequentialGroup()
										.addComponent(lblBuy, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnToggleBuy,
												GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING,
								gl_panelNotification.createSequentialGroup()
										.addComponent(lblMarket, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnMaket,
												GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING,
								gl_panelNotification.createSequentialGroup()
										.addComponent(lblCmt, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE).addGap(10)
										.addComponent(btnToggleCmt, GroupLayout.PREFERRED_SIZE, 70,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		gl_panelNotification.setVerticalGroup(gl_panelNotification.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNotification.createSequentialGroup()
						.addGroup(gl_panelNotification.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelNotification.createSequentialGroup().addContainerGap()
										.addComponent(lblNotification, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(lblProduct, GroupLayout.PREFERRED_SIZE, 18,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelNotification.createSequentialGroup().addGap(40).addComponent(
										btnToggleProduct, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
						.addGap(18).addComponent(lblArrow3, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelNotification.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelNotification.createSequentialGroup().addGap(18).addComponent(btnMaket,
										GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelNotification.createSequentialGroup().addGap(27).addComponent(
										lblMarket, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
						.addGap(18).addComponent(lblArrow4, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelNotification.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelNotification.createSequentialGroup().addGap(18).addComponent(
										btnToggleCmt, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelNotification.createSequentialGroup().addGap(29).addComponent(lblCmt,
										GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
						.addGap(18).addComponent(lblArrow5, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelNotification.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelNotification.createSequentialGroup().addGap(18).addComponent(
										btnToggleBuy, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelNotification.createSequentialGroup().addGap(26).addComponent(lblBuy,
										GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
						.addGap(43)));
		panelNotification.setLayout(gl_panelNotification);

		lblLogin = new JLabel("Đăng nhập");
		lblLogin.setForeground(new Color(252, 252, 252));
		lblLogin.setFont(new Font("Roboto", Font.BOLD, 18));

		lblOldPassword = new JLabel("Mật khẩu cũ");
		lblOldPassword.setForeground(new Color(147, 147, 147));
		lblOldPassword.setFont(new Font("Roboto", Font.BOLD, 15));

		panelOldPassword = new PanelTitle();

		txtOldPassword = new JTextField();
		txtOldPassword.setOpaque(false);
		txtOldPassword.setForeground(Color.WHITE);
		txtOldPassword.setFont(new Font("Roboto", Font.BOLD, 14));
		txtOldPassword.setCaretColor(new Color(252, 252, 252));
		txtOldPassword.setBorder(null);
		GroupLayout gl_panelOldPassword = new GroupLayout(panelOldPassword);
		gl_panelOldPassword.setHorizontalGroup(
				gl_panelOldPassword.createParallelGroup(Alignment.LEADING).addGap(0, 592, Short.MAX_VALUE)
						.addGroup(gl_panelOldPassword.createSequentialGroup().addContainerGap()
								.addComponent(txtOldPassword, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
								.addContainerGap()));
		gl_panelOldPassword.setVerticalGroup(
				gl_panelOldPassword.createParallelGroup(Alignment.LEADING).addGap(0, 49, Short.MAX_VALUE)
						.addComponent(txtOldPassword, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE));
		panelOldPassword.setLayout(gl_panelOldPassword);

		panelNewPassword = new PanelTitle();

		txtNewPassword = new JTextField();
		txtNewPassword.setOpaque(false);
		txtNewPassword.setForeground(Color.WHITE);
		txtNewPassword.setFont(new Font("Roboto", Font.BOLD, 14));
		txtNewPassword.setCaretColor(new Color(252, 252, 252));
		txtNewPassword.setBorder(null);
		GroupLayout gl_panelNewPassword = new GroupLayout(panelNewPassword);
		gl_panelNewPassword.setHorizontalGroup(gl_panelNewPassword.createParallelGroup(Alignment.LEADING)
				.addGap(0, 592, Short.MAX_VALUE).addGap(0, 592, Short.MAX_VALUE)
				.addGroup(gl_panelNewPassword.createSequentialGroup().addContainerGap()
						.addComponent(txtNewPassword, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
						.addContainerGap()));
		gl_panelNewPassword.setVerticalGroup(gl_panelNewPassword.createParallelGroup(Alignment.LEADING)
				.addGap(0, 49, Short.MAX_VALUE).addGap(0, 49, Short.MAX_VALUE)
				.addComponent(txtNewPassword, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE));
		panelNewPassword.setLayout(gl_panelNewPassword);

		lblNewPassword = new JLabel("Mật khẩu mới");
		lblNewPassword.setForeground(new Color(147, 147, 147));
		lblNewPassword.setFont(new Font("Roboto", Font.BOLD, 15));

		panelConfirmPassword = new PanelTitle();

		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setOpaque(false);
		txtConfirmPassword.setForeground(Color.WHITE);
		txtConfirmPassword.setFont(new Font("Roboto", Font.BOLD, 14));
		txtConfirmPassword.setCaretColor(new Color(252, 252, 252));
		txtConfirmPassword.setBorder(null);
		GroupLayout gl_panelConfirmPassword = new GroupLayout(panelConfirmPassword);
		gl_panelConfirmPassword.setHorizontalGroup(gl_panelConfirmPassword.createParallelGroup(Alignment.LEADING)
				.addGap(0, 289, Short.MAX_VALUE).addGap(0, 592, Short.MAX_VALUE).addGap(0, 592, Short.MAX_VALUE)
				.addGroup(gl_panelConfirmPassword.createSequentialGroup().addContainerGap()
						.addComponent(txtConfirmPassword, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
						.addContainerGap()));
		gl_panelConfirmPassword.setVerticalGroup(gl_panelConfirmPassword.createParallelGroup(Alignment.LEADING)
				.addGap(0, 49, Short.MAX_VALUE).addGap(0, 49, Short.MAX_VALUE).addGap(0, 49, Short.MAX_VALUE)
				.addComponent(txtConfirmPassword, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE));
		panelConfirmPassword.setLayout(gl_panelConfirmPassword);

		lblConfirmPassword = new JLabel("Xác nhận mật khẩu mới");
		lblConfirmPassword.setForeground(new Color(147, 147, 147));
		lblConfirmPassword.setFont(new Font("Roboto", Font.BOLD, 15));

		btnUpdatePassword = new ButtonCheckedSizeAndColor(1);
		btnUpdatePassword.setText("Cập nhật mật khẩu");
		btnUpdatePassword.setForeground(new Color(252, 252, 252));
		btnUpdatePassword.setFont(new Font("Roboto", Font.BOLD, 18));
		GroupLayout gl_panelAccount = new GroupLayout(panelAccount);
		gl_panelAccount.setHorizontalGroup(gl_panelAccount.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAccount.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelAccount.createParallelGroup(Alignment.LEADING)
								.addComponent(panelOldPassword, GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
								.addGroup(gl_panelAccount.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblOldPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panelAccount.createSequentialGroup()
										.addGroup(gl_panelAccount.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewPassword, GroupLayout.PREFERRED_SIZE, 92,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(panelNewPassword, GroupLayout.PREFERRED_SIZE, 317,
														GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_panelAccount.createParallelGroup(Alignment.LEADING)
												.addComponent(panelConfirmPassword, GroupLayout.DEFAULT_SIZE, 307,
														Short.MAX_VALUE)
												.addComponent(lblConfirmPassword)))
								.addComponent(btnUpdatePassword, GroupLayout.PREFERRED_SIZE, 210,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_panelAccount.setVerticalGroup(gl_panelAccount.createParallelGroup(Alignment.LEADING).addGroup(gl_panelAccount
				.createSequentialGroup().addContainerGap()
				.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(lblOldPassword, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(panelOldPassword, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addGroup(gl_panelAccount.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewPassword, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConfirmPassword, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_panelAccount.createParallelGroup(Alignment.LEADING)
						.addComponent(panelNewPassword, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelConfirmPassword, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
				.addGap(27).addComponent(btnUpdatePassword, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(92, Short.MAX_VALUE)));
		panelAccount.setLayout(gl_panelAccount);

		lblInformation = new JLabel("Thông tin cá nhân");
		lblInformation.setForeground(color2);
		lblInformation.setFont(new Font("Roboto", Font.BOLD, 18));

		avatar = new Avatar();

		ButtonShowAllNotification btnNewAvatar = new ButtonShowAllNotification("Chọn ảnh mới");
		btnNewAvatar.setIcon(new ImageIcon(PanelSetting.class.getResource("/icon/plus-white.png")));

		btnRemoveAvatar = new ButtonCheckedSizeAndColor(1);
		btnRemoveAvatar.setForeground(color2);
		btnRemoveAvatar.setFont(new Font("Roboto", Font.BOLD, 18));
		btnRemoveAvatar.setText("Xóa ảnh");

		lblShow = new JLabel("Tên hiển thị");
		lblShow.setFont(new Font("Roboto", Font.BOLD, 15));
		lblShow.setForeground(color3);

		panelName = new PanelTitle();

		txtName = new JTextField();
		txtName.setOpaque(false);
		txtName.setForeground(Color.WHITE);
		txtName.setFont(new Font("Roboto", Font.BOLD, 14));
		txtName.setCaretColor(new Color(252, 252, 252));
		txtName.setBorder(null);
		GroupLayout gl_panelName = new GroupLayout(panelName);
		gl_panelName.setHorizontalGroup(gl_panelName.createParallelGroup(Alignment.LEADING)
				.addGap(0, 613, Short.MAX_VALUE).addGroup(gl_panelName.createSequentialGroup().addContainerGap()
						.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE).addContainerGap()));
		gl_panelName.setVerticalGroup(gl_panelName.createParallelGroup(Alignment.LEADING).addGap(0, 49, Short.MAX_VALUE)
				.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE));
		panelName.setLayout(gl_panelName);

		lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(147, 147, 147));
		lblEmail.setFont(new Font("Roboto", Font.BOLD, 15));

		panelEmail = new PanelTitle();

		txtEmail = new JTextField();
		txtEmail.setOpaque(false);
		txtEmail.setForeground(Color.WHITE);
		txtEmail.setFont(new Font("Roboto", Font.BOLD, 14));
		txtEmail.setCaretColor(new Color(252, 252, 252));
		txtEmail.setBorder(null);
		GroupLayout gl_panelEmail = new GroupLayout(panelEmail);
		gl_panelEmail.setHorizontalGroup(gl_panelEmail.createParallelGroup(Alignment.LEADING)
				.addGap(0, 592, Short.MAX_VALUE).addGroup(gl_panelEmail.createSequentialGroup().addContainerGap()
						.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE).addContainerGap()));
		gl_panelEmail.setVerticalGroup(gl_panelEmail.createParallelGroup(Alignment.LEADING)
				.addGap(0, 49, Short.MAX_VALUE).addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE));
		panelEmail.setLayout(gl_panelEmail);

		lblPhone = new JLabel("Số điện thoại");
		lblPhone.setForeground(new Color(147, 147, 147));
		lblPhone.setFont(new Font("Roboto", Font.BOLD, 15));

		panelPhone = new PanelTitle();

		txtPhone = new JTextField();
		txtPhone.setOpaque(false);
		txtPhone.setForeground(Color.WHITE);
		txtPhone.setFont(new Font("Roboto", Font.BOLD, 14));
		txtPhone.setCaretColor(new Color(252, 252, 252));
		txtPhone.setBorder(null);
		GroupLayout gl_panelPhone = new GroupLayout(panelPhone);
		gl_panelPhone.setHorizontalGroup(gl_panelPhone.createParallelGroup(Alignment.LEADING)
				.addGap(0, 592, Short.MAX_VALUE).addGap(0, 592, Short.MAX_VALUE)
				.addGroup(gl_panelPhone.createSequentialGroup().addContainerGap()
						.addComponent(txtPhone, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE).addContainerGap()));
		gl_panelPhone.setVerticalGroup(gl_panelPhone.createParallelGroup(Alignment.LEADING)
				.addGap(0, 49, Short.MAX_VALUE).addGap(0, 49, Short.MAX_VALUE)
				.addComponent(txtPhone, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE));
		panelPhone.setLayout(gl_panelPhone);
		GroupLayout gl_panelInfo = new GroupLayout(panelInfo);
		gl_panelInfo.setHorizontalGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING).addGroup(gl_panelInfo
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
						.addComponent(panelName, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
						.addGroup(gl_panelInfo.createSequentialGroup()
								.addComponent(avatar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnNewAvatar, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(btnRemoveAvatar, GroupLayout.PREFERRED_SIZE, 100,
										GroupLayout.PREFERRED_SIZE))
						.addComponent(lblInformation).addComponent(lblShow)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelEmail, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE).addComponent(lblPhone)
						.addComponent(panelPhone, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
				.addContainerGap()));
		gl_panelInfo.setVerticalGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING).addGroup(gl_panelInfo
				.createSequentialGroup().addContainerGap().addComponent(lblInformation)
				.addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInfo.createSequentialGroup().addGap(19).addComponent(avatar,
								GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelInfo.createSequentialGroup().addGap(44)
								.addGroup(gl_panelInfo.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNewAvatar, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnRemoveAvatar, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE))))
				.addGap(18).addComponent(lblShow).addGap(18)
				.addComponent(panelName, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(panelEmail, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(panelPhone, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(63, Short.MAX_VALUE)));
		panelInfo.setLayout(gl_panelInfo);
		panelEast.setLayout(gl_panelEast);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panelWest, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
								.addComponent(panelWest, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		btnProfile = new ButtonSetting(1, "Thông tin cá nhân");

		btnProfile.setHorizontalAlignment(SwingConstants.LEFT);
		btnProfile.setForeground(color1);
		btnProfile.setFont(new Font("Roboto", Font.BOLD, 17));
		btnProfile.setBorder(null);

		btnAccount = new ButtonSetting(2, "Tài khoản");

		btnAccount.setHorizontalAlignment(SwingConstants.LEFT);
		btnAccount.setForeground(new Color(78, 79, 81));
		btnAccount.setFont(new Font("Roboto", Font.BOLD, 17));
		btnAccount.setBorder(null);

		btnNotification = new ButtonSetting(3, "Thông báo");

		btnNotification.setHorizontalAlignment(SwingConstants.LEFT);
		btnNotification.setForeground(new Color(78, 79, 81));
		btnNotification.setFont(new Font("Roboto", Font.BOLD, 17));
		btnNotification.setBorder(null);

		GroupLayout gl_panelWest = new GroupLayout(panelWest);
		gl_panelWest.setHorizontalGroup(gl_panelWest.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelWest.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelWest.createParallelGroup(Alignment.LEADING)
								.addComponent(btnProfile, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
								.addComponent(btnAccount, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
								.addComponent(btnNotification, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
						.addContainerGap()));
		gl_panelWest
				.setVerticalGroup(gl_panelWest.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelWest.createSequentialGroup().addContainerGap()
								.addComponent(btnProfile, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnAccount, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnNotification,
										GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(138, Short.MAX_VALUE)));
		panelWest.setLayout(gl_panelWest);
		setLayout(groupLayout);
		index = 1;
		if (MainForm.mode == "Dark") {
			setColorModeDark();
		} else {
			setColorModeLight();
		}

		action();
	}

	public void action() {
		actionButtonSetting(btnProfile, btnAccount, btnNotification);
		actionButtonSetting(btnAccount, btnProfile, btnNotification);
		actionButtonSetting(btnNotification, btnProfile, btnAccount);
	}

	public void actionButtonSetting(ButtonSetting button, ButtonSetting... buttons) {

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (MainForm.mode == "Dark") {

					button.setColor(ColorBackground.colorGRB394348);
					button.setColor1(ColorBackground.colorGRB252252239);

					buttons[0].setColor(ColorBackground.colorDark);
					buttons[1].setColor(ColorBackground.colorDark);

				} else {
					button.setColor(ColorBackground.colorGRB239239239);
					button.setColor1(ColorBackground.colorGRB147147147);

					buttons[0].setColor(ColorBackground.colorLight);
					buttons[1].setColor(ColorBackground.colorLight);
				}
			}
		});

		scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				int value = scrollPane.getVerticalScrollBar().getValue();
				int extent = scrollPane.getVerticalScrollBar().getModel().getExtent();

			}
		});

		btnProfile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				scrollPane.getVerticalScrollBar().setValue(0);
				index = 1;
			}
		});

		btnAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				scrollPane.getVerticalScrollBar().setValue(520);
				index = 2;
			}
		});

		btnNotification.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				scrollPane.getVerticalScrollBar().setValue(844);
				index = 3;
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

		mouseListenerText(txtName, panelName);
		mouseListenerText(txtEmail, panelEmail);
		mouseListenerText(txtPhone, panelPhone);
		mouseListenerText(txtOldPassword, panelOldPassword);
		mouseListenerText(txtNewPassword, panelNewPassword);
		mouseListenerText(txtConfirmPassword, panelConfirmPassword);
	}

	public void setColorButtonSettingModeDark(ButtonSetting button, ButtonSetting... buttons) {
		button.setColor(ColorBackground.colorGRB394348);
		button.setColor1(ColorBackground.colorGRB252252239);

		buttons[0].setColor(ColorBackground.colorDark);
		buttons[1].setColor(ColorBackground.colorDark);
	}

	public void setColorButtonSettingModeLight(ButtonSetting button, ButtonSetting... buttons) {
		button.setColor(ColorBackground.colorGRB239239239);
		button.setColor1(ColorBackground.colorGRB147147147);

		buttons[0].setColor(ColorBackground.colorLight);
		buttons[1].setColor(ColorBackground.colorLight);
	}

	public void setColorModeDark() {
		setColor(ColorBackground.colorDark);
		panelEast.setOpaque(true);
		panelEast.setBackground(ColorBackground.colorDark);

		setColorTextAndPanelModeDark(txtName, panelName);
		setColorTextAndPanelModeDark(txtEmail, panelEmail);
		setColorTextAndPanelModeDark(txtPhone, panelPhone);
		setColorTextAndPanelModeDark(txtOldPassword, panelOldPassword);
		setColorTextAndPanelModeDark(txtNewPassword, panelNewPassword);
		setColorTextAndPanelModeDark(txtConfirmPassword, panelConfirmPassword);

		setColorLabelModeDark(lblInformation, lblLogin, lblNotification, lblArrow1, lblArrow2, lblArrow3, lblArrow4,
				lblArrow5);

		setColorButtonModeDark(btnRemoveAvatar, btnUpdatePassword);

		if (index == 1) {
			setColorButtonSettingModeDark(btnProfile, btnAccount, btnNotification);
		} else if (index == 2) {
			setColorButtonSettingModeDark(btnAccount, btnProfile, btnNotification);
		} else if (index == 3) {
			setColorButtonSettingModeDark(btnNotification, btnAccount, btnProfile);
		}

		setColorButtonToggleDark(btnToggleProduct,btnToggleCmt,btnToggleBuy,btnMaket);
		

	}

	public void setColorModeLight() {
		setColor(ColorBackground.colorLight);
		panelEast.setOpaque(true);
		panelEast.setBackground(ColorBackground.colorLight);

		setColorTextAndPanelModeLight(txtName, panelName);
		setColorTextAndPanelModeLight(txtEmail, panelEmail);
		setColorTextAndPanelModeLight(txtPhone, panelPhone);
		setColorTextAndPanelModeLight(txtOldPassword, panelOldPassword);
		setColorTextAndPanelModeLight(txtNewPassword, panelNewPassword);
		setColorTextAndPanelModeLight(txtConfirmPassword, panelConfirmPassword);

		setColorLabelModeLight(lblInformation, lblLogin, lblNotification, lblArrow1, lblArrow2, lblArrow3, lblArrow4,
				lblArrow5);

		setColorButtonModeLight(btnRemoveAvatar, btnUpdatePassword);

		if (index == 1) {
			setColorButtonSettingModeLight(btnProfile, btnAccount, btnNotification);
		} else if (index == 2) {
			setColorButtonSettingModeLight(btnAccount, btnProfile, btnNotification);
		} else if (index == 3) {
			setColorButtonSettingModeLight(btnNotification, btnAccount, btnProfile);
		}

		setColorButtonToggleLight(btnToggleProduct,btnToggleCmt,btnToggleBuy,btnMaket);
		
	}

	public void setColorLabelModeLight(JLabel... lblTitle) {
		lblTitle[0].setForeground(ColorBackground.colorGRB171921);
		lblTitle[1].setForeground(ColorBackground.colorGRB171921);
		lblTitle[2].setForeground(ColorBackground.colorGRB171921);

		lblTitle[3].setForeground(ColorBackground.colorGRB200200200);
		lblTitle[4].setForeground(ColorBackground.colorGRB200200200);
		lblTitle[5].setForeground(ColorBackground.colorGRB200200200);
		lblTitle[6].setForeground(ColorBackground.colorGRB200200200);
		lblTitle[7].setForeground(ColorBackground.colorGRB200200200);

	}

	public void setColorLabelModeDark(JLabel... lblTitle) {
		lblTitle[0].setForeground(ColorBackground.colorLight);
		lblTitle[1].setForeground(ColorBackground.colorLight);
		lblTitle[2].setForeground(ColorBackground.colorLight);

		lblTitle[3].setForeground(ColorBackground.colorGRB707070);
		lblTitle[4].setForeground(ColorBackground.colorGRB707070);
		lblTitle[5].setForeground(ColorBackground.colorGRB707070);
		lblTitle[6].setForeground(ColorBackground.colorGRB707070);
		lblTitle[7].setForeground(ColorBackground.colorGRB707070);

	}

	public void setColorTextAndPanelModeLight(JTextField text, PanelTitle panel) {
		text.setCaretColor(ColorBackground.colorDark);
		text.setForeground(ColorBackground.colorDark);

		panel.setColorBackground(ColorBackground.colorLight);
		panel.setColorClick(ColorBackground.colorGRB239239239);
	}

	public void setColorTextAndPanelModeDark(JTextField text, PanelTitle panel) {
		text.setCaretColor(ColorBackground.colorLight);
		text.setForeground(ColorBackground.colorLight);

		panel.setColorBackground(ColorBackground.colorGRB394348);
		panel.setColorClick(ColorBackground.colorGRB394348);
	}

	public void setColorButtonModeLight(ButtonCheckedSizeAndColor... button) {
		button[0].setColorBackground(ColorBackground.colorLight);
		button[0].setColorhover1(ColorBackground.colorGRB181228202);
		button[0].setForeground(ColorBackground.colorDark);

		button[1].setColorhover1(ColorBackground.colorGRB181228202);
		button[1].setColorBackground(ColorBackground.colorLight);
		button[1].setForeground(ColorBackground.colorDark);
	}

	public void setColorButtonModeDark(ButtonCheckedSizeAndColor... button) {
		button[0].setColorBackground(ColorBackground.colorDark);
		button[0].setColorhover1(ColorBackground.colorGRB394348);
		button[0].setForeground(ColorBackground.colorLight);

		button[1].setColorBackground(ColorBackground.colorDark);
		button[1].setColorhover1(ColorBackground.colorGRB394348);
		button[1].setForeground(ColorBackground.colorLight);

	}

	public void mouseListenerText(JTextField text, PanelTitle panel) {
		text.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (MainForm.mode == "Dark") {
					panel.setColorBackground(ColorBackground.colorGRB000);
					panel.setColorClick(new Color(82, 147, 242));
				} else {
					panel.setColorBackground(ColorBackground.colorLight);
					panel.setColorClick(new Color(82, 147, 242));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (MainForm.mode == "Dark") {
					panel.setColorBackground(ColorBackground.colorGRB394348);
					panel.setColorClick(ColorBackground.colorGRB394348);
				} else {
					panel.setColorBackground(ColorBackground.colorGRB240242245);
					panel.setColorClick(ColorBackground.colorGRB239239239);
				}
			}
		});
	}

	public void setColorButtonToggleDark(ToggleButton...buttons) {
		buttons[0].setColor4(ColorBackground.colorGRB147147147);
		buttons[1].setColor4(ColorBackground.colorGRB147147147);
		buttons[2].setColor4(ColorBackground.colorGRB147147147);
		buttons[3].setColor4(ColorBackground.colorGRB147147147);

	}

	public void setColorButtonToggleLight(ToggleButton...buttons) {
		buttons[0].setColor4(ColorBackground.colorLight);
		buttons[1].setColor4(ColorBackground.colorLight);
		buttons[2].setColor4(ColorBackground.colorLight);
		buttons[3].setColor4(ColorBackground.colorLight);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		super.paintComponent(g);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		repaint();
	}

}
