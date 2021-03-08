package abc.abc101_150.abc141;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProblemA {

	/** 天気の文字列の一覧 */
	private static final List<String> WEATHERS = Arrays.asList("Sunny", "Cloudy", "Rainy");

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			System.out.println(WEATHERS.get((WEATHERS.indexOf(s) + 1) % WEATHERS.size()));
		}
	}
}
