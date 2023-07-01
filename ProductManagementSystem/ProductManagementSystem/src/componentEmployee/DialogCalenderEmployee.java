package componentEmployee;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class DialogCalenderEmployee extends JDialog {

	public DialogCalenderEmployee(JFrame parent) {
		super(parent, false);
		init();
		setBackground(new Color(0, 0, 0, 0));
		setPreferredSize(new Dimension(400, 200));

	}

	public void init() {
		setUndecorated(true);
		PanelCalenderEmployee panel = new PanelCalenderEmployee();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE).addContainerGap()));
		getContentPane().setLayout(groupLayout);
		pack();
	}
}
