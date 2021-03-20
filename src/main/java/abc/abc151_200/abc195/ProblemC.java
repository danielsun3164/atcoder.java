package abc.abc151_200.abc195;

import java.util.Scanner;

public class ProblemC {

	private static final long[] L_NUMS = { 999L, 999_999L, 999_999_999L, 999_999_999_999L, 999_999_999_999_999L };
	private static final long[] R_NUMS = { 999_999L, 999_999_999L, 999_999_999_999L, 999_999_999_999_999L,
			999_999_999_999_999_999L };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			long answer = 0L;
			for (int i = 0; i < L_NUMS.length; i++) {
				if (n < L_NUMS[i]) {
					break;
				}
				answer += (Math.min(R_NUMS[i], n) - L_NUMS[i]) * (i + 1);
			}
			System.out.println(answer);
		}
	}
}
