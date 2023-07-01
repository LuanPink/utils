package componentCalender;

import java.awt.Component;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import javax.swing.JPanel;

import color.ColorBackground;
import componentEmployee.PanelCalenderEmployee;

public class PanelYear extends JPanel {
	private CellYear cell1;
	private CellYear cell2;
	private CellYear cell3;
	private CellYear cell4;
	private CellYear cell5;
	private CellYear cell6;
	private CellYear cell7;
	public CellYear cell8;
	public CellYear cell9;
	public CellYear cell10;
	public CellYear cell11;
	public CellYear cell12;
	public CellYear cell13;
	public CellYear cell14;
	public CellYear cell15;
	public CellYear cell16;
	int index = 1;
	int year;

	public PanelYear(int year) {
		this.year = year;
		setLayout(new GridLayout(4, 4, 0, 0));
		setBackground(ColorBackground.colorDark);
		cell1 = new CellYear();
		add(cell1);

		cell2 = new CellYear();
		add(cell2);

		cell3 = new CellYear();
		add(cell3);

		cell4 = new CellYear();
		add(cell4);

		cell5 = new CellYear();
		add(cell5);

		cell6 = new CellYear();
		add(cell6);

		cell7 = new CellYear();
		add(cell7);

		cell8 = new CellYear();
		add(cell8);

		cell9 = new CellYear();
		add(cell9);

		cell10 = new CellYear();
		add(cell10);

		cell11 = new CellYear();
		add(cell11);

		cell12 = new CellYear();
		add(cell12);

		cell13 = new CellYear();
		add(cell13);

		cell14 = new CellYear();
		add(cell14);

		cell15 = new CellYear();
		add(cell15);

		cell16 = new CellYear();
		add(cell16);
		init();
	}

	public void init() {
		setYear();
	}

	public void setYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.YEAR, year);
		int currentYear = calendar.get(calendar.YEAR);
		int lastDigit = currentYear % 10;
		int yearStart = currentYear - lastDigit;
		int yearEnd =0;
		int year;
		Today today = getToday();
		for (int i = 0; i < 16; i++) {
			CellYear cell = (CellYear) getComponents()[i];
			if(i<10) {
				year = yearStart + i;
				cell.setText(year+"");
				cell.setYear(year);
				cell.currenYear(true);
				yearEnd = year;
			}else {
				year = yearStart + i;
				cell.setText(year+"");
				cell.setYear(year);
				cell.currenYear(false);
			}
			
			
			if(today.isToday(new Today(year))) {
				cell.setAsDay();
			}
		}
		
		PanelCalenderEmployee.lblMonthYear.setText(yearStart +" - "+yearEnd);

	}

	public Today getToday() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return new Today(calendar.get(calendar.YEAR));
	}
}
