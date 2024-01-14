package abc.abc201_250.abc221;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray(), t = scanner.next().toCharArray();
			int diffCount = (int) IntStream.range(0, s.length).filter(i -> s[i] != t[i]).count();
			if (0 == diffCount) {
				System.out.println("Yes");
			} else if (2 == diffCount) {
				int index = IntStream.range(0, s.length).filter(i -> s[i] != t[i]).findFirst().getAsInt();
				System.out.println(((s[index] == t[index + 1]) && (s[index + 1] == t[index])) ? "Yes" : "No");
			} else {
				System.out.println("No");
			}
		}
	}
}
