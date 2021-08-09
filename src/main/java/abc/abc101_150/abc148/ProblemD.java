package abc.abc101_150.abc148;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int now = 1, answer = 0;
			for (int ai : a) {
				if (now == ai) {
					now++;
				} else {
					answer++;
				}
			}
			System.out.println((n == answer) ? -1 : answer);
		}
	}
}
