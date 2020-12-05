package other.joi2007ho;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] r = new int[n], b = new int[n];
			Node[] nodes = new Node[n];
			boolean[] hasRoot = new boolean[n];
			Arrays.fill(hasRoot, false);
			IntStream.range(0, n).forEach(i -> {
				nodes[i] = new Node(scanner.nextInt(), scanner.nextInt());
				checkHasRoot(r[i] = scanner.nextInt() - 1, hasRoot);
				checkHasRoot(b[i] = scanner.nextInt() - 1, hasRoot);
			});
			IntStream.range(0, n).forEach(i -> {
				nodes[i].r = (r[i] >= 0) ? nodes[r[i]] : null;
				nodes[i].b = (b[i] >= 0) ? nodes[b[i]] : null;
			});
			int root = IntStream.range(0, n).filter(i -> !hasRoot[i]).findFirst().getAsInt();
			calc(nodes[root]);
			System.out.println(nodes[root].w);
		}
	}

	/**
	 * indexのhasRootをtrueにする
	 * 
	 * @param index
	 * @param hasRoot rootを持っているかどうかの配列
	 */
	private static void checkHasRoot(int index, boolean[] hasRoot) {
		if (index >= 0) {
			hasRoot[index] = true;
		}
	}

	/**
	 * ノードの重さを計算する
	 * 
	 * @param node ノード
	 */
	private static void calc(Node node) {
		if (null != node.r) {
			calc(node.r);
		}
		if (null != node.b) {
			calc(node.b);
		}
		long rw = (null != node.r) ? node.r.w : 1L;
		long bw = (null != node.b) ? node.b.w : 1L;
		long gcd = gcd(rw * node.p, bw * node.q);
		node.w = (rw * bw * node.q) / gcd + (rw * node.p * bw) / gcd;
	}

	/**
	 * aとbの最大公約数を計算する
	 * 
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	private static long gcd(long a, long b) {
		if (0 == b) {
			return a;
		}
		return gcd(b, a % b);
	}

	/**
	 * 棒を表すクラス
	 */
	private static class Node {
		int p, q;
		Node r, b;
		/** 重さ */
		long w;

		Node(int p, int q) {
			this.p = p;
			this.q = q;
		}
	}
}
