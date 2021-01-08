package abc.abc151_200.abc175;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 * 
 * https://atcoder.jp/contests/abc175/submissions/15991728 にも参考
 */
public class ProblemF {

	/** 文字列の最大長さ+1 */
	private static final int MAX_LENGTH = 21;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			String[][] s = new String[n][2];
			long[] c = new long[n];
			IntStream.range(0, n).forEach(i -> {
				s[i][0] = scanner.next();
				s[i][1] = new StringBuilder(s[i][0]).reverse().toString();
				c[i] = scanner.nextLong();
			});
			long answer = Long.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				long[][][] d = new long[n][2][MAX_LENGTH];
				IntStream.range(0, n)
						.forEach(j -> IntStream.range(0, 2).forEach(k -> Arrays.fill(d[j][k], Long.MAX_VALUE)));
				d[i][0][0] = c[i];
				Queue<Node> queue = new PriorityQueue<>();
				queue.add(new Node(i, 0, 0, c[i]));
				while (!queue.isEmpty()) {
					Node node = queue.poll();
					String string = s[node.i][node.j].substring(node.index);
					if (isPalindrome(string)) {
						answer = Math.min(answer, node.cost);
						break;
					}
					if (node.cost <= d[node.i][node.j][node.index]) {
						int j2 = 1 - node.j;
						for (int i2 = 0; i2 < n; i2++) {
							int ni = -1, nj = -1, nIndex = -1;
							if (s[i2][j2].startsWith(string)) {
								ni = i2;
								nj = j2;
								nIndex = string.length();
							}
							if (string.startsWith(s[i2][j2])) {
								ni = node.i;
								nj = node.j;
								nIndex = node.index + s[i2][j2].length();
							}
							if (-1 != ni) {
								long nCost = node.cost + c[i2];
								if (nCost < d[ni][nj][nIndex]) {
									d[ni][nj][nIndex] = nCost;
									queue.add(new Node(ni, nj, nIndex, nCost));
								}
							}
						}
					}
				}
			}
			System.out.println((Long.MAX_VALUE == answer) ? -1 : answer);
		}
	}

	/**
	 * 文字列が回文かどうかを計算する
	 * 
	 * @param string 文字列
	 * @return 文字列が回文かどうか
	 */
	private static boolean isPalindrome(String string) {
		int left = 0, right = string.length() - 1;
		char[] cs = string.toCharArray();
		while (left < right) {
			if (cs[left++] != cs[right--]) {
				return false;
			}
		}
		return true;
	}

	private static class Node implements Comparable<Node> {
		int i, j, index;
		long cost;

		Node(int i, int j, int index, long cost) {
			super();
			this.i = i;
			this.j = j;
			this.index = index;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node node) {
			return Long.compare(cost, node.cost);
		}
	}
}
