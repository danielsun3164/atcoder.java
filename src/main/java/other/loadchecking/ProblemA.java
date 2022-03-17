package other.loadchecking;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemA {

	/** 結果の順列 */
	private static final int[] b = { 2, 20, 19, 10, 17, 12, 9, 13, 14, 15, 4, 8, 3, 16, 11, 18, 7, 5, 1, 6 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Arrays.stream(b).forEach(System.out::println);
		}
	}
}
