package abc.abc201_250.abc215;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	/** 座標の最大値 */
	private static final int N = 1_000_000_000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Data[] datas = IntStream.range(0, n).mapToObj(i -> new Data(scanner.nextInt(), scanner.nextInt()))
					.sorted((a, b) -> Integer.compare(a.x, b.x)).toArray(Data[]::new);
			int ok = 0, ng = N + 1;
			while (ng - ok > 1) {
				int med = (ok + ng) >> 1;
				if (check(datas, med)) {
					ok = med;
				} else {
					ng = med;
				}
			}
			System.out.println(ok);
		}
	}

	/**
	 * 点の中で距離がvalue以上のペアがあるかどうかをチェック
	 *
	 * @param datas
	 * @param value
	 * @return 点の中で距離がvalue以上のペアがあるかどうか
	 */
	private static boolean check(Data[] datas, int value) {
		int left = 0, right = 0, minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
		while (right < datas.length) {
			if ((minY <= datas[right].y - value) || (maxY >= datas[right].y + value)) {
				return true;
			}
			if (datas[right].x - value < datas[left].x) {
				right++;
			} else {
				minY = Math.min(minY, datas[left].y);
				maxY = Math.max(maxY, datas[left].y);
				left++;
			}
		}
		return false;
	}

	/**
	 * x,y を格納するクラス
	 */
	private static class Data {
		int x, y;

		Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
