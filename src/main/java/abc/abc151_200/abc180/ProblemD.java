package abc.abc151_200.abc180;

import java.util.Scanner;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long x = scanner.nextLong(), y = scanner.nextLong();
			long a = scanner.nextLong(), b = scanner.nextLong();
			long result = 0L, now = x;
			if ((x + b) / x > a) {
				// 解説から now*a<y の条件を追加
				while ((now * a < x + b) && (now * a < y)) {
					now *= a;
					result++;
				}
			}
			result += ((y - 1) - now) / b;
			System.out.println(result);
		}
	}
}
