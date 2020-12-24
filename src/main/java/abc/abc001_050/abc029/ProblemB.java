package abc.abc001_050.abc029;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 入力文字列数 */
	private static final int SIZE = 12;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(
					IntStream.range(0, SIZE).mapToObj(i -> scanner.next()).filter(s -> s.contains("r")).count());
		}
	}
}
