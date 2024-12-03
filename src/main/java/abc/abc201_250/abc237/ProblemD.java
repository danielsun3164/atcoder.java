package abc.abc201_250.abc237;

import java.util.Scanner;

public class ProblemD {

	/** 左を表す文字 */
	private static final char LEFT = 'L';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			Data[] datas = new Data[n + 1];
			Data start = datas[0] = new Data(0);
			for (int i = 1; i <= n; i++) {
				Data now = datas[i] = new Data(i);
				if (LEFT == s[i - 1]) {
					Data next = datas[i - 1], prev = next.left;
					now.right = next;
					next.left = now;
					if (null != prev) {
						prev.right = now;
						now.left = prev;
					} else {
						start = now;
					}
				} else {
					Data prev = datas[i - 1], next = prev.right;
					now.left = prev;
					prev.right = now;
					if (null != next) {
						next.left = now;
						now.right = next;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append(start.value);
			while (null != start.right) {
				start = start.right;
				sb.append(" ").append(start.value);
			}
			System.out.println(sb.toString());
		}
	}

	/**
	 * LinkedListの要素を表すクラス
	 */
	private static class Data {
		Data left, right;
		int value;

		Data(int value) {
			this.value = value;
		}
	}
}
