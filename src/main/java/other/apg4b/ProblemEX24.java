package other.apg4b;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ProblemEX24 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int hour = scanner.nextInt();
			int minute = scanner.nextInt();
			int second = scanner.nextInt();
			int diffSecond = scanner.nextInt();
			LocalTime localTime = LocalTime.of(hour, minute, second);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
			System.out.println(dtf.format(localTime));
			LocalTime localTime2 = localTime.plusSeconds(diffSecond);
			System.out.println(dtf.format(localTime2));
		}
	}
}
