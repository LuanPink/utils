package componentCalender;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import color.ColorBackground;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

public class PanelDay extends JPanel {

	private CellDay sun;
	private CellDay mon;
	private CellDay tue;
	private CellDay wed;
	private CellDay thu;
	private CellDay fri;
	private CellDay sat;
	public CellDay cell8;
	public CellDay cell9;
	public CellDay cell10;
	public CellDay cell11;
	public CellDay cell12;
	public CellDay cell13;
	public CellDay cell14;
	public CellDay cell15;
	public CellDay cell16;
	public CellDay cell17;
	public CellDay cell18;
	public CellDay cell19;
	public CellDay cell20;
	public CellDay cell21;
	public CellDay cell22;
	public CellDay cell23;
	public CellDay cell24;
	public CellDay cell25;
	public CellDay cell26;
	public CellDay cell27;
	public CellDay cell28;
	public CellDay cell29;
	public CellDay cell30;
	public CellDay cell31;
	public CellDay cell32;
	public CellDay cell33;
	public CellDay cell34;
	public CellDay cell35;
	public CellDay cell36;
	public CellDay cell37;
	public CellDay cell38;
	public CellDay cell39;
	public CellDay cell40;
	public CellDay cell41;
	public CellDay cell42;
	public CellDay cell43;
	public CellDay cell44;
	public CellDay cell45;
	public CellDay cell46;
	public CellDay cell47;
	public CellDay cell48;
	public CellDay cell49;
	
	private int month;
	private int year;

	public PanelDay(int month , int year) {
		this.month = month;
		this.year = year;
		
		setLayout(new GridLayout(7, 7, 0, 0));
		setBackground(ColorBackground.colorDark);
		sun = new CellDay();
		sun.setText("Su");
		add(sun);


		mon = new CellDay();
		mon.setText("Mo");
		add(mon);


		tue = new CellDay();
		tue.setText("Tu");
		add(tue);

		wed = new CellDay();
		wed.setText("We");
		add(wed);


		thu = new CellDay();
		thu.setText("Th");
		add(thu);


		fri = new CellDay();
		fri.setText("Fr");
		add(fri);


		sat = new CellDay();
		sat.setText("Sa");
		add(sat);


		cell8 = new CellDay();
		add(cell8);
	

		cell9 = new CellDay();
		add(cell9);
		

		cell10 = new CellDay();
		add(cell10);
		

		cell11 = new CellDay();
		add(cell11);
		

		cell12 = new CellDay();
		add(cell12);
		

		cell13 = new CellDay();
		add(cell13);
	

		cell14 = new CellDay();
		add(cell14);
		

		cell15 = new CellDay();
		add(cell15);
		

		cell16 = new CellDay();
		add(cell16);
		

		cell17 = new CellDay();
		add(cell17);
		

		cell18 = new CellDay();
		add(cell18);
		

		cell19 = new CellDay();
		add(cell19);
		

		cell20 = new CellDay();
		add(cell20);
		

		cell21 = new CellDay();
		add(cell21);
		

		cell22 = new CellDay();
		add(cell22);
		

		cell23 = new CellDay();
		add(cell23);
		

		cell24 = new CellDay();
		add(cell24);
		

		cell25 = new CellDay();
		add(cell25);
		

		cell26 = new CellDay();
		add(cell26);
		

		cell27 = new CellDay();
		add(cell27);
		

		cell28 = new CellDay();
		add(cell28);
		

		cell29 = new CellDay();
		add(cell29);
		

		cell30 = new CellDay();
		add(cell30);
		

		cell31 = new CellDay();
		add(cell31);
		

		cell32 = new CellDay();
		add(cell32);
		

		cell33 = new CellDay();
		add(cell33);
		

		cell34 = new CellDay();
		add(cell34);
		

		cell35 = new CellDay();
		add(cell35);
		

		cell36 = new CellDay();
		add(cell36);
		

		cell37 = new CellDay();
		add(cell37);
		

		cell38 = new CellDay();
		add(cell38);
		

		cell39 = new CellDay();
		add(cell39);
		

		cell40 = new CellDay();
		add(cell40);
		

		cell41 = new CellDay();
		add(cell41);
		

		cell42 = new CellDay();
		add(cell42);
		

		cell43 = new CellDay();
		add(cell43);
		

		cell44 = new CellDay();
		add(cell44);
		

		cell45 = new CellDay();
		add(cell45);
	

		cell46 = new CellDay();
		add(cell46);
		

		cell47 = new CellDay();
		add(cell47);
	

		cell48 = new CellDay();
		add(cell48);
	

		cell49 = new CellDay();
		add(cell49);

		
		
		
		init();

	}
	

	public void init() {
		mon.asTitle();
		tue.asTitle();
		wed.asTitle();
		thu.asTitle();
		fri.asTitle();
		sat.asTitle();
		sun.asTitle();
		setDate();
	}
	
	public void setDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.YEAR,year);
		calendar.set(calendar.MONTH, month - 1);
		calendar.set(calendar.DATE, 1);
		int startDay = calendar.get(calendar.DAY_OF_WEEK) - 1;
		calendar.add(calendar.DATE, - startDay);

		Today today = getToday();
		for(Component com : getComponents()) {
			CellDay cell = (CellDay) com;
			if(!cell.isTitle()) {
				cell.setText(calendar.get(calendar.DATE) + "");
				cell.setDateTime(calendar.getTime());	
				cell.currenMonth(calendar.get(calendar.MONTH) == month -1);
				cell.setDay(calendar.get(calendar.DATE));
				cell.setMonth(calendar.get(calendar.MONTH)+1);
				cell.setYear(calendar.get(calendar.YEAR));		
				if(today.isToday(new Today(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR)))) {
					cell.setAsDay();
				}
				calendar.add(Calendar.DATE, 1);
			}
		}
	}
	
	private Today getToday() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return new Today(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
	}
}
