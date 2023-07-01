package view;

import java.awt.*;

import javax.swing.*;

import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;

public class DialogMessage extends JDialog {

	private String title;
	private int w;
	private PanelMessageDialog panel;

	public DialogMessage(JFrame parent, String title,int width) {
		super(parent, false);
		this.title = title;
		this.w = width;
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));
		init();

		setPreferredSize(new Dimension(w, 160));
		pack();
	}

	public void init() {
		panel = new PanelMessageDialog(title);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, w, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(48, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);
	}

	public void setBackgroundDialog(Color color1, Color color2, Color color3) {
		panel.setColor(color1);
		panel.setColor2(color2);
		panel.getLblTitle().setForeground(color3);
	}

}
