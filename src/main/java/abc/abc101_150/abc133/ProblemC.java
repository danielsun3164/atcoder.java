package abc.abc101_150.abc133;

import java.util.Scanner;
import java.util.stream.LongStream;

public class ProblemC {

	private static final int N = 2019;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long l = scanner.nextLong(), r = scanner.nextLong();
			if (r - l >= N) {
				System.out.println(0);
			} else {
				long rl = l % N, rr = r % N;
				if (rr < rl) {
					System.out.println(0);
				} else {
					System.out.println(LongStream.range(rl, rr)
							.map(i -> LongStream.rangeClosed(i + 1, rr).map(j -> i * j % N).min().getAsLong()).min()
							.getAsLong());
				}
			}
		}
	}
}
