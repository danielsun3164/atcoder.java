package abc.abc001_050.abc033;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Set<Character> set = new HashSet<>();
			for (char c : scanner.next().toCharArray()) {
				set.add(c);
			}
			System.out.println((set.size() > 1) ? "DIFFERENT" : "SAME");
		}
	}
}
