package componentSupplier;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
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
import java.util.Date;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import animation.AnimationButtonList;
import color.ColorBackground;
import componentCalender.CurrendarCustom;
import componentCalender.PanelDate;
import componentCalender.PanelDay;
import componentCalender.PanelMonth;
import componentCalender.PanelYear;
import componentCalender.SlideDate;

import javax.swing.LayoutStyle.ComponentPlacement;
import componentProduct.IconEditProduct;

public class PanelCalenderSupplier extends JPanel {
	Color color1 = ColorBackground.colorDark;
	Color color2 = new Color(207, 106, 119);
	public static SlideDate slide;
	public static int month;
	public static int year;
	public static JLabel lblMonthYear;
	public static int index = 0;
	private AnimationButtonList btnPrev;
	private AnimationButtonList btnNext;
	public static IconEditProduct btnClose;

	public static String option = "Day";

	public PanelCalenderSupplier() {
		setOpaque(false);
		slide = new SlideDate();
		slide.setOpaque(false);
		JPanel panel = new JPanel();
		panel.setOpaque(false);

		btnClose = new IconEditProduct((Icon) null);
		btnClose.setIcon(new ImageIcon(PanelCalenderSupplier.class.getResource("/icon/close.png")));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(btnClose,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING,
								groupLayout.createSequentialGroup().addGap(10)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(slide, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
												.addComponent(panel, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(5)
						.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(slide, GroupLayout.PREFERRED_SIZE, 221, Short.MAX_VALUE).addContainerGap()));

		btnNext = new AnimationButtonList(new ImageIcon(PanelCalenderSupplier.class.getResource("/icon/next.png")), "");
		btnNext.setBorder(null);

		lblMonthYear = new JLabel("April 2023");
		lblMonthYear.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblMonthYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblMonthYear.setForeground(ColorBackground.colorLight);
		lblMonthYear.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnPrev = new AnimationButtonList(new ImageIcon(PanelCalenderSupplier.class.getResource("/icon/back.png")), "");
		btnPrev.setBorder(null);
		btnPrev.setHorizontalTextPosition(SwingConstants.LEFT);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblMonthYear)
					.addPreferredGap(ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
					.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblMonthYear, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(btnNext, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnPrev, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		thisMonth();
		init();
		action();
	}

	public void thisMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		month = calendar.get(Calendar.MONTH) + 1;
		year = calendar.get(Calendar.YEAR);
	}
	
	

	public void action() {
		btnPrev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (option == "Day") {
					if (month == 1) {
						month = 12;
						year--;
					} else {
						month--;
					}
					slide.show(new PanelDay(month, year), SlideDate.AnimateType.TO_RIGHT);
					showMonthYear();
				} else if (option == "Month") {
					year--;
					slide.show(new PanelMonth(year), SlideDate.AnimateType.TO_RIGHT);
					showYear();
				} else if (option == "Year") {
					year = year - 10;
					slide.show(new PanelYear(year), SlideDate.AnimateType.TO_RIGHT);
					
				}
			}
		});

		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (option == "Day") {
					if(month==12) {
						month=1;
						year++;
					}else {
						month++;
					}
					slide.show(new PanelDay(month, year), SlideDate.AnimateType.TO_LEFT);
					showMonthYear();
				} else if (option == "Month") {
					year++;
					slide.show(new PanelMonth(year), SlideDate.AnimateType.TO_LEFT);
					showYear();
				} else if (option == "Year") {
					year = year + 10;
					slide.show(new PanelYear(year), SlideDate.AnimateType.TO_LEFT);
					
				}
			}
		});

		lblMonthYear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index++;
				if (index == 1) {
					// show month
					lblMonthYear.setText(year + "");
					slide.show(new PanelMonth(year), SlideDate.AnimateType.TO_LEFT);
					option = "Month";
				} else if (index == 2) {
					// show year
					option = "Year";
					slide.show(new PanelYear(year), SlideDate.AnimateType.TO_LEFT);
					
				}
			}
		});
	}
	
	public static void showMonthYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH,month-1);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DATE,1);
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
		lblMonthYear.setText(sdf.format(calendar.getTime()));
	}
	
	public static void showYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		lblMonthYear.setText(sdf.format(calendar.getTime()));
	}

	void init() {
		slide.show(new PanelDay(month, year), SlideDate.AnimateType.TO_RIGHT);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color2);
		g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		g2.setColor(color1);
		g2.fillRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 15, 15);

		super.paintComponent(g);
	}
}
