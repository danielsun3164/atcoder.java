package abc.abc201_250.abc235;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc235/editorial/3255 の実装
 */
public class ProblemD {

	/** 10 */
	private static final int TEN = 10;
	/** 最大値 */
	private static final int MAX = 1_000_000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), n = scanner.nextInt();
			Queue<Integer> que = new ArrayDeque<>();
			Map<Integer, Integer> map = new HashMap<>();
			map.put(1, 0);
			que.add(1);
			while (!que.isEmpty()) {
				int now = que.poll(), count = map.get(now);
				int op1 = now * a;
				if ((op1 <= MAX) && !map.containsKey(op1)) {
					map.put(op1, count + 1);
					que.add(op1);
				}

				if ((now >= TEN) && (0 != now % TEN)) {
					int op2 = convert(now);
					if ((op2 <= MAX) && !map.containsKey(op2)) {
						map.put(op2, count + 1);
						que.add(op2);
					}
				}
			}
			System.out.println(map.getOrDefault(n, -1));
		}
	}

	/**
	 * 123の数字を312へ変換する
	 *
	 * @param n
	 * @return 変換後の数字
	 */
	private static int convert(int n) {
		int power = 1, x = n;
		while (x >= TEN) {
			x /= TEN;
			power *= TEN;
		}
		return (n % TEN) * power + n / TEN;
	}
}
