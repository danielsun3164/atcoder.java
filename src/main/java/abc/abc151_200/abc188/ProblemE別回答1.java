package abc.abc151_200.abc188;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード（解法1）
 */
public class ProblemE別回答1 {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			@SuppressWarnings("unchecked")
			List<Integer>[] childrens = new List[n];
			IntStream.range(0, n).forEach(i -> childrens[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> childrens[scanner.nextInt() - 1].add(scanner.nextInt() - 1));
			/** dp[i]は街iに到達できる街 (街i自身を含まない)における金の最安値 */
			int[] dp = new int[n];
			Arrays.fill(dp, INF);
			IntStream.range(0, n).forEach(i -> childrens[i].stream().forEach(j -> dp[j] = min(dp[j], dp[i], a[i])));
			System.out.println(IntStream.range(0, n).map(i -> a[i] - dp[i]).max().getAsInt());
		}
	}

	/**
	 * 配列の最小値を計算する
	 * 
	 * @param a 配列
	 * @return 配列の最小値
	 */
	private static int min(int... a) {
		return Arrays.stream(a).min().getAsInt();
	}
}
