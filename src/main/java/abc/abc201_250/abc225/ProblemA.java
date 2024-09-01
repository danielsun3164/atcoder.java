package abc.abc201_250.abc225;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 順列のループは https://maku77.github.io/java/numstr/permutation.html を参考
 */
public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			System.out.println(permutation(s));
		}
	}

	/**
	 * 与えられた配列で順列のループを実施する
	 *
	 * @param seed 順列のもととなる配列
	 * @return 順列で組み立てられる文字列の数
	 */
	private static int permutation(char[] seed) {
		char[] perm = new char[seed.length];
		boolean[] used = new boolean[seed.length];
		Set<String> set = new HashSet<>();
		buildPerm(seed, perm, set, used, 0);
		return set.size();
	}

	/**
	 * 与えられた配列で順列のループを実施し、最小値を計算する
	 *
	 * @param seed  順列のもととなる配列
	 * @param perm  作成された順列
	 * @param set   作成された文字列を保存するSet
	 * @param used  個々の要素が使用したかどうかを記録用配列
	 * @param index 現在処理しているインデックス
	 */
	private static void buildPerm(char[] seed, char[] perm, Set<String> set, boolean[] used, int index) {
		if (seed.length == index) {
			set.add(new String(perm));
		}

		for (int i = 0; i < seed.length; ++i) {
			if (!used[i]) {
				perm[index] = seed[i];
				used[i] = true;
				buildPerm(seed, perm, set, used, index + 1);
				used[i] = false;
			}
		}
	}
}
