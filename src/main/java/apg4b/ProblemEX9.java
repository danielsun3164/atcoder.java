package apg4b;

import java.util.Scanner;

public class ProblemEX9 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt();
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			// 1.xに1を足した値
			x += 1;
			System.out.println(x);
			// 2.(1.で出力した値)に(a+b)を掛けた値
			x *= (a + b);
			System.out.println(x);
			// 3.(2.で出力した値)に(2.で出力した値)を掛けた値
			x *= x;
			System.out.println(x);
			// 4.(3.で出力した値)から1を引いた値
			x -= 1;
			System.out.println(x);
		}
	}
}
