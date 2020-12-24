package abc.abc001_050.abc042;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			// l
			scanner.nextInt();
			System.out.println(
					IntStream.range(0, n).mapToObj(i -> scanner.next()).sorted().collect(Collectors.joining()));
		}
	}
}
