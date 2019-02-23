import java.util.Scanner;

public class Prompt {
	/**
	 * 
	 * @param week 요일명
	 * @return 0~6 (0 = Sunday, 6 = Saturday)
	 */
	public int parseDay(String week) {
		if (week.equals("일"))
			return 0;
		else if (week.equals("월"))
			return 1;
		else if (week.equals("화"))
			return 2;
		else if (week.equals("수"))
			return 3;
		else if (week.equals("목"))
			return 4;
		else if (week.equals("금"))
			return 5;
		else if (week.equals("토"))
			return 6;
		else
			return 0;
	}

	public void runPrompt() {
		Scanner sc = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 1;
		int year = 2019;
		int weekday = 0;

		while (true) {
			System.out.println("연도를 입력하세요");
			System.out.print("YEAR> ");
			year = sc.nextInt();
			System.out.println("달을 입력하세요");
			System.out.print("MONTH> ");
			month = sc.nextInt();
			System.out.println("첫째 날의 요일을 입력하세요(일, 월, 화, 수, 목, 금, 토).");
			System.out.print("> ");
			String str_weekday = sc.next();
			weekday = parseDay(str_weekday);
			System.out.println(str_weekday + "," + weekday);

			if (month == -1) {
				break;
			}
			if (month > 12) {
				continue;
			}
			cal.printCalendar(year, month, weekday);
		}
		System.out.println("캘린더를 종료합니다.");
		sc.close();
	}

	public static void main(String[] args) {
		// 셀입력
		Prompt p = new Prompt();
		p.runPrompt();

	}
}