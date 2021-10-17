package abc.abc201_250.abc210;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc210/submissions/24406218 にも参考
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			Data[] datas = IntStream.range(0, m).mapToObj(i -> new Data(scanner.nextInt(), scanner.nextLong()))
					.sorted((x, y) -> Long.compare(x.c, y.c)).toArray(Data[]::new);
			int x = n;
			long answer = 0L;
			for (Data data : datas) {
				int nx = gcd(x, data.a);
				answer += data.c * (x - nx);
				x = nx;
			}
			System.out.println((x > 1) ? -1L : answer);
		}
	}

	/**
	 * aとbの最大公約数を計算する
	 *
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	private static int gcd(int a, int b) {
		return (0 == b) ? a : gcd(b, a % b);
	}

	/**
	 * aとcを格納するクラス
	 */
	private static class Data {
		int a;
		long c;

		Data(int a, long c) {
			super();
			this.a = a;
			this.c = c;
		}
	}
}
