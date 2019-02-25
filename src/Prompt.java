import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
	public void printMenu() {
		System.out.println(" +----------------------+");
		System.out.println(" | 1.일정등록      ");
		System.out.println(" | 2.일정검색      ");
		System.out.println(" | 3.달력보기      ");
		System.out.println(" | h.도움말  q.종료      ");
		System.out.println(" +----------------------+");
	}

	/**
	 * 
	 * @param week 요일명
	 * @return 0~6 (0 = Sunday, 6 = Saturday)
	 */
	public int parseDay(String week) {
		switch (week) {
		case "sun":
			return 0;
		case "mon":
			return 1;
		case "tue":
			return 2;
		case "wed":
			return 3;
		case "thu":
			return 4;
		case "fri":
			return 5;
		case "sat":
			return 6;
		default:
			return 0;
		}
	}

	public void runPrompt() throws ParseException {
		printMenu();
		
		Scanner sc = new Scanner(System.in);
		Calendar cal = new Calendar();

		boolean isLoop = true;
		
		while (isLoop) {
			System.out.println("명령( 1, 2, 3, h, q)");
			String cmd = sc.next();

			switch (cmd) {
			case "1":
				cmdRegister(sc, cal);
				break;
			case "2":
				cmdSearch(sc, cal);
				break;
			case "3":
				cmdCal(sc, cal);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				isLoop = false;
				break;
			}
		}
		System.out.println("캘린더를 종료합니다.");
		sc.close();
	}

	private void cmdCal(Scanner sc, Calendar cal) {
		int month = 1;
		int year = 2019;
		System.out.println("연도를 입력하세요.");
		System.out.print("YEAR> ");
		year = sc.nextInt();

		System.out.println("달을 입력하세요.");
		System.out.print("MONTH> ");
		month = sc.nextInt();

		if (month > 12 || month < 1) {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		cal.printCalendar(year, month);
	}

	private void cmdSearch(Scanner sc, Calendar cal) {
		System.out.println("[일정검색]");
		System.out.println("날짜를 입력해주세요(yyyy-MM-dd).");
		String date = sc.next();
		Schedules plan;
		plan = cal.searchPlan(date);

		if (plan != null) {
			System.out.println(plan.detail);
		} else {
			System.out.println("일정이 없습니다.");
		}
	}

	private void cmdRegister(Scanner sc, Calendar cal) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해주세요 (yyyy-MM-dd).");
		String date = sc.next();
		String text = "";
		System.out.println("일정을 입력해 주세요.(끝문자 = ;)"); 
		
		String word;
		while(!(word = sc.next()).endsWith(";")) {
			text += word +" ";
		}
		word = word.replace(";", "");
		text += word;
		cal.registerPlan(date, text);
	}

	public static void main(String[] args) throws ParseException {
		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();
	}
}