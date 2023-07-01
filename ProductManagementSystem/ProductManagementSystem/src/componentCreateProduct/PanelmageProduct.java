package componentCreateProduct;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import color.ColorBackground;
import componentProduct.PanelCustomers;
import view.MainForm;
import view.PanelMode;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class PanelmageProduct extends JPanel {

	private Color color = new Color(26, 29, 31);
	private Color color1 = new Color(0,0,0);
	private Color color2 = new Color(252,252,252);
	private PanelTitle panel;
	private ButtonLoadImage btnChooseImage;
	private JLabel lblImage;
	private JLabel lblTitle;
	private String path="";
	private Icon iconDownWhite = new ImageIcon(PanelmageProduct.class.getResource("/icon/down-white.png"));
	private Icon iconDownBlack = new ImageIcon(PanelmageProduct.class.getResource("/icon/down-black.png"));
	private JLabel lblerimg;
	private JLabel lblhinhanh;
	
	public PanelmageProduct() {
		setBorder(null);
		setOpaque(false);
		
		lblTitle = new JLabel("Hình ảnh & CTA");
		lblTitle.setForeground(new Color(252, 252, 252));
		lblTitle.setFont(new Font("Roboto", Font.BOLD, 18));
		
		lblImage = new JLabel("Hình ảnh");
		lblImage.setForeground(new Color(252, 252, 252));
		lblImage.setFont(new Font("Roboto", Font.BOLD, 14));
		
		panel = new PanelTitle();
		
		lblerimg = new JLabel("");
		lblerimg.setForeground(new Color(255, 0, 0));
		lblerimg.setFont(new Font("Dialog", Font.ITALIC, 12));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblerimg, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
						.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
						.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblerimg, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(329, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		btnChooseImage = new ButtonLoadImage("Chọn hoặc xóa hình ảnh"); 
		btnChooseImage.setBounds(330, 80, 196, 24);
		btnChooseImage.setIcon(iconDownWhite);
		panel.add(btnChooseImage);
		
		lblhinhanh = new JLabel("");
		lblhinhanh.setBounds(187, 10, 556, 160);
		panel.add(lblhinhanh);
		setLayout(groupLayout);
		if(MainForm.mode == "Dark") {
			setColorModeDark();
		}else {
			setColorModeLight();
		}
		action();
	}
	
	public void action() {
		btnChooseImage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChoose = new JFileChooser();
				fileChoose.setFileFilter(new javax.swing.filechooser.FileFilter() {
					
					@Override
					public String getDescription() {
						return "Image File (*.jpg)";
					}
					
					@Override
					public boolean accept(File f) {
						if(f.isDirectory()) {
							
							return true;
						}else {
							
						    return f.getName().toLowerCase().endsWith(".jpg");
						    
						}
						
					}
				});
				
				if(fileChoose.showOpenDialog(null)==JFileChooser.CANCEL_OPTION) {
					return ;
				}else {
					File file=fileChoose.getSelectedFile();
					path=file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(File.separator));
					ImageIcon icon=new ImageIcon(file.getAbsolutePath());
					Image image=icon.getImage().getScaledInstance(lblhinhanh.getWidth(),lblhinhanh.getHeight() ,Image.SCALE_SMOOTH);
					ImageIcon icon2=new ImageIcon(image);
					lblhinhanh.setIcon(icon2);
					
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
	}
	
	public void setColorModeDark() {
		setColor(ColorBackground.colorDark);
		panel.setColorBackground(ColorBackground.colorGRB394348);
		btnChooseImage.setForeground(ColorBackground.colorLight);
		
		lblTitle.setForeground(ColorBackground.colorLight);
		lblImage.setForeground(ColorBackground.colorLight);
		
		btnChooseImage.setColorBackground(ColorBackground.colorDark);
		btnChooseImage.setIcon(iconDownWhite);
	}
	
	public void setColorModeLight() {
		setColor(ColorBackground.colorLight);
		panel.setColorBackground(ColorBackground.colorGRB239239239);
		btnChooseImage.setForeground(ColorBackground.colorGRB147147147);
		
		lblTitle.setForeground(ColorBackground.colorDark);
		lblImage.setForeground(ColorBackground.colorGRB147147147);
		
		btnChooseImage.setColorBackground(ColorBackground.colorLight);
		btnChooseImage.setIcon(iconDownBlack);
		
	}
	public String PathImg() {
		if(path=="") {
			lblerimg.setText("Xin chọn hình ảnh");
			
		}else {
			lblerimg.setText("");
			return path;
		}
		return null;
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
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
