package abc.abc071;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// すべての小文字を含む集合
			Set<Character> set = new HashSet<>();
			for (char a = 'a'; a <= 'z'; a++) {
				set.add(a);
			}
			set.removeAll(scanner.nextLine().chars().distinct().collect(ArrayList<Character>::new,
					(a, b) -> a.add((char) b), ArrayList<Character>::addAll));
			Optional<Character> first = set.stream().sorted().findFirst();
			System.out.println(first.isPresent() ? first.get() : "None");
		}
	}
}
