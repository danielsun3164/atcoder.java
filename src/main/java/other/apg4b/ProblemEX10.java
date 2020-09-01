package other.apg4b;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemEX10 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			System.out.println("A:" + IntStream.range(0, a).mapToObj(i -> "]").collect(Collectors.joining()));
			System.out.println("B:" + IntStream.range(0, b).mapToObj(i -> "]").collect(Collectors.joining()));
		}
	}
}
