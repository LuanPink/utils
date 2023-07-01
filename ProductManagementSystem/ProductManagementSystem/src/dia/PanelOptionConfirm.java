package dia;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import color.ColorBackground;
import componentCreateProduct.ButtonCheckedSizeAndColor;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import animation.TextField;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelOptionConfirm extends JPanel {
	private Color color = ColorBackground.colorGRB171921;
	public JTextField text;
	public JLabel lblTitle;
	public JLabel lblContent;
	public ButtonCheckedSizeAndColor btnOK;
	public ButtonCheckedSizeAndColor btnCancel;
	int cursor = -1;
	public PanelOptionConfirm() {
		setOpaque(false);
		lblTitle = new JLabel();
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(252, 252, 252));
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 16));

		lblContent = new JLabel();
		lblContent.setHorizontalAlignment(SwingConstants.LEFT);
		lblContent.setForeground(new Color(252, 252, 252));
		lblContent.setFont(new Font("Dialog", Font.BOLD, 14));

		text = new JTextField();
		text.setForeground(new Color(252, 252, 252));
		text.setBackground(ColorBackground.colorDark);
		text.setFont(new Font("Roboto", Font.PLAIN, 14));
		text.setCaretColor(new Color(252, 252, 252));
		text.setBorder(null);

		btnOK = new ButtonCheckedSizeAndColor(0);
		btnOK.setText("OK");
		btnOK.setForeground(new Color(252, 252, 252));
		btnOK.setFont(new Font("Roboto", Font.PLAIN, 14));

		btnCancel = new ButtonCheckedSizeAndColor(0);
		btnCancel.setText("Hủy");
		btnCancel.setForeground(new Color(252, 252, 252));
		btnCancel.setFont(new Font("Roboto", Font.PLAIN, 14));	

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
								.addComponent(lblContent, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
								.addComponent(text, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(88)
							.addComponent(btnOK, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblContent, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(text, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOK, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		action();
	}
	
	public void action() {
		
		text.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				cursor = text.getCaretPosition();
				System.out.println(cursor);
			}
		});
		
		
		
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}else {
					if(cursor==0 && c == '0') {
						e.consume();
					}
				}
			
			}
			
			
			
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		super.paintComponent(g);
	}
}
