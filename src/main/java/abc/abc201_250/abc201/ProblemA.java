package abc.abc201_250.abc201;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	/** 数字の数 */
	private static int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] a = IntStream.range(0, N).map(i -> scanner.nextInt()).sorted().toArray();
			System.out.println(((a[1] - a[0]) == (a[2] - a[1])) ? "Yes" : "No");
		}
	}
}
