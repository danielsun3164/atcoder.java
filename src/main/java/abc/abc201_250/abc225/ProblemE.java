package abc.abc201_250.abc225;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc225/editorial/2853 の実装
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Pair[] pairs = IntStream.range(0, n).mapToObj(i -> {
				long x = scanner.nextLong(), y = scanner.nextLong();
				return new Pair(new Data(y, x - 1), new Data(y - 1, x));
			}).sorted(
					(a, b) -> (0 == compare(a.data1, b.data1)) ? compare(a.data2, b.data2) : compare(a.data1, b.data1))
					.toArray(Pair[]::new);
			int answer = 0;
			Data now = new Data(0L, 1L);
			for (Pair pair : pairs) {
				if (compare(now, pair.data2) <= 0) {
					answer++;
					now = pair.data1;
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * Data型のaとbを比較する
	 *
	 * @param a
	 * @param b
	 * @return 比較結果
	 */
	static int compare(Data a, Data b) {
		return Long.compare(a.x * b.y, b.x * a.y);
	}

	/**
	 * x,y を格納するクラス
	 */
	private static class Data {
		long x, y;

		Data(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	/**
	 * Dataを2つ格納するクラス
	 */
	private static class Pair {
		Data data1, data2;

		Pair(Data data1, Data data2) {
			this.data1 = data1;
			this.data2 = data2;
		}
	}
}
