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
		printMenu();
		Scanner sc = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		while (true) {
			System.out.println("명령( 1, 2, 3, h, q)");
			String cmd =sc.next();
			if(cmd.equals("1")) {
				cmdRegister();
			}else if(cmd.equals("2")) cmdSearch();
			else if(cmd.equals("3")) cmdCal(sc, cal);
			else if(cmd.equals("h")) printMenu();
			else if(cmd.equals("q")) break;
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
	private void cmdSearch() {
		// TODO Auto-generated method stub
		
	}

	private void cmdRegister() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// 셀입력
		Prompt p = new Prompt();
		p.runPrompt();

	}
}