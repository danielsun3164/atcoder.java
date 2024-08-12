package abc.abc201_250.abc234;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://kanpurin.hatenablog.com/entry/2022/01/08/231634 の実装
 */
public class ProblemD別回答3 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			BinaryTrie bt = new BinaryTrie(n);
			IntStream.range(0, k - 1).forEach(i -> bt.insert(scanner.nextInt()));
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(k - 1, n).forEach(i -> {
				bt.insert(scanner.nextInt());
				sb.append(bt.kthElement(i + 2 - k)).append(System.lineSeparator());
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	private static class BinaryTrie {
		private static final int BIT_LENGTH = 30;

		final int[] nodes, count;
		int id;

		BinaryTrie(int n) {
			int n2 = (n + 1) * BIT_LENGTH;
			nodes = new int[n2 << 1];
			Arrays.fill(nodes, -1);
			count = new int[n2];
			Arrays.fill(count, 0);
			id = 0;
		}

		/**
		 * 数字の数を取得する
		 *
		 * @return 数字の数
		 */
		@SuppressWarnings("unused")
		int size() {
			return count[0];
		}

		/**
		 * 数字xの個数を取得する
		 *
		 * @param x
		 * @return 数字xの個数
		 */
		int count(int x) {
			int pt = 0;
			for (int i = BIT_LENGTH - 1; i >= 0; i--) {
				int y = (x >> i) & 1;
				if (-1 == nodes[(pt << 1) + y]) {
					return 0;
				}
				pt = nodes[(pt << 1) + y];
			}
			return count[pt];
		}

		/**
		 * 数字xを挿入する
		 *
		 * @param x
		 */
		void insert(int x) {
			int pt = 0;
			for (int i = BIT_LENGTH - 1; i >= 0; i--) {
				int y = (x >> i) & 1;
				if (-1 == nodes[(pt << 1) + y]) {
					nodes[(pt << 1) + y] = ++id;
				}
				count[pt]++;
				pt = nodes[(pt << 1) + y];
			}
			count[pt]++;
		}

		/**
		 * 数字xを削除する<br/>
		 * xが存在しないときは何もしない
		 *
		 * @param x
		 */
		@SuppressWarnings("unused")
		void erase(int x) {
			if (0 == count(x)) {
				return;
			}
			int pt = 0;
			for (int i = BIT_LENGTH - 1; i >= 0; i--) {
				int y = (x >> i) & 1;
				count[pt]--;
				pt = nodes[(pt << 1) + y];
			}
			count[pt]--;
		}

		/**
		 * 昇順k番目(1-indexed)の値を取得する
		 *
		 * @param k
		 * @return 昇順k番目(1-indexed)の値
		 */
		int kthElement(int k) {
			int pt = 0, answer = 0;
			for (int i = BIT_LENGTH - 1; i >= 0; i--) {
				answer <<= 1;
				if ((-1 != nodes[pt << 1]) && (count[nodes[pt << 1]] > 0)) {
					if (count[nodes[pt << 1]] >= k) {
						pt = nodes[pt << 1];
					} else {
						k -= count[nodes[pt << 1]];
						pt = nodes[(pt << 1) + 1];
						answer++;
					}
				} else {
					pt = nodes[(pt << 1) + 1];
					answer++;
				}
			}
			return answer;
		}

		/**
		 * x以上の最小要素が昇順何番目か(1-indexed)を取得する<br/>
		 * x以上の要素がない時はsize()+1を返す
		 *
		 * @param x
		 * @return x以上の最小要素が昇順何番目か(1-indexed)
		 */
		@SuppressWarnings("unused")
		int lowerBound(int x) {
			int pt = 0, answer = 1;
			for (int i = BIT_LENGTH - 1; i >= 0; i--) {
				if (-1 == pt) {
					break;
				}
				if ((1 == ((x >> i) & 1)) && (-1 != nodes[pt << 1])) {
					answer += count[nodes[pt << 1]];
				}
				pt = nodes[(pt << 1) + ((x >> i) & 1)];
			}
			return answer;
		}
	}
}
