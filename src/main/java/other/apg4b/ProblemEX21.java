package other.apg4b;

import java.util.Scanner;

public class ProblemEX21 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();

			int a0 = -1, a1 = -1, a2 = -1, a3 = -1, a4 = -1, a5 = -1;

			// 計算量が最も大きいもの1つだけコメントアウトする
			a0 = f0(n);
			a1 = f1(n, m);
			a2 = f2(n);
			a3 = f3(n);
			// a4 = f4(n);
			a5 = f5(n, m);

			System.out.println("f0: " + a0);
			System.out.println("f1: " + a1);
			System.out.println("f2: " + a2);
			System.out.println("f3: " + a3);
			System.out.println("f4: " + a4);
			System.out.println("f5: " + a5);
		}
	}

	private static int f0(int n) {
		return 1;
	}

	private static int f1(int n, int m) {
		int s = 0;
		for (int i = 0; i < n; i++) {
			s++;
		}
		for (int i = 0; i < m; i++) {
			s++;
		}
		return s;
	}

	private static int f2(int n) {
		int s = 0;
		for (int i = 0; i < n; i++) {
			int t = n;
			int cnt = 0;
			while (t > 0) {
				cnt++;
				t /= 2;
			}
			s += cnt;
		}
		return s;
	}

	private static int f3(int n) {
		int s = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				s++;
			}
		}
		return s;
	}

	@SuppressWarnings("unused")
	private static int f4(int n) {
		int s = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				s += i + j;
			}
		}
		return s;
	}

	private static int f5(int n, int m) {
		int s = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				s += i + j;
			}
		}
		return s;
	}
}
