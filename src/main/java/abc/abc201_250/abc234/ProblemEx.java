package abc.abc201_250.abc234;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc234/editorial/3226 の実装
 */
public class ProblemEx {

	/** 最大値 */
	private static final long MAX = Integer.MAX_VALUE;
	/** 差分の一覧 */
	private static final long[] DLT = { -MAX - 1, -MAX, -MAX + 1, -1L, 0L, 1L, MAX - 1, MAX, MAX + 1 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			Point[] points = new Point[n];
			Map<Long, List<Integer>> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				long x = scanner.nextLong(), y = scanner.nextLong();
				points[i] = new Point(x, y);
				long id = x / k * MAX + y / k;
				if (!map.containsKey(id)) {
					map.put(id, new ArrayList<>());
				}
				map.get(id).add(i);
			});
			List<Point> answer = new ArrayList<>();
			IntStream.range(0, n).forEach(i -> {
				long id = points[i].x / k * MAX + points[i].y / k;
				for (long d : DLT) {
					long current = id + d;
					if (map.containsKey(current)) {
						for (int nx : map.get(current)) {
							if (i >= nx) {
								continue;
							}
							long dist = (points[i].x - points[nx].x) * (points[i].x - points[nx].x)
									+ (points[i].y - points[nx].y) * (points[i].y - points[nx].y);
							if (dist <= k * k) {
								answer.add(new Point(i + 1, nx + 1));
							}
						}
					}
				}
			});
			Collections.sort(answer, (a, b) -> (a.x == b.x) ? Long.compare(a.y, b.y) : Long.compare(a.x, b.x));
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			sb.append(answer.size()).append(System.lineSeparator());
			answer.forEach(ai -> sb.append(ai.x + " " + ai.y).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * x,yを格納するクラス
	 */
	private static class Point {
		long x, y;

		Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
}
