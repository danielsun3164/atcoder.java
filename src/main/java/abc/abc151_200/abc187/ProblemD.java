package abc.abc151_200.abc187;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = new long[n], b = new long[n];
			Data[] datas = new Data[n];
			long aoki = IntStream.range(0, n).mapToLong(i -> {
				a[i] = scanner.nextLong();
				b[i] = scanner.nextLong();
				datas[i] = new Data(a[i], b[i]);
				return a[i];
			}).sum();
			long takahashi = 0L;
			Arrays.sort(datas, (x, y) -> Long.compare(y.b + 2 * y.a, x.b + 2 * x.a));
			for (int i = 0; i < n; i++) {
				takahashi += datas[i].a + datas[i].b;
				aoki -= datas[i].a;
				if (takahashi > aoki) {
					System.out.println(i + 1);
					return;
				}
			}
		}
	}

	/**
	 * aとbの人数を表すクラス
	 */
	private static class Data {
		/** 青木と高橋に投票する人数 */
		long a, b;

		Data(long a, long b) {
			this.a = a;
			this.b = b;
		}
	}
}
