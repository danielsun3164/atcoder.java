package abc.abc201_250.abc206;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	/** 区間のサイズ */
	private static final int N = 100;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			IntStream.range(0, t).forEach(i -> {
				int n = scanner.nextInt();
				Data[] datas = IntStream.range(0, n)
						.mapToObj(j -> new Data(scanner.nextInt() - 1, scanner.nextInt() - 1)).toArray(Data[]::new);
				int[][] dp = new int[N][N];
				IntStream.range(0, N).forEach(j -> Arrays.fill(dp[j], -1));
				System.out.println((0 == grundy(0, N - 1, datas, dp)) ? "Bob" : "Alice");
			});
		}
	}

	/**
	 * [l,r)の区間のGrundy数を計算する
	 *
	 * @param l
	 * @param r
	 * @param datas 選択できる区間一覧
	 * @param dp    計算結果を保存するための配列
	 * @return [l,r)の区間のGrundy数
	 */
	private static int grundy(int l, int r, Data[] datas, int[][] dp) {
		if (l >= r) {
			return 0;
		}
		if (-1 != dp[l][r]) {
			return dp[l][r];
		}
		// MEX計算用
		boolean[] kh = new boolean[N];
		Arrays.fill(kh, false);
		for (Data data : datas) {
			if ((l <= data.l) && (data.r <= r)) {
				kh[grundy(l, data.l, datas, dp) ^ grundy(data.r, r, datas, dp)] = true;
			}
		}
		return dp[l][r] = IntStream.range(0, N).filter(i -> !kh[i]).findFirst().getAsInt();
	}

	/**
	 * l,rを格納するクラス
	 */
	private static class Data {
		int l, r;

		Data(int l, int r) {
			super();
			this.l = l;
			this.r = r;
		}
	}
}
