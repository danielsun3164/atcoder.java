package abc.abc201_250.abc248;

import java.util.BitSet;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	/** 数字の数 */
	private static final int N = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			BitSet set = new BitSet(N);
			set.set(0, N, true);
			String s = scanner.next();
			for (char c : s.toCharArray()) {
				set.set(c - '0', false);
			}
			System.out.println(IntStream.range(0, N).filter(i -> set.get(i)).findFirst().getAsInt());
		}
	}
}
