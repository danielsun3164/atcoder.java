package other.atc002;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/atc002/submissions/691904 にも参考
 */
public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] w = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			System.out.println((new HuTucker(w)).answer);
		}
	}

	/**
	 * Hu-Tuckerの実装
	 *
	 * https://atcoder.jp/contests/atc002/submissions/691904 を参考に作成
	 */
	private static class HuTucker {

		/** 最大値 */
		static final long INF = Long.MAX_VALUE >> 1;

		final int n;
		final SkewHeap[] heapQue;
		final int[] left, right;
		final long[] cst;
		long answer = 0L;

		HuTucker(long[] w) {
			n = w.length;
			heapQue = new SkewHeap[n];
			left = new int[n];
			right = new int[n];
			cst = new long[n];
			PriorityQueue<HuTuckerNode> que = new PriorityQueue<>(
					(a, b) -> (a.w == b.w) ? Integer.compare(a.pos, b.pos) : Long.compare(a.w, b.w));
			IntStream.range(0, n - 1).forEach(i -> {
				heapQue[i] = null;
				right[i] = i + 1;
				left[i] = i - 1;
				cst[i] = w[i] + w[i + 1];
				que.add(new HuTuckerNode(cst[i], i));
			});

			for (int step = 0; step < n - 1; step++) {
				int i;
				long c;
				do {
					HuTuckerNode top = que.poll();
					c = top.w;
					i = top.pos;
				} while (right[i] == -1 || cst[i] != c);

				boolean ml = false, mr = false;
				if (w[i] + first(heapQue[i]) == c) {
					heapQue[i] = SkewHeap.pop(heapQue[i]);
					ml = true;
				} else if (w[i] + w[right[i]] == c) {
					ml = mr = true;
				} else if (first(heapQue[i]) + second(heapQue[i]) == c) {
					heapQue[i] = SkewHeap.pop(SkewHeap.pop(heapQue[i]));
				} else {
					heapQue[i] = SkewHeap.pop(heapQue[i]);
					mr = true;
				}
				answer += c;
				heapQue[i] = SkewHeap.add(heapQue[i], c);
				if (ml) {
					w[i] = INF;
				}
				if (mr) {
					w[right[i]] = INF;
				}
				if (ml && (i > 0)) {
					int j = left[i];
					heapQue[j] = SkewHeap.meld(heapQue[j], heapQue[i]);
					right[j] = right[i];
					right[i] = -1;
					left[right[j]] = j;
					i = j;
				}
				if (mr && (right[i] + 1 < n)) {
					int j = right[i];
					heapQue[i] = SkewHeap.meld(heapQue[i], heapQue[j]);
					right[i] = right[j];
					right[j] = -1;
					left[right[i]] = i;
				}
				cst[i] = min(w[i] + w[right[i]], min(w[i], w[right[i]]) + first(heapQue[i]));
				cst[i] = min(cst[i], first(heapQue[i]) + second(heapQue[i]));
				que.add(new HuTuckerNode(cst[i], i));
			}
		}

		private long first(SkewHeap p) {
			return (null != p) ? p.value : INF;
		}

		private long second(SkewHeap p) {
			return (null != p) ? min(first(p.l), first(p.r)) : INF;
		}

		/**
		 * 配列aの最小値を返す
		 *
		 * @param a
		 * @return 配列aの最小値
		 */
		private static long min(long... a) {
			return Arrays.stream(a).min().getAsLong();
		}
	}

	private static class HuTuckerNode {
		long w;
		int pos;

		public HuTuckerNode(long w, int pos) {
			this.w = w;
			this.pos = pos;
		}
	}

	/**
	 * SkewHeapの実装
	 */
	private static class SkewHeap {
		SkewHeap l, r;
		long value;

		SkewHeap(long value) {
			this.value = value;
		}

		static SkewHeap add(SkewHeap x, long value) {
			return meld(x, new SkewHeap(value));
		}

		static SkewHeap pop(SkewHeap x) {
			return meld(x.l, x.r);
		}

		/**
		 * aとbの2つのヒープを一つにまとめる
		 *
		 * @param a
		 * @param b
		 * @return まとめた結果
		 */
		static SkewHeap meld(SkewHeap a, SkewHeap b) {
			if (a == null) {
				return b;
			}
			if (b == null) {
				return a;
			}
			if (a.value > b.value) {
				SkewHeap tmp = a;
				a = b;
				b = tmp;
			}
			a.r = meld(a.r, b);
			{
				SkewHeap tmp = a.l;
				a.l = a.r;
				a.r = tmp;
			}
			return a;
		}
	}
}
