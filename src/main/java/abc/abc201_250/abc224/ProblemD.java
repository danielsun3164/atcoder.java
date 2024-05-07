package abc.abc201_250.abc224;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** マスの数 */
	private static final int N = 9;
	/** 完成形の配列表現 */
	private static final int[] END_STATUS = IntStream.range(1, N + 1).map(i -> i % N).toArray();

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[N + 1];
			IntStream.range(0, N).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				edges[u].add(v);
				edges[v].add(u);
			});
			int[] a = new int[N];
			Arrays.fill(a, 0);
			IntStream.range(1, N).forEach(i -> a[scanner.nextInt() - 1] = i);
			Map<String, Integer> map = new HashMap<>();
			Queue<String> que = new ArrayDeque<>();
			String key = toString(a);
			map.put(key, 0);
			que.add(key);
			while (!que.isEmpty()) {
				String nowKey = que.poll();
				int[] status = toIntArray(nowKey);
				int now = IntStream.range(0, N).filter(i -> 0 == status[i]).findFirst().getAsInt();
				for (int next : edges[now]) {
					swap(status, now, next);
					String nextKey = toString(status);
					if (!map.containsKey(nextKey)) {
						map.put(nextKey, map.get(nowKey) + 1);
						que.add(nextKey);
					}
					swap(status, now, next);
				}
			}
			String endKey = toString(END_STATUS);
			System.out.println(map.containsKey(endKey) ? map.get(endKey) : -1);
		}
	}

	/**
	 * 配列のi番目とj番目の要素を交換する
	 *
	 * @param a 配列
	 * @param i
	 * @param j
	 */
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/**
	 * 配列を文字列へ変換する
	 *
	 * @param a 配列
	 * @return 文字列
	 */
	private static String toString(int[] a) {
		StringBuilder sb = new StringBuilder();
		Arrays.stream(a).forEach(sb::append);
		return sb.toString();
	}

	/**
	 * 文字列を配列へ変換する
	 *
	 * @param s 文字列
	 * @return 配列
	 */
	private static int[] toIntArray(String s) {
		return IntStream.range(0, N).map(i -> s.charAt(i) - '0').toArray();
	}
}
