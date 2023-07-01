package componentCalender;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import color.ColorBackground;
import componentEmployee.PanelAddEmployee;

public class CellDay extends JButton {
	Color color = ColorBackground.colorDark;
	private Date date;
	private boolean title;
	private boolean isToday;
	int day;
	int month;
	int year;
	public CellDay() {
		setContentAreaFilled(false);
		setBorder(null);
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("SansSerif", Font.PLAIN, 14));
		setFocusPainted(false);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (!title) {
					color = new Color(147, 147, 147);
					repaint();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!title) {
					color = ColorBackground.colorDark;
					repaint();
				}
			}
		});
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				String d = getDay()+"";
				if(d.length()<2) {
					d = "0"+d;
				}
				
				String m = getMonth()+"";
				if(m.length()<2) {
					m = "0"+m;
				}
				PanelAddEmployee.txtDate.setText(getYear()+"-"+m+"-"+d);
			}
		});

	}

	public void asTitle() {
		setForeground(new Color(255, 255, 255));
		title = true;
	}

	public boolean isTitle() {
		return title;
	}

	public void setDateTime(Date date) {
		this.date = date;
	}

	public void setAsDay() {
		isToday = true;
		setForeground(Color.WHITE);
	}

	public void currenMonth(boolean act) {
		if (act) {
			setForeground(new Color(255, 255, 255));

		} else {
			setForeground(new Color(100, 100, 100));

		}
	}
	

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (isToday) {
			g2.setColor(new Color(207, 106, 119));
			g2.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
		}
		g2.setColor(color);
		g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

		super.paintComponent(g);
	}

}
