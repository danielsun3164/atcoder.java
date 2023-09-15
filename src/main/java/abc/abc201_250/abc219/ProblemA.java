package abc.abc201_250.abc219;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ProblemA {

	/** 各レベルの最低点 */
	private static final NavigableSet<Integer> SET = new TreeSet<>(Set.of(40, 70, 90));

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt();
			Integer next = SET.higher(x);
			System.out.println((null == next) ? "expert" : String.valueOf(next - x));
		}
	}
}
