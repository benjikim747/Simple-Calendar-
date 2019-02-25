import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

public class Calendar {

	private static final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30 };
	private static final int[] LEAP_MAX_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30 };

	private HashMap<Date, Schedules> planMap;

	public Calendar() {
		planMap = new HashMap<Date, Schedules>(); // 날짜로 플랜찾기
	}

	public void registerPlan(String strDate, String plan) {
		Schedules s = new Schedules(strDate, plan);
		planMap.put(s.getDate(), s);
	}

	public Schedules searchPlan(String strDate) {
		Date date = Schedules.getDatefromString(strDate);
		return planMap.get(date);
	}

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
	}

	public int TotalDaysOfaMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		} else {
			return MAX_DAYS[month];
		}
	}

	public void printCalendar(int year, int month) {
		System.out.printf("    << %4d년 %3d월 >>\n", year, month);
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
		System.out.println("---------------------------");

		// get weekday automatically
		int weekday = getWeekDay(year, month, 1);

		// print blank space
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}
		int maxDay = TotalDaysOfaMonth(year, month);
		int count = 7 - weekday;
		int delim = (count < 7) ? count : 0;
		/*
		 * int delim; if (count <7) { delim = count; }else{ delim = 0;
		 */

		// print the first line
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();

		// print from the second line til the last
		count++;
		for (int i = count; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == delim)
				System.out.println();
		}
		System.out.println();
		System.out.println();
	}

	private int getWeekDay(int year, int month, int day) {
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4; // Thursday.1st.Jan.1970

		int count = 0;

		for (int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 365 : 365;
			count += delta;
		}
		// System.out.println(count);
		for (int i = 1; i < month; i++) {
			int delta = TotalDaysOfaMonth(year, i);
			count += delta;
		}
		count += day - 1;

		int weekday = (count + STANDARD_WEEKDAY) % 7;
		return weekday;
	}

	public static void main(String[] args) throws ParseException {
		Calendar cal = new Calendar();
		cal.registerPlan("2019-02-23", "Watched Cold pursuit");
	}
}