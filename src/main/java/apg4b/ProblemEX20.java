package apg4b;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemEX20 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] p = new List[n];
			IntStream.range(0, n).forEach(i -> p[i] = new ArrayList<>());
			IntStream.range(1, n).forEach(i -> p[scanner.nextInt()].add(i));
			IntStream.range(0, n).forEach(i -> System.out.println(getResult(p, i)));
		}
	}

	/**
	 * @param p   親子関係
	 * @param now 現在の計算対象
	 * @return nowの提出ページ数
	 */
	private static int getResult(final List<Integer>[] p, int now) {
		return p[now].stream().mapToInt(i -> getResult(p, i)).sum() + 1;
	}
}
