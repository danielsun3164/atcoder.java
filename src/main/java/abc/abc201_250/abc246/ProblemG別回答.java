package abc.abc201_250.abc246;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc246/editorial/3724 の実装<br/>
 * https://atcoder.jp/contests/abc246/submissions/30680400 にも参考
 */
public class ProblemG別回答 {

	/**
	 * 木を幅優先探索し、逆順の頂点処理によって答えを計算する。
	 *
	 * <p>
	 * 各頂点の子のヒープから最大値を1つ削除した後、 頂点自身の値を追加し、そのヒープを親のヒープに併合する。
	 * </p>
	 *
	 * @throws IOException 標準入力の読み込み中にエラーが発生した場合
	 */
	public static void main(String[] args) throws IOException {
		try (Scanner fs = new Scanner(System.in)) {
			int n = fs.nextInt();
			int[] a = new int[n];
			IntStream.range(1, n).forEach(i -> a[i] = fs.nextInt());

			// 隣接リストを構築する。
			int[] degree = new int[n], u = new int[n - 1], v = new int[n - 1];
			IntStream.range(0, n - 1).forEach(i -> {
				u[i] = fs.nextInt() - 1;
				v[i] = fs.nextInt() - 1;
				degree[u[i]]++;
				degree[v[i]]++;
			});

			int[][] adj = new int[n][];
			IntStream.range(0, n).forEach(i -> adj[i] = new int[degree[i]]);
			Arrays.fill(degree, 0);
			IntStream.range(0, n - 1).forEach(i -> {
				adj[u[i]][degree[u[i]]++] = v[i];
				adj[v[i]][degree[v[i]]++] = u[i];
			});

			// 幅優先探索で親頂点と頂点の処理順を求める。
			int[] bfs = new int[n], parent = new int[n];
			Arrays.fill(bfs, 0);
			Arrays.fill(parent, -1);

			int count = 1;
			for (int i = 0; i < count; i++) {
				int p = bfs[i];
				for (int e : adj[p]) {
					if (parent[p] != e) {
						parent[e] = p;
						bfs[count++] = e;
					}
				}
			}

			// 各頂点に対応する左偏ヒープを作成する。
			LeftistHeap[] dp = new LeftistHeap[n];
			IntStream.range(0, n).forEach(i -> dp[i] = new LeftistHeap());

			// 葉に近い頂点から親方向へ処理する。
			IntStream.iterate(n - 1, i -> i >= 1, i -> i - 1).forEach(i -> {
				int p = bfs[i];
				if (dp[p].size() > 0) {
					dp[p].pop();
				}
				dp[p].push(a[p]);
				dp[parent[p]].meld(dp[p]);
			});

			// 根のヒープから最大値を1つ削除し、残った最大値を答えとする。
			if (dp[0].size() > 0) {
				dp[0].pop();
			}
			System.out.println((dp[0].size() > 0) ? dp[0].top() : 0);
		}
	}

	/**
	 * 整数を要素とする最大左偏ヒープ。
	 *
	 * <p>
	 * 親ノードのキーが子ノードのキー以上となる最大ヒープを構成する。 左偏ヒープの性質を利用して、ヒープの併合を効率的に行う。
	 * </p>
	 *
	 * <p>
	 * 併合処理は明示的なスタックを用いて反復的に実行し、 再帰呼び出しによるスタックオーバーフローを回避する。
	 * </p>
	 */
	static class LeftistHeap {
		/**
		 * 左偏ヒープを構成するノード。
		 */
		private static final class Node {
			Node left, right;
			int height, key;

			/**
			 * 指定されたキーを持つノードを生成する。
			 *
			 * @param key ノードに格納する整数
			 */
			Node(int key) {
				this.key = key;
				height = 1;
			}
		}

		private Node root;
		private int size;

		/**
		 * 空の左偏ヒープを生成する。
		 */
		LeftistHeap() {
			root = null;
			size = 0;
		}

		/**
		 * ノードの高さを取得する。
		 *
		 * <p>
		 * 空ノードの高さは 0 とする。
		 * </p>
		 *
		 * @param node 高さを取得するノード
		 * @return ノードの高さ。node が null の場合は 0
		 */
		private static int height(Node node) {
			return node == null ? 0 : node.height;
		}

		/**
		 * ノードの左右の子を調整し、高さを更新する。
		 *
		 * <p>
		 * 左偏ヒープの条件を満たすように、左の子の高さが右の子の 高さ以上になるよう調整する。ノードの高さは右の子の高さに 1 を加えた値とする。
		 * </p>
		 *
		 * @param node 調整するノード
		 */
		private static void fix(Node node) {
			if (node.left == null) {
				swapChildren(node);
				node.height = 1;
			} else if (node.right == null) {
				node.height = 1;
			} else {
				if (height(node.left) < height(node.right)) {
					swapChildren(node);
				}
				node.height = height(node.right) + 1;
			}
		}

		private static void swapChildren(Node node) {
			Node tmp = node.left;
			node.left = node.right;
			node.right = tmp;
		}

		/**
		 * 2つのヒープの根を併合する。
		 *
		 * <p>
		 * 大きいキーを持つノードを根として選択しながら右の子をたどる。 たどったノードを明示的なスタックに格納し、末端から順に 左偏ヒープの条件と高さを復元する。
		 * </p>
		 *
		 * <p>
		 * このメソッドはノードを新たに生成せず、既存のノードを再利用する。
		 * </p>
		 *
		 * @param a 併合する1つ目のヒープの根
		 * @param b 併合する2つ目のヒープの根
		 * @return 併合後のヒープの根
		 */
		private static Node meldNodes(Node a, Node b) {
			if (a == null) {
				return b;
			}
			if (b == null) {
				return a;
			}

			List<Node> stack = new ArrayList<>(height(a) + height(b));
			while (a != null && b != null) {
				if (a.key < b.key) {
					Node tmp = a;
					a = b;
					b = tmp;
				}
				stack.add(a);
				a = a.right;
			}

			Node merged = (a != null) ? a : b;
			for (int i = stack.size() - 1; i >= 0; i--) {
				Node node = stack.get(i);
				node.right = merged;
				fix(node);
				merged = node;
			}
			return merged;
		}

		/**
		 * ヒープに整数を追加する。
		 *
		 * <p>
		 * 新しいノードを生成し、現在のヒープと併合する。
		 * </p>
		 *
		 * @param value 追加する整数
		 */
		void push(int value) {
			Node node = new Node(value);
			root = meldNodes(root, node);
			size++;
		}

		/**
		 * ヒープの最大値を取得する。
		 *
		 * @return ヒープの最大値
		 * @throws IllegalStateException ヒープが空の場合
		 */
		int top() {
			if (root == null) {
				throw new IllegalStateException("Heap is empty");
			}
			return root.key;
		}

		/**
		 * ヒープから最大値を削除する。
		 *
		 * <p>
		 * 根を削除し、左右の部分ヒープを併合して新しい根とする。
		 * </p>
		 *
		 * @throws IllegalStateException ヒープが空の場合
		 */
		void pop() {
			if (root == null) {
				throw new IllegalStateException("Heap is empty");
			}
			root = meldNodes(root.left, root.right);
			size--;
		}

		/**
		 * ヒープに格納されている要素数を取得する。
		 *
		 * @return 要素数
		 */
		int size() {
			return size;
		}

		/**
		 * 別のヒープを現在のヒープに併合する。
		 *
		 * <p>
		 * 併合後、引数で指定したヒープは空になる。 要素を複製せず、既存のノードを再利用する。
		 * </p>
		 *
		 * @param other 併合するヒープ
		 */
		void meld(LeftistHeap other) {
			if (other == this) {
				return;
			}
			root = meldNodes(root, other.root);
			size += other.size;
			other.root = null;
			other.size = 0;
		}
	}
}
