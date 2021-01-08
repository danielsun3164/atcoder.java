package abc.abc001_050.abc030;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt() % 12, m = scanner.nextInt();
			// 分針が0時時点との角度
			double mDegree = m * 6.0d;
			// 時針が0時時点との角度
			double hDegree = n * 30d + m / 2.0d;
			double diff = Math.max(mDegree, hDegree) - Math.min(mDegree, hDegree);
			if (diff > 180d) {
				diff = 360d - diff;
			}
			System.out.println(diff);
		}
	}
}
