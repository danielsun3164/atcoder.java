package abc.abc201_250.abc231;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://kanpurin.hatenablog.com/entry/2021/12/22/001854 の実装
 */
public class ProblemC別回答1 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			BinaryTrie bt = new BinaryTrie(n + 1);
			IntStream.range(0, n).forEach(i -> bt.insert(scanner.nextInt()));
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				int x = scanner.nextInt();
				sb.append(n + 1 - bt.lowerBound(x)).append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	private static class BinaryTrie {
		private static final int BIT_LENGTH = 30;
		int n, id;
		int[] nodes, count;

		BinaryTrie(int n) {
			this.n = n * BIT_LENGTH;
			nodes = new int[this.n << 1];
			Arrays.fill(nodes, -1);
			count = new int[this.n];
			Arrays.fill(count, 0);
			id = 0;
		}

		@SuppressWarnings("unused")
		int size() {
			return count[0];
		}

		@SuppressWarnings("unused")
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

		void insert(int x) {
			int pt = 0;
			for (int i = BIT_LENGTH - 1; i >= 0; i--) {
				int y = (x >> i) & 1;
				if (-1 == nodes[(pt << 1) + y]) {
					id++;
					nodes[(pt << 1) + y] = id;
				}
				count[pt]++;
				pt = nodes[(pt << 1) + y];
			}
			count[pt]++;
		}

		@SuppressWarnings("unused")
		void erase(int x) {
			if (0 == count[x]) {
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

		@SuppressWarnings("unused")
		int kthElement(int x) {
			int pt = 0, answer = 0;
			for (int i = BIT_LENGTH - 1; i >= 0; i--) {
				answer <<= 1;
				if ((-1 != nodes[pt << 1]) && (count[nodes[pt << 1]] > 0)) {
					if (count[nodes[pt << 1]] >= x) {
						pt = nodes[pt << 1];
					} else {
						x -= count[nodes[pt << 1]];
						pt = nodes[(pt << 1) + 1];
						answer++;
					}
				} else {
					pt = nodes[pt << 1];
					answer++;
				}
			}
			return answer;
		}

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
