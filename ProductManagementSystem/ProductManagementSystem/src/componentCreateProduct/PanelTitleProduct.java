package componentCreateProduct;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import color.ColorBackground;
import componentProduct.PanelCustomers;
import model.ModelProduct;
import model.ModelProductName;
import view.MainForm;
import view.PanelMode;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class PanelTitleProduct extends JPanel  {

	private Color color = ColorBackground.colorDark;
	
	private JTextField txtNameProduct;
	private PanelTitle panelTitle;
	private JLabel lblDescriber;
	private JTextArea txtDescriber;
	private ButtonPont btnBold;
	private ButtonPont btnItalic;
	private ButtonPont btnIUnderline;
	private JLabel lblTitle;
	private JLabel lblNameProduct;
	private PanelTitle panelDescriber;

	
	private Icon iconBoldWhite = new ImageIcon(PanelTitleProduct.class.getResource("/icon/bold-white.png"));
	private Icon iconItalicWhite = new ImageIcon(PanelTitleProduct.class.getResource("/icon/italic-white.png"));
	private Icon iconUnderlineWhite = new ImageIcon(PanelTitleProduct.class.getResource("/icon/underline-white.png"));
	
	private Icon iconBoldBlack = new ImageIcon(PanelTitleProduct.class.getResource("/icon/bold-black.png"));
	private Icon iconItalicBlack = new ImageIcon(PanelTitleProduct.class.getResource("/icon/italic-black.png"));
	private Icon iconUnderlineBlack = new ImageIcon(PanelTitleProduct.class.getResource("/icon/underline-black.png"));
	private JLabel lblertensanpham;
	private JLabel lblermotasanpham;
	
	
	
	public PanelTitleProduct() {
		setBorder(null);
		setOpaque(false);
		
		lblTitle = new JLabel("Tên & Mô tả");
		lblTitle.setForeground(new Color(252, 252, 252));
		lblTitle.setFont(new Font("Roboto", Font.BOLD, 18));

		lblNameProduct = new JLabel("Tên sản phẩm");
		lblNameProduct.setForeground(new Color(252, 252, 252));
		lblNameProduct.setFont(new Font("Roboto", Font.BOLD, 14));

		panelTitle = new PanelTitle();

		lblDescriber = new JLabel("Mô tả sản phẩm");
		lblDescriber.setForeground(new Color(252, 252, 252));
		lblDescriber.setFont(new Font("Roboto", Font.BOLD, 14));

		panelDescriber = new PanelTitle();

		txtDescriber = new JTextArea();
		txtDescriber.setLineWrap(true);
		txtDescriber.setWrapStyleWord(true);
		txtDescriber.setMargin(new Insets(2, 20, 2, 2));

		txtDescriber.setFont(new Font("Roboto", Font.BOLD, 14));
		JScrollPane scrollPane = new JScrollPane(txtDescriber);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(null);
		txtDescriber.setBorder(null);
		
		txtDescriber.setCaretColor(ColorBackground.colorLight);
		txtDescriber.setForeground(ColorBackground.colorLight);
		txtDescriber.setBackground(ColorBackground.colorGRB000);

		btnBold = new ButtonPont();
		btnBold.setIcon(iconBoldWhite);

		btnItalic = new ButtonPont();
		btnItalic.setIcon(iconItalicWhite);

		btnIUnderline = new ButtonPont();
		btnIUnderline.setIcon(iconUnderlineWhite);

		GroupLayout gl_panelDescriber = new GroupLayout(panelDescriber);
		gl_panelDescriber.setHorizontalGroup(gl_panelDescriber.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDescriber.createSequentialGroup().addContainerGap()
						.addComponent(btnBold, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnItalic, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnIUnderline, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(478, Short.MAX_VALUE))
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE));
		gl_panelDescriber.setVerticalGroup(gl_panelDescriber.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDescriber.createSequentialGroup().addGap(13)
						.addGroup(gl_panelDescriber.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBold, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnItalic, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnIUnderline, GroupLayout.PREFERRED_SIZE, 35,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)));
		panelDescriber.setLayout(gl_panelDescriber);
		
		lblertensanpham = new JLabel("");
		lblertensanpham.setForeground(new Color(255, 0, 0));
		lblertensanpham.setFont(new Font("Dialog", Font.ITALIC, 12));
		
		lblermotasanpham = new JLabel("");
		lblermotasanpham.setForeground(Color.RED);
		lblermotasanpham.setFont(new Font("Dialog", Font.ITALIC, 12));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelDescriber, GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
						.addComponent(panelTitle, GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
						.addComponent(lblNameProduct, GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
						.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDescriber, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(897))
						.addComponent(lblertensanpham, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblermotasanpham, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNameProduct, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelTitle, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblertensanpham, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(lblDescriber, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelDescriber, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblermotasanpham, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(211, Short.MAX_VALUE))
		);

		txtNameProduct = new JTextField();
		txtNameProduct.setCaretColor(ColorBackground.colorLight);
		txtNameProduct.setForeground(Color.WHITE);
		txtNameProduct.setFont(new Font("Roboto", Font.BOLD, 14));
		txtNameProduct.setBorder(null);
		txtNameProduct.setOpaque(false);

		GroupLayout gl_panelTitle = new GroupLayout(panelTitle);
		gl_panelTitle.setHorizontalGroup(gl_panelTitle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTitle.createSequentialGroup().addContainerGap()
						.addComponent(txtNameProduct, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
						.addContainerGap()));
		gl_panelTitle.setVerticalGroup(gl_panelTitle.createParallelGroup(Alignment.LEADING).addComponent(txtNameProduct,
				GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE));
		panelTitle.setLayout(gl_panelTitle);
		setLayout(groupLayout);
		if(MainForm.mode == "Dark") {
			setColorModeDark();
			
		}else {
			setColorModeLight();
		}
		action();
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

		txtNameProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (MainForm.mode == "Dark") {
					panelTitle.setColorBackground(ColorBackground.colorGRB000);
					panelTitle.setColorClick(new Color(82,147,242));
				} else {
					panelTitle.setColorBackground(ColorBackground.colorLight);
					panelTitle.setColorClick(new Color(82,147,242));
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				if (MainForm.mode == "Dark") {
					panelTitle.setColorBackground(ColorBackground.colorGRB394348);
					panelTitle.setColorClick(ColorBackground.colorGRB394348);
				} else {
					panelTitle.setColorBackground(ColorBackground.colorGRB240242245);
					panelTitle.setColorClick(ColorBackground.colorGRB239239239);
				}
			}
		});
		

		btnBold.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtDescriber.setFont(new Font("Roboto", Font.BOLD, 14));
			}
		});

		btnItalic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtDescriber.setFont(new Font("Roboto", Font.ITALIC, 14));

			}

		});

		btnIUnderline.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				txtDescriber.setText("<html><u>" + txtDescriber.getText() + "</u></html>");

			}
		});

	}
	
	public void setColorModeDark() {
		setColor(ColorBackground.colorDark);
		lblTitle.setForeground(ColorBackground.colorLight);
		lblNameProduct.setForeground(ColorBackground.colorLight);
		lblDescriber.setForeground(ColorBackground.colorLight);
		
		panelTitle.setColorBackground(ColorBackground.colorGRB394348);
		
		txtNameProduct.setCaretColor(ColorBackground.colorLight);
		txtNameProduct.setForeground(ColorBackground.colorLight);
		panelTitle.setColorClick(ColorBackground.colorGRB394348);
		
		panelDescriber.setColorBackground(ColorBackground.colorGRB394348);
		panelDescriber.setColorClick(ColorBackground.colorGRB394348);
		btnBold.setIcon(iconBoldWhite);
		btnItalic.setIcon(iconItalicWhite);
		btnIUnderline.setIcon(iconUnderlineWhite);
		
		txtDescriber.setCaretColor(ColorBackground.colorLight);
		txtDescriber.setForeground(ColorBackground.colorLight);
		txtDescriber.setBackground(ColorBackground.colorGRB000);

	}
	
	public void setColorModeLight() {
		setColor(ColorBackground.colorLight);
		lblTitle.setForeground(ColorBackground.colorDark);
		lblNameProduct.setForeground(ColorBackground.colorGRB147147147);
		lblDescriber.setForeground(ColorBackground.colorGRB147147147);
		panelTitle.setColorBackground(ColorBackground.colorGRB239239239);
		txtNameProduct.setCaretColor(ColorBackground.colorDark);
		txtNameProduct.setForeground(ColorBackground.colorDark);
		panelTitle.setColorClick(ColorBackground.colorGRB239239239);
		
		
		panelDescriber.setColorBackground(ColorBackground.colorLight);
		panelDescriber.setColorClick(ColorBackground.colorGRB239239239);
		btnBold.setIcon(iconBoldBlack);
		btnItalic.setIcon(iconItalicBlack);
		btnIUnderline.setIcon(iconUnderlineBlack);
		
		txtDescriber.setCaretColor(ColorBackground.colorDark);
		txtDescriber.setForeground(ColorBackground.colorDark);
		txtDescriber.setBackground(ColorBackground.colorGRB239239239);

	}
	public String CheckNameProduct() {	
		String NameProduct=txtNameProduct.getText();
		if(NameProduct.length()==0) {
			lblertensanpham.setText("Xin nhập tên sản phẩm");
			return null;
		}else {
			lblertensanpham.setText("");
			return NameProduct;
		}
	}
	public String CheckDecribe() {
		String Des=txtDescriber.getText();
		if(Des.length()==0) {
			lblermotasanpham.setText("Xin nhập mô tả sản phẩm");
			return null;
		}else {
			lblermotasanpham.setText("");
			return Des;
		}
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
