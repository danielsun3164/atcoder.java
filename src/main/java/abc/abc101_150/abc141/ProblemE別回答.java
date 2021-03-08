package abc.abc101_150.abc141;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * 二分法及び平衡二分探索木を用いたハッシュ値の既出判定の実装<br/>
 * https://atcoder.jp/contests/abc141/submissions/16177068 にも参考
 */
public class ProblemE別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			RollingHash rh = new RollingHash(s);
			int ok = 0, ng = n + 1;
			while (ng - ok > 1) {
				int mid = (ok + ng) / 2;

				boolean isOK = false;
				Map<Long, Integer> map = new HashMap<>();
				for (int i = 0; i + mid <= n; i++) {
					long p = rh.get(i, i + mid);
					isOK |= map.containsKey(p) && map.get(p) <= i;
					if (!map.containsKey(p)) {
						map.put(p, i + mid);
					}
				}

				if (isOK) {
					ok = mid;
				} else {
					ng = mid;
				}
			}
			System.out.println(ok);
		}
	}

	final static long MASK30 = (1L << 30) - 1;
	final static long MASK31 = (1L << 31) - 1;
	final static long MODRH = (1L << 61) - 1;
	final static long MASK61 = MODRH;
	final static long POSITIVIZER = MODRH * 4;
	final static long BASE = random(MODRH >>> 1, MODRH);

	private static long random(long max) {
		return (long) Math.floor(Math.random() * max);
	}

	private static long random(long min, long max) {
		return random(max - min) + min;
	}

	private static class RollingHash {
		long hash[];
		long pow[];
		int len;

		long mul(long a, long b) {
			long au = a >>> 31;
			long ad = a & MASK31;
			long bu = b >>> 31;
			long bd = b & MASK31;
			long mid = ad * bu + au * bd;
			long midu = mid >>> 30;
			long midd = mid & MASK30;
			return au * bu * 2 + midu + (midd << 31) + ad * bd;
		}

		long mod(long x) {
			long xu = x >> 61;
			long xd = x & MASK61;
			long res = xu + xd;
			if (res >= MODRH) {
				res -= MODRH;
			}
			return res;
		}

		RollingHash(char[] s) {
			len = s.length;
			hash = new long[len + 1];
			pow = new long[len + 1];
			hash[0] = 0L;
			pow[0] = 1L;
			IntStream.range(0, len).forEach(i -> {
				hash[i + 1] = mod(mul(hash[i], BASE) + s[i]);
				pow[i + 1] = mod(mul(pow[i], BASE));
			});
		}

		long get(int l, int r) { // [l,r) (0-indexed)
			long res = hash[r] - mul(hash[l], pow[r - l]);
			if (res < 0) {
				res += POSITIVIZER;
			}
			return mod(res);
		}

		@SuppressWarnings("unused")
		int getLCP(int a, int b) {
			int ok = 0;
			int ng = len - Math.max(a, b) + 1;
			while (ng - ok > 1) {
				int mid = (ok + ng) / 2;
				if (get(a, a + mid) == (get(b, b + mid))) {
					ok = mid;
				} else {
					ng = mid;
				}
			}
			return ok;
		}
	}
}
