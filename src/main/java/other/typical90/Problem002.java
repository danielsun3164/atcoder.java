package other.typical90;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Problem002 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			if (0 == (n & 1)) {
				getResult(n, new Set[n + 1]).stream().forEach(System.out::println);
			}
		}
	}

	/**
	 * 長さnの正しいカッコ列の一覧を生成する
	 *
	 * @param n
	 * @param memo 途中の計算結果を保存する配列
	 * @return 長さnの正しいカッコ列の一覧
	 */
	static private Set<String> getResult(int n, Set<String>[] memo) {
		if (null != memo[n]) {
			return memo[n];
		}
		if (2 == n) {
			return memo[n] = Set.of("()");
		}
		Set<String> result = new TreeSet<>();
		Set<String> set2 = getResult(n - 2, memo);
		set2.stream().forEach(string -> {
			result.add("(" + string + ")");
			result.add(string + "()");
			result.add("()" + string);
		});
		for (int i = 4; i <= (n / 2); i += 2) {
			Set<String> set11 = getResult(n - i, memo);
			Set<String> set12 = getResult(i, memo);
			set11.stream().forEach(string11 -> set12.stream().forEach(string12 -> {
				result.add(string11 + string12);
				result.add(string12 + string11);
			}));
		}
		return result;
	}
}
