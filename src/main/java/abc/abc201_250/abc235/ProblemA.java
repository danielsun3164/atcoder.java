package abc.abc201_250.abc235;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] abc = scanner.next().toCharArray();
			System.out.println(IntStream.range(0, abc.length).map(i -> abc[i] - '0').sum() * 111);
		}
	}
}
