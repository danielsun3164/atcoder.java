package abc.abc151_200.abc152;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] p = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int min = p[0], answer = 1;
			for (int i = 1; i < n; i++) {
				if (p[i] < min) {
					answer++;
					min = p[i];
				}
			}
			System.out.println(answer);
		}
	}
}
