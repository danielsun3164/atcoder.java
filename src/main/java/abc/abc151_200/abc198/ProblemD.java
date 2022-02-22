package abc.abc151_200.abc198;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	/** アルファベットの数 */
	private static final int N = 26;
	/** 数字の数 */
	private static final int M = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s1 = scanner.next().toCharArray(), s2 = scanner.next().toCharArray(),
					s3 = scanner.next().toCharArray();
			List<Character> list = new ArrayList<>();
			addList(s1, list);
			addList(s2, list);
			addList(s3, list);
			if (list.size() > 10) {
				System.out.println("UNSOLVABLE");
				return;
			}
			// アルファベットの変数を数字に変換する配列
			int[] dict = new int[N];
			// ある数字がすでに変数の値として使用されているかどうかの配列
			boolean[] used = new boolean[M];
			if (solve(s1, s2, s3, dict, list, used, 0)) {
				System.out.println(process(s1, dict));
				System.out.println(process(s2, dict));
				System.out.println(process(s3, dict));
			} else {
				System.out.println("UNSOLVABLE");
			}
		}
	}

	/**
	 * 文字列sに含まれる文字をすべてリストへ追加する。ただし、すでにリストに存在する文字は重複追加はしない
	 *
	 * @param s    文字列
	 * @param list 追加対象リスト
	 */
	private static void addList(char[] s, List<Character> list) {
		for (char c : s) {
			if (!list.contains(c)) {
				list.add(c);
			}
		}
	}

	/**
	 * s1+s2=s3のような解があるかどうかを計算する
	 *
	 * @param s1
	 * @param s2
	 * @param s3
	 * @param dict  アルファベットの変数を数字に変換する配列
	 * @param list  変数の一覧
	 * @param used  ある数字がすでに変数の値として使用されているかどうかの配列
	 * @param index 現在処理対象の変数のインデックス
	 * @return s1+s2=s3のような解があるかどうか
	 */
	private static boolean solve(char[] s1, char[] s2, char[] s3, int[] dict, List<Character> list, boolean[] used,
			int index) {
		if (list.size() == index) {
			return (process(s1, dict) + process(s2, dict)) == process(s3, dict);
		}
		char c = list.get(index);
		for (int n = 0; n < M; n++) {
			if ((0 == n) && ((c == s1[0]) || (c == s2[0]) || (c == s3[0]))) {
				continue;
			}
			if (!used[n]) {
				dict[c - 'a'] = n;
				used[n] = true;
				if (solve(s1, s2, s3, dict, list, used, index + 1)) {
					return true;
				}
				used[n] = false;
			}
		}
		return false;
	}

	/**
	 * 文字列を数字へ変換する
	 *
	 * @param s    文字列
	 * @param dict アルファベットの変数を数字に変換する配列
	 * @return 変換された数字
	 */
	private static long process(char[] s, int[] dict) {
		long result = dict[s[0] - 'a'];
		for (int i = 1; i < s.length; i++) {
			result = (result * M) + dict[s[i] - 'a'];
		}
		return result;
	}
}
