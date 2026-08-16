package abc.abc101_150.abc124;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			List<Block> list = new ArrayList<>();
			int max = 0;
			// 直前に1があるかどうか
			boolean prevOne;
			if (s[0] == '0') {
				list.add(new Block(k, 0, 0));
				prevOne = true;
			} else {
				prevOne = false;
			}
			for (int i = 0; i < s.length; i++) {
				if (prevOne && ('0' == s[i])) {
					for (int j = 0; j < list.size(); j++) {
						Block result = list.get(j);
						if (result.k > 0) {
							result.k--;
						} else {
							// 反転できる回数が0になったら
							result.count = i - result.start;
							if (result.count > max) {
								max = result.count;
							}
							list.remove(j);
							j--;
						}
					}
					prevOne = false;
				} else if (!prevOne && ('1' == s[i])) {
					if (i < n - max) {
						list.add(new Block(k, i, 0));
					}
					prevOne = true;
				}
			}
			if (!list.isEmpty()) {
				Block result = list.get(0);
				result.count = n - result.start;
				if (result.count > max) {
					max = result.count;
				}
			}
			System.out.println(max);
		}
	}

	/**
	 * 0の連続したブロックを表すクラス
	 */
	private static class Block {
		/** 反転できる回数 */
		int k;
		/** 開始index */
		int start;
		/** 連続した長さ */
		int count;

		Block(int k, int start, int count) {
			this.k = k;
			this.start = start;
			this.count = count;
		}
	}
}
