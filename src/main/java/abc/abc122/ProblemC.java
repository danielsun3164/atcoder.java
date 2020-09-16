package abc.abc122;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// n
			scanner.nextInt();
			int q = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			List<Integer> countList = new ArrayList<>();
			char previous = ' ';
			int count = 0;
			for (char c : s) {
				if (('A' == previous) && ('C' == c)) {
					count++;
				}
				previous = c;
				countList.add(count);
			}
			IntStream.range(0, q).forEach(i -> {
				int l = scanner.nextInt() - 1, r = scanner.nextInt() - 1;
				System.out.println(countList.get(r) - countList.get(l));
			});
		}
	}
}
