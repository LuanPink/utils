package componentCalender;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;

import color.ColorBackground;
import componentEmployee.PanelCalenderEmployee;

public class CellYear extends JButton {
	private boolean isToday;
	Color color = ColorBackground.colorDark;
	int year;
	int month;
	public CellYear() {
		setContentAreaFilled(false);
		setBorder(null);
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("SansSerif", Font.PLAIN, 14));
		setFocusPainted(false);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				color = new Color(147,147,147);
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				color = ColorBackground.colorDark;
				repaint();
			}
		});
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelCalenderEmployee.slide.show(new PanelMonth(getYear()), SlideDate.AnimateType.TO_RIGHT);
				PanelCalenderEmployee.year = getYear();
				PanelCalenderEmployee.index = 1;
				PanelCalenderEmployee.option = "Month";
				PanelCalenderEmployee.showYear();
			}
		});
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setAsDay() {
		isToday = true;
		setForeground(Color.WHITE);
	}

	public void currenYear(boolean act) {
		if (act) {
			setForeground(new Color(255, 255, 255));
		} else {
			setForeground(new Color(100, 100, 100));

		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (isToday) {
			g2.setColor(new Color(207, 106, 119));
			g2.fillRect(1, 1, getWidth()-2, getHeight()-2);
		}
		
		g2.setColor(color);
		g2.drawRect(0, 0, getWidth()-1, getHeight()-1);
		
		super.paintComponent(g);
	}

}
