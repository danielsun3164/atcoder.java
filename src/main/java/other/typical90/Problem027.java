package other.typical90;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Problem027 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Set<String> set = new HashSet<>();
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.rangeClosed(1, n).forEach(i -> {
				String s = scanner.next();
				if (!set.contains(s)) {
					set.add(s);
					sb.append(i).append(System.lineSeparator());
				}
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
