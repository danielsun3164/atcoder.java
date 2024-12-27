package abc.abc201_250.abc238;

import java.util.Scanner;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			while (t-- > 0) {
				long a = scanner.nextLong(), s = scanner.nextLong();
				long d = s - (a << 1);
				sb.append(((d >= 0L) && (0L == (d & a))) ? "Yes" : "No").append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
