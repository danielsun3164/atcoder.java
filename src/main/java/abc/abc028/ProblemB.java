package abc.abc028;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.nextLine().toCharArray();
			int[] result = new int[6];
			Arrays.fill(result, 0);
			for (char ch : s) {
				result[ch - 'A']++;
			}
			System.out.println(Arrays.stream(result).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(" ")));
		}
	}
}
