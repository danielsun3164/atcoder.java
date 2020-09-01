package abc.abc063;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			Set<Character> set = new HashSet<>();
			for (char c : s) {
				set.add(c);
			}
			System.out.println((set.size() == s.length) ? "yes" : "no");
		}
	}
}
