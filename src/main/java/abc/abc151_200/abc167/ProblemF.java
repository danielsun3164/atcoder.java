package abc.abc151_200.abc167;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc167/submissions/13128568 にも参照
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			List<Data> ls = new ArrayList<>(), rs = new ArrayList<>();
			long sum = IntStream.range(0, n).mapToLong(i -> {
				char[] s = scanner.next().toCharArray();
				int total = 0, min = 0;
				for (char c : s) {
					total += ('(' == c) ? 1 : -1;
					min = Math.min(total, min);
				}
				if (total >= 0) {
					ls.add(new Data(total, min));
				} else {
					rs.add(new Data(-total, min - total));
				}
				return total;
			}).sum();
			Collections.sort(ls);
			Collections.sort(rs);
			System.out.println((check(ls) && check(rs) && (sum == 0L)) ? "Yes" : "No");
		}
	}

	/**
	 * リストの実現可能性をチェックする
	 *
	 * @param list データのリスト
	 * @return リストが実現可能かどうか
	 */
	private static boolean check(List<Data> list) {
		long total = 0L;
		for (Data data : list) {
			if (total + data.min < 0) {
				return false;
			}
			total += data.total;
		}
		return true;
	}

	/**
	 * 個々のsを表す用クラス
	 */
	private static class Data implements Comparable<Data> {
		int total;
		int min;

		public Data(int total, int min) {
			this.total = total;
			this.min = min;
		}

		@Override
		public int compareTo(Data o) {
			return Integer.compare(o.min, min);
		}
	}
}
