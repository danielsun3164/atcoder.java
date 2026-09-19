package abc.abc201_250.abc241;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc241/editorial/3488 の実装<br/>
 * https://atcoder.jp/contests/abc241/submissions/29726957 にも参考
 */
public class ProblemD別回答4 {

	public static void main(String[] args) throws Exception {
		try (Scanner scanner = new Scanner(System.in)) {
			int q = scanner.nextInt();
			BinaryTrie trie = new BinaryTrie(60);
			int count = 0;

			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < q; i++) {
				int t = scanner.nextInt();
				long x = scanner.nextLong();
				if (t == 1) {
					trie.insert(x);
					count++;
				} else if (t == 2) {
					int k = scanner.nextInt();
					// x以下の個数
					int num = trie.lessX(x + 1);
					if (num < k) {
						sb.append(-1).append(System.lineSeparator());
					} else {
						// x以下のnum個のうち、d番目に大きい
						// = 小さい順で num-d+1 番目
						sb.append(trie.getKthMin(num - k + 1)).append(System.lineSeparator());
					}
				} else {
					int k = scanner.nextInt();
					// x未満の個数
					int num = trie.lessX(x);
					if (num + k > count) {
						sb.append(-1).append(System.lineSeparator());
					} else {
						// x未満のnum個を飛ばした後のd番目
						// = x以上のd番目に小さい値
						sb.append(trie.getKthMin(num + k)).append(System.lineSeparator());
					}
				}
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * Binary Trie
	 *
	 * x <= 10^18 なので、2^60 未満として扱える。
	 */
	static class BinaryTrie {
		/*
		 * Node: child[0] : 0側 child[1] : 1側 count : このノード以下に存在する要素数
		 */
		static class Node {
			Node[] child = new Node[2];
			int count;
		}

		private final Node root;
		private final long bitStart;

		BinaryTrie(int bitDepth) {
			root = new Node();
			bitStart = 1L << (bitDepth - 1);
		}

		/**
		 * xを格納
		 */
		void insert(long x) {
			long b = bitStart;
			Node node = root;

			node.count++;
			while (b != 0) {
				int i = ((x & b) != 0) ? 1 : 0;
				if (node.child[i] == null) {
					node.child[i] = new Node();
				}
				node = node.child[i];
				node.count++;
				b >>= 1;
			}
		}

		/**
		 * k番目に小さい値を取得。
		 *
		 * kは1-indexed。
		 */
		long getKthMin(int k) {
			long b = bitStart;
			Node node = root;
			long ret = 0;

			while (b != 0) {
				if (node.child[0] == null) {
					node = node.child[1];
					ret |= b;
				} else if (node.child[1] == null) {
					node = node.child[0];
				} else if (k <= node.child[0].count) {
					node = node.child[0];
				} else {
					k -= node.child[0].count;
					node = node.child[1];
					ret |= b;
				}
				b >>= 1;
			}
			return ret;
		}

		/**
		 * xより小さい値の個数を返す。
		 */
		int lessX(long x) {
			if (x <= 0) {
				return 0;
			}

			long b = bitStart;
			Node node = root;
			int ans = 0;

			while (b != 0) {
				int i = ((x & b) != 0) ? 1 : 0;
				if (node.child[i] == null) {
					if (i == 1 && node.child[0] != null) {
						ans += node.child[0].count;
					}
					return ans;
				}

				if (i == 1 && node.child[0] != null) {
					ans += node.child[0].count;
				}

				node = node.child[i];
				b >>= 1;
			}
			return ans;
		}
	}
}
