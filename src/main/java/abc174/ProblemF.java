package abc174;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 解説通りに実装したソースコード
 * 
 * https://atcoder.jp/contests/abc174/submissions/15644133 と https://atcoder.jp/contests/abc174/submissions/15644479
 * にも参考<br/>
 * TLE回避するため以下のことを実施
 * <ol>
 * <li>java.util.Scanner のかわりに、java.io.BufferedReaderを使用</li>
 * <li>Stream APIのかわりに、普通のfor文使用</li>
 * <li>結果出力する際に、いったんStringBuilderに入れてからいっきに出力(一番重要)</li>
 * </ol>
 */
public class ProblemF {

	public static void main(String[] args) {
		try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr)) {
			String[] strings = br.readLine().split(" ", 2);
			int n = Integer.parseInt(strings[0]), q = Integer.parseInt(strings[1]);
			String[] cs = br.readLine().split(" ", n);
			Queue<Query> queue = new PriorityQueue<>();
			for (int i = 0; i < q; i++) {
				String[] s = br.readLine().split(" ", 2);
				int l = Integer.parseInt(s[0]), r = Integer.parseInt(s[1]);
				queue.add(new Query(i, l, r));
			}
			BinaryIndexedTree bit = new BinaryIndexedTree(n + 1);
			int[] answers = new int[q], indexes = new int[n + 1];
			Arrays.fill(indexes, 0);
			for (int i = 0; i < n; i++) {
				int c = Integer.parseInt(cs[i]);
				if (indexes[c] > 0) {
					bit.add(indexes[c], -1);
				}
				bit.add(i + 1, 1);
				indexes[c] = i + 1;
				while (!queue.isEmpty() && (i + 1 == queue.peek().right)) {
					Query query = queue.poll();
					answers[query.index] = bit.sum(query.left, query.right);
				}
				if (queue.isEmpty()) {
					break;
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int x : answers) {
				sb.append(x).append("\n");
			}
			System.out.print(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class Query implements Comparable<Query> {
		int index;
		int left;
		int right;

		Query(int index, int left, int right) {
			super();
			this.index = index;
			this.left = left;
			this.right = right;
		}

		@Override
		public int compareTo(Query o) {
			return this.right - o.right;
		}
	}

	private static class BinaryIndexedTree {
		int size;
		int[] data;

		BinaryIndexedTree(int size) {
			super();
			this.size = size;
			data = new int[size];
			Arrays.fill(data, 0);
		}

		void add(int index, int value) {
			for (int i = index; i < size; i += (i & -i)) {
				data[i] += value;
			}
		}

		int sum(int index) {
			int sum = 0;
			for (int i = index; i > 0; i -= (i & -i)) {
				sum += data[i];
			}
			return sum;
		}

		int sum(int from, int to) {
			return sum(to) - sum(from - 1);
		}
	}
}
