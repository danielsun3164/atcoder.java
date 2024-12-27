package other.math_and_algorithm;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class Problem033 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			double ax = scanner.nextDouble(), ay = scanner.nextDouble(), bx = scanner.nextDouble(),
					by = scanner.nextDouble(), cx = scanner.nextDouble(), cy = scanner.nextDouble();
			double bax = ax - bx, bay = ay - by, bcx = cx - bx, bcy = cy - by, cax = ax - cx, cay = ay - cy,
					cbx = bx - cx, cby = by - cy;
			int pattern = 2;
			if (bax * bcx + bay * bcy < 0.0) {
				pattern = 1;
			}
			if (cax * cbx + cay * cby < 0.0) {
				pattern = 3;
			}
			System.out.println(switch (pattern) {
			case 1 -> Math.hypot(bax, bay);
			case 3 -> Math.hypot(cax, cay);
			default -> Math.abs(bax * bcy - bay * bcx) / Math.hypot(bcx, bcy);
			});
		}
	}
}
