package abc.abc201_250.abc216;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			while (n > 0) {
				if (1L == (1L & n)) {
					sb.append("A");
					n--;
				} else {
					sb.append("B");
					n >>= 1;
				}
			}
			System.out.println(sb.reverse().toString());
		}
	}
}
