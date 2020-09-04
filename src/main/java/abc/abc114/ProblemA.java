package abc.abc114;

import java.util.Scanner;
import java.util.Set;

public class ProblemA {

	/** 七五三の数字のセット */
	private static final Set<Integer> SET = Set.of(3, 5, 7);

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt();
			System.out.println(SET.contains(x) ? "YES" : "NO");
		}
	}
}
