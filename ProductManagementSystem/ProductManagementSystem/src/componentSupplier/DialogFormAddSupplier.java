package componentSupplier;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import model.ModelEmployee;
import model.ModelSupplier;

public class DialogFormAddSupplier extends JDialog {
	
	private ModelSupplier employee;
	
	public DialogFormAddSupplier(JFrame parent,ModelSupplier employee) {
		super(parent,true);
		this.employee = employee;
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));
		init();
		setPreferredSize(new Dimension(820, 600));
		pack();	
	}
	
	public void init() {
		PanelAddSupplier panel = new PanelAddSupplier(employee);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
	}
	

}
