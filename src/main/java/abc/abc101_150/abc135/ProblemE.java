package abc.abc101_150.abc135;

import java.util.Scanner;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc135/submissions/7719127 にも参考
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt(), x = scanner.nextInt(), y = scanner.nextInt();
			if ((0 == (k & 1)) && (1 == ((x + y) & 1))) {
				System.out.println(-1);
				return;
			}
			// 答え
			int n = 0;
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			int tx = 0, ty = 0;
			while (true) {
				n++;
				// 目標までの距離
				int d = Math.abs(x - tx) + Math.abs(y - ty);
				if (d >= 2 * k) {
					// 距離が2k以上の場合
					int dx = Math.min(k, Math.abs(x - tx));
					tx += (((x - tx) >= 0) ? 1 : -1) * dx;
					ty += (((y - ty) >= 0) ? 1 : -1) * (k - dx);
				} else if (d == k) {
					// 距離がちょうどkの場合
					tx = x;
					ty = y;
				} else if (0 == (d & 1)) {
					// 距離が偶数の場合、距離Kの位置に移動
					if (Math.abs(x - tx) >= k) {
						int dx = d / 2;
						tx += (((x - tx) >= 0) ? 1 : -1) * dx;
						ty -= (((y - ty) >= 0) ? 1 : -1) * (k - dx);
					} else if (Math.abs(y - ty) >= k) {
						int dx = k - d / 2;
						tx -= (((x - tx) >= 0) ? 1 : -1) * dx;
						ty += (((y - ty) >= 0) ? 1 : -1) * (k - dx);
					} else if (Math.abs(x - tx) >= d / 2) {
						int dx = d / 2;
						tx += (((x - tx) >= 0) ? 1 : -1) * dx;
						ty -= (((y - ty) >= 0) ? 1 : -1) * (k - dx);
					} else {
						int dx = Math.abs(x - tx) + (k - d / 2);
						tx += (((x - tx) >= 0) ? 1 : -1) * dx;
						ty += (((y - ty) >= 0) ? 1 : -1) * (k - dx);
					}
				} else {
					// 距離が奇数の場合、ゴールの近くに移動
					int dx = Math.min(k, Math.abs(x - tx));
					tx += (((x - tx) >= 0) ? 1 : -1) * dx;
					ty += (((y - ty) >= 0) ? 1 : -1) * (k - dx);
				}
				sb.append(tx).append(" ").append(ty).append(System.lineSeparator());
				if ((tx == x) && (ty == y)) {
					break;
				}
			}
			System.out.println(n);
			System.out.print(sb.toString());
		}
	}
}
