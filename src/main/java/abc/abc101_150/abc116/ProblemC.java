package abc.abc101_150.abc116;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] h = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			System.out.println(getResult(h, 0, n - 1, 0));
		}
	}

	/**
	 * 条件を満たすような最小の「水やり」操作の回数を計算する
	 * 
	 * @param h       希望する高さの配列
	 * @param from    処理対象indexのfrom
	 * @param to      処理対象indexのfrom
	 * @param current 現在の高さ
	 * @return
	 */
	private static int getResult(final int[] h, int from, int to, int current) {
		if (from > to) {
			return 0;
		}
		if (from == to) {
			return h[from] - current;
		}
		List<Integer> minIndexes = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		// 最小値とそのindexを計算する
		for (int i = from; i <= to; i++) {
			if (min > h[i]) {
				minIndexes.clear();
				min = h[i];
				minIndexes.add(i);
			}
		}
		int answer = 0;
		int prev = from - 1;
		for (int index : minIndexes) {
			answer += getResult(h, prev + 1, minIndexes.get(0) - 1, min);
			prev = index;
		}
		answer += getResult(h, prev + 1, to, min);
		return answer + min - current;
	}
}
