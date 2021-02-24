package abc.abc101_150.abc137;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説の別解を実装したソースコード
 * 
 * https://atcoder.jp/contests/abc137/submissions/6844730 にも参考
 */
public class ProblemD別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			Data[] datas = IntStream.range(0, n).mapToObj(i -> new Data(scanner.nextInt(), scanner.nextInt()))
					.filter(data -> data.a <= m).sorted((x, y) -> Integer.compare(y.b, x.b)).toArray(Data[]::new);
			Node[] tree = IntStream.range(0, 4 * Math.max(n, m)).mapToObj(i -> new Node()).toArray(Node[]::new);
			build(tree, 1, m, 1);
			System.out.println(
					Arrays.stream(datas).filter(data -> addSc(tree, 1, data.a)).mapToLong(data -> data.b).sum());
		}
	}

	/**
	 * treeを初期化
	 * 
	 * @param tree
	 * @param l
	 * @param r
	 * @param k
	 */
	private static void build(Node[] tree, int l, int r, int k) {
		tree[k].l = l;
		tree[k].r = r;
		if (l == r) {
			tree[k].w = true;
			return;
		}
		int m = (l + r) / 2;
		build(tree, l, m, 2 * k);
		build(tree, m + 1, r, 2 * k + 1);
		tree[k].w = true;
	}

	/**
	 * aのアルバイトがkの場所に追加可能かどうかを判定する
	 * 
	 * @param tree
	 * @param k
	 * @param a
	 * @return aのアルバイトが追加可能かどうか
	 */
	private static boolean addSc(Node[] tree, int k, int a) {
		if (tree[k].l == tree[k].r) {
			if (tree[k].w) {
				tree[k].w = false;
				return true;
			} else {
				return false;
			}
		}
		int m = (tree[k].l + tree[k].r) / 2;
		if (!tree[k].w) {
			return false;
		}
		boolean y = false;
		if ((a <= m) && (tree[2 * k].w)) {
			y = addSc(tree, 2 * k, a);
		}
		if (!y) {
			y = addSc(tree, 2 * k + 1, a);
		}
		tree[k].w = tree[2 * k].w || tree[2 * k + 1].w;
		return y;
	}

	/**
	 * a,bを表すクラス
	 */
	private static class Data {
		int a, b;

		Data(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	/**
	 * ノードを表すクラス
	 */
	private static class Node {
		int l, r;
		boolean w;

		Node() {
			l = r = 0;
			w = false;
		}
	}
}
