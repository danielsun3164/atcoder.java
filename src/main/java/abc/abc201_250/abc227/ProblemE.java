package abc.abc201_250.abc227;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc227/editorial/2908 の実装<br/>
 * https://atcoder.jp/contests/abc227/submissions/27208776 にも参考
 */
public class ProblemE {

	/** KEY */
	private static final char[] KEY = "KEY".toCharArray();

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			int n = s.length(), k = scanner.nextInt();
			// dp[x][e][y]=(i番目まで見て、)swapをx回していて、Eをe個、Yをy個使用済みのとき、(残りの文字列,数)
			Map<Integer, Map<Integer, Map<Integer, Data>>> dp = new HashMap<>();
			dp.put(0, new HashMap<>());
			dp.get(0).put(0, new HashMap<>());
			dp.get(0).get(0).put(0, new Data(s, 1));

			for (int i = 0; i < n; i++) {
				Map<Integer, Map<Integer, Map<Integer, Data>>> newDp = new HashMap<>();
				for (var entry1 : dp.entrySet()) {
					int x = entry1.getKey();
					for (var entry2 : entry1.getValue().entrySet()) {
						int e = entry2.getKey();
						for (var entry3 : entry2.getValue().entrySet()) {
							int y = entry3.getKey();
							String es = entry3.getValue().s;
							long value = entry3.getValue().value;
							for (char c : KEY) {
								int index = es.indexOf(c);
								if (index >= 0) {
									int newX = x + index, newE = e + (('E' == c) ? 1 : 0),
											newY = y + (('Y' == c) ? 1 : 0);
									if (!newDp.containsKey(newX)) {
										newDp.put(newX, new HashMap<>());
									}
									if (!newDp.get(newX).containsKey(newE)) {
										newDp.get(newX).put(newE, new HashMap<>());
									}
									if (newDp.get(newX).get(newE).containsKey(newY)) {
										newDp.get(newX).get(newE).get(newY).value += value;
									} else {
										newDp.get(newX).get(newE).put(newY,
												new Data(es.substring(0, index) + es.substring(index + 1), value));
									}
								}
							}
						}
					}
				}
				dp = newDp;
			}
			long answer = 0L;
			for (var entry1 : dp.entrySet()) {
				int x = entry1.getKey();
				if (x > k) {
					continue;
				}
				for (var entry2 : entry1.getValue().entrySet()) {
					for (var entry3 : entry2.getValue().entrySet()) {
						answer += entry3.getValue().value;
					}
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * s,valueを格納するクラス
	 */
	private static class Data {
		String s;
		long value;

		Data(String s, long value) {
			super();
			this.s = s;
			this.value = value;
		}
	}
}
