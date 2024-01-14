package abc.abc201_250.abc221;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc221/editorial/2724 の実装
 */
public class ProblemG {

	/** 移動方法の文字 */
	private static final char[] MOVES = { 'L', 'U', 'D', 'R' };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), a = scanner.nextInt(), b = scanner.nextInt();
			int[] d = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int x = a + b, y = a - b;
			BitSet[] bitSets = new BitSet[n + 1];
			int sum = Arrays.stream(d).sum();
			if ((Math.abs(x) > Math.abs(sum)) || (Math.abs(y) > Math.abs(sum)) || (((x + sum) & 1) != 0)
					|| (((y + sum) & 1) != 0)) {
				System.out.println("No");
				return;
			}
			x = (x + sum) >> 1;
			y = (y + sum) >> 1;
			bitSets[0] = new BitSet(1);
			bitSets[0].set(0, true);
			for (int i = 0; i < n; i++) {
				bitSets[i + 1] = shiftLeft(bitSets[i], d[i]);
				bitSets[i + 1].or(bitSets[i]);
			}
			if ((!bitSets[n].get(x)) || (!bitSets[n].get(y))) {
				System.out.println("No");
				return;
			}
			StringBuilder answer = new StringBuilder();
			for (int i = n - 1; i >= 0; i--) {
				int s = 0;
				if (!bitSets[i].get(x)) {
					x -= d[i];
					s += 1;
				}
				if (!bitSets[i].get(y)) {
					y -= d[i];
					s += 2;
				}
				answer.append(MOVES[s]);
			}
			System.out.println("Yes");
			System.out.println(answer.reverse().toString());
		}
	}

	/**
	 * BitSetの左シフト操作を行う
	 *
	 * @param bitSet BitSet
	 * @param n      ビット数
	 * @return BitSetを左シフト操作した結果
	 */
	private static BitSet shiftLeft(BitSet bitSet, int n) {
		// 左にm個longをシフトする
		int m = (n + Long.SIZE - 1) / Long.SIZE;
		long[] longArray = bitSet.toLongArray();
		long[] newArray = new long[m + longArray.length];
		System.arraycopy(longArray, 0, newArray, m, longArray.length);
		BitSet newBitSet = BitSet.valueOf(newArray);
		return newBitSet.get(m * Long.SIZE - n, bitSet.length() + m * Long.SIZE);
	}
}
