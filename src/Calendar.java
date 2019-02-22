import java.util.Scanner;

public class Calendar {
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30 };

	public int TotalDaysOfaMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	public void printSimpeCalendar() {
		System.out.println(" =====  My Calendar  =====");
		System.out.println("  일    월     화      수     목     금   토 ");
		System.out.println(" 1   2   3    4   5   6  7");
		System.out.println(" 8   9  10   11  12  13 14");
		System.out.println("15  16  17   18  19  20 21");
		System.out.println("22  23  24   25  26  27 28");
	}

	public static void main(String[] args) {

		String PROMPT = "입력: ";
		Scanner sc = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 1;
		while (true) { // 무한루프

			System.out.println("달을 입력하세요.");
			System.out.print(PROMPT);
			month = sc.nextInt();
			if (month == -1 || month < 1) {

				System.out.println("-----------------");
				break;
			}
			if (month > 12) {
				continue;
			}
			System.out.printf("%d월은 %d일까지 있습니다.\n\n", month, cal.TotalDaysOfaMonth(month));
			System.out.println("-----------------");
		}
		System.out.println("캘린더를 종료합니다.");
		sc.close();
	}
}