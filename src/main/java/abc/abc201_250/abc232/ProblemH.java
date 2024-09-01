package abc.abc201_250.abc232;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc232/editorial/3140 の実装
 */
public class ProblemH {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), a = scanner.nextInt(), b = scanner.nextInt();
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			solve(h, w, a, b).forEach(data -> sb.append(data.toString()).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 問題を解決する
	 *
	 * @param h
	 * @param w
	 * @param a
	 * @param b
	 * @return たどっていく経路
	 */
	private static List<Data> solve(int h, int w, int a, int b) {
		List<Data> result;
		if (2 == h) {
			result = new ArrayList<>();
			IntStream.range(1, b).forEach(i -> IntStream.rangeClosed(1, 2).forEach(j -> result.add(new Data(j, i))));
			result.add(new Data(3 - a, b));
			IntStream.rangeClosed(b + 1, w).forEach(i -> result.add(new Data(1, i)));
			IntStream.rangeClosed(b + 1, w).map(i -> w + b + 1 - i).forEach(i -> result.add(new Data(2, i)));
			result.add(new Data(a, b));
		} else if ((2 == w) || (1 == b) || ((h == a) && (2 == b))) {
			result = solve(w, h, b, a);
			result.forEach(Data::swap);
		} else {
			result = new ArrayList<>();
			IntStream.rangeClosed(1, h).forEach(i -> result.add(new Data(i, 1)));
			List<Data> result2 = solve(h, w - 1, h + 1 - a, b - 1);
			result2.forEach(data -> {
				data.a = h + 1 - data.a;
				data.b++;
			});
			result.addAll(result2);
		}
		return result;
	}

	/**
	 * a,bを格納するクラス
	 */
	private static class Data {
		int a, b;

		Data(int a, int b) {
			this.a = a;
			this.b = b;
		}

		void swap() {
			int temp = a;
			a = b;
			b = temp;
		}

		@Override
		public String toString() {
			return a + " " + b;
		}
	}
}
