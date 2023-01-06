package other.typical90;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem036別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			NavigableSet<Long> xSet = new TreeSet<>(), ySet = new TreeSet<>();
			Data[] datas = IntStream.range(0, n).mapToObj(i -> {
				long x = scanner.nextInt(), y = scanner.nextLong();
				Data data = new Data(x - y, x + y);
				xSet.add(data.x);
				ySet.add(data.y);
				return data;
			}).toArray(Data[]::new);
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(i -> {
				int qi = scanner.nextInt() - 1;
				sb.append(max(Math.abs(datas[qi].x - xSet.first()), Math.abs(datas[qi].x - xSet.last()),
						Math.abs(datas[qi].y - ySet.first()), Math.abs(datas[qi].y - ySet.last())))
						.append(System.lineSeparator());
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 複数のlongの値の最大値を返す
	 *
	 * @param array
	 * @return 複数のlongの値の最大値
	 */
	private static long max(long... array) {
		return Arrays.stream(array).max().getAsLong();
	}

	/**
	 * x,y を格納するクラス
	 */
	private static class Data {
		long x, y;

		Data(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
