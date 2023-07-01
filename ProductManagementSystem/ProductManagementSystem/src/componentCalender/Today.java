package componentCalender;

public class Today {
	private int day;
	private int month;
	private int year;
	
	private String MONTH;
	private int YEAR;
	
	
	
	public String getMONTH() {
		return MONTH;
	}
	public void setMONTH(String mONTH) {
		MONTH = mONTH;
	}
	
	
	
	public int getYEAR() {
		return YEAR;
	}
	public void setYEAR(int yEAR) {
		YEAR = yEAR;
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
	
	
	
	public Today(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public Today(String month) {
		super();
		this.MONTH = month;
	}
	
	public Today(int year) {
		super();
		this.year = year;
	}
	
	public Today() {
		
	}
	
	public boolean isToday(Today date) {
		return day==date.getDay() && month == date.getMonth() && year == date.getYear();
	}
	
	public boolean isTodayMonth(Today date) {
		return MONTH == date.getMONTH();
	}
	
	public boolean isTodayYear(Today date) {
		return YEAR == date.getYear();
	}
}
