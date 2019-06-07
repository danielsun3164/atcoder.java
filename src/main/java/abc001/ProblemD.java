package abc001;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * メモリー超過対策として、scanner.nextLine()をscanner.next()に置き換え
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			boolean[] moments = new boolean[289];
			Arrays.fill(moments, false);
			int n = scanner.nextInt();
			IntStream.range(0, n).forEach(i -> {
				String string = scanner.next();
				Arrays.fill(moments, floor(string), ceil(string), true);
			});
			output(moments);
		}
	}

	private static int floor(String string) {
		int number = Integer.parseInt(string.substring(0, 4));
		int hour = number / 100;
		int minute = (number % 100) / 5;
		return hour * 12 + minute;
	}

	private static int ceil(String string) {
		int number = Integer.parseInt(string.substring(5, 9));
		int hour = number / 100;
		int minute = ((number % 100) + 4) / 5;
		return hour * 12 + minute;
	}

	private static void output(boolean[] moments) {
		boolean findStart = true;
		for (int i = 0; i < moments.length; i++) {
			if (findStart && moments[i]) {
				findStart = false;
				printTime(i);
				System.out.print("-");
			} else if (!findStart && !moments[i]) {
				printTime(i);
				System.out.println();
				findStart = true;
			}
		}
	}

	private static void printTime(int number) {
		int hour = number / 12;
		int minute = (number % 12) * 5;
		System.out.printf("%02d%02d", hour, minute);
	}
}
