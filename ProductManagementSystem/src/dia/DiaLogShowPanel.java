package dia;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import componentEmployee.PanelAddEmployee;
import model.ModelEmployee;
import net.miginfocom.swing.MigLayout;

public class DiaLogShowPanel extends JDialog {

	private JPanel panel;

	public DiaLogShowPanel(JFrame parent) {
		super(parent,false);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));
		init();
		setPreferredSize(new Dimension(820, 580));
		pack();	
	}
	
	public void init() {
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new MigLayout("fill,insets 0"));
		getContentPane().add(panel);
	}

	public void showForm(JComponent com) {
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
		panel.add(com);
	}
	
}
