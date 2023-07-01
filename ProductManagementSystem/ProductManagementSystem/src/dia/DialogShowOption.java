package dia;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class DialogShowOption extends JDialog {

	private JPanel panel;

	public DialogShowOption(JFrame parent) {
		super(parent,false);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));
		init();
		setPreferredSize(new Dimension(300, 140));
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
