package abc.abc201_250.abc223;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** 長方形の数 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long x = scanner.nextLong(), y = scanner.nextLong();
			long[] a = IntStream.range(0, N).mapToLong(i -> scanner.nextLong()).toArray();
			for (int i = 0; i < N; i++) {
				int index = i;
				long[] remain = IntStream.range(0, N).filter(j -> j != index).mapToLong(j -> a[j]).toArray();
				if (ok(x, y, a[i], remain)) {
					System.out.println("Yes");
					return;
				}
			}
			System.out.println("No");
		}
	}

	/**
	 * x*yの枠の中に、nowの大きさの長方形とremain配列に入っている長方形が配置できるかを計算する
	 *
	 * @param x      枠の横幅
	 * @param y      枠の縦幅
	 * @param now    今配置したい長方形の大きさ
	 * @param remain 残りの長方形の大きさの配列
	 * @return x*yの枠の中に、nowの大きさの長方形とremain配列に入っている長方形が配置できるか
	 */
	private static boolean ok(long x, long y, long now, long[] remain) {
		if ((0L == x) || (0L == y)) {
			return false;
		}
		long newX = x - (now + y - 1) / y;
		if (ok(newX, y, remain) || ok(y, newX, remain)) {
			return true;
		}
		long newY = y - (now + x - 1) / x;
		if (ok(newY, x, remain) || ok(x, newY, remain)) {
			return true;
		}
		return false;
	}

	/**
	 * x*yの枠の中にremain配列に入っている長方形が配置できるかを計算する
	 *
	 * @param x      枠の横幅
	 * @param y      枠の縦幅
	 * @param remain 長方形の大きさの配列
	 * @return x*yの枠の中にremain配列に入っている長方形が配置できるか
	 */
	private static boolean ok(long x, long y, long[] remain) {
		if (remain.length > 1) {
			if (ok(x, y, remain[0], new long[] { remain[1] }) || ok(x, y, remain[1], new long[] { remain[0] })) {
				return true;
			}
			return false;
		} else {
			return x * y >= remain[0];
		}
	}
}
