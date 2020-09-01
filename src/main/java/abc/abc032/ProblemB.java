package abc.abc032;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.nextLine();
			int k = scanner.nextInt();
			Set<String> set = new HashSet<>();
			IntStream.rangeClosed(0, s.length() - k).forEach(i -> set.add(s.substring(i, i + k)));
			System.out.println(set.size());
		}
	}
}
