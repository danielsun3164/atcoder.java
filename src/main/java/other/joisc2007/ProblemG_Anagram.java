package other.joisc2007;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemG_Anagram {

	/** アルファベットの数 */
	private static final int N = 26;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int n = s.length;
			long[] frac = new long[n + 1];
			frac[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> frac[i] = frac[i - 1] * i);
			int[] counts = new int[N];
			IntStream.range(0, n).forEach(i -> counts[s[i] - 'A']++);
			System.out.println(getResult(counts, s, frac) + 1);
		}
	}

	/**
	 * アルファベットの分布の中で、sより小さい文字列の数を計算する
	 * 
	 * @param counts アルファベットの分布
	 * @param s      文字列
	 * @param frac   階乗の配列
	 * @return アルファベットの分布の中で、sより小さい文字列の数
	 */
	private static long getResult(int[] counts, final char[] s, final long[] frac) {
		long result = 0L;
		if (s.length > 1) {
			for (int i = 0; i < s[0] - 'A'; i++) {
				if (counts[i] > 0) {
					counts[i]--;
					result += count(counts, frac);
					counts[i]++;
				}
			}
			char[] newS = new char[s.length - 1];
			System.arraycopy(s, 1, newS, 0, newS.length);
			counts[s[0] - 'A']--;
			result += getResult(counts, newS, frac);
		}
		return result;
	}

	/**
	 * アルファベットの分布から、順列の数を計算する
	 * 
	 * @param counts アルファベットの分布
	 * @param frac   階乗の配列
	 * @return 順列の数
	 */
	private static long count(int[] counts, long[] frac) {
		long result = frac[Arrays.stream(counts).sum()];
		for (int c : counts) {
			result /= frac[c];
		}
		return result;
	}
}
