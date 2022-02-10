package abc.abc101_150.abc140;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc140/submissions/15981144 にも参考
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] indexes = new int[n + 1];
			IntStream.rangeClosed(1, n).forEach(i -> indexes[scanner.nextInt()] = i);
			NavigableSet<Integer> set = new TreeSet<>();
			set.add(0);
			set.add(n + 1);
			System.out.println(IntStream.range(0, n).map(i -> n - i).mapToLong(pi -> {
				int i = indexes[pi];
				set.add(i);
				int x = set.lower(i);
				int w = (null == set.lower(x)) ? 0 : set.lower(x);
				int y = set.higher(i);
				int z = (null == set.higher(y)) ? n + 1 : set.higher(y);
				return ((x - w) * (long) (y - i) + (i - x) * (long) (z - y)) * pi;
			}).sum());
		}
	}
}
