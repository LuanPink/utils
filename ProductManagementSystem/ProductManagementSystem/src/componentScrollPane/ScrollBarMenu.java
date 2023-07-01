package componentScrollPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JScrollBar;
import javax.swing.UIManager;

import color.ColorBackground;
import view.PanelMode;

public class ScrollBarMenu extends JScrollBar {
	ModelScrollBarUIMenu scrollPane;

	public ScrollBarMenu() {
		scrollPane = new ModelScrollBarUIMenu();
		setUI(scrollPane);
		setPreferredSize(new Dimension(4, 8));
		setUnitIncrement(50);
		action();
	}

	public void action() {
		PanelMode.actionButonModeDark(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				scrollPane.setColor1(ColorBackground.colorDark);
				scrollPane.setColor2(ColorBackground.colorGRB200200200);
				
			}
		});

		PanelMode.actionButonModeLight(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				scrollPane.setColor1(ColorBackground.colorLight);
				scrollPane.setColor2(ColorBackground.colorGRB147147147);
			}
		});
	}

}
