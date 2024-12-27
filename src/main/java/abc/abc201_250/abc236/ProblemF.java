package abc.abc201_250.abc236;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc236/editorial/3287 の実装
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Data[] datas = IntStream.range(0, (1 << n) - 1).mapToObj(i -> new Data(scanner.nextLong(), i + 1))
					.sorted((a, b) -> Long.compare(a.c, b.c)).toArray(Data[]::new);
			Set<Integer> s = new HashSet<>();
			System.out.println(Arrays.stream(datas).filter(d -> !s.contains(d.p)).mapToLong(d -> {
				List<Integer> list = s.stream().map(si -> si ^ d.p).toList();
				s.add(d.p);
				s.addAll(list);
				return d.c;
			}).sum());
		}
	}

	/**
	 * c,pを格納するクラス
	 */
	private static class Data {
		long c;
		int p;

		Data(long c, int p) {
			this.c = c;
			this.p = p;
		}
	}
}
