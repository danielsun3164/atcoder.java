package other.typical90;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * DP復元の実装
 */
public class Problem056別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), s = scanner.nextInt();
			int[] a = new int[n], b = new int[n];
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextInt();
				b[i] = scanner.nextInt();
			});
			StringBuilder sb = new StringBuilder();
			System.out.println(
					calc(n, s, a, b, 0, s, sb, new HashMap<Integer, Boolean>()) ? sb.toString() : "Impossible");
		}
	}

	/**
	 * A か B を選んでいった際に、選び方を記憶しながら、条件を満たす購入の計画が存在するかどうかを計算する
	 *
	 * @param n    福袋の数
	 * @param s    目標金額
	 * @param a    Aの価格の配列
	 * @param b    Bの価格の配列
	 * @param now  現在処理中のi
	 * @param nowS 現在の残高
	 * @param sb   選び方
	 * @param memo 計算結果を保存するためのメモ
	 * @return 条件を満たす購入の計画が存在するかどうか
	 */
	private static boolean calc(int n, int s, int[] a, int[] b, int now, int nowS, StringBuilder sb,
			Map<Integer, Boolean> memo) {
		if (now == n) {
			return (0 == nowS);
		}
		int key = now * (s + 1) + nowS;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		if (nowS >= a[now]) {
			sb.append("A");
			if (calc(n, s, a, b, now + 1, nowS - a[now], sb, memo)) {
				memo.put(key, true);
				return true;
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		if (nowS >= b[now]) {
			sb.append("B");
			if (calc(n, s, a, b, now + 1, nowS - b[now], sb, memo)) {
				memo.put(key, true);
				return true;
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		memo.put(key, false);
		return false;
	}
}
