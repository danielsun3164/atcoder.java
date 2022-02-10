package abc.abc151_200.abc157;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class ProblemE {

	/** アルファベットの数 */
	private static final int N = 26;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			// アルファベットごとの位置情報を保存するSet
			@SuppressWarnings("unchecked")
			NavigableSet<Integer>[] sets = new NavigableSet[N];
			IntStream.range(0, N).forEach(i -> sets[i] = new TreeSet<>());
			IntStream.range(0, n).forEach(i -> sets[s[i] - 'a'].add(i));
			int q = scanner.nextInt();
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(k -> {
				int t = scanner.nextInt();
				if (1 == t) {
					int i = scanner.nextInt() - 1;
					char c = scanner.next().charAt(0);
					if (s[i] != c) {
						sets[s[i] - 'a'].remove(i);
						s[i] = c;
						sets[c - 'a'].add(i);
					}
				} else {
					int l = scanner.nextInt() - 1, r = scanner.nextInt();
					sb.append(IntStream.range(0, N).filter(i -> {
						Integer ceiling = sets[i].ceiling(l);
						return ((null != ceiling) && (ceiling < r));
					}).count()).append(System.lineSeparator());
				}
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
