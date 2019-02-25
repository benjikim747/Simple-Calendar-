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
				cmdRegister(sc, cal);
				break;
			case "3":
				cmdRegister(sc, cal);
				break;
			case "4":
				cmdRegister(sc, cal);
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
		System.out.println("날짜를 입력해주세요(yyyy-mm-dd).");
		String date = sc.next();
		String plan = "";
		try {
			plan = cal.searchPlan(date);
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println("일정 검색 중 오류가 발생했습니다.");
		}
		System.out.println(plan);
	}

	private void cmdRegister(Scanner sc, Calendar cal) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해주세요 (yyyy-mm-dd).");
		String date = sc.next();
		String text = "";
		System.out.println("일정을 입력해주세요.(문자의 끝에 ;을 입력해주세요.)");

		while (true) {
			String word = sc.next();
			text += word + "";
			if (word.endsWith(";")) {
				break;
			}
		}
		cal.registerPlan(date, text);
	}

	public static void main(String[] args) throws ParseException {
		// 셀입력
		Prompt p = new Prompt();
		p.runPrompt();
	}
}