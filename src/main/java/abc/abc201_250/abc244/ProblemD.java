package abc.abc201_250.abc244;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = new char[N], t = new char[N];
			IntStream.range(0, N).forEach(i -> s[i] = scanner.next().charAt(0));
			IntStream.range(0, N).forEach(i -> t[i] = scanner.next().charAt(0));
			int count = (int) IntStream.range(0, N).filter(i -> s[i] == t[i]).count();
			System.out.println(((3 == count) || (0 == count)) ? "Yes" : "No");
		}
	}
}
