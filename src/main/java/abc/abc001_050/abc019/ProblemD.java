package abc.abc001_050.abc019;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	/** 質問するときの文字 */
	private static final String QUESTION = "? ";

	/** 回答するときの文字 */
	private static final String ANSWER = "! ";

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int now = 1, maxNode = 1, r = 0;
			for (int i = 2; i <= n; i++) {
				System.out.println("? " + now + " " + i);
				int distance = scanner.nextInt();
				if (distance > r) {
					r = distance;
					maxNode = i;
				}
			}
			now = maxNode;
			for (int i = 2; i <= n; i++) {
				System.out.println(QUESTION + now + " " + i);
				int distance = scanner.nextInt();
				if (distance > r) {
					r = distance;
					maxNode = i;
				}
			}
			System.out.println(ANSWER + r);
		}
	}
}
