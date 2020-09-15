package abc.abc032;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			int k = scanner.nextInt();
			Set<String> set = IntStream.rangeClosed(0, s.length() - k).mapToObj(i -> s.substring(i, i + k))
					.collect(Collectors.toSet());
			System.out.println(set.size());
		}
	}
}
