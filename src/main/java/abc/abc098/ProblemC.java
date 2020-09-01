package abc.abc098;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 西を表す文字 */
	private static final char WEST = 'W';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			int[] wCounts = new int[n + 1], eCounts = new int[n + 1];
			wCounts[0] = eCounts[0] = 0;
			IntStream.range(0, n).forEach(i -> {
				wCounts[i + 1] = (s[i] == WEST) ? wCounts[i] + 1 : wCounts[i];
				eCounts[i + 1] = (s[i] == WEST) ? eCounts[i] : eCounts[i] + 1;
			});
			System.out.println(
					IntStream.rangeClosed(1, n).map(i -> wCounts[i - 1] + eCounts[n] - eCounts[i]).min().getAsInt());
		}
	}
}
