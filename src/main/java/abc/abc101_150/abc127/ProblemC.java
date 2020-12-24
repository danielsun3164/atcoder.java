package abc.abc101_150.abc127;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			@SuppressWarnings("unused")
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] l = new int[m], r = new int[m];
			int lMax = IntStream.range(0, m).map(i -> {
				l[i] = scanner.nextInt();
				r[i] = scanner.nextInt();
				return l[i];
			}).max().getAsInt();
			int rMin = Arrays.stream(r).min().getAsInt();
			System.out.println((rMin >= lMax) ? rMin - lMax + 1 : 0);
		}
	}
}
