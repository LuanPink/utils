package componentDoiHang;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class LabelSP extends JLabel {

	
	public LabelSP(String text) {
		setText(text);
		setFont(new Font("Roboto",Font.BOLD,16));
		setForeground(new Color(207,106,119));
		
	}

}
