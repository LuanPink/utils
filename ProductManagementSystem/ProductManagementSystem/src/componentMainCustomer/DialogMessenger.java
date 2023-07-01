package componentMainCustomer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class DialogMessenger extends JDialog {

	
	private PanelDialogMessenger panel;

	public DialogMessenger(JFrame parent) {
		super(parent,false);
		init();
		setBackground(new Color(0, 0, 0, 0));
		setPreferredSize(new Dimension(350, 430));
		
		
	}
	
	public void init() {
		setUndecorated(true);
		
		panel = new PanelDialogMessenger();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		pack();
	}
	
	public void closeDialog(ActionListener event) {
		panel.closeDialog(event);
	}
	

}
