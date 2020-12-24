package abc.abc001_050.abc038;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード<br/>
 * BITの実装は https://atcoder.jp/contests/abc038/submissions/3404469 に参考
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Box[] boxes = new Box[n];
			IntStream.range(0, n).forEach(i -> boxes[i] = new Box(scanner.nextInt(), scanner.nextInt()));
			Arrays.sort(boxes);
			BinaryIndexedTree bit = new BinaryIndexedTree(100_000);
			System.out.println(IntStream.range(0, n).map(i -> {
				int w = boxes[i].w;
				int cur = bit.query(w - 1) + 1;
				bit.update(w, cur);
				return cur;
			}).max().getAsInt());
		}
	}

	/**
	 * 箱を表すクラス
	 */
	private static class Box implements Comparable<Box> {
		/** 縦 */
		int h;
		/** 横 */
		int w;

		Box(int h, int w) {
			super();
			this.h = h;
			this.w = w;
		}

		@Override
		public int compareTo(Box box) {
			if (this.h == box.h) {
				// hが同じの場合、wは大きいものを先にソート
				return box.w - this.w;
			}
			return this.h - box.h;
		}
	}

	/**
	 * max版のBinary Indexed Treeの実装
	 */
	private static class BinaryIndexedTree {
		/** 要素数 */
		int n;
		/** データの配列 */
		int[] bit;

		BinaryIndexedTree(int n) {
			this.n = n;
			this.bit = new int[n + 1];
		}

		void update(int i, int v) {
			i++;
			while (i <= n) {
				bit[i] = Math.max(bit[i], v);
				i += i & -i;
			}
		}

		int query(int i) {
			i++;
			int ret = 0;
			while (i > 0) {
				ret = Math.max(bit[i], ret);
				i -= i & -i;
			}
			return ret;
		}
	}
}
