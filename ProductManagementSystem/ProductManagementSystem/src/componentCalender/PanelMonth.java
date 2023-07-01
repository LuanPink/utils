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

public class PanelMonth extends JPanel {
	private CellMonth cell1;
	private CellMonth cell2;
	private CellMonth cell3;
	private CellMonth cell4;
	private CellMonth cell5;
	private CellMonth cell6;
	private CellMonth cell7;
	public CellMonth cell8;
	public CellMonth cell9;
	public CellMonth cell10;
	public CellMonth cell11;
	public CellMonth cell12;
	public CellMonth cell13;
	public CellMonth cell14;
	public CellMonth cell15;
	public CellMonth cell16;
	int index = 1;
	int year;

	public PanelMonth(int year) {
		this.year = year;
		setLayout(new GridLayout(4, 4, 0, 0));
		setBackground(ColorBackground.colorDark);
		cell1 = new CellMonth();
		add(cell1);

		cell2 = new CellMonth();
		add(cell2);

		cell3 = new CellMonth();
		add(cell3);

		cell4 = new CellMonth();
		add(cell4);

		cell5 = new CellMonth();
		add(cell5);

		cell6 = new CellMonth();
		add(cell6);

		cell7 = new CellMonth();
		add(cell7);

		cell8 = new CellMonth();
		add(cell8);

		cell9 = new CellMonth();
		add(cell9);

		cell10 = new CellMonth();
		add(cell10);

		cell11 = new CellMonth();
		add(cell11);

		cell12 = new CellMonth();
		add(cell12);

		cell13 = new CellMonth();
		add(cell13);

		cell14 = new CellMonth();
		add(cell14);

		cell15 = new CellMonth();
		add(cell15);

		cell16 = new CellMonth();
		add(cell16);
		init();
	}

	public void init() {
		setMonth();
	}

	public void setMonth() {
		Calendar calendar = Calendar.getInstance();
		Today today = getToday();

		for (int month = Calendar.JANUARY; month <= Calendar.DECEMBER; month++) {
			calendar.set(year, month, 1);
			String mth = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
			String MONTH = mth.substring(0, 3);
			CellMonth cell = (CellMonth) getComponents()[month];
			cell.setMonth(calendar.get(Calendar.MONTH));
			cell.setText(MONTH);
			cell.setYear(year);
			cell.currenYear(true);
			if (month == Calendar.DECEMBER) {
				for (int i = 0; i < 4; i++) {
					calendar.set(year + 1, i , 1);
					String mth2 = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		            String MONTH2 = mth2.substring(0, 3);
		            
		            CellMonth cell2 = (CellMonth) getComponents()[12 + i];
		            cell2.setMonth(calendar.get(Calendar.MONTH));
		            cell2.setText(MONTH2);
		            cell2.setYear(year + 1);
		            cell2.currenYear(false);
		            
		        
				}	
			}
			
            if (today.isTodayMonth(new Today(mth)) && year == getTodayYear()) {
				cell.setAsDay();
			}
			
		}

	}
	
	public int getTodayYear() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR);
	}

	public Today getToday() {
		Calendar calendar = Calendar.getInstance();
		String mth = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		return new Today(mth);
	}
}
