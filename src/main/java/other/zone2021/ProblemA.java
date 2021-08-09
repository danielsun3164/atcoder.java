package other.zone2021;

import java.util.Scanner;

public class ProblemA {

	/** 検索対象文字 */
	private static final String ZONE = "ZONe";

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			int index = 0, count = 0;
			while ((index = s.indexOf(ZONE, index)) >= 0) {
				count++;
				index++;
			}
			System.out.println(count);
		}
	}
}
