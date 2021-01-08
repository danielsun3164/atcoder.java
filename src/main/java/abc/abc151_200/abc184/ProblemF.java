package abc.abc151_200.abc184;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long t = scanner.nextLong();
			@SuppressWarnings("unchecked")
			TreeSet<Long>[] sets = new TreeSet[2];
			IntStream.range(0, 2).forEach(i -> {
				sets[i] = new TreeSet<>();
				sets[i].add(0L);
			});
			for (int i = 0; i < n; i++) {
				long a = scanner.nextLong();
				// https://atcoder.jp/contests/abc184/submissions/18347548 に参考
				// a_i==tが出たら、結果はtとなる
				if (a == t) {
					System.out.println(t);
					return;
				} else if (a < t) {
					// a_i < tのときのみ加算する
					sets[i & 1].addAll(
							sets[i & 1].stream().map(ai -> ai + a).filter(ai -> ai <= t).collect(Collectors.toList()));
				}
			}
			System.out.println(sets[0].stream().mapToLong(bi -> sets[1].floor(t - bi) + bi).max().getAsLong());
		}
	}
}
