package abc.abc089;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 数値を英語の数字に変換するための配列 */
	private static final String[] NUMBERS = { "", "One", "Two", "Three", "Four" };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(NUMBERS[(int) IntStream.range(0, n).mapToObj(i -> scanner.next()).distinct().count()]);
		}
	}
}
