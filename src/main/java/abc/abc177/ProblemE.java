package abc.abc177;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemE {

	/** 1000以下の素数の配列 */
	private static final int[] PRIMES = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
			73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181,
			191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307,
			311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433,
			439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571,
			577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701,
			709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853,
			857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			int oneCount = (int) IntStream.range(0, n).map(i -> a[i] = scanner.nextInt()).filter(ai -> 0 == ai).count();
			boolean pairwiseCoprime = true;
			// 因数のセット
			Set<Integer> totalSet = getFactors(a[0]);
			main: for (int i = 1; i < n; i++) {
				Set<Integer> set = getFactors(a[i]);
				for (Integer j : set) {
					if (totalSet.contains(j)) {
						pairwiseCoprime = false;
						break main;
					}
				}
				totalSet.addAll(set);
			}
			if (pairwiseCoprime) {
				System.out.println("pairwise coprime");
				return;
			}
			boolean setwiseCoprime = true;
			if (0 == oneCount) {
				setwiseCoprime = false;
				int gcd = a[0];
				for (int i = 1; i < n; i++) {
					gcd = gcd(gcd, a[i]);
					if (1 == gcd) {
						setwiseCoprime = true;
						break;
					}
				}
			}
			if (setwiseCoprime) {
				System.out.println("setwise coprime");
			} else {
				System.out.println("not coprime");
			}
		}
	}

	/**
	 * nの素数となる因数のセットを計算
	 * 
	 * @param n
	 * @return nの素数となる因数のセット
	 */
	private static Set<Integer> getFactors(int n) {
		Set<Integer> set = new HashSet<>();
		int index = 0;
		while (n > 1) {
			if (index == PRIMES.length) {
				set.add(n);
				break;
			}
			while (0 == (n % PRIMES[index])) {
				n /= PRIMES[index];
				set.add(PRIMES[index]);
			}
			index++;
		}
		return set;
	}

	/**
	 * mとnの最大公約数を返す
	 * 
	 * @param m
	 * @param n
	 * @return mとnの最大公約数
	 */
	private static int gcd(int m, int n) {
		if (0 == n) {
			return m;
		}
		return gcd(n, m % n);
	}
}
