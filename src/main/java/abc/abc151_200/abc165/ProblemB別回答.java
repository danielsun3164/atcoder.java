package abc.abc151_200.abc165;

import java.util.Scanner;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemB別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long x = scanner.nextLong(), now = 100L;
			int count = 0;
			while (now < x) {
				now = now + now / 100L;
				count++;
			}
			System.out.println(count);
		}
	}
}
